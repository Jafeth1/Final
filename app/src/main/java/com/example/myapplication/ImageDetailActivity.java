package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ImageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);
        TextView titleView = findViewById(R.id.detailTitle);
        TextView dateView = findViewById(R.id.detailDate);
        TextView explanationView = findViewById(R.id.detailExplanation);
        ImageView imageView = findViewById(R.id.detailImage);
        Intent intent = getIntent();
        String title = intent.getStringExtra("TITLE");
        String date = intent.getStringExtra("DATE");
        String explanation = intent.getStringExtra("EXPLANATION");
        String imageUrl = intent.getStringExtra("IMAGE_URL");
        titleView.setText(title);
        dateView.setText(date);
        explanationView.setText(explanation);
        Picasso.get().load(imageUrl).into(imageView);
    }
}
