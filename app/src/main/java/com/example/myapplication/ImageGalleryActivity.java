package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ImageGalleryActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ImageData> imageList;
    ImageGalleryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery);

        listView = findViewById(R.id.listViewImageGallery);
        imageList = new ArrayList<>();
        adapter = new ImageGalleryAdapter(this, imageList);
        listView.setAdapter(adapter);

        loadGalleryImages();

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(ImageGalleryActivity.this, ImageDetailActivity.class);
            intent.putExtra("IMAGE_DATA", imageList.get(position));
            startActivity(intent);
        });
    }

    private void loadGalleryImages() {
        ArrayList<ImageData> fetchedImages = fetchDataFromDataSource();
        imageList.clear();
        imageList.addAll(fetchedImages);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<ImageData> fetchDataFromDataSource() {
        // Implement fetching logic
        // For demonstration, return an empty list
        return new ArrayList<>();
    }

}
