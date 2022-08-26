package com.example.projectajwongyoswood;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class QuizPageNo4 extends AppCompatActivity {
    Button c1, c2, c3, c4;
    ImageView acc, w1, w2, w3;
    ProgressBar progressBar;
    ObjectAnimator progressAnim;
    boolean check = false;
    int i = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page_no4);
        i = getIntent().getIntExtra("ans3", 0);
        Toast.makeText(this, "" + i, Toast.LENGTH_SHORT).show();
        c1 = findViewById(R.id.buttonChoiceNo1c4);
        c2 = findViewById(R.id.buttonChoiceNo2c4);
        c3 = findViewById(R.id.buttonChoiceNo3c4);
        c4 = findViewById(R.id.buttonChoiceNo4c4);
        acc = findViewById(R.id.imageViewAcc);
        w1 = findViewById(R.id.imageViewWong1);
        w2 = findViewById(R.id.imageViewWong2);
        w3 = findViewById(R.id.imageViewWong3);
        setProgressBar();
        Handler h = new Handler();
        c1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                singleClick();
                c2.setBackgroundResource(R.drawable.style_green);
                c1.setBackgroundResource(R.drawable.style_red);
                acc.setVisibility(View.VISIBLE);
                w1.setVisibility(View.VISIBLE);
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        Intent in = new Intent(QuizPageNo4.this, QuizPageNo5.class);
                        in.putExtra("ans4", i);
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
                c2.setBackgroundResource(R.drawable.style_green);
                acc.setVisibility(View.VISIBLE);
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        Intent in = new Intent(QuizPageNo4.this, QuizPageNo5.class);
                        in.putExtra("ans4", i + 1);
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
                c2.setBackgroundResource(R.drawable.style_green);
                c3.setBackgroundResource(R.drawable.style_red);
                acc.setVisibility(View.VISIBLE);
                w2.setVisibility(View.VISIBLE);
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        check = true;
                        Intent in = new Intent(QuizPageNo4.this, QuizPageNo5.class);
                        in.putExtra("ans4", i);
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
                c2.setBackgroundResource(R.drawable.style_green);
                c4.setBackgroundResource(R.drawable.style_red);
                acc.setVisibility(View.VISIBLE);
                w3.setVisibility(View.VISIBLE);
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        Intent in = new Intent(QuizPageNo4.this, QuizPageNo5.class);
                        in.putExtra("ans4", i);
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
                    Toast.makeText(QuizPageNo4.this, "หมดเวลา", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(QuizPageNo4.this, QuizPageNo5.class);
                    in.putExtra("ans4", i);
                    startActivity(in);
                    finish();
                } else {

                }
            }
        });

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "ไม่สามารถย้อนกลับได้", Toast.LENGTH_SHORT).show();
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
        YoYo.with(Techniques.RubberBand).duration(700).repeat(1).playOn(c2);
    }
}