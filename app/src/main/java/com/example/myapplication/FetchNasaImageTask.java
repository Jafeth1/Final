package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FetchNasaImageTask extends AsyncTask<String, Void, ImageData> {
    private Context context;
    private boolean highQuality;
    private ImageView imageView;

    public FetchNasaImageTask(Context context, boolean highQuality) {
        this.context = context;
        this.highQuality = highQuality;
    }

    @Override
    protected ImageData doInBackground(String... params) {
        String apiUrl = "https://api.nasa.gov/planetary/apod?api_key=b78ZxBqIhEowOWAMSepIyNtTdylJLgMIFmNKvfWk&date=" + params[0];
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            JSONObject jsonObject = new JSONObject(result.toString());
            String imageUrl = highQuality ? jsonObject.getString("hdurl") : jsonObject.getString("url");
            return new ImageData(params[0], jsonObject.getString("title"), imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    protected void onPostExecute(ImageData imageData) {
        super.onPostExecute(imageData);
        displayImage(imageData);
    }

    private void displayImage(ImageData imageData) {
        if (imageView != null && imageData != null) {
            Picasso.get().load(imageData.getImageUrl()).into(imageView);
        }
    }

}
