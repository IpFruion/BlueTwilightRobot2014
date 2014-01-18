/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage.health;

import bt.storage.health.BTStatistic.BTStatBoolean;
import bt.storage.health.BTStatistic.BTStatNum;
import bt.storage.health.BTStatistic.BTStatString;

/**
 *
 * @author Dlock
 */
public class BTStatGroup
    {
        public final String groupName;
        public BTStatGroup(String groupName)
        {
            this.groupName = groupName;
        }
        public BTStatString newStringStat(String name, String initVal, boolean isDisplayed)
        {
            return new BTStatString(name,groupName,initVal,isDisplayed);
        }
        public BTStatNum newNumStat(String name, double initVal, boolean isDisplayed)
        {
            return new BTStatNum(name,groupName,initVal,isDisplayed);
        }
        public BTStatBoolean newBoolStat(String name, boolean initVal, boolean isDisplayed)
        {
            return new BTStatBoolean(name,groupName,initVal,isDisplayed);
        }
    }
