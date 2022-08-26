package com.example.projectajwongyoswood;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;

public class Solid_Wood_Page1 extends AppCompatActivity {
    private RecyclerView courseRV;
    private ArrayList<CourseModel> courseModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solid_wood_page1);
        courseRV = findViewById(R.id.idRVCourse);
        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new CourseModel("ไม้เต็ง", R.drawable.solidwood1, getString(R.string.solidWood1), R.drawable.woodteng, R.drawable.tteng, R.drawable.bgn1));
        courseModelArrayList.add(new CourseModel("ไม้ตะเเบก", R.drawable.solidwood2, getString(R.string.solidWood2), R.drawable.woodtabark, R.drawable.ttabark, R.drawable.bgn1));
        courseModelArrayList.add(new CourseModel("ไม้ตะเคียนทอง", R.drawable.solidwood3, getString(R.string.solidWood3), R.drawable.woodtakhiane, R.drawable.ttakhianthong, R.drawable.bgn1));
        courseModelArrayList.add(new CourseModel("ไม้ประดู่", R.drawable.solidwood4, getString(R.string.solidWood4), R.drawable.woodpradoo, R.drawable.ttakhianthong, R.drawable.bgn1));
        courseModelArrayList.add(new CourseModel("ไม้เเดง", R.drawable.solidwood5, getString(R.string.solidWood5), R.drawable.woodred, R.drawable.tdang, R.drawable.bgn1));
        courseModelArrayList.add(new CourseModel("ไม้มะค่า", R.drawable.solidwood6, getString(R.string.solidWood6), R.drawable.woodmakha, R.drawable.tmakha, R.drawable.bgn1));


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

class CourseModel {
    private String course_name;
    private int course_image, content_image, content_image_title, bg_image;
    private String content;

    // Constructor
    public CourseModel(String course_name, int course_image) {
        this.course_name = course_name;
        this.course_image = course_image;
    }

    public CourseModel(String course_name, int course_image, String content) {
        this.course_name = course_name;
        this.course_image = course_image;
        this.content = content;
    }

    public CourseModel(String course_name, int course_image, String content, int content_image) {
        this.course_name = course_name;
        this.course_image = course_image;
        this.content = content;
        this.content_image = content_image;
    }

    public CourseModel(String course_name, int course_image, String content, int content_image, int content_image_title) {
        this.course_name = course_name;
        this.course_image = course_image;
        this.content = content;
        this.content_image = content_image;
        this.content_image_title = content_image_title;
    }

    public CourseModel(String course_name, int course_image, String content, int content_image, int content_image_title, int bg_image) {
        this.course_name = course_name;
        this.course_image = course_image;
        this.content = content;
        this.content_image = content_image;
        this.content_image_title = content_image_title;
        this.bg_image = bg_image;
    }

    public int getBg_image() {
        return this.bg_image;
    }

    public int getcontent_image_title() {
        return this.content_image_title;
    }

    // Getter and Setter
    public String getCourse_content() {
        return this.content;
    }

    public int getContent_image() {
        return this.content_image;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_image() {
        return course_image;
    }

    public void setCourse_image(int course_image) {
        this.course_image = course_image;
    }
}

class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.Viewholder> {

    private Context context;
    private ArrayList<CourseModel> courseModelArrayList;

    // Constructor
    public CourseAdapter() {

    }

    public CourseAdapter(Context context, ArrayList<CourseModel> courseModelArrayList) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
    }


    @NonNull
    @Override
    public CourseAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_model_wood, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        CourseModel model = courseModelArrayList.get(position);

        holder.courseNameTV.setText(model.getCourse_name());
        holder.courseIV.setImageResource(model.getCourse_image());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context,R.raw.clicksound);
                YoYo.with(Techniques.FadeOut).duration(700).repeat(1).playOn(holder.itemView);
                YoYo.with(Techniques.FadeIn).duration(700).repeat(1).playOn(holder.itemView);
                mediaPlayer.start();
                Intent in = new Intent(context, ShowpageWood.class);
                in.putExtra("name", model.getCourse_content());
                in.putExtra("images", model.getContent_image());
                in.putExtra("contentimages", model.getcontent_image_title());
                in.putExtra("bgImages", model.getBg_image());
                context.startActivity(in);
            }
        });


    }


    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return courseModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView courseIV;
        private TextView courseNameTV;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            courseIV = itemView.findViewById(R.id.idIVCourseImage);
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            CourseModel listitem = courseModelArrayList.get(position);
            courseNameTV.setText(listitem.getCourse_name());

            Toast.makeText(context, "" + listitem.getCourse_name(), Toast.LENGTH_LONG).show();
            Intent in = new Intent(context, ShowpageWood.class);
            context.startActivity(in);
        }
    }
}