package com.example.storyidea2.contact;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storyidea2.R;
import com.google.android.material.slider.Slider;
import com.google.android.material.textfield.TextInputEditText;

/**
 * Collects contact data before opening the map screen.
 */
public class ContactIndexActivity extends AppCompatActivity {

    private TextInputEditText inputName;
    private TextInputEditText inputPhone;
    private TextInputEditText inputEmail;
    private TextInputEditText inputPostalCode;
    private Slider sliderRadius;
    private TextView radiusValueLabel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_index);

        inputName = findViewById(R.id.inputName);
        inputPhone = findViewById(R.id.inputPhone);
        inputEmail = findViewById(R.id.inputEmail);
        inputPostalCode = findViewById(R.id.inputPostalCode);
        sliderRadius = findViewById(R.id.sliderRadius);
        radiusValueLabel = findViewById(R.id.labelRadiusValue);
        Button btnContinue = findViewById(R.id.btnContinue);

        sliderRadius.addOnChangeListener((slider, value, fromUser) -> updateRadiusLabel(Math.round(value)));

        Contact existing = ContactRepository.getContact(this);
        if (existing != null) {
            inputName.setText(existing.getName());
            inputPhone.setText(existing.getPhone());
            inputEmail.setText(existing.getEmail());
            inputPostalCode.setText(existing.getPostalCode());
            int safeRadius = clampRadius(existing.getRadiusKm());
            sliderRadius.setValue(safeRadius);
            updateRadiusLabel(safeRadius);
        } else {
            updateRadiusLabel(Math.round(sliderRadius.getValue()));
        }

        btnContinue.setOnClickListener(v -> onContinue());
    }

    private void updateRadiusLabel(int radius) {
        radiusValueLabel.setText(getString(R.string.contact_radius_value, radius));
    }

    private void onContinue() {
        String name = textFrom(inputName);
        String phone = textFrom(inputPhone);
        String email = textFrom(inputEmail);
        String postalCode = textFrom(inputPostalCode);
        int radius = clampRadius(Math.round(sliderRadius.getValue()));

        if (TextUtils.isEmpty(name)) {
            inputName.setError(getString(R.string.contact_form_missing_name));
            return;
        }
        if (TextUtils.isEmpty(postalCode)) {
            inputPostalCode.setError(getString(R.string.contact_form_missing_postal_code));
            return;
        }

        Contact contact = new Contact(name, phone, email, postalCode, radius);
        ContactRepository.saveContact(this, contact);

        Intent intent = new Intent(this, ContactMapActivity.class);
        startActivity(intent);
    }

    private String textFrom(TextInputEditText editText) {
        return editText.getText() != null ? editText.getText().toString().trim() : "";
    }

    private int clampRadius(int radius) {
        if (radius < 1) {
            return 1;
        }
        if (radius > 50) {
            return 50;
        }
        return radius;
    }
}
