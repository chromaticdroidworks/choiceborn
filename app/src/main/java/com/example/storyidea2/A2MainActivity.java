package com.example.storyidea2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class A2MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2story);

        // 3-Punkte-Button (oben rechts) -> Popup-Menü
        ImageButton more = findViewById(R.id.btnOverflow);
        if (more != null) {
            more.setOnClickListener(this::showSideMenu);
        }

        // Button 1: Auswahlseite für Geschichten
        Button btnOne = findViewById(R.id.btnOne);
        if (btnOne != null) {
            btnOne.setOnClickListener(v ->
                    startActivity(new Intent(this, StoryMain.class))
            );
        }

        // Button 2: App schließen (wie vorher)
        Button btnTwo = findViewById(R.id.btnTwo);
        if (btnTwo != null) btnTwo.setOnClickListener(v -> finishAndRemoveTask());

        // Button 3: Impressum
        Button btnThree = findViewById(R.id.btnThree);
        if (btnThree != null) {
            btnThree.setOnClickListener(v ->
                    startActivity(new Intent(this, A1ImpressumActivity.class))
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