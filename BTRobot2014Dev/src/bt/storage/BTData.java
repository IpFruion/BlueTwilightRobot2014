/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage;

/**
 *
 * @author Dlock
 */
public class BTData {
    public long CYCLE = 0;
    public double DRIVE_TRAIN_LEFT_VALUE = 0.0;
    public double DRIVE_TRAIN_RIGHT_VALUE = 0.0;
    public BTData()
    {
        
    }
    public void updateCycles()
    {
        CYCLE++;
    }
}
