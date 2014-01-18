/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage.health;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Dlock
 */
public abstract class BTStatistic
{
    public final String name;
    public final String groupName;
    public final boolean isDisplayed;
        
    public BTStatistic (String name, String groupName, boolean isDisplayed)
    {
        this.name = name;
        this.groupName = groupName;
        this.isDisplayed = isDisplayed;
    }
    public static class BTStatBoolean extends BTStatistic
    {
        private boolean val;
        
        public BTStatBoolean(String valname,String groupName, boolean val, boolean isDisplayed)
        {
            super(valname,groupName,isDisplayed);
            this.val = val;
            updateVal(val);
        }
        public void updateVal(boolean val)
        {
            this.val = val;
            if (isDisplayed)
            {
                SmartDashboard.putBoolean(name, val);
            }
            
            //TODO: add code to check against perams
        }
    }
    public static class BTStatString extends BTStatistic
    {
        private String val;
        
        public BTStatString(String valname,String groupName, String val, boolean isDisplayed)
        {
            super(valname,groupName,isDisplayed);
            updateVal(val);
        }
        public void updateVal(String val)
        {
            this.val = val;
            if (isDisplayed)
            {
                SmartDashboard.putString(name, val);
            }
            //TODO: add code to check against perams
        }
    }
    public static class BTStatNum extends BTStatistic
    {
        private double val;
        
        public BTStatNum(String valname,String groupName, double val, boolean isDisplayed)
        {
            super(valname,groupName,isDisplayed);
            updateVal(val);
        }
        public void updateVal(double val)
        {
            this.val = val;
            if (isDisplayed)
            {
                SmartDashboard.putNumber(name, val);
            }
            //TODO: add code to check against perams
        }
    }
}
