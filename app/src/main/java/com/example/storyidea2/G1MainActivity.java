package com.example.storyidea2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import com.google.android.material.button.MaterialButton;

public class G1MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g1activity_main);

        Button btnOne = findViewById(R.id.btnOne);
        Button btnTwo = findViewById(R.id.btnTwo);
        MaterialButton toHome = findViewById(R.id.btnToHome);
        ImageButton more = findViewById(R.id.btnOverflow); // Drei-Punkte-Menü-Button

        // Button 1 -> nächste Story
        if (btnOne != null) {
            btnOne.setOnClickListener(
                    v -> startActivity(new Intent(this, G2Story.class))
            );
        }

        // Button 2 -> App beenden
        if (btnTwo != null) {
            btnTwo.setOnClickListener(v -> finishAndRemoveTask());
        }

        // Zurück zur Startseite
        if (toHome != null) {
            toHome.setOnClickListener(v -> {
                Intent home = new Intent(this, A2MainActivity.class);
                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(home);
            });
        }

        // Overflow-Menü öffnen
        if (more != null) {
            more.setOnClickListener(v -> showSideMenu(more));
        }
    }
    private void showSideMenu(View anchor) {
        PopupMenu pm = new PopupMenu(this, anchor);
        pm.getMenuInflater().inflate(R.menu.overflow_menu, pm.getMenu());
        pm.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            if (id == R.id.action_home) {
                // <-- An deine echte Startseite anpassen!
                Intent home = new Intent(this, A2MainActivity.class); // oder A2Story.class
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