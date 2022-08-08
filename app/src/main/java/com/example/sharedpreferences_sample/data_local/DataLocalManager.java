package com.example.sharedpreferences_sample.data_local;

import android.content.Context;

import com.example.sharedpreferences_sample.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataLocalManager {

    private static final String PREF_OBJECT_USER = "PREF_OBJECT_USER" ;
    private static final String PREF_LIST_USER = "PREF_LIST_USER";
    private static DataLocalManager instance;
    private mySharedPreferences mySharedPreferences;

    public static void init(Context context){
        instance = new DataLocalManager();
        instance.mySharedPreferences = new mySharedPreferences(context);
    }

    public static DataLocalManager getInstance(){
        if(instance == null){
            instance = new DataLocalManager();
        }
        return instance;
    }

    public static void setUser(User user){
        Gson gson = new Gson();
        String strJsonUser = gson.toJson(user);
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_OBJECT_USER , strJsonUser);
    }

    public static User getUser(){
        String strJsonUser = DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_OBJECT_USER);
        Gson gson = new Gson();
        User user = gson.fromJson(strJsonUser , User.class);
        return user;
    }

    public static void setListUsers(List<User> listUsers){
        Gson gson = new Gson();
        JsonArray jsonArray = gson.toJsonTree(listUsers).getAsJsonArray();
        String strJsonArray = jsonArray.toString();
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_LIST_USER,strJsonArray);
    }

    public static List<User> getListUser (){
        String strJsonArray = DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_LIST_USER);
        List<User> listUser = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJsonArray);
            JSONObject jsonObject;
            User user;
            Gson gson = new Gson();
            for(int i=0 ;i<jsonArray.length() ; i++){
                jsonObject = jsonArray.getJSONObject(i);
                user = gson.fromJson(jsonObject.toString(),User.class);
                listUser.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listUser;
    }
}
