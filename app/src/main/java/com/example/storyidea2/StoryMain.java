package com.example.storyidea2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StoryMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.astorymain);

        Button btnMedieval = findViewById(R.id.btnMedieval);
        if (btnMedieval != null) {
            btnMedieval.setOnClickListener(v ->
                    startActivity(new Intent(this, A1ImpressumActivity.class))
            );
        }

        Button btnHitler = findViewById(R.id.btnHitler);
        if (btnHitler != null) {
            btnHitler.setOnClickListener(v ->
                    startActivity(new Intent(this, B1MainActivity.class))
            );
        }

        Button btnAI = findViewById(R.id.btnAI);
        if (btnAI != null) {
            btnAI.setOnClickListener(v ->
                    startActivity(new Intent(this, G1MainActivity.class))
            );
        }
    }
}
