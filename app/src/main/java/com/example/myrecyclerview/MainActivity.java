package com.example.myrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerviewContactList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*ContactModel model = new ContactModel(R.drawable.profile_1, "Siddharth", "9876543210");
        ContactModel model2 = new ContactModel(R.drawable.profile_1, "Siddharth", "9876543210");
        arrContacts.add(model);*/

        arrContacts.add(new ContactModel(R.drawable.profile_1, "Siddharth", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.profile_2, "Ishan", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.profile_3, "Rohan", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.profile_4, "Himanshu", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.profile_5, "Vishal", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.profile_6, "Aman", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.profile_7, "Yogesh", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.profile_1, "Siddharth", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.profile_2, "Ishan", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.profile_3, "Rohan", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.profile_4, "Himanshu", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.profile_5, "Vishal", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.profile_6, "Aman", "9876543210"));
        arrContacts.add(new ContactModel(R.drawable.profile_7, "Yogesh", "9876543210"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);
    }
}