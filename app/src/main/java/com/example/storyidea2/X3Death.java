package com.example.storyidea2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import com.google.android.material.button.MaterialButton;

public class X3Death extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x3death);

        // Startseite-Button
        MaterialButton toHome = findViewById(R.id.btnToHome);
        if (toHome != null) {
            toHome.setOnClickListener(v -> {
                Intent home = new Intent(this, A2MainActivity.class); // ggf. A2Story.class
                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(home);
                // optional: finish();
            });
        }

        // Overflow-Menü (oben rechts)
        ImageButton more = findViewById(R.id.btnOverflow);
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