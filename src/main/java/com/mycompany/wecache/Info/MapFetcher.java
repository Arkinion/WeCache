/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wecache.Info;

import com.mypopsy.maps.StaticMap;
import com.mypopsy.maps.StaticMap.GeoPoint;
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
    
    public static BufferedImage fetchMap(GeoPoint g)
    {
        StaticMap map = new StaticMap();
        //load(map.toURL());
        
        map.key("AIzaSyBiUqnWbs1oB299MMEZs-kPgFgc1CvRBMA");
        map.center(g);
        map.size(380, 380);
        map.type(StaticMap.Type.TERRAIN);
        
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
    
}