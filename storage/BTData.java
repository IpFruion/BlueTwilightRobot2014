/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage;

import bt.storage.motor.BTCanJaguar;
import bt.storage.motor.BTJaguar;
import bt.storage.motor.BTMotor;
import bt.storage.motor.BTMotorFactory;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 * @author Dlock
 */
public class BTData {
    public double CYCLE = 0;
    public long TIME = 0;
    public long STIME = 0;
    public BTMotorFactory motorFactDT;
    public BTMotor Rmotor1;
    public BTMotor Rmotor2;
    public BTMotor Lmotor1;
    public BTMotor Lmotor2;
    public Encoder left_encode;
    public Encoder right_encode;
    
    public BTData(BTDebugger debug)
    {
        //DRIVETRAIN DATA
        if (Constants.IS_DT_CANBUS)
        {
            motorFactDT = new BTCanJaguar.Factory(Constants.IS_DT_VOLTAGE,debug);
        }
        else
        {
            motorFactDT = new BTJaguar.Factory();
        }
        Rmotor1 = motorFactDT.makeMotor(Constants.RIGHT_MOTOR_1_PORT);
        Rmotor2 = motorFactDT.makeMotor(Constants.RIGHT_MOTOR_2_PORT);
        Lmotor1 = motorFactDT.makeMotor(Constants.LEFT_MOTOR_1_PORT);
        Lmotor2 = motorFactDT.makeMotor(Constants.LEFT_MOTOR_2_PORT);
        
        left_encode = new Encoder(Constants.LEFT_ENCODE_A, Constants.LEFT_ENCODE_B);
        right_encode = new Encoder(Constants.RIGHT_ENCODE_A, Constants.RIGHT_ENCODE_B);
        left_encode.setDistancePerPulse(Constants.WHEEL_CIRCUMFERENCE/Constants.ENCODER_TEETH);
        right_encode.setDistancePerPulse(Constants.WHEEL_CIRCUMFERENCE/Constants.ENCODER_TEETH);
    }
    public void updateCycles()
    {
        CYCLE++;
        TIME = System.currentTimeMillis()-STIME;
    }
    public double getCyclesperSecond()
    {
        long tempTime = TIME;
        updateCycles();
        double cperS = CYCLE/TIME;
        return cperS;
    }
}
