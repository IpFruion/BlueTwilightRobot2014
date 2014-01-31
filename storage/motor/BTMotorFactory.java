/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage.motor;

/**
 *
 * @author Dlock
 */
public interface BTMotorFactory {
    public BTMotor makeMotor(int port);
    public BTCanJaguar makeCanMotor(int port);
    public BTJaguar makeJagMotor(int port);
}
