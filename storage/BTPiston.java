package bt.storage;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * A simple utility class to make pistons easier to use
 * @author Martin Wickham (MartinWickham@comcast.net)
 */
public class BTPiston {
    private final Solenoid left;
    private final Solenoid right;
    
    /**
     * Creates a piston with solenoids on the given ports
     * @param extendPort the port to which the solenoid to extend the piston is connected
     * @param retractPort the port to which the solenoid to retract the piston is connected
     */
    public BTPiston(int extendPort, int retractPort) {
        left = new Solenoid(extendPort);
        right = new Solenoid(retractPort);
    }
    
    /**
     * sets the piston to the given value
     * @param up extend if true, retract if false;
     */
    public void set(boolean up) {
        left.set(up);
        right.set(!up);
    }
    
    /**
     * extends the piston
     */
    public void extend() {
        set(true);
    }
    
    /**
     * retracts the piston
     */
    public void retract() {
        set(false);
    }
    
    /**
     * returns true if the piston is extended, false otherwise.
     * @return true if the piston is extended, false otherwise.
     */
    public boolean isExtended() {
        return left.get();
    }
}