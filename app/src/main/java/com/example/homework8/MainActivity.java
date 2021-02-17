package com.example.homework8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //global object
    ListView musiciansLV;

    ArrayList<String> musiciansName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define global objects
        musiciansLV = (ListView) findViewById(R.id.musicLV);
        musiciansName = new ArrayList<String>();


        try {

            InputStreamReader isr = new InputStreamReader(getAssets().open("music.csv"));

            BufferedReader reader = new BufferedReader(isr);

            String fileLine, mName, mSong;

            //This allows to skip the first line (column)
            int count = 0;

            while ((fileLine = reader.readLine()) != null) {

                if (count == 0) {
                    count++;
                    continue;
                }

                    mName = fileLine.split(",")[0];
                    mSong = fileLine.split(",")[3];

                    //now let's populate the ArrayList with the musiciansName value
                    musiciansName.add(mName + " - " + mSong);
                }




            //create the ArrayAdapter
            ArrayAdapter<String> yearAA = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, musiciansName);

            //set the adapter to the ListView
            musiciansLV.setAdapter(yearAA);


            //setting up listener to ListView
            musiciansLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    //let's send this value to the second screen
                    Intent gotoScreen2 = new Intent(MainActivity.this, secondpage.class);

                    //pack the value with the intent
                    gotoScreen2.putExtra("musickey", position);

                    //start Activity (screen2)
                    startActivity(gotoScreen2);



                }

            });


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
