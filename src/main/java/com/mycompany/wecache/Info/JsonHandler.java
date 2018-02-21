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
            ArrayList<Cache> retrieved = retrieveWaitlistCaches();
            System.out.println("Store Waitlist Retrieval:" + retrieved);
            
            String path = "src\\main\\java\\com\\mycompany\\wecache\\Caches\\";
            Writer writer = new OutputStreamWriter(new FileOutputStream(path + "Waitlist_Caches.json"), "UTF-8");
            
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            
            json.toJson(merge(retrieved, available), writer);
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
            
            Gson json = new GsonBuilder().create();
            
            ArrayList<Cache> output = json.fromJson(reader, new TypeToken<ArrayList<Cache>>() {}.getType());
            
            if (output != null)
            {
                return output;
            }
            else
            {
                return new ArrayList<Cache>();
            }
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        return new ArrayList<Cache>();
        
    }
    
    public static void storeWaitlistCaches(ArrayList<Cache> waitlist)
    {
        
        try
        {
            
            ArrayList<Cache> retrieved = retrieveWaitlistCaches();
            
            String path = "src\\main\\java\\com\\mycompany\\wecache\\Caches\\";
            Writer writer = new OutputStreamWriter(new FileOutputStream(path + "Waitlist_Caches.json"), "UTF-8");
            
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            
            json.toJson(merge(retrieved, waitlist), writer);
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
            
            Gson json = new GsonBuilder().create();
            ArrayList<Cache> output =  json.fromJson(reader, new TypeToken<ArrayList<Cache>>() {}.getType());
            
            if (output != null)
            {
                return output;
            }
            else
            {
                return new ArrayList<Cache>();
            }
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        return new ArrayList<Cache>();
    }
    
    public static void makeAvailable(Cache selectedCache)
    {
        
        // WIP
        
        return;
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
