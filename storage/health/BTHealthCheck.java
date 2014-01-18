/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage.health;

import bt.storage.BTDebugger;
import bt.storage.Constants;

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
    public void checkHealth(String valName, String val)
    {
        
    }
    public void clearDash()
    {
        
    }
}
