package com.ware.android.ware_resume;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private String skill;
    private ArrayMap<String,String> skillsHash = new ArrayMap(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean setDarkTheme = sharedPref.getBoolean("setDarkTheme", false);

        setTheme(setDarkTheme ? R.style.AppThemeDark : R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            skill = intent.getStringExtra(WordListAdapter.SKILL);
        } else {
            skill = (String) savedInstanceState.getSerializable("SKILL");
        }
        //replace with JSON parsing
        skillsHash.put("Programming","Java, Android, C, C++, Linux Command Line");
        skillsHash.put("SQL Database","Basic SQL table design, stored procedures, and triggers");
        skillsHash.put("Leadership/Communication","Built strong leadership and communication skills through past experience as a Residential Assistant at Northern Kentucky University");
        skillsHash.put("Problem Solving","Strong problem solving skills");

        TextView skillTextView = findViewById(R.id.skill);
        TextView detailsTextView = findViewById(R.id.details);

        skillTextView.setText(skill);
        detailsTextView.setText(skillsHash.get(skill));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("SKILL", skill);
    }
}
