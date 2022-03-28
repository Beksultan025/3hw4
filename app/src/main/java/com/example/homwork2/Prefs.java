package com.example.homwork2;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

public class Prefs {

    private SharedPreferences preferences;

    public Prefs(Context context) {
        preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    public void saveBoardState() {
        preferences.edit().putBoolean("isBoardShown", true).apply();
    }

    public Boolean isBoardShown() {
        return preferences.getBoolean("isBoardShown", false);
    }

    public void saveEditText(String name) {
        preferences.edit().putString("name", name).apply();
    }

    public String isEditText() {
        return preferences.getString("name", "");
    }
    public void saveImage(Uri image) {
        preferences.edit().putString("image", String.valueOf(image)).apply();
    }

    public Uri isImage() {
        return Uri.parse(preferences.getString("image", ""));
    }

    public void spClear (){
        preferences.edit().clear().apply();
    }


}
