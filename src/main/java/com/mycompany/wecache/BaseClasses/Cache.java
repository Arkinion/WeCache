/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wecache.BaseClasses;

import com.mypopsy.maps.StaticMap.GeoPoint;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class Cache implements Comparable, Serializable
{
    
    private GeoPoint location;
    private int timesFound;
    private boolean available;
    
    public Cache()
    {
        location = new GeoPoint("");
        timesFound = 0;
        available = false;
    }
    
    public Cache(GeoPoint l)
    {
        location = l;
        timesFound = 0;
        available = false;
    }
    
    public void find()
    {
        timesFound++;
    }
    
    public void setAvailability(boolean a)
    {
        available = a;
    }
    
    public boolean isAvailable()
    {
        return available;
    }
    
    public int getTimesFound()
    {
        return timesFound;
    }
    
    public GeoPoint getLocation()
    {
        return location;
    }
    
    @Override
    public boolean equals(Object o)
    {
        return location.equals(location);
    }
    
    @Override
    public String toString()
    {
        return location.toString();
    }

    @Override
    public int compareTo(Object o)
    {
        return toString().compareTo(o.toString());
    }
    
}
