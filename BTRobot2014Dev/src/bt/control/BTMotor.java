/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.control;

import bt.main.Constants;
import bt.storage.BTStorage;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Dlock
 */
public class BTMotor {
    
    private boolean isCANBus = false;
    private CANJaguar CANMotor;
    private Jaguar PWMMotor;
    private boolean successJag = false;
    private boolean voltage;
    private int portNum;
    BTStorage storage;
    
    public BTMotor(int port, boolean isCan, boolean isVoltage, BTStorage storage)
    {
        this.storage = storage;
        isCANBus = isCan;
        portNum = port;
        voltage = isVoltage;
        instanciate(port,isCan,isVoltage);
    }
    public void instanciate(int port, boolean isCan, boolean isVoltage)
    {
        if (isCANBus) {
            try{
                CANMotor = new CANJaguar(port);
                if (isVoltage)
                {
                    setVoltageControlMode();
                }
                successJag = true;
            }
            catch(Exception CANTimeoutException){
                storage.debug.write(Constants.LOCATION_ARR[4], Constants.SEVERITY_ARR[2], "Error initialising CANJaguar at port: " +port);
            }
        }
        else
        {
            PWMMotor = new Jaguar(port);
        }
    }
    public void setX(double x)
    {
        
        if(isCANBus && successJag)
        {
            try{
                
                CANMotor.setX(x);
            }
            catch(Exception CANTimeoutException){
                storage.debug.write(Constants.LOCATION_ARR[4], Constants.SEVERITY_ARR[2], "Error setting CANJaguar speed at "+portNum+" to value: "+x);
            }
        }
        else
        {
            PWMMotor.set(x);
        }
       
    }
    public void setBTVoltageRampRate(double ramprate)
    {
        if (voltage&&isCANBus)
        {
            try
            {
                CANMotor.setVoltageRampRate(ramprate);
            }
            catch (Exception CANTimeoutException)
            {
                storage.debug.write(Constants.LOCATION_ARR[4], Constants.SEVERITY_ARR[1], "Error setting CANJaguar ramp-rate at"+portNum+" to value: "+ramprate);
            }
        }
    }
    public double getBTBusVoltage(){
        if(isCANBus && successJag)
        {
            try{
                return CANMotor.getBusVoltage();
            }
            catch(Exception e){
                storage.debug.write(Constants.LOCATION_ARR[4], Constants.SEVERITY_ARR[1], "Error in getting voltage at "+portNum);
               
            }
        }
    return 0;
    }
    public double getBTOutputCurrent(){
        if(isCANBus && successJag)
        {            
            try{
                return CANMotor.getOutputCurrent();
        }
            catch(Exception e){
                storage.debug.write(Constants.LOCATION_ARR[4], Constants.SEVERITY_ARR[1], "Error in getting current at "+portNum);
            }
        }
    return 0;
    }
    public double getBTTemperature(){
        if(isCANBus)
        {
            try{
                return CANMotor.getTemperature();
        }
            catch (Exception e){
                storage.debug.write(Constants.LOCATION_ARR[4], Constants.SEVERITY_ARR[1], "Error in getting temperature at "+portNum);
            }    
        }
    return 0;
    }
    private void setVoltageControlMode()
    {
        try {
            CANMotor.changeControlMode(CANJaguar.ControlMode.kVoltage);
            CANMotor.enableControl();
        }
        catch(Exception e){}
    }
}
