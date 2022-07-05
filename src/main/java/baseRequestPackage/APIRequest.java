package main.baseRequestPackage;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public  class APIRequest {
public static Map<String,Properties> map=null;
public static RequestSpecification requestSpecification=null;
public static Properties configProperties=null;
public APIRequest(boolean readConfiguration){
         if(configProperties==null){
         try {
             FileInputStream in=new FileInputStream(System.getProperty("user.dir")+"//src//main//config//config.properties");
             configProperties.load(in);
         } catch (FileNotFoundException e) {
             throw new RuntimeException(e);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }
    requestSpecification= RestAssured.given().baseUri(configProperties.get("baseURI").toString());
     if(readConfiguration&&map==null){
        FileInputStream in;
        try {
          File files=new File(System.getProperty("user.dir")+"//src//main//resources");
          File[] fileArray=files.listFiles();
          for(File e:fileArray){
              try {
                  Properties properties=new Properties();
                  in=new FileInputStream(e);
                  properties.load(in);
                  map.put(e.getCanonicalPath(),properties);
                 }
              catch (FileNotFoundException ex) {
                  throw new RuntimeException(ex);
              } catch (IOException ex) {
                  throw new RuntimeException(ex);
              }
          }
        }
        catch (Exception e){
            throw  new RuntimeException(e);
        }

    }

    }
    public <T extends APIRequest> void setupAPIRequest(Class<T>cls){
    if(APIRequest.map!=null) {
        Properties properties= map.get(cls.getCanonicalName());
        Iterator<Object> propertiesIterator=properties.keySet().iterator();
        while(propertiesIterator.hasNext())
        {
            String p=propertiesIterator.next().toString();
            String property=p.split("@@@")[0];
            String propertyType=p.split("@@@")[1];
            requestSpecification.header(property,map.get(p));
        }
        }
    }

    public static RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public  <T extends APIRequest>Properties getProperties(Class<T> cls){
       return map.get(cls.getCanonicalName());
    }



}
