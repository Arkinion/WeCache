/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wecache.Info;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import com.mycompany.wecache.GUIs.MainWindow;
import com.mypopsy.maps.StaticMap;
import com.mypopsy.maps.StaticMap.GeoPoint;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author rose_880118
 */
public class MapFetcher
{
    
    private MapFetcher() throws Exception
    {
        throw new Exception("MapFetcher cannot be instantiated.");
    }
    
    public static BufferedImage fetchMap(GeoPoint place, Dimension size, int zoom)
    {
        StaticMap map = new StaticMap();
        
        map.key("AIzaSyBiUqnWbs1oB299MMEZs-kPgFgc1CvRBMA");
        map.center(place);
        map.marker(place);
        map.size(size.width, size.height);
        map.type(StaticMap.Type.TERRAIN);
        map.zoom(zoom);
        
        try
        {
            URL url = map.toURL();
            System.out.println(url);
            BufferedImage image = ImageIO.read(url);
            return image;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    public static LatLng locate(String address)
    {
        GeoApiContext context = MainWindow.getGeoContext();
        GeocodingResult[] results;
        
        try
        {
            results = GeocodingApi.geocode(context, address).await();
            
            if (results != null && results.length > 0)
            {
                
                for (GeocodingResult r : results)
                {
                    return r.geometry.location;
                }
                
            }
            else
            {
                return new LatLng(91, 181);
            }
        }
        catch (Exception E)
        {
            System.out.println(E);
        }
        
        return new LatLng(91, 181);
    }
    
    public static String locate(double latitude, double longitude)
    {
        LatLng coords = new LatLng(latitude, longitude);
        GeoApiContext context = MainWindow.getGeoContext();
        GeocodingResult[] results;
        String output = "";
        
        try
        {
            results = GeocodingApi.reverseGeocode(context, coords).await();
            
            if (results != null && results.length > 0)
            {
                output = results[0].formattedAddress;
                
                for (GeocodingResult r : results)
                {
                    if ((r.formattedAddress.split(",").length > output.split(",").length)
                            || (r.formattedAddress.length() > output.length()
                                && r.formattedAddress.split(",").length == output.split(",").length))
                    {
                        output = r.formattedAddress;
                    }
                }

                System.out.println(output);
                return output;
            }
            else
            {
                System.out.println("Location not found.");
                return "";
            }
        }
        catch (Exception E)
        {
            System.out.println(E);
        }
        
        // Check https://www.programcreek.com/java-api-examples/index.php?api=com.google.maps.GeoApiContext
        
        // Check https://www.programcreek.com/java-api-examples/?api=com.google.maps.GeocodingApi
        
        return "";
    }
    
    public static long distance(GeoPoint geo1, GeoPoint geo2)
    {
        
        LatLng originCoords = new LatLng(geo1.latitude(), geo1.longitude());
        LatLng targetCoords = new LatLng(geo2.latitude(), geo2.longitude());
        GeoApiContext context = MainWindow.getGeoContext();
        DistanceMatrix result;
        long output;
                
        try
        {
            result = DistanceMatrixApi.newRequest(context)
                .origins(originCoords)
                .destinations(targetCoords)
                .mode(TravelMode.DRIVING)
                .units(Unit.METRIC)
                .language("en-US")
                .await();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return 0;
        }
        
        if (!(result == null || result.rows == null || result.rows[0] == null
                || result.rows[0].elements == null || result.rows[0].elements[0] == null
                || result.rows[0].elements[0].distance == null))
        {
            output =  result.rows[0].elements[0].distance.inMeters;
        }
        else
        {
            return Long.MAX_VALUE;
        }
        
        return output;
    }
    
}
