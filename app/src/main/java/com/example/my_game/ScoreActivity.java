package com.example.my_game;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class ScoreActivity extends AppCompatActivity {

    ListView list;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    int movesInt;
    boolean overwrite = false;
    Date today = Calendar.getInstance().getTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        list = findViewById(R.id.resultListView);
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        list.setAdapter(adapter);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            movesInt = extras.getInt("scoreRetrieval");
            writeInternalMemoryFile();
        }
        readInternalMemoryFile();
    }

    public void deleteHistory(View view){
        overwrite = true;
        writeInternalMemoryFile();

        onBackPressed();
    }

    public void readInternalMemoryFile()
    {
        String str;

        try {


            InputStream is = openFileInput("scores.txt");

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            if (is != null) {
                try {
                    while ((str = reader.readLine()) != null) {
                        arrayList.add(str);
                    }

                    adapter.notifyDataSetChanged();
                    reader.close();
                    is.close();


                } catch (IOException ex) {

                }
            }
        }
        catch(FileNotFoundException ex){

        }
    }

    public void writeInternalMemoryFile()
    {
        try{

            if(overwrite == false){
                OutputStreamWriter output = new OutputStreamWriter(openFileOutput("scores.txt", MODE_APPEND));

                output.append(today + "\nNumber of moves taken: " + movesInt +"\n\n");

                output.close();
            }
            else{
                OutputStreamWriter output = new OutputStreamWriter(openFileOutput("scores.txt", MODE_PRIVATE));

                output.append("");

                output.close();

            }

        }
        catch(Exception ex)
        {

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
