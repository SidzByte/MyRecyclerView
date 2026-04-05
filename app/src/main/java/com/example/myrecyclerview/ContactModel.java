package com.example.myrecyclerview;


public class ContactModel {
    int imgProfile;
    String txtName;
    String txtNumber;


    ContactModel(int imgProfile, String txtName, String txtNumber) {
        this.imgProfile = imgProfile;
        this.txtName = txtName;
        this.txtNumber = txtNumber;
    }


    ContactModel(String txtName, String txtNumber) {
        this.txtName = txtName;
        this.txtNumber = txtNumber;
        this.imgProfile = R.drawable.profile_1; // Default profile image
    }
}
