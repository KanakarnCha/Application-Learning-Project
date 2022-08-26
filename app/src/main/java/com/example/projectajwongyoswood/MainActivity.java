package com.example.projectajwongyoswood;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
    public ImageButton bt, bt2, btCredit;
    ViewFlipper v_flip;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int image [] = {R.drawable.logo_main,R.drawable.logo,R.drawable.logogo};
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.clicksound);
        view = findViewById(R.id.viewt2);
        v_flip = findViewById(R.id.imageViewlogo);
        bt = findViewById(R.id.buttonLearn);
        btCredit = findViewById(R.id.imageButtonCredit);
        YoYo.with(Techniques.SlideInDown).duration(1000).repeat(0).playOn(view);
        for(int i = 0; i< image.length;i++){
                flipperImg(image[i]);
        }
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                YoYo.with(Techniques.RubberBand).duration(700).repeat(1).playOn(bt);
                Intent in = new Intent(MainActivity.this, Page2Wood.class);
                startActivity(in);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        bt2 = findViewById(R.id.buttonQuiz);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                YoYo.with(Techniques.RubberBand).duration(700).repeat(1).playOn(bt2);
                Intent in = new Intent(MainActivity.this, AboutQuiz.class);
                startActivity(in);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
        btCredit.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                YoYo.with(Techniques.RubberBand).duration(700).repeat(1).playOn(btCredit);
                mediaPlayer.start();
                dialog_Show();
            }
        });
    }
    void dialog_Show(){
        final Dialog dialog = new Dialog(MainActivity.this, R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.customdialog);


        Button bt1 = dialog.findViewById(R.id.buttonclick1);
        Button bt2 = dialog.findViewById(R.id.buttonclick2);
        Button bt3 = dialog.findViewById(R.id.buttonclick3);
        Button bt4 = dialog.findViewById(R.id.buttonclick4);
        Button bt5 = dialog.findViewById(R.id.buttonclick5);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.onestockhome.com/th/homemap_contents/50551302/wood-for-construction")));
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.baanlaesuan.com/")));
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://designtechnology.ipst.ac.th/")));
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.livingdd.com/lumber-knowledge-for-smart-selection/")));
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://craftnroll.net/craft-101/wood-101")));
            }
        });

        dialog.show();
    }

    void flipperImg(int img){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(img);
        v_flip.addView(imageView);
        v_flip.setFlipInterval(3000);
        v_flip.setAutoStart(true);
        v_flip.setInAnimation(this, android.R.anim.fade_in);
        v_flip.setOutAnimation(this, android.R.anim.fade_out);
    }
}