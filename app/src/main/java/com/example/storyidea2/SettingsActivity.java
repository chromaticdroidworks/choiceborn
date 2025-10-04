package com.example.storyidea2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

public class SettingsActivity extends AppCompatActivity {

    private static final String PREFS = "app_settings";
    private static final String KEY_SOUND = "sound_enabled";
    private static final String KEY_THEME = "theme_mode";     // 0 = System, 2 = Dark (Light wird aktuell nicht gespeichert)
    private static final String KEY_TEXTSIZE = "text_scale";  // Prozentwert 100–150

    private SwitchCompat swSound;
    private SwitchCompat swThemeDark;   // an = Dark, aus = System
    private SeekBar sbTextScale;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        swSound = findViewById(R.id.swSound);
        swThemeDark = findViewById(R.id.swThemeDark);
        sbTextScale = findViewById(R.id.sbTextScale);
        btnSave = findViewById(R.id.btnSave);

        // Gespeicherte Werte laden
        SharedPreferences sp = getSharedPreferences(PREFS, MODE_PRIVATE);
        boolean sound = sp.getBoolean(KEY_SOUND, true);
        int theme = sp.getInt(KEY_THEME, 0);
        int textScale = sp.getInt(KEY_TEXTSIZE, 100); // 100..150

        // --- SeekBar: 100–150 % ohne setMin() (API 26+) ---
        sbTextScale.setMax(50); // interner Bereich 0..50 entspricht 100..150
        int clamped = Math.max(100, Math.min(150, textScale));
        sbTextScale.setProgress(clamped - 100); // 0..50

        // Switches setzen
        swSound.setChecked(sound);
        swThemeDark.setChecked(theme == 2);

        btnSave.setOnClickListener(v -> {
            boolean newSound = swSound.isChecked();
            int newTheme = swThemeDark.isChecked() ? 2 : 0;      // 2 = Dark, 0 = System
            int newTextScale = sbTextScale.getProgress() + 100;  // zurück auf 100..150

            // Werte speichern
            sp.edit()
                    .putBoolean(KEY_SOUND, newSound)
                    .putInt(KEY_THEME, newTheme)
                    .putInt(KEY_TEXTSIZE, newTextScale)
                    .apply();

            // Theme sofort anwenden
            if (newTheme == 2) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
            }

            Toast.makeText(this, "Einstellungen wurden gespeichert.", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
