package com.example.storyidea2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class A100Story extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a100story);
        setTitle("A5 Fifth");

        // Drei-Punkte-Button (oben rechts) -> zurück zur Startseite
        ImageButton more = findViewById(R.id.btnOverflow);
        if (more != null) {
            more.setOnClickListener(v -> {
                PopupMenu pm = new PopupMenu(this, more);
                pm.getMenuInflater().inflate(R.menu.overflow_menu, pm.getMenu());
                pm.setOnMenuItemClickListener(item -> {
                    if (item.getItemId() == R.id.action_home) {
                        Intent home = new Intent(this, A2MainActivity.class);
                        home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(home);
                        return true;
                    }
                    return false;
                });
                pm.show();
            });
        }
        }
}
