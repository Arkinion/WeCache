/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wecache.BaseClasses;

import com.mypopsy.maps.StaticMap.GeoPoint;
import java.io.Serializable;
import com.mycompany.wecache.Info.MapFetcher;

/**
 *
 * @author User
 */
public class Cache implements Comparable, Serializable
{
    
    private GeoPoint location;
    private int timesFound;
    private boolean available;
    
    public Cache(GeoPoint l)
    {
        location = l;
        timesFound = 0;
        available = false;
    }
    
    public Cache()
    {
        location = new GeoPoint("");
        timesFound = 0;
        available = false;
    }
    
    public boolean inRange(GeoPoint c, long range)
    {
        return MapFetcher.distance(location, c) <= range * 1000;
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
        Cache c = (Cache)o;
        
        return (location.latitude() == c.getLocation().latitude() && location.longitude() == c.getLocation().longitude())
                || location.address().equals(c.getLocation().address());
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
