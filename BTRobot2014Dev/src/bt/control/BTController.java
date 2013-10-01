/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.control;

import bt.main.Constants;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Dlock
 */
public class BTController {
    
    boolean[] buttonarr;
    double[] axisarr;
    Joystick xboxCon;
    
    public BTController()
    {
        xboxCon = new Joystick(Constants.XBOX_CONTROLLER_PORT);
        buttonarr = new boolean[Constants.XBOX_CONTROLLER_BUTTONS];
    }
    public void update()
    {
        for (int x = 1; x<=buttonarr.length;x++)
        {
            buttonarr[x] = xboxCon.getRawButton(x);
        }
    }
}
