/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wecache.Info;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mycompany.wecache.BaseClasses.Cache;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class JsonHandler
{
    
    private JsonHandler() throws Exception
    {
        throw new Exception("MapFetcher cannot be instantiated.");
    }
    
    public static void storeAvailableCaches(ArrayList<Cache> available)
    {
        
        try
        {
            String path = "src\\main\\java\\com\\mycompany\\wecache\\Caches\\";
            
            Writer writer = new OutputStreamWriter(new FileOutputStream(path + "Available_Caches.json"), "UTF-8");
            
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            
            json.toJson(merge(retrieveAvailableCaches(), available), writer);
            writer.flush();
            
            writer.close();
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public static ArrayList<Cache> retrieveAvailableCaches()
    {
        
        try
        {
            String path = "src\\main\\java\\com\\mycompany\\wecache\\Caches\\";
            Reader reader = new InputStreamReader(new FileInputStream(path + "Available_Caches.json"), "UTF-8");
            
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            
            return json.fromJson(reader, new TypeToken<ArrayList<Cache>>() {}.getType());
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        return null;
        
    }
    
    public static void storeWaitlistCaches(ArrayList<Cache> waitlist)
    {
        
        try
        {
            String path = "src\\main\\java\\com\\mycompany\\wecache\\Caches\\";
            Writer writer = new OutputStreamWriter(new FileOutputStream(path + "Waitlist_Caches.json"), "UTF-8");
            
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            
            json.toJson(merge(retrieveWaitlistCaches(), waitlist), writer);
            writer.flush();
            
            writer.close();
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public static ArrayList<Cache> retrieveWaitlistCaches()
    {
        
        try
        {
            String path = "src\\main\\java\\com\\mycompany\\wecache\\Caches\\";
            Reader reader = new InputStreamReader(new FileInputStream(path + "Waitlist_Caches.json"), "UTF-8");
            
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            return json.fromJson(reader, new TypeToken<ArrayList<Cache>>() {}.getType());
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        return null;
    }
    
    private static ArrayList<Cache> merge(ArrayList<Cache> list1, ArrayList<Cache> list2)
    {
        
        for (Cache c : list2)
        {
            list1.add(c);
        }
        
        list1.sort(null);
        
        return list1;
        
    }
    
}
