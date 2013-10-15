/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.control;

import bt.main.BTDriveTrain;
import bt.main.Constants;
import bt.storage.BTStorage;

/**
 *
 * @author Dlock
 */
public class BTControlBoard {
    BTStorage storage;
    BTDriveTrain dt;
    public BTControlBoard(BTStorage storage)
    {
        this.storage = storage;
        storage.debug.write(Constants.LOCATION_ARR[1], Constants.SEVERITY_ARR[0], "Control Board Init Start");
        
        dt = new BTDriveTrain(storage);
        
        storage.debug.write(Constants.LOCATION_ARR[1], Constants.SEVERITY_ARR[0], "Control Board Init End");
    }
    public void update()
    {
        dt.update();
    }
}
