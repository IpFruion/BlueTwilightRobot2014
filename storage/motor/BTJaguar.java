/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage.motor;

import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Dlock
 */
public class BTJaguar implements BTMotor {

    Jaguar jag;
    public BTJaguar(int port)
    {
        jag = new Jaguar(port);
    }
    public void setX(double x) {
        jag.set(x);
    }
    public static class Factory implements BTMotorFactory
    {

        public BTMotor makeMotor(int port) {
            return new BTJaguar(port);
        }
        
    }
}
