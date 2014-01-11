/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage;

import com.sun.squawk.microedition.io.FileConnection;
import java.io.DataOutputStream;
import java.io.PrintStream;
import javax.microedition.io.Connector;

/**
 *
 * @author Dlock
 */
public class BTDebugger {
    public String[][] DEBUGARR;
    boolean debugMode;
    int debugCount = 0;
    double timeCount = 0;
    
    PrintStream out;
    DataOutputStream theFile;
    FileConnection fc;
    
    public BTDebugger()
    {
        DEBUGARR = new String[Constants.DEBUG_CAP_LIMIT][4];
        this.debugMode = Constants.DEBUGMODE; 
    }
    public String getLatestMsg()
    {
        return "["+DEBUGARR[debugCount][0]+"]["+DEBUGARR[debugCount][1]+"]["+DEBUGARR[debugCount][2]+"]: "+DEBUGARR[debugCount][3];
    }
    public void write(Constants.DebugLocation location, Constants.Severity severity, String txt)
    {
        
        String time;
        time = getCurrentSysTime();
        //time = Long.toString((System.currentTimeMillis()));
        
        DEBUGARR[debugCount][0] = time;
        DEBUGARR[debugCount][1] = location.toString();
        DEBUGARR[debugCount][2] = severity.toString();
        DEBUGARR[debugCount][3] = txt;
        
        if (debugMode)
            System.out.println(getLatestMsg());
        debugCount++;
    }
    
    public void printDebugWARNING()
    {
        for (int x = 0; x <=debugCount; x++)
        {
            if (DEBUGARR[x][0] != null)
                System.out.println("["+DEBUGARR[x][0]+"]["+DEBUGARR[x][1]+"]["+DEBUGARR[x][2]+"]: "+DEBUGARR[x][3]);
        }
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
            write(Constants.DebugLocation.BTDebug,Constants.Severity.WARNING,"Debug unable to write to file");
        }
    }
}
