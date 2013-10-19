/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.main;

import bt.control.BTMotor;
import bt.control.BTPiston;
import bt.storage.BTStorage;

/**
 *
 * @author Dlock
 */
public class BTDriveTrain {
    BTStorage storage;
    BTMotor left;
    BTMotor right;
    BTMotor left_2;
    BTMotor right_2;
    BTPiston shifter;
    double leftSpeed = 0;
    double rightSpeed = 0;
    boolean prevShifterVal;
    boolean shifterSetting;
    public BTDriveTrain(BTStorage store)
    {
        
        storage = store;
        left = new BTMotor(Constants.LEFT_MOTOR_PORT,true,true,store);
        right = new BTMotor(Constants.RIGHT_MOTOR_PORT,true,true,store);
        left_2 = new BTMotor(Constants.LEFT_2_MOTOR_PORT,true,true,store);
        right_2 = new BTMotor(Constants.RIGHT_2_MOTOR_PORT,true,true,store);
        
        shifter = new BTPiston(Constants.SHIFTER_EXTEND_PORT,Constants.SHIFTER_RETRACT_PORT);
        prevShifterVal = false;
        shifterSetting = false;
        
        //RampRate
        left.setBTVoltageRampRate(Constants.VOLTAGE_RAMP_RATE);
        left_2.setBTVoltageRampRate(Constants.VOLTAGE_RAMP_RATE);
        right.setBTVoltageRampRate(Constants.VOLTAGE_RAMP_RATE);
        right_2.setBTVoltageRampRate(Constants.VOLTAGE_RAMP_RATE);
        shifter.retract();
    }
    
    public void update()
    {
        tankDrive();
        //fpsDrive();
        updateShifter();
    }
    public void tankDrive()
    {
        leftSpeed = storage.xbox.AXES[Constants.LEFT_STICK_UP_DOWN_PORT];
        rightSpeed = storage.xbox.AXES[Constants.RIGHT_STICK_UP_DOWN_PORT];
        
        leftSpeed = calcSpeed(leftSpeed);
        rightSpeed = calcSpeed(rightSpeed);
        
        storage.data.DRIVE_TRAIN_LEFT_VALUE = leftSpeed;
        
        left.setX(leftSpeed);
        left_2.setX(leftSpeed);
        right.setX(-rightSpeed);
        right_2.setX(-rightSpeed);
    }
    public void fpsDrive()
    {
        leftSpeed = storage.xbox.AXES[Constants.LEFT_STICK_UP_DOWN_PORT];
        rightSpeed = storage.xbox.AXES[Constants.RIGHT_STICK_LEFT_RIGHT_PORT];
        
        leftSpeed = calcSpeed(leftSpeed);
        rightSpeed = calcSpeed(rightSpeed);
        
        left.setX(leftSpeed);
        left_2.setX(leftSpeed);
        right.setX(-leftSpeed);
        right_2.setX(-leftSpeed);
        
        left.setX(rightSpeed);
        left_2.setX(rightSpeed);
        right.setX(rightSpeed);
        right_2.setX(rightSpeed);
    }
    public void updateShifter()
    {
        boolean curShifterVal = storage.xbox.BUTTONS[Constants.RIGHT_BUMPER_BUTTON];
        if (!prevShifterVal && curShifterVal)
        {
            shifter.set(shifterSetting);
        }
        shifterSetting = !shifterSetting;
        prevShifterVal = curShifterVal;
    }
    public double calcSpeed(double joyIn)
    {
        return joyIn*12;
    }
}
