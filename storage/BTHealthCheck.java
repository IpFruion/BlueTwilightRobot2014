/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableProvider;
import edu.wpi.first.wpilibj.networktables2.NetworkTableNode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITableListener;

/**
 *
 * @author Dlock
 */
public class BTHealthCheck {
    
    private BTDebugger debug;
    private String[] HEALTH_CLASS_ID;
    private BTStatistic[][] HEALTH_DATA;
    
    public BTHealthCheck(BTDebugger debug)
    {
        this.debug = debug;
        HEALTH_CLASS_ID = new String[100];
        HEALTH_DATA = new BTStatistic[100][0];
        debug.write(Constants.DebugLocation.BTHealthCheck,
                    Constants.Severity.INFO,
                    "HealthCheck init success");
    }
    public void setupHealthClass(String idname)
    {
        int count = getNextIDOpen();
        
        HEALTH_CLASS_ID[count] = idname;
    }
    public void updateStat(String idname, String valname, String val, boolean isDisplayed)
    {
       int pos;
       int id = getIDViaName(idname);
       if (id < 0)
       {
           debug.write(Constants.DebugLocation.BTHealthCheck, 
                        Constants.Severity.WARNING, 
                        "Invalid IDname: "+idname+"\nWhile Adding "+valname+":"+val+"\nCreating New id and adding statistic");
           setupHealthClass(idname);
           id = getIDViaName(idname);
       }
       pos = getPosViaName(id,valname);
       if (pos == -1)
       {
           addStat(id, valname, val, isDisplayed);
           return;
       }
       HEALTH_DATA[id][pos].isDisplayed = isDisplayed;
       HEALTH_DATA[id][pos].valname = valname;
       HEALTH_DATA[id][pos].val = val;
    }
    public void updateStat(String idname, String valname, String val)
    {
       int pos;
       boolean isDisplayed = false;
       int id = getIDViaName(idname);
       if (id == -1)
       {
           debug.write(Constants.DebugLocation.BTHealthCheck, 
                        Constants.Severity.WARNING, 
                        "Invalid IDname: "+idname+"\nWhile Adding "+valname+":"+val+"\nCreating New id and adding statistic");
           setupHealthClass(idname);
           id = getIDViaName(idname);
       }
       pos = getPosViaName(id,valname);
       if (pos == -1)
       {
           addStat(id, valname, val, isDisplayed);
           return;
       }
       HEALTH_DATA[id][pos].isDisplayed = isDisplayed;
       HEALTH_DATA[id][pos].valname = valname;
       HEALTH_DATA[id][pos].val = val;
    }
    public String getStat(String idname, String valname)
    {
        int id = getIDViaName(idname);
        int pos = getPosViaName(id,valname);
        if (pos == -1 || id == -1)
            return null;
        return HEALTH_DATA[id][pos].val;
    }

    public int getNextIDOpen() 
    {
        int nextSpot = 0;
        for (int i=0; i<HEALTH_CLASS_ID.length; i++)
        {
            if (HEALTH_CLASS_ID[i] == null)
            {
                nextSpot = i;
                break;
            }
        }
        return nextSpot;
    }
    private void addStat(int id, String valname, String val, boolean isDisplayed)
    {
       addPosAt(id);
       HEALTH_DATA[id][HEALTH_DATA[id].length-1] = new BTStatistic(valname,val,isDisplayed);
    }
    private void addPosAt(int id) 
    {
        int count;
        count = HEALTH_DATA[id].length;
        //count = Integer.parseInt(HEALTH_CLASS_ID[id][1].substring(HEALTH_CLASS_ID[id][1].indexOf(':')+1));
        count++;
        BTStatistic[] tmp = HEALTH_DATA[id];
        HEALTH_DATA[id] = new BTStatistic[count];
        System.arraycopy(tmp, 0, HEALTH_DATA[id], 0, tmp.length);
    }
    private int getPosViaName(int id, String valname) 
    {
        int pos = -1;
        for (int i=0;i<HEALTH_DATA[id].length;i++)
        {
            if (HEALTH_DATA[id][i].valname.equals(valname))
            {
                pos = i;
                break;
            }
        }
        return pos;
    }
    private int getIDViaName(String idname)
    {
        int id;
        for (int i=0;i<HEALTH_CLASS_ID.length;i++)
        {
            if (HEALTH_CLASS_ID[i].equals(idname))
            {
                id = i;
                return id;
            }
        }
        return -1;
    }
    public void updateHealth()
    {   
        updateDisplay();
        //create place to check HEALTH_CLASS_ID with value
        //WITHIN exceptable perams
    }
    public void clearDash()
    {
        
    }
    private void updateDisplay() 
    {
        for (int i = 0; i<HEALTH_DATA.length; i++)
        {
            for (int x = 0; x<HEALTH_DATA[i].length; x++)
            {
                if (HEALTH_DATA[i][x].isDisplayed)
                {
                    SmartDashboard.putString(HEALTH_DATA[i][x].valname, HEALTH_DATA[i][x].val);
                }
            }
        }
    }
    private class BTStatistic
    {
        public String valname;
        public String val;
        public boolean isDisplayed;
        
        public BTStatistic(String valname, String val, boolean isDisplayed)
        {
            this.valname = valname;
            this.val = val;
            this.isDisplayed = isDisplayed;
        }
    }
}
