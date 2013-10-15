/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.main;

import bt.storage.BTStorage;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Dlock
 */
public class BTSmartGUI {
    BTStorage storage;
    SmartDashboard dash;
    String[] strs;
    boolean[] bols;
    int[] ints;
    
    
    public BTSmartGUI(BTStorage storage)
    {
        storage.debug.write(Constants.LOCATION_ARR[5], Constants.SEVERITY_ARR[0], "BTSmartGUI Init Start");
        
        strs = new String[Constants.CAP_LIMIT_OUTPUT];
        bols = new boolean[Constants.CAP_LIMIT_OUTPUT];
        ints = new int[Constants.CAP_LIMIT_OUTPUT];
        
        
        this.storage = storage;
        
        storage.debug.write(Constants.LOCATION_ARR[5], Constants.SEVERITY_ARR[0], "BTSmartGUI Init End");
    }
    
    public void update()
    {
        gatherData();
        
    }
    public void gatherData()
    {
        ints[0] = (int)storage.data.DRIVE_TRAIN_LEFT_VALUE;
        ints[1] = (int)storage.data.DRIVE_TRAIN_RIGHT_VALUE;
    }
}
