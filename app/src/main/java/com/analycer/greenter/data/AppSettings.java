package com.analycer.greenter.data;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSettings {

    private static final String SETT_NAME = "com.greenter.setting";
    private SharedPreferences preferences;

    public AppSettings(Context context){
        preferences = context.getSharedPreferences(SETT_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Save setting
     * @param key key
     * @param value value
     */
    public void save(String key, String value) {
        SharedPreferences.Editor editor  = preferences.edit();

        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Get value from key
     * @param key key
     * @param def default value
     * @return value from key
     */
    public String get(String key, String def) {
        return preferences.getString(key, def);
    }
}
