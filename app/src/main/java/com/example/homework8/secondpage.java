package com.example.homework8;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class secondpage extends AppCompatActivity {

    int musicimageindexArray[] = {R.drawable.boz_scaggs, R.drawable.caroline_rose, R.drawable.charles_bradley,
            R.drawable.dawes, R.drawable.jungle, R.drawable.kacey_musgraves, R.drawable.stanley_clarke};

    int music[] = {R.raw.boz_scaggs_georgia, R.raw.caroline_rose_jeannie_becomes_a_mom, R.raw.charles_bradley_cant_fight_the_feeling,
            R.raw.dawes_feed_the_fire, R.raw.jungle_heavy_california, R.raw.kacey_musgraves_high_horse, R.raw.stanley_clarke_school_days};
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);

        //defining the objects (LinearLayout)
        LinearLayout musicImage = (LinearLayout) findViewById(R.id.musicLL);


        //creating an intent to get the passing variables
        Intent getVars = getIntent();

        //now we can get the variables (name,index)
        int index = getVars.getExtras().getInt("musickey");


        //placing the corresponding image in the LinearLayout musicImage
        musicImage.setBackgroundResource(musicimageindexArray[index]);

        //play music
        mp = MediaPlayer.create(this, music[index]);
        mp.start(); // no need to call prepare(); create() does that for you


    }

    @Override
    protected void onDestroy() {

        //stop music
        super.onDestroy();
        mp.stop();


    }
}
