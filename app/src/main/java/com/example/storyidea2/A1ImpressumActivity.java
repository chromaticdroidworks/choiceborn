package com.example.storyidea2;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.button.MaterialButton;
import androidx.appcompat.app.AppCompatActivity;

public class A1ImpressumActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1story);
        setTitle(R.string.impressum_title);

        MaterialButton toHome = findViewById(R.id.btnToHome);
        if (toHome != null) {
            toHome.setOnClickListener(v -> {
                Intent home = new Intent(this, A2MainActivity.class);
                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(home);
            });
        }
    }
}
