/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package bt.main;

import bt.control.BTControlBoard;
import bt.storage.BTStorage;
import edu.wpi.first.wpilibj.SimpleRobot;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class BTmain extends SimpleRobot {
    public BTControlBoard cb;
    public BTStorage storage;
    public BTSmartGUI gui;
    private boolean isInit = false;
    public void robotInit()
    {
        isInit = true;
        
        storage = new BTStorage();
        
        storage.debug.write(Constants.LOCATION_ARR[0], Constants.SEVERITY_ARR[0], "Robot Init Started");
        gui = new BTSmartGUI(storage);
        cb = new BTControlBoard(storage);
        
        storage.debug.write(Constants.LOCATION_ARR[0], Constants.SEVERITY_ARR[0], "Robot Init Ended");
    }
    
    public void autonomous() 
    {
        
    }

    public void operatorControl() 
    {
        storage.debug.write(Constants.LOCATION_ARR[0], Constants.SEVERITY_ARR[0], "Is Operator Control Start");
        while (isOperatorControl())
        {
            //can be moved incase of latency
            storage.xbox.update();
            
            cb.update();
            gui.update();
            
            storage.data.updateCycles();
        }
    }
    
    public void disabled()
    {
        if(isInit)
        {
            storage.debug.write(Constants.LOCATION_ARR[0], Constants.SEVERITY_ARR[0], "In Disabled Mode");
            if (Constants.DEBUG_DURING_DISABLED)
            {
                storage.debug.write(Constants.LOCATION_ARR[0], Constants.SEVERITY_ARR[0], "Printing Debug Output");
                storage.debug.printDebugWARNING();
            }
        }
    }
}
