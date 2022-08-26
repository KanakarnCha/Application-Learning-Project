package com.example.projectajwongyoswood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Show_Point_page extends AppCompatActivity {
TextView tp,tc,tic;
ImageButton btinho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_point_page);
        int i = getIntent().getIntExtra("ans10", 0);
        Toast.makeText(this,""+i,Toast.LENGTH_SHORT).show();


        tp = (TextView) findViewById(R.id.textViewPoint);
        tc = (TextView) findViewById(R.id.textViewCon);
        tic = (TextView) findViewById(R.id.textViewInCon);
        btinho = (ImageButton)findViewById(R.id.imageButtonInhome) ;
        YoYo.with(Techniques.ZoomIn).duration(1500).repeat(0).playOn(tp);
        YoYo.with(Techniques.SlideInLeft).duration(1500).repeat(0).playOn(tc);
        YoYo.with(Techniques.SlideInLeft).duration(1500).repeat(0).playOn(tic);
        btinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Show_Point_page.this,MainActivity.class);
                startActivity(in);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        tp.setText(""+i);
        switch (i) {
            case 0:
                tc.setText("0");
                tic.setText("10");
                break;
            case 1:
                tc.setText("1");
                tic.setText("9");
                break;
            case 2:
                tc.setText("2");
                tic.setText("8");
                break;
            case 3:
                tc.setText("3");
                tic.setText("7");
                break;
            case 4:
                tc.setText("4");
                tic.setText("6");
                break;
            case 5:
                tc.setText("5");
                tic.setText("5");
                break;
            case 6:
                tc.setText("6");
                tic.setText("4");
                break;
            case 7:
                tc.setText("7");
                tic.setText("3");
                break;
            case 8:
                tc.setText("8");
                tic.setText("2");
                break;
            case 9:
                tc.setText("9");
                tic.setText("1");
                break;
            case 10:
                tc.setText("10");
                tic.setText("0");
                break;
        }
    }
}