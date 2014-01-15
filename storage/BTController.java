/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Dlock
 */
public class BTController 
{
    public BTController(BTDebugger debug)
    {
        this.debug = debug;
    }
    private BTDebugger debug;
    public Joystick xbox = new Joystick(Constants.XBOX_CONTROLLER_PORT);
    public final Button A_BUTTON = new Button(1);
    public final Button B_BUTTON = new Button(2);
    public final Button X_BUTTON = new Button(3);
    public final Button Y_BUTTON = new Button(4);
    public final Button LEFT_BUMPER_BUTTON = new Button(5);
    public final Button RIGHT_BUMPER_BUTTON = new Button(6);
    public final Button BACK_BUTTON = new Button(7);
    public final Button START_BUTTON = new Button(8);
    public final Button LEFT_STICK_BUTTON = new Button(9);
    public final Button RIGHT_STICK_BUTTON = new Button(10);
    
    
    public final Axis LEFT_STICK_LEFT_RIGHT = new Axis(1);
    public final Axis LEFT_STICK_UP_DOWN = new Axis(2);
    public final Axis TRIGGER = new Axis(3);
    public final Axis RIGHT_STICK_LEFT_RIGHT = new Axis(4);
    public final Axis RIGHT_STICK_UP_DOWN = new Axis(5);
    public final Axis DPAD_LEFT_RIGHT = new Axis(6);
    
    public final class Button
    {
        int port;
        boolean prevVal = false;
        public Button(int port)
        {
            this.port = port;
        }
        public boolean getBoolVal()
        {
            prevVal = xbox.getRawButton(port);
            return prevVal;
        }
        public boolean getLeadingEdge()
        {
            boolean current = xbox.getRawButton(port);
            boolean state = false;
            if (!prevVal && current)
            {
                state = true;
            }
            prevVal = current;
            return state;
        }
        public boolean getBackEdge()
        {
            boolean current = xbox.getRawButton(port);
            boolean state = false;
            if (prevVal && !current)
            {
                state = true;
            }
            prevVal = current;
            return state;
        }
        public boolean getContinousEdge()
        {
            boolean current = xbox.getRawButton(port);
            boolean state = false;
            if (prevVal && current)
            {
                state = true;
            }
            prevVal = current;
            return state;
        }
    }
    public final class Axis
    {
        int port;
        public Axis(int port)
        {
            this.port = port;
        }
        public double getVal()
        {
            return xbox.getRawAxis(port);
        }
    }
}
