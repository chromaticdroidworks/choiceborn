package com.example.storyidea2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import com.example.storyidea2.contact.ContactIndexActivity;

public class A0StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2story);

        ImageButton more = findViewById(R.id.btnOverflow);
        if (more != null) {
            more.setOnClickListener(this::showSideMenu);
        }

        Button btnOne = findViewById(R.id.btnOne);
        if (btnOne != null) {
            btnOne.setOnClickListener(v ->
                    startActivity(new Intent(this, StoryMain.class))
            );
        }

        Button btnTwo = findViewById(R.id.btnTwo);
        if (btnTwo != null) {
            btnTwo.setOnClickListener(v -> finishAndRemoveTask());
        }

        Button btnThree = findViewById(R.id.btnThree);
        if (btnThree != null) {
            btnThree.setOnClickListener(v ->
                    startActivity(new Intent(this, A1ImpressumActivity.class))
            );
        }

        Button btnContact = findViewById(R.id.btnContact);
        if (btnContact != null) {
            btnContact.setOnClickListener(v ->
                    startActivity(new Intent(this, ContactIndexActivity.class))
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
