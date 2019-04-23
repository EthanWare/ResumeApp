package com.ware.android.ware_resume;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;

public class SkillsActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    //public static final int DETAILS_REQUEST = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean setDarkTheme = sharedPref.getBoolean("setDarkTheme", false);

        setTheme(setDarkTheme ? R.style.AppThemeDark : R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.skills_activity);
        /*
        // Put initial data into the word list.
        for (int i = 0; i < 5; i++) {
            mWordList.addLast("Word " + i);
        }
        */
        // Put initial data into the RecyclerView.
        String[] skills = new String[]{"Programming","SQL Database","Leadership/Communication","Problem Solving"};
        for (int i = 0; i < skills.length; i++) {
            mWordList.addLast(skills[i]);
        }


        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*
        TextView word = (TextView) findViewById(R.id.word);
        word.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SkillsActivity.this, details_activity.class);
                startActivityForResult(intent, DETAILS_REQUEST);
            }
        });
        */
    }
}
