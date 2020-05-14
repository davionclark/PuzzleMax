package com.example.my_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.graphics.drawable.BitmapDrawable;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;


import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    Context context = this;
    ArrayList<ImageButton> buttons = new ArrayList<>();

    Bitmap smallBitmap;
    Bitmap holderMap;

    Drawable myDrawable;

    int resourceInt;
    int buttonID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton button1 = findViewById(R.id.imageButton);
        ImageButton button2 = findViewById(R.id.imageButton2);
        ImageButton button3 = findViewById(R.id.imageButton3);
        ImageButton button4 = findViewById(R.id.imageButton4);
        ImageButton button5 = findViewById(R.id.imageButton5);
        ImageButton button6 = findViewById(R.id.imageButton6);
        ImageButton button7 = findViewById(R.id.imageButton7);
        ImageButton button8 = findViewById(R.id.imageButton8);
        ImageButton button9 = findViewById(R.id.imageButton9);

        resourceInt = R.drawable.nature;
        BitmapFactory.Options options = bitResizer();
        smallBitmap = BitmapFactory.decodeResource(getResources(), resourceInt, options);
        button1.setImageBitmap(smallBitmap);

        resourceInt = R.drawable.drop;
        smallBitmap = BitmapFactory.decodeResource(getResources(), resourceInt, options);
        button2.setImageBitmap(smallBitmap);

        resourceInt = R.drawable.angel;
        smallBitmap = BitmapFactory.decodeResource(getResources(), resourceInt, options);
        button3.setImageBitmap(smallBitmap);

        resourceInt = R.drawable.wave;
        smallBitmap = BitmapFactory.decodeResource(getResources(), resourceInt, options);
        button4.setImageBitmap(smallBitmap);

        resourceInt = R.drawable.city;
        smallBitmap = BitmapFactory.decodeResource(getResources(), resourceInt, options);
        button5.setImageBitmap(smallBitmap);

        resourceInt = R.drawable.autumn;
        smallBitmap = BitmapFactory.decodeResource(getResources(), resourceInt, options);
        button6.setImageBitmap(smallBitmap);

        resourceInt = R.drawable.cave;
        smallBitmap = BitmapFactory.decodeResource(getResources(), resourceInt, options);
        button7.setImageBitmap(smallBitmap);

        resourceInt = R.drawable.clock;
        smallBitmap = BitmapFactory.decodeResource(getResources(), resourceInt, options);
        button8.setImageBitmap(smallBitmap);

        resourceInt = R.drawable.sunset;
        smallBitmap = BitmapFactory.decodeResource(getResources(), resourceInt, options);
        button9.setImageBitmap(smallBitmap);
    }

    public void onClick(View view){

        ImageButton button1 = findViewById(R.id.imageButton);
        ImageButton button2 = findViewById(R.id.imageButton2);
        ImageButton button3 = findViewById(R.id.imageButton3);
        ImageButton button4 = findViewById(R.id.imageButton4);
        ImageButton button5 = findViewById(R.id.imageButton5);
        ImageButton button6 = findViewById(R.id.imageButton6);
        ImageButton button7 = findViewById(R.id.imageButton7);
        ImageButton button8 = findViewById(R.id.imageButton8);
        ImageButton button9 = findViewById(R.id.imageButton9);

        if(view.getId() == button1.getId()){
            resourceInt = R.drawable.nature;
            holderMap = ((BitmapDrawable)button1.getDrawable()).getBitmap();

        }
        else if(view.getId() == button2.getId()){
            resourceInt = R.drawable.drop;
            holderMap = ((BitmapDrawable)button2.getDrawable()).getBitmap();

        }
        else if(view.getId() == button3.getId()){
            resourceInt = R.drawable.angel;
            holderMap = ((BitmapDrawable)button3.getDrawable()).getBitmap();

        }
        else if(view.getId() == button4.getId()){
            resourceInt = R.drawable.wave;
            holderMap = ((BitmapDrawable)button4.getDrawable()).getBitmap();

        }
        else if(view.getId() == button5.getId()){
            resourceInt = R.drawable.city;
            holderMap = ((BitmapDrawable)button5.getDrawable()).getBitmap();

        }
        else if(view.getId() == button6.getId()){
            resourceInt = R.drawable.autumn;
            holderMap = ((BitmapDrawable)button6.getDrawable()).getBitmap();

        }
        else if(view.getId() == button7.getId()){
            resourceInt = R.drawable.cave;
            holderMap = ((BitmapDrawable)button7.getDrawable()).getBitmap();

        }
        else if(view.getId() == button8.getId()){
            resourceInt = R.drawable.clock;
            holderMap = ((BitmapDrawable)button8.getDrawable()).getBitmap();

        }
        else if(view.getId() == button9.getId()){
            resourceInt = R.drawable.sunset;
            holderMap = ((BitmapDrawable)button9.getDrawable()).getBitmap();
        }

        buttonID = view.getId();

        if(holderMap != null){
            Intent intent = new Intent(SelectionActivity.this, MainActivity.class);
            intent.putExtra("puzzleRetrieval",resourceInt);
            startActivity(intent);
            finish();
        }

    }

    public BitmapFactory.Options bitResizer(){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        options.inSampleSize = calculateInSampleSize(options, 1080,1920);
        options.inJustDecodeBounds = false;

        return options;
    }
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

}
