package com.example.android.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button play;
    private Button pause;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);

        //MediaPlayer using local source
        mediaPlayer = MediaPlayer.create(this, R.raw.music);


        //MediaPlayer using Remote Source
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("http://penguinradio.dominican.edu/Sound%20FX%20Collection/Apple%20Bite.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                Toast.makeText(MainActivity.this,"Ready To Play" , Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });

        mediaPlayer.prepareAsync();

        //mediaPlayer.start();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();

            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });


    }
}