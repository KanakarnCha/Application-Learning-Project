package com.example.projectajwongyoswood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Mediumwood_Wood_Page2 extends AppCompatActivity {
    private RecyclerView courseRV;
    private ArrayList<CourseModel> courseModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediumwood_wood_page2);
        courseRV = findViewById(R.id.rvTVpage2);
        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new CourseModel("ไม้สัก", R.drawable.maisuk, getString(R.string.mediumWood1), R.drawable.woodsak, R.drawable.tsak, R.drawable.bgn2));
        courseModelArrayList.add(new CourseModel("ไม้มะค่าแต้ ", R.drawable.maimakatae, getString(R.string.mediumWood2), R.drawable.woodmakatare, R.drawable.tmakha, R.drawable.bgn2));
        courseModelArrayList.add(new CourseModel("ไม้พลวง", R.drawable.maipluang, getString(R.string.mediumWood3), R.drawable.woodphuand, R.drawable.tphuang, R.drawable.bgn2));
        courseModelArrayList.add(new CourseModel("ไม้นนทรี", R.drawable.mainonsee, getString(R.string.mediumWood4), R.drawable.woodnonsee, R.drawable.tnonsee, R.drawable.bgn2));
        courseModelArrayList.add(new CourseModel("ไม้ตาเสือ", R.drawable.maitasuae, getString(R.string.mediumWood5), R.drawable.woodtasaeon, R.drawable.ttarsuaen, R.drawable.bgn2));


        // we are initializing our adapter class and passing our arraylist to it.
        CourseAdapter courseAdapter = new CourseAdapter(this, courseModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);


    }
}