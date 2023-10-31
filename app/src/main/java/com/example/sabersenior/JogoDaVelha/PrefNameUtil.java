package com.example.sabersenior.JogoDaVelha;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.example.sabersenior.R;

public class PrefNameUtil {

    public static String getName1(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("name_1", "Jogador 1");
    }

    public static String getName2(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("name_2", "Jogador 2");
    }

    public static void setName1(String name, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name_1", name);
        editor.commit();
    }

    public static void setName2(String name, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name_2", name);
        editor.commit();
    }
}
