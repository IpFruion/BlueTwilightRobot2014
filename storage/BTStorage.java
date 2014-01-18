/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage;

/**
 *
 * @author Dlock
 */
public class BTStorage {
    
    public BTDebugger debug;
    public BTData data;
    public BTController con;
    
    public BTStorage()
    {
        debug = new BTDebugger();
        data = new BTData(debug);
        con = new BTController(debug);
    }
    
}
