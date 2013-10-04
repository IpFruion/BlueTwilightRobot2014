/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.main;

/**
 *
 * @author Dlock
 */
public class BTDebugger {
    String[][] debugarr;
    public BTDebugger()
    {
        debugarr = new String[0][4];
    }
    public void write(String location, String Severity, String txt)
    {
        //tmp storage init
        String[][] debugtmp;
        String time;
        time = getCurrentSysTime();
        
        debugtmp = debugarr;
        debugarr = new String[debugtmp.length+1][4];
        
        for (int x = 0; x < debugtmp.length; x++)
        {
            for (int i = 0; i < debugtmp[x].length; i++)
            {
                debugarr[x][i] = debugtmp[x][i];
            }
        }
        debugarr[debugtmp.length-1][0] = time;
        debugarr[debugtmp.length-1][1] = getLocationName(location);
        debugarr[debugtmp.length-1][2] = getSeverityName(location);
        debugarr[debugtmp.length-1][3] = txt;
    }
    public void printDebugWARNING()
    {
        for (int x = 0; x < debugarr.length; x++)
        {
            
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
        double td = t/1000;
        String hr = Integer.toString((int)(td/3600)%24);
        String sec = Double.toString(td%60);
        String min = Integer.toString((int)(td/60)%60);
        
        return hr+":"+min+":"+sec;
    }
}
