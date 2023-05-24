package com.bookStore.tests;

import com.bookStore.utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

public class DataForApi {
    public static Map<String,String> mapBody(){
        Map<String,String> mapBody=new HashMap<>();
        mapBody.put("userName", ConfigurationReader.get("userName"));
        mapBody.put("password",ConfigurationReader.get("password"));
        return mapBody;
    }
    public static Map<String,String> getBearerToken(){
        Map<String,String> token=new HashMap<>();
        token.put("Authorization","Bearer "+ConfigurationReader.get("token"));
        return token;
    }
}
