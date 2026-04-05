package com.example.myrecyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModel> arrContacts;

    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts) {
        this.context = context;
        this.arrContacts = arrContacts; // added because arrContacts will used by onBindViewHolder
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_contact_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgContact.setImageResource(arrContacts.get(position).imgProfile);
        holder.txtName.setText(arrContacts.get(position).txtName);
        holder.txtNumber.setText(arrContacts.get(position).txtNumber);
        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_layout);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);
                btnAction.setText("Update");
                TextView txtTitle = dialog.findViewById(R.id.txtTitle);
                txtTitle.setText("Update Contact");

                edtName.setText(arrContacts.get(position).txtName);
                edtNumber.setText(arrContacts.get(position).txtNumber);


                btnAction.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        String name = "";
                        String number = "";

                        if(!edtName.getText().toString().isEmpty()) {
                            name = edtName.getText().toString();
                        }else {
                            Toast.makeText(context, "PLease Enter Contact Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!edtNumber.getText().toString().isEmpty()) {
                            number = edtNumber.getText().toString();
                        }else {
                            Toast.makeText(context, "PLease Enter Contact Number", Toast.LENGTH_SHORT).show();
                        }

                        if (!name.isEmpty() && !number.isEmpty()) {
                            arrContacts.set(position, new ContactModel(arrContacts.get(position).imgProfile, name, number));
                            notifyItemChanged(position);

                            dialog.dismiss();
                        }

                    }
                });
                dialog.show();
            }
        });

        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure you want to delete this contact?")
                        .setIcon(R.drawable.baseline_auto_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arrContacts.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        builder.show();

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgContact;
        TextView txtName, txtNumber;
        LinearLayout llRow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.ivProfile);
            llRow = itemView.findViewById(R.id.llRow);
        }
    }
}
