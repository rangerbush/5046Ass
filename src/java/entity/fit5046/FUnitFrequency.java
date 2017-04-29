/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.fit5046;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 *
 * @author Ranger
 */
public class FUnitFrequency {
    
    public FUnitFrequency()
    {
        this.unitList = new HashMap();
    }
    
    private Map<String, Integer> unitList; 

    /**
     * @return the unitList
     */
    public Map<String, Integer> getUnitList() {
        return unitList;
    }

    /**
     * @param unitList the unitList to set
     */
    public void setUnitList(Map<String, Integer> unitList) {
        this.unitList = unitList;
    }
    
    public void add(String s)
    {
        if (this.unitList.containsKey(s))
        {
            Integer v = this.unitList.get(s);
            this.unitList.replace(s,v,v+1);
        }
        else
            this.unitList.put(s,1);
    }
    
}
