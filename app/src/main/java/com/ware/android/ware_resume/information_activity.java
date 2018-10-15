package com.ware.android.ware_resume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class information_activity extends AppCompatActivity {

    private Button previous;
    private Button next;
    private ImageView imageView;
    private int currentImage;
    int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_activity);

        previous = (Button)findViewById(R.id.previous);
        next = (Button)findViewById(R.id.next);
        imageView = (ImageView)findViewById(R.id.imageView);

        if(savedInstanceState != null){
            currentImage = savedInstanceState.getInt("currentImage");
            if(currentImage == 0){
                imageView.setImageResource(images[0]);
                previous.setVisibility(INVISIBLE);
            }
            else if(currentImage == 1){
                imageView.setImageResource(images[1]);
                previous.setVisibility(VISIBLE);
            }
            else{
                imageView.setImageResource(images[2]);
                previous.setVisibility(VISIBLE);
                next.setVisibility(INVISIBLE);
            }
        }
        else {
            currentImage = 0;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentImage",currentImage);
    }

    public void previousImage(View view) {
        imageView = (ImageView)findViewById(R.id.imageView);
        if(currentImage == 2){
            imageView.setImageResource(images[1]);
            currentImage = 1;
            next.setVisibility(VISIBLE);
        }
        else if(currentImage == 1){
            imageView.setImageResource(images[0]);
            currentImage = 0;
            previous.setVisibility(INVISIBLE);
        }
    }

    public void nextImage(View view) {
        imageView = (ImageView)findViewById(R.id.imageView);
        if(currentImage == 0){
            imageView.setImageResource(images[1]);
            currentImage = 1;
            previous.setVisibility(VISIBLE);
        }
        else if(currentImage == 1){
            imageView.setImageResource(images[2]);
            currentImage = 2;
            next.setVisibility(INVISIBLE);
        }
    }
}
