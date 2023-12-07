package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class SettingsActivity extends AppCompatActivity {

    private Switch imageQualitySwitch;
    private SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPrefs = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        imageQualitySwitch = findViewById(R.id.switch_image_quality);

        // Load saved preferences
        boolean highQuality = sharedPrefs.getBoolean("HighQualityImages", true);
        imageQualitySwitch.setChecked(highQuality);

        // Save preferences on change
        imageQualitySwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putBoolean("HighQualityImages", isChecked);
            editor.apply();
        });
    }
}
