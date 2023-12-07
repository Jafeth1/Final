package com.example.myapplication;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class UserPreferenceActivity extends AppCompatActivity {

    RadioGroup radioGroupQuality;
    RadioButton radioButtonHigh, radioButtonLow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preferences);

        radioGroupQuality = findViewById(R.id.radioGroupQuality);
        radioButtonHigh = findViewById(R.id.radioButtonHigh);
        radioButtonLow = findViewById(R.id.radioButtonLow);

        SharedPreferences prefs = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        String quality = prefs.getString("ImageQuality", "High");
        if ("Low".equals(quality)) {
            radioButtonLow.setChecked(true);
        } else {
            radioButtonHigh.setChecked(true);
        }

        radioGroupQuality.setOnCheckedChangeListener((group, checkedId) -> {
            SharedPreferences.Editor editor = prefs.edit();
            if (checkedId == R.id.radioButtonHigh) {
                editor.putString("ImageQuality", "High");
            } else {
                editor.putString("ImageQuality", "Low");
            }
            editor.apply();
        });
    }
}

