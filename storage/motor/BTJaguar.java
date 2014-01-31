/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage.motor;

import bt.storage.BTDebugger;
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Dlock
 */
public class BTJaguar implements BTMotor {

    Jaguar jag;
    public BTJaguar(int port, BTDebugger debug)
    {
        jag = new Jaguar(port);
    }
    public void setX(double x) {
        jag.set(x);
    }

    public static class Factory implements BTMotorFactory
    {
        BTDebugger debug;
        public Factory(BTDebugger debug)
        {
            this.debug = debug;
        }
        public BTJaguar makeJagMotor(int port) {
            return new BTJaguar(port, debug);
        }

        public BTMotor makeMotor(int port) {
            return new BTJaguar(port, debug);
        }

        public BTCanJaguar makeCanMotor(int port) {
            return null;
        }
    }
}
