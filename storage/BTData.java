/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage;

import bt.storage.motor.BTCanJaguar;
import bt.storage.motor.BTJaguar;
import bt.storage.motor.BTMotor;
import bt.storage.motor.BTMotorFactory;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 * @author Dlock
 */
public class BTData {
    
    public BTMotorFactory motorFactDT;
    public BTMotorFactory motorFactManip;
    public BTCanJaguar Rmotor1;
    public BTCanJaguar Rmotor2;
    public BTCanJaguar Lmotor1;
    public BTCanJaguar Lmotor2;
    public BTMotor manipWinch;
    public BTMotor reloadMotor;
    public BTMotor hingeMotor;
    public AnalogPotentiometer hingePOT;
    public AnalogPotentiometer collectorPOT;
    
    public Encoder left_encode;
    public Encoder right_encode;
    public Encoder manip_shoot_encode;
    
    public BTPiston manipRelease;
    public BTPiston collectorPiston;
    
    public BTData(BTDebugger debug)
    {
        //DRIVETRAIN MOTORS
        if (Constants.IS_DT_CANBUS)
        {
            motorFactDT = new BTCanJaguar.Factory(Constants.IS_DT_VOLTAGE,debug);
        }
        else
        {
            motorFactDT = new BTJaguar.Factory(debug);
        }
        if (Constants.IS_SHOOTER_CANBUS)
        {
            motorFactManip = new BTCanJaguar.Factory(Constants.IS_SHOOTER_VOLTAGE, debug);
        }
        else
        {
            motorFactManip = new BTJaguar.Factory(debug);
        }
        Rmotor1 = motorFactDT.makeCanMotor(Constants.RIGHT_MOTOR_1_PORT);
        Rmotor2 = motorFactDT.makeCanMotor(Constants.RIGHT_MOTOR_2_PORT);
        Lmotor1 = motorFactDT.makeCanMotor(Constants.LEFT_MOTOR_1_PORT);
        Lmotor2 = motorFactDT.makeCanMotor(Constants.LEFT_MOTOR_2_PORT);
        
        Rmotor1.setBTVoltageRampRate(Constants.DT_RAMPRATE);
        Rmotor2.setBTVoltageRampRate(Constants.DT_RAMPRATE);
        Lmotor1.setBTVoltageRampRate(Constants.DT_RAMPRATE);
        Lmotor2.setBTVoltageRampRate(Constants.DT_RAMPRATE);
        
        //SHOOTER MOTORS
        manipWinch = motorFactManip.makeMotor(Constants.WINCH_MOTOR_PORT);
//        reloadMotor = motorFactManip.makeMotor(Constants.RELOAD_MOTOR_PORT);
//        hingeMotor = motorFactManip.makeMotor(Constants.HINGE_MOTOR_PORT);
        //DRIVETRAIN ENCODERS
//        left_encode = new Encoder(Constants.LEFT_ENCODE_A, Constants.LEFT_ENCODE_B);
//        right_encode = new Encoder(Constants.RIGHT_ENCODE_A, Constants.RIGHT_ENCODE_B);
//        left_encode.setDistancePerPulse(Constants.WHEEL_CIRCUMFERENCE/Constants.ENCODER_TEETH);
//        right_encode.setDistancePerPulse(Constants.WHEEL_CIRCUMFERENCE/Constants.ENCODER_TEETH);
        
        manip_shoot_encode = new Encoder(Constants.MANIP_SHOOT_ENCODE_A, Constants.MANIP_SHOOT_ENCODE_B);
        manip_shoot_encode.setDistancePerPulse(Constants.MANIP_WHEEL_CIRCUMFERENCE/Constants.ENCODER_TEETH);
//        hingePOT = new AnalogPotentiometer(Constants.HINGE_POT_CHANNEL);
//        collectorPOT = new AnalogPotentiometer(Constants.COLLECTOR_POT_CHANNEL);
        //SHOOTER PISTON
//        manipRelease = new BTPiston(Constants.MANIP_RELEASE_EXTEND_PORT,Constants.MANIP_RELEASE_RETRACT_PORT);
//        collectorPiston = new BTPiston(Constants.COLLECTOR_PISTON_EXTEND_PORT,Constants.COLLECTOR_PISTON_RETRACT_PORT);
    }
    public void encoderStart()
    {
        manip_shoot_encode.start();
    }
    public void encoderReset()
    {
        manip_shoot_encode.reset();
    }
    
}
