package com.example.my_game;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;



public class HomeActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClick2(View view){
        openGallery();
    }

    public void onClick3(View view){
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();

            if(imageUri != null) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                intent.putExtra("galleryRetrieval", imageUri.toString());
                startActivity(intent);
                finish();
            }
        }
    }

    public void onClick(View view){
        Intent intent = new Intent(this, SelectionActivity.class);
        startActivity(intent);
    }


}
