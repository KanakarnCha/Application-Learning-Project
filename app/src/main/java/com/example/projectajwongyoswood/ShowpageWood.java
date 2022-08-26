package com.example.projectajwongyoswood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowpageWood extends AppCompatActivity {
    TextView txt;
    View imgBackgrouend;
    ImageView imageViewContent,imageViewTittle;
    String name;
    int image,contmg,bG;
    Button btbackhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_showpage_wood);
        btbackhome = findViewById(R.id.buttonInHome);
        btbackhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bc = new Intent(ShowpageWood.this,MainActivity.class);
                startActivity(bc);
            }
        });
        txt = findViewById(R.id.textViewTest);
        imageViewTittle = (ImageView)findViewById(R.id.imageView2);
        imageViewContent = (ImageView)findViewById(R.id.imageViewContent);
        imgBackgrouend = findViewById(R.id.imgBackgrouend);
        name = getIntent().getStringExtra("name");
        image = getIntent().getIntExtra("images",0);
        contmg = getIntent().getIntExtra("contentimages",0);
        bG = getIntent().getIntExtra("bgImages",0);
        txt.setText(name);
        imgBackgrouend.setBackgroundResource(bG);
        imageViewContent.setImageResource(image);
        imageViewTittle.setImageResource(contmg);

    }
}