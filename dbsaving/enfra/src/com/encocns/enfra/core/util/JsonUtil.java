/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file JsonUtil.java
 * @brief 
 */
/**
 * @namespace com.encocns.enfra.core.util
 * @brief 
 */
package com.encocns.enfra.core.util;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * @brief 
 * @details 
 * @author : CHA, SANG-GIL
 * @date : 2019. 6. 26.
 * @version : 1.0.0
 */
public class JsonUtil {

//    public static Gson gson = new GsonBuilder().serializeNulls().create();
    public static Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
    public static JsonParser parser = new JsonParser();
    public static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {

        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            // 
            
            Class<T> rawType = (Class<T>) type.getRawType();
            
            if( rawType != String.class ){
                return null;
            }
            
            return (TypeAdapter<T>) new StringAdapter();
        }
        
    }
    
    public static class StringAdapter extends TypeAdapter<String> {

        @Override
        public String read(JsonReader reader) throws IOException {
            if(reader.peek()==JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }

        @Override
        public void write(JsonWriter writer, String value) throws IOException {
            if(  value==null ) {
//                writer.nullValue();
                writer.value("");
                return;
            }
            writer.value(value);
        }
    }
    
    
    public static JsonObject toJsonObject( Object obj ) {
        return parser.parse(gson.toJson(obj)).getAsJsonObject();
    }
    
    public static JsonArray toJsonArray( Object obj ) {
        return parser.parse(gson.toJson(obj)).getAsJsonArray();
    }
    
    public static JsonElement getObject( Object obj ) {
        return new Gson().toJsonTree(obj);
    }
    
    public static JsonObject toJsonObject( String json ) 
    {
        JsonElement el = parser.parse(json);
        
        return el.getAsJsonObject();
    }
    
    public static JsonArray toJsonArray( String json ) 
    {
        JsonElement el = parser.parse(json);
        return el.getAsJsonArray();
    }
    
    public static void main(String[] args) {
        
        String param = "{a : 1, b : \"2\"}";
        System.out.println(JsonUtil.toJsonObject(param));
    }
    
}
