/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package bt.main;

import bt.control.BTControlBoard;
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
    public BTDebugger debug;
    
    public void initRobot()
    {
        debug = new BTDebugger();
        debug.write(Constants.LOCATION_ARR[0], Constants.SEVERITY_ARR[0], "Robot Init Started");
        
        cb = new BTControlBoard(debug);
        
        debug.write(Constants.LOCATION_ARR[0], Constants.SEVERITY_ARR[0], "Robot Init Ended");
    }
    
    public void autonomous() 
    {
        
    }

    public void operatorControl() 
    {
        debug.write(Constants.LOCATION_ARR[0], Constants.SEVERITY_ARR[0], "Is Operator Control Start");
        while (isOperatorControl())
        {
            
        }
    }
    
    public void Disabled()
    {
        debug.write(Constants.LOCATION_ARR[0], Constants.SEVERITY_ARR[0], "In Disabled Mode");
    }
}
