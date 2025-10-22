package com.example.storyidea2.contact;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storyidea2.R;

/**
 * Displays a simple map placeholder and the saved contact details.
 */
public class ContactMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_map);

        TextView detailsView = findViewById(R.id.contactDetails);
        Button closeButton = findViewById(R.id.btnFinish);

        Contact contact = ContactRepository.getContact(this);
        if (contact != null) {
            detailsView.setText(getString(R.string.contact_map_contact_details,
                    emptySafe(contact.getName()),
                    emptySafe(contact.getPhone()),
                    emptySafe(contact.getEmail()),
                    emptySafe(contact.getPostalCode()),
                    contact.getRadiusKm()));
        } else {
            detailsView.setText(R.string.contact_map_no_data);
        }

        closeButton.setOnClickListener(v -> finish());
    }

    private String emptySafe(String value) {
        return value == null || value.isEmpty() ? "-" : value;
    }
}
