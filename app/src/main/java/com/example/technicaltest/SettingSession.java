package com.example.technicaltest;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingSession {
    public static final String Sp_ItIce_App = "SpPreTestApp";
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    public SettingSession(Context context){
        sp =context.getSharedPreferences(Sp_ItIce_App,Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }
    public SettingSession() {
    }
    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }
    public void setPreference(Context context, String key, String value){
        SharedPreferences.Editor editor = context.getSharedPreferences("PreTest",Context.MODE_PRIVATE).edit();
        editor.putString(key,value);
        editor.apply();
    }

    public String getPreference(Context context, String key){
        SharedPreferences preferences = context.getSharedPreferences("PreTest",Context.MODE_PRIVATE);
        String position = preferences.getString(key,"");
        return position;
    }
    public SharedPreferences getSp(){
        return sp;
    }
}
