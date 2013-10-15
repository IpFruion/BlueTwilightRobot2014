/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage;

import bt.main.Constants;

/**
 *
 * @author Dlock
 */
public class BTStorage {
    
    public BTDebugger debug;
    public BTController xbox;
    public BTData data;
    
    public BTStorage()
    {
        data = new BTData();
        debug = new BTDebugger(data);
        xbox = new BTController(debug);
    }
    
}
