/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.main;

import bt.storage.BTStorage;

/**
 *
 * @author Dlock
 */
public class BTSmartGUI {
    BTStorage storage;
    public BTSmartGUI(BTStorage storage)
    {
        storage.debug.write(Constants.LOCATION_ARR[5], Constants.SEVERITY_ARR[0], "BTSmartGUI Init Start");
        
        this.storage = storage;
        
        storage.debug.write(Constants.LOCATION_ARR[5], Constants.SEVERITY_ARR[0], "BTSmartGUI Init End");
    }
    
    public void update()
    {
        
    }
}
