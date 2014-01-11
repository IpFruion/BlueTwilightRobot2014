/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage.profile;

/**
 *
 * @author Dlock
 */
public abstract class Profile {
    
    abstract public double getDriveLeftStick();
    abstract public double getDriveRightStick();
    abstract public void setDriveLeft(double velocity);
    abstract public void setDriveRight(double velocity);
    
}
