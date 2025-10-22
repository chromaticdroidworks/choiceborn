package com.example.storyidea2.contact;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

/**
 * Persists the latest contact so it can be reused from the map view.
 */
public final class ContactRepository {

    private static final String PREFS_NAME = "contact_repository";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_POSTAL_CODE = "postal_code";
    private static final String KEY_RADIUS = "radius_km";

    private ContactRepository() {
        // no instances
    }

    public static void saveContact(Context context, Contact contact) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        prefs.edit()
                .putString(KEY_NAME, contact.getName())
                .putString(KEY_PHONE, contact.getPhone())
                .putString(KEY_EMAIL, contact.getEmail())
                .putString(KEY_POSTAL_CODE, contact.getPostalCode())
                .putInt(KEY_RADIUS, clampRadius(contact.getRadiusKm()))
                .apply();
    }

    @Nullable
    public static Contact getContact(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        if (!prefs.contains(KEY_NAME)
                && !prefs.contains(KEY_PHONE)
                && !prefs.contains(KEY_EMAIL)
                && !prefs.contains(KEY_POSTAL_CODE)) {
            return null;
        }

        String name = prefs.getString(KEY_NAME, "");
        String phone = prefs.getString(KEY_PHONE, "");
        String email = prefs.getString(KEY_EMAIL, "");
        String postalCode = prefs.getString(KEY_POSTAL_CODE, "");
        int radius = clampRadius(prefs.getInt(KEY_RADIUS, 5));

        return new Contact(name != null ? name : "",
                phone != null ? phone : "",
                email != null ? email : "",
                postalCode != null ? postalCode : "",
                radius);
    }

    private static int clampRadius(int radius) {
        if (radius < 1) {
            return 1;
        }
        if (radius > 50) {
            return 50;
        }
        return radius;
    }
}
