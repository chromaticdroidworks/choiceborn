package com.example.storyidea2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class StoryMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_main);

        ImageButton more = findViewById(R.id.btnOverflow);
        if (more != null) {
            more.setOnClickListener(v -> showSideMenu(more));
        }

        Button btnStoryA = findViewById(R.id.btnStoryA);
        if (btnStoryA != null) {
            btnStoryA.setOnClickListener(v ->
                    startActivity(new Intent(this, A2MainActivity.class))
            );
        }

        Button btnStoryB = findViewById(R.id.btnStoryB);
        if (btnStoryB != null) {
            btnStoryB.setOnClickListener(v ->
                    startActivity(new Intent(this, B1MainActivity.class))
            );
        }

        Button btnStoryG = findViewById(R.id.btnStoryG);
        if (btnStoryG != null) {
            btnStoryG.setOnClickListener(v ->
                    startActivity(new Intent(this, G1MainActivity.class))
            );
        }
    }

    private void showSideMenu(View anchor) {
        PopupMenu pm = new PopupMenu(this, anchor);
        pm.getMenuInflater().inflate(R.menu.overflow_menu, pm.getMenu());
        pm.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            if (id == R.id.action_home) {
                Intent home = new Intent(this, A0StartPage.class);
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
