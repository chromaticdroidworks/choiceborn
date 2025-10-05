package com.example.storyidea2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class A100Story extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a100story);

        ImageButton more = findViewById(R.id.btnOverflow);
        if (more != null) {
            more.setOnClickListener(v -> showSideMenu(more));
        }

        Intent homeIntent = new Intent(this, A2MainActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        Button b1 = findViewById(R.id.btnOne);
        Button b2 = findViewById(R.id.btnTwo);
        Button b3 = findViewById(R.id.btnThree);

        if (b1 != null) {
            b1.setOnClickListener(v -> startActivity(homeIntent));
        }
        if (b2 != null) {
            b2.setOnClickListener(v -> {
                Intent deathIntent = new Intent(this, X6Death.class);
                startActivity(deathIntent);
            });
        }
        if (b3 != null) {
            b3.setOnClickListener(v -> startActivity(homeIntent));
        }
    }

    private void showSideMenu(View anchor) {
        PopupMenu pm = new PopupMenu(this, anchor);
        pm.getMenuInflater().inflate(R.menu.overflow_menu, pm.getMenu());
        pm.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            if (id == R.id.action_home) {
                Intent home = new Intent(this, A2MainActivity.class);
                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(home);
                return true;
            } else if (id == R.id.action_new_story) {
                startActivity(new Intent(this, B1MainActivity.class));
                return true;
            } else if (id == R.id.action_new_story2) {
                startActivity(new Intent(this, G1MainActivity.class));
                return true;
            } else if (id == R.id.action_settings) {
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            }
            return false;
        });
        pm.show();
    }
}
