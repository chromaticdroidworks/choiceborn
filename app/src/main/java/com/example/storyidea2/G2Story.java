package com.example.storyidea2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class G2Story extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g2story);

        // Overflow/Drei-Punkte-Button (oben rechts): Menü
        ImageButton more = findViewById(R.id.btnOverflow);
        if (more != null) {
            more.setOnClickListener(v -> showSideMenu(more));
        }

        // Standard-Navigation: G2 -> G3
        Intent next = new Intent(G2Story.this, G3Story.class);

        Button b1 = findViewById(R.id.btnOne);
        Button b2 = findViewById(R.id.btnTwo);
        Button b3 = findViewById(R.id.btnThree);

        if (b1 != null) {
            b1.setOnClickListener(v -> {                               // zu G3
                Intent i = new Intent(this, G3Story.class);
                startActivity(i);
            });
        }
        if (b2 != null) {
            b2.setOnClickListener(v -> {                               // zu G4
                Intent i = new Intent(this, G4Story.class);
                startActivity(i);
            });
        }
        if (b3 != null) {
            b3.setOnClickListener(v -> {                               // zu G5
                Intent i = new Intent(this, G5Story.class);
                startActivity(i);
            });
        }
    }

    // Popup-Menü (Startseite, neue Geschichten, Einstellungen)
    private void showSideMenu(View anchor) {
        PopupMenu pm = new PopupMenu(this, anchor);
        pm.getMenuInflater().inflate(R.menu.overflow_menu, pm.getMenu());
        pm.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            if (id == R.id.action_home) {
                // An deine echte Startseite anpassen (z. B. A1Story oder A2Story)
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
