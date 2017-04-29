/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.fit5046;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 *
 * @author Ranger
 */
public class LocationAndStudent implements Serializable{
    private String fn;
    private String ln;
    private double latitude;
    private double longtitude;

    public LocationAndStudent()
    {
        
    }
    
    public LocationAndStudent(String fn,String ln,double latitude,double longtitude)
    {
        this.fn =fn;
        this.ln = ln;
        this.latitude =latitude;
        this.longtitude = longtitude;
    }

    /**
     * @return the fn
     */
    public String getFn() {
        return fn;
    }

    /**
     * @param fn the fn to set
     */
    public void setFn(String fn) {
        this.fn = fn;
    }

    /**
     * @return the ln
     */
    public String getLn() {
        return ln;
    }

    /**
     * @param ln the ln to set
     */
    public void setLn(String ln) {
        this.ln = ln;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longtitude
     */
    public double getLongtitude() {
        return longtitude;
    }

    /**
     * @param longtitude the longtitude to set
     */
    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

}
