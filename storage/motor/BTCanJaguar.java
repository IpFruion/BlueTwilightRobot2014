/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage.motor;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author Dlock
 */
public class BTCanJaguar implements BTMotor {
    private CANJaguar motor;
    private boolean isVoltage;
    
    private BTCanJaguar(int port, boolean isVoltage)
    {
        this.isVoltage = isVoltage;
        setVoltageMode(isVoltage);
        try {
            motor = new CANJaguar(port);
        } catch (CANTimeoutException ex) {
            
        }
    }
    private void setVoltageMode(boolean isVoltage)
    {
        if (isVoltage)
        {
            try {
                motor.changeControlMode(CANJaguar.ControlMode.kVoltage);
            } catch (CANTimeoutException ex) {
                
            }
        }
    }
    public void setX(double x) {
        if (isVoltage)
        {
            x *= 12;
        }
        try {
            motor.setX(x);
        } catch (CANTimeoutException ex) {
            
        }
    }

    public void setBTVoltageRampRate(double ramprate) {
        try {
            motor.setVoltageRampRate(ramprate);
        } catch (CANTimeoutException ex) {
            
        }
    }

    public double getBTBusVoltage() {
        try {
            return motor.getBusVoltage();
        } catch (CANTimeoutException ex) {
            
        }
        return 0;
    }

    public double getBTOutputCurrent() {
        try {
            return motor.getOutputCurrent();
        } catch (CANTimeoutException ex) {
            
        }
        return 0;
    }
    public double getBTTemperature()
    {
        try {
            return motor.getTemperature();
        } catch (CANTimeoutException ex) {
            
        }
        return 0;
    }
    public static class Factory implements BTMotorFactory
    {
        private boolean isVoltage;
        public BTMotor makeMotor(int port) {
            return new BTCanJaguar(port,isVoltage);
        }
        public Factory(boolean isVoltage)
        {
            this.isVoltage = isVoltage;
        }
        public Factory()
        {
            this.isVoltage = false;
        }
    }
}
