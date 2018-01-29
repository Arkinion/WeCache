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
            String path = "U:\\My Documents\\Nicholas_CompSci3\\WeCacheRepository\\WeCache\\src\\main\\java\\com\\mycompany\\wecache\\Caches\\Available_Caches.json";
            Writer writer = new OutputStreamWriter(new FileOutputStream(path), "UTF-8");
            
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            json.toJson(available, writer);
            
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
            String path = System.getenv("APPDATA") + "/WeCache/Caches/Available_Caches.json";
            Reader reader = new InputStreamReader(JsonHandler.class.getResourceAsStream(path), "UTF-8");
            
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
            String path = System.getenv("APPDATA") + "/WeCache/Caches/Waitlist_Caches.json";
            Writer writer = new OutputStreamWriter(new FileOutputStream(path), "UTF-8");
            
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            json.toJson(waitlist, writer);
            
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
            String path = System.getenv("APPDATA") + "/WeCache/Caches/Waitlist_Caches.json";
            Reader reader = new InputStreamReader(JsonHandler.class.getResourceAsStream(path), "UTF-8");
            
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            return json.fromJson(reader, new TypeToken<ArrayList<Cache>>() {}.getType());
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        return null;
    }
    
}
