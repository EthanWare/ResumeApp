package com.ware.android.ware_resume;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat  {
    public static final String DARK_THEME = "DarkTheme";
    public static final int MODE_PRIVATE = 0;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(((SettingsActivity)getContext()));
        Boolean setDark = sharedPref.getBoolean("setDarkTheme", false);

        ((SettingsActivity)getContext()).setTheme(setDark ? R.style.AppThemeDark : R.style.AppTheme);

        setPreferencesFromResource(R.xml.preferences, rootKey);
        Preference setDarkTheme = findPreference("setDarkTheme");
        setDarkTheme.setOnPreferenceChangeListener(
                new Preference.OnPreferenceChangeListener(){
                    @Override
                    public boolean onPreferenceChange(Preference preference, Object newValue){
                        Intent intent = ((SettingsActivity)getContext()).getIntent();
                        ((SettingsActivity)getContext()).finish();
                        startActivity(intent);

                        return true;
                    }
                }

        );
    }
}