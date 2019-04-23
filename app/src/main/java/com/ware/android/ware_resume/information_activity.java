package com.ware.android.ware_resume;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class information_activity extends AppCompatActivity {

    private Button skills;
    private Button previous;
    private Button next;
    private ImageView imageView;
    private int currentImage;
    int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3};

    public static final int SETTINGS_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean setDarkTheme = sharedPref.getBoolean("setDarkTheme", false);

        setTheme(setDarkTheme ? R.style.AppThemeDark : R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_activity);

        previous = (Button) findViewById(R.id.previous);
        next = (Button) findViewById(R.id.next);
        imageView = (ImageView) findViewById(R.id.imageView);
        skills = (Button) findViewById(R.id.skills);

        if (savedInstanceState != null) {
            currentImage = savedInstanceState.getInt("currentImage");
            if (currentImage == 0) {
                imageView.setImageResource(images[0]);
                previous.setVisibility(INVISIBLE);
            } else if (currentImage == 1) {
                imageView.setImageResource(images[1]);
                previous.setVisibility(VISIBLE);
            } else {
                imageView.setImageResource(images[2]);
                previous.setVisibility(VISIBLE);
                next.setVisibility(INVISIBLE);
            }
        } else {
            currentImage = 0;
        }

        previous.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imageView = (ImageView) findViewById(R.id.imageView);
                if (currentImage == 2) {
                    imageView.setImageResource(images[1]);
                    currentImage = 1;
                    next.setVisibility(VISIBLE);
                } else if (currentImage == 1) {
                    imageView.setImageResource(images[0]);
                    currentImage = 0;
                    previous.setVisibility(INVISIBLE);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imageView = (ImageView) findViewById(R.id.imageView);
                if (currentImage == 0) {
                    imageView.setImageResource(images[1]);
                    currentImage = 1;
                    previous.setVisibility(VISIBLE);
                } else if (currentImage == 1) {
                    imageView.setImageResource(images[2]);
                    currentImage = 2;
                    next.setVisibility(INVISIBLE);
                }
            }
        });


        skills.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(information_activity.this, SkillsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.settings) {
            Intent intent = new Intent(information_activity.this, SettingsActivity.class);
            startActivityForResult(intent, SETTINGS_REQUEST);
        }
        //this.recreate();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentImage", currentImage);
    }
}