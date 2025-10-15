package com.example.storyidea2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class A0StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_start_page);

        Button btnStartStory = findViewById(R.id.btnStartStory);
        if (btnStartStory != null) {
            btnStartStory.setOnClickListener(v ->
                    startActivity(new Intent(this, StoryMain.class))
            );
        }

        Button btnSettings = findViewById(R.id.btnSettings);
        if (btnSettings != null) {
            btnSettings.setOnClickListener(v ->
                    startActivity(new Intent(this, SettingsActivity.class))
            );
        }

        Button btnImpressum = findViewById(R.id.btnImpressum);
        if (btnImpressum != null) {
            btnImpressum.setOnClickListener(v ->
                    startActivity(new Intent(this, A1ImpressumActivity.class))
            );
        }
    }
}
