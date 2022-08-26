package com.example.projectajwongyoswood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Page2Wood extends AppCompatActivity {
    private ImageButton imageButton1, imageButton2, imageButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_wood);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.clicksound);
        imageButton1 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Intent in = new Intent(Page2Wood.this, Solid_Wood_Page1.class);
                startActivity(in);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Intent in = new Intent(Page2Wood.this, Mediumwood_Wood_Page2.class);
                startActivity(in);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Intent in = new Intent(Page2Wood.this, Softwood_Wood_Page3.class);
                startActivity(in);
            }
        });

    }
}