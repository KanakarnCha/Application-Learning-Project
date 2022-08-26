package com.example.projectajwongyoswood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Softwood_Wood_Page3 extends AppCompatActivity {
    private RecyclerView courseRV;
    private ArrayList<CourseModel> courseModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_softwood_wood_page3);
        courseRV = findViewById(R.id.recvTvview);
        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new CourseModel("ไม้ยางแดง", R.drawable.yang,getString(R.string.softWood1),R.drawable.woodyang,R.drawable.tyang,R.drawable.bgn3));
        courseModelArrayList.add(new CourseModel("ไม้พะยอม", R.drawable.payorm,getString(R.string.softWood2),R.drawable.woodphayom,R.drawable.tphayom,R.drawable.bgn3));
        courseModelArrayList.add(new CourseModel("ไม้กระเจา", R.drawable.krajao,getString(R.string.softWood3),R.drawable.woodkrachao,R.drawable.tkrajao,R.drawable.bgn3));
        courseModelArrayList.add(new CourseModel("ไม้กระท้อน", R.drawable.maikatorn,getString(R.string.softWood4),R.drawable.maikatorn,R.drawable.woodkrathon,R.drawable.bgn3));
        courseModelArrayList.add(new CourseModel("ไม้ต้นมะพร้าว", R.drawable.maprao,getString(R.string.softWood5),R.drawable.woodmapraow,R.drawable.tmaprow,R.drawable.bgn3));

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