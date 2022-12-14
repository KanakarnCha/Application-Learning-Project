package com.example.projectajwongyoswood;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class QuizPageNo2 extends AppCompatActivity {
    Button c1, c2, c3, c4;
    ImageView acc, w1, w2, w3;
    ProgressBar progressBar;
    ObjectAnimator progressAnim;
    int i = -1;
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page_no2);

        i = getIntent().getIntExtra("ans1", 0);
        Toast.makeText(this, "" + i, Toast.LENGTH_SHORT).show();
        setProgressBar();
        c1 = findViewById(R.id.buttonChoiceNo1c2);
        c2 = findViewById(R.id.buttonChoiceNo2c2);
        c3 = findViewById(R.id.buttonChoiceNo3c2);
        c4 = findViewById(R.id.buttonChoiceNo4c2);
        acc = findViewById(R.id.imageViewAcc);
        w1 = findViewById(R.id.imageViewWong1);
        w2 = findViewById(R.id.imageViewWong2);
        w3 = findViewById(R.id.imageViewWong3);



        Handler h = new Handler();
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                singleClick();
                c4.setBackgroundResource(R.drawable.style_green);
                c1.setBackgroundResource(R.drawable.style_red);
                acc.setVisibility(View.VISIBLE);
                w3.setVisibility(View.VISIBLE);
                acc.setVisibility(View.VISIBLE);
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        Intent in = new Intent(QuizPageNo2.this, QuizPageNo3.class);
                        in.putExtra("ans2", i);
                        startActivity(in);
                        finish();
                    }
                };
                h.postDelayed(r, 1000);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                singleClick();
                c4.setBackgroundResource(R.drawable.style_green);
                c2.setBackgroundResource(R.drawable.style_red);
                acc.setVisibility(View.VISIBLE);
                w1.setVisibility(View.VISIBLE);
                acc.setVisibility(View.VISIBLE);
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        Intent in = new Intent(QuizPageNo2.this, QuizPageNo3.class);
                        in.putExtra("ans2", i);
                        startActivity(in);
                        finish();
                    }

                };
                h.postDelayed(r, 1000);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                singleClick();
                c4.setBackgroundResource(R.drawable.style_green);
                c3.setBackgroundResource(R.drawable.style_red);
                acc.setVisibility(View.VISIBLE);
                w2.setVisibility(View.VISIBLE);
                acc.setVisibility(View.VISIBLE);
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        Intent in = new Intent(QuizPageNo2.this, QuizPageNo3.class);
                        in.putExtra("ans2", i);
                        startActivity(in);
                        finish();
                    }

                };
                h.postDelayed(r, 1000);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                singleClick();
                c4.setBackgroundResource(R.drawable.style_green);
                acc.setVisibility(View.VISIBLE);
                acc.setVisibility(View.VISIBLE);
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        Intent in = new Intent(QuizPageNo2.this, QuizPageNo3.class);
                        in.putExtra("ans2", i + 1);
                        startActivity(in);
                        finish();
                    }

                };
                h.postDelayed(r, 1000);
            }
        });



    }

    void setProgressBar() {

        progressBar = findViewById(R.id.progressani);
        progressAnim = ObjectAnimator.ofInt(progressBar, "progress", 0, 100);
        progressAnim.setDuration(8000);
        progressAnim.start();
        progressAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (check == false) {
                    check = true;
                    Toast.makeText(QuizPageNo2.this, "?????????????????????", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(QuizPageNo2.this, QuizPageNo3.class);
                    in.putExtra("ans2", i);
                    startActivity(in);
                    finish();
                } else {

                }
            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "????????????????????????????????????????????????????????????", Toast.LENGTH_SHORT).show();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    void singleClick() {
        c1.setClickable(false);
        c2.setClickable(false);
        c3.setClickable(false);
        c4.setClickable(false);
        check = true;
        progressAnim.pause();
        YoYo.with(Techniques.RubberBand).duration(700).repeat(1).playOn(c4);
    }
}