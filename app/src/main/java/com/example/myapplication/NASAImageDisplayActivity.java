package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NASAImageDisplayActivity extends AppCompatActivity {

    private ImageView imageView;
    private String highQualityImageUrl; // This URL should be fetched from the API
    private String lowQualityImageUrl; // This URL should be fetched from the API

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasa_image_display);

        imageView = findViewById(R.id.nasaImageView);
        loadNASAImage();
    }

    private void loadNASAImage() {
        new FetchNASAImageTask().execute();
    }

    private class FetchNASAImageTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL("https://api.nasa.gov/planetary/apod?api_key=YOUR_API_KEY");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

                String response = builder.toString();
                JSONObject jsonObject = new JSONObject(response);

                highQualityImageUrl = jsonObject.getString("hdurl");
                lowQualityImageUrl = jsonObject.getString("url");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            loadImageBasedOnQualityPreference();
        }
    }

    private void loadImageBasedOnQualityPreference() {
        SharedPreferences prefs = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        String quality = prefs.getString("ImageQuality", "High");

        String imageUrl = (quality.equals("High")) ? highQualityImageUrl : lowQualityImageUrl;
        Picasso.get().load(imageUrl).into(imageView); // Load the image using Picasso
    }
}