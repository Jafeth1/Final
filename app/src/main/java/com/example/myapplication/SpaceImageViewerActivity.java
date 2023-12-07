package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;

public class SpaceImageViewerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SpaceImageAdapter adapter;
    private ArrayList<SpaceImageData> spaceImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_image_viewer);

        recyclerView = findViewById(R.id.space_image_recycler_view);
        spaceImageList = new ArrayList<>();
        adapter = new SpaceImageAdapter(this, spaceImageList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadSpaceImages();
    }

    private void loadSpaceImages() {
        // Fetch images from a data source
        ArrayList<SpaceImageData> fetchedImages = fetchDataFromDataSource();
        spaceImageList.clear();
        spaceImageList.addAll(fetchedImages);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<SpaceImageData> fetchDataFromDataSource() {
        // Implement fetching logic
        // For demonstration, return an empty list
        return new ArrayList<>();
    }
}