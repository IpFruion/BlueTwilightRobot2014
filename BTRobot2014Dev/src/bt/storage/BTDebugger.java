/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage;

import bt.main.Constants;
import com.sun.squawk.microedition.io.FileConnection;
import java.io.DataOutputStream;
import java.io.PrintStream;
import javax.microedition.io.Connector;

/**
 *
 * @author Dlock
 */
public class BTDebugger {
    String[][] debugarr;
    boolean debugMode;
    int count = 0;
    BTData data;
    
    PrintStream out;
    DataOutputStream theFile;
    FileConnection fc;
    public BTDebugger(BTData data)
    {
        debugarr = new String[Constants.DEBUG_CAP_LIMIT][4];
        this.debugMode = Constants.DEBUGMODE;
        this.data = data;
    }
    public void printLatestMsg()
    {
        System.out.println("["+debugarr[count][0]+"]["+debugarr[count][1]+"]["+debugarr[count][2]+"]: "+debugarr[count][3]);
    }
    public void write(String location, String severity, String txt)
    {
        
        String time;
        time = getCurrentSysTime();
        //time = Long.toString((System.currentTimeMillis()));
        
        debugarr[count][0] = time;
        debugarr[count][1] = getLocationName(location);
        debugarr[count][2] = getSeverityName(severity);
        debugarr[count][3] = txt;
        if (debugMode)
            printLatestMsg();
        count++;
    }
    public void printDebugWARNING()
    {
        for (int x = 0; x <=count; x++)
        {
            if (debugarr[x][0] != null)
                System.out.println("["+debugarr[x][0]+"]["+debugarr[x][1]+"]["+debugarr[x][2]+"]: "+debugarr[x][3]);
        }
    }
    private String getLocationName(String loc)
    {
        for (int i = 0; i < Constants.LOCATION_ARR.length; i++)
        {
            if (loc == Constants.LOCATION_ARR[i])
            {
                return loc;
            }
        }
        System.out.println("ERROR_INVALID_LOCATION: "+loc);
        return "ERROR_INVALID LOCATION";
    }
    private String getSeverityName(String sev)
    {
        for (int i = 0; i < Constants.SEVERITY_ARR.length; i++)
        {
            if (sev == Constants.SEVERITY_ARR[i])
            {
                return sev;
            }
        }
        System.out.println("ERROR_INVALID_SEVERITY: "+sev);
        return "ERROR_INVALID_SEVERITY";
    }
    public String getCurrentSysTime()
    {
        long t = System.currentTimeMillis();
        int min = (int)(t/(1000*60));
        t = t-(min*(1000*60));
        int sec = (int)(t/(1000));
        t = t-(sec*1000);
        
        String mins = Integer.toString(min);
        String secs = Integer.toString(sec);
        String tsec = Long.toString(t);
        return mins+":"+secs+":"+tsec;
    }
    public void intoFile()
    {
        try
        {
            fc = (FileConnection)Connector.open("file:///Debugoutput.txt",Connector.WRITE);
            fc.create();
            theFile = fc.openDataOutputStream();
        }
        catch(Exception e){
            write(Constants.LOCATION_ARR[3],Constants.SEVERITY_ARR[2],"Debug unable to write to file");
        }
    }
}
