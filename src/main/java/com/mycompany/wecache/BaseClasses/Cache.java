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
    
    public Cache()
    {
        location = new GeoPoint("");
    }
    
    public Cache(GeoPoint l)
    {
        location = l;
    }
    
    public GeoPoint getLocation()
    {
        return location;
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
