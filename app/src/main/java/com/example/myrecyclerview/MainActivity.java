package com.example.myrecyclerview;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerContactAdapter adapter;
    FloatingActionButton btnOpenDialog;

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

        recyclerView = findViewById(R.id.recyclerviewContactList);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        btnOpenDialog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_layout);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        String name = "";
                        String number = "";

                    if(!edtName.getText().toString().isEmpty()) {
                        name = edtName.getText().toString();
                    }else {
                        Toast.makeText(MainActivity.this, "PLease Enter Contact Name", Toast.LENGTH_SHORT).show();
                    }
                        if(!edtNumber.getText().toString().isEmpty()) {
                            number = edtNumber.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this, "PLease Enter Contact Number", Toast.LENGTH_SHORT).show();
                        }

                        if (!name.isEmpty() && !number.isEmpty()) {
                            arrContacts.add(new ContactModel(name, number));
                            adapter.notifyItemInserted(arrContacts.size() - 1);
                            recyclerView.scrollToPosition(arrContacts.size() - 1);

                            dialog.dismiss();
                        }

                    }
                });
                dialog.show();
            }
        });




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

        adapter = new RecyclerContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);
    }
}