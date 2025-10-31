package com.example.storyidea2.contact;

import androidx.annotation.NonNull;

/**
 * Simple immutable value object representing a contact entry inside the app.
 */
public class Contact {
    private final String name;
    private final String phone;
    private final String email;
    private final String postalCode;
    private final int radiusKm;

    public Contact(@NonNull String name,
                   @NonNull String phone,
                   @NonNull String email,
                   @NonNull String postalCode,
                   int radiusKm) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.postalCode = postalCode;
        this.radiusKm = radiusKm;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    @NonNull
    public String getPostalCode() {
        return postalCode;
    }

    public int getRadiusKm() {
        return radiusKm;
    }
}
