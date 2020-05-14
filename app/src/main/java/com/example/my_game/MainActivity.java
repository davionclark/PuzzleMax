package com.example.my_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ArrayList<Bitmap> pieces;

    boolean firstClick = true;

    Bitmap holderMap;
    Bitmap holderMap2;
    int resourceInt;
    Context context = this;
    ImageButton holderButton;
    ArrayList<ImageButton> buttons = new ArrayList<>();
    Random randomizer = new Random();
    ImageButton myImageButton;
    int moves = 0;
    int randInt;
    Uri imageUri;

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

        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            resourceInt = extras.getInt("puzzleRetrieval");
            if(resourceInt == 0){
                imageUri = Uri.parse(extras.getString("galleryRetrieval"));
            }

        }

        if (imageUri != null) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                bitmap = Bitmap.createScaledBitmap(bitmap,1080,1920,true);
                pieces = splitImage(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            pieces = splitImage(resourceInt);
        }

        randomizer();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void randomizer(){
        for (Bitmap piece : pieces){
            if(buttons.size() > 0){
                randInt = randomizer.nextInt(buttons.size());
                myImageButton = buttons.get(randInt);
                myImageButton.setImageBitmap(piece);
                buttons.remove(randInt);
            }
        }
    }

    public void victoryChecker(){

        ImageButton button1 = findViewById(R.id.imageButton);
        ImageButton button2 = findViewById(R.id.imageButton2);
        ImageButton button3 = findViewById(R.id.imageButton3);
        ImageButton button4 = findViewById(R.id.imageButton4);
        ImageButton button5 = findViewById(R.id.imageButton5);
        ImageButton button6 = findViewById(R.id.imageButton6);
        ImageButton button7 = findViewById(R.id.imageButton7);
        ImageButton button8 = findViewById(R.id.imageButton8);
        ImageButton button9 = findViewById(R.id.imageButton9);

        if(pieces.get(0) == ((BitmapDrawable)button1.getDrawable()).getBitmap()&&
                pieces.get(1) == ((BitmapDrawable)button2.getDrawable()).getBitmap()&&
                pieces.get(2) == ((BitmapDrawable)button3.getDrawable()).getBitmap()&&
                pieces.get(3) == ((BitmapDrawable)button4.getDrawable()).getBitmap()&&
                pieces.get(4) == ((BitmapDrawable)button5.getDrawable()).getBitmap()&&
                pieces.get(5) == ((BitmapDrawable)button6.getDrawable()).getBitmap()&&
                pieces.get(6) == ((BitmapDrawable)button7.getDrawable()).getBitmap()&&
                pieces.get(7) == ((BitmapDrawable)button8.getDrawable()).getBitmap()&&
                pieces.get(8) == ((BitmapDrawable)button9.getDrawable()).getBitmap()){
            Toast.makeText(context, "You won in " + moves + " moves.", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
            intent.putExtra("scoreRetrieval", moves);
            startActivity(intent);
            finish();
        }
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

        if(firstClick){
            if(view.getId() == button1.getId()){
                holderMap = ((BitmapDrawable)button1.getDrawable()).getBitmap();
                holderButton = button1;
            }
            else if(view.getId() == button2.getId()){
                holderMap = ((BitmapDrawable)button2.getDrawable()).getBitmap();
                holderButton = button2;
            }
            else if(view.getId() == button3.getId()){
                holderMap = ((BitmapDrawable)button3.getDrawable()).getBitmap();
                holderButton = button3;
            }
            else if(view.getId() == button4.getId()){
                holderMap = ((BitmapDrawable)button4.getDrawable()).getBitmap();
                holderButton = button4;
            }
            else if(view.getId() == button5.getId()){
                holderMap = ((BitmapDrawable)button5.getDrawable()).getBitmap();
                holderButton = button5;
            }
            else if(view.getId() == button6.getId()){
                holderMap = ((BitmapDrawable)button6.getDrawable()).getBitmap();
                holderButton = button6;
            }
            else if(view.getId() == button7.getId()){
                holderMap = ((BitmapDrawable)button7.getDrawable()).getBitmap();
                holderButton = button7;
            }
            else if(view.getId() == button8.getId()){
                holderMap = ((BitmapDrawable)button8.getDrawable()).getBitmap();
                holderButton = button8;
            }
            else if(view.getId() == button9.getId()){
                holderMap = ((BitmapDrawable)button9.getDrawable()).getBitmap();
                holderButton = button9;
            }
            firstClick = false;
        }
        else if(!firstClick){
            if(view.getId() == button1.getId()){
                holderMap2 = ((BitmapDrawable)button1.getDrawable()).getBitmap();
                holderButton.setImageBitmap(holderMap2);
                button1.setImageBitmap(holderMap);
            }
            else if(view.getId() == button2.getId()){
                holderMap2 = ((BitmapDrawable)button2.getDrawable()).getBitmap();
                holderButton.setImageBitmap(holderMap2);
                button2.setImageBitmap(holderMap);
            }
            else if(view.getId() == button3.getId()){
                holderMap2 = ((BitmapDrawable)button3.getDrawable()).getBitmap();
                holderButton.setImageBitmap(holderMap2);
                button3.setImageBitmap(holderMap);
            }
            else if(view.getId() == button4.getId()){
                holderMap2 = ((BitmapDrawable)button4.getDrawable()).getBitmap();
                holderButton.setImageBitmap(holderMap2);
                button4.setImageBitmap(holderMap);
            }
            else if(view.getId() == button5.getId()){
                holderMap2 = ((BitmapDrawable)button5.getDrawable()).getBitmap();
                holderButton.setImageBitmap(holderMap2);
                button5.setImageBitmap(holderMap);
            }
            else if(view.getId() == button6.getId()){
                holderMap2 = ((BitmapDrawable)button6.getDrawable()).getBitmap();
                holderButton.setImageBitmap(holderMap2);
                button6.setImageBitmap(holderMap);
            }
            else if(view.getId() == button7.getId()){
                holderMap2 = ((BitmapDrawable)button7.getDrawable()).getBitmap();
                holderButton.setImageBitmap(holderMap2);
                button7.setImageBitmap(holderMap);
            }
            else if(view.getId() == button8.getId()){
                holderMap2 = ((BitmapDrawable)button8.getDrawable()).getBitmap();
                holderButton.setImageBitmap(holderMap2);
                button8.setImageBitmap(holderMap);
            }
            else if(view.getId() == button9.getId()){
                holderMap2 = ((BitmapDrawable)button9.getDrawable()).getBitmap();
                holderButton.setImageBitmap(holderMap2);
                button9.setImageBitmap(holderMap);
            }
            firstClick = true;
            moves++;
            victoryChecker();

        }
    }

    private ArrayList<Bitmap> splitImage(int resourceInt) {
        int piecesNumber = 12;
        int rows = 4;
        int cols = 3;

        ArrayList<Bitmap> pieces = new ArrayList<>(piecesNumber);

        // Get the bitmap of the source image

        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(),resourceInt);


        // Calculate the with and height of the pieces
        int pieceWidth = myBitmap.getWidth()/cols;
        int pieceHeight = myBitmap.getHeight()/rows;

        // Create each bitmap piece and add it to the resulting array
        int yCoord = 0;
        for (int row = 0; row < rows; row++) {
            int xCoord = 0;
            for (int col = 0; col < cols; col++) {
                pieces.add(Bitmap.createBitmap(myBitmap, xCoord, yCoord, pieceWidth, pieceHeight));
                xCoord += pieceWidth;
            }
            yCoord += pieceHeight;
        }

        return pieces;
    }

    private ArrayList<Bitmap> splitImage(Bitmap myBitmap) {
        int piecesNumber = 12;
        int rows = 4;
        int cols = 3;

        ArrayList<Bitmap> pieces = new ArrayList<>(piecesNumber);

        // Get the bitmap of the source image

        // Calculate the with and height of the pieces
        int pieceWidth = myBitmap.getWidth()/cols;
        int pieceHeight = myBitmap.getHeight()/rows;

        // Create each bitmap piece and add it to the resulting array
        int yCoord = 0;
        for (int row = 0; row < rows; row++) {
            int xCoord = 0;
            for (int col = 0; col < cols; col++) {
                pieces.add(Bitmap.createBitmap(myBitmap, xCoord, yCoord, pieceWidth, pieceHeight));
                xCoord += pieceWidth;
            }
            yCoord += pieceHeight;
        }

        return pieces;
    }

}
