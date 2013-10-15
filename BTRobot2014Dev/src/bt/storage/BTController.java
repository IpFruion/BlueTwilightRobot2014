/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage;

import bt.storage.BTDebugger;
import bt.main.Constants;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Dlock
 */
public class BTController {
    
    Joystick xboxCon;
    BTDebugger debug;
    public boolean[] BUTTONS = new boolean[11];
    public double[] AXES = new double[8];
    
    public BTController(BTDebugger debug)
    {
        this.debug = debug;
        debug.write(Constants.LOCATION_ARR[2], Constants.SEVERITY_ARR[0], "Xbox Controller Init Start");
        
        xboxCon = new Joystick(Constants.XBOX_CONTROLLER_PORT);
        
        debug.write(Constants.LOCATION_ARR[2], Constants.SEVERITY_ARR[0], "Xbox Controller Init End");
    }
    public void update()
    {
        for (int x = 1; x<BUTTONS.length;x++)
        {
            BUTTONS[x] = xboxCon.getRawButton(x);
        }
        for (int x = 1; x<AXES.length;x++)
        {
            AXES[x] = xboxCon.getRawAxis(x);
        }
    }
}
