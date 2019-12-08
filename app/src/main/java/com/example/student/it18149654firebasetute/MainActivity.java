package com.example.student.it18149654firebasetute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText id_student, name_student, address_student, contact_student;
    private Button add_btn, show_btn, update_btn, delete_btn;

    private DatabaseReference dbRef;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_student = findViewById(R.id.txtID);
        name_student = findViewById(R.id.txtName);
        address_student = findViewById(R.id.txtAddress);
        contact_student = findViewById(R.id.txtContact);

        add_btn = findViewById(R.id.btnSave);
        show_btn = findViewById(R.id.btnShow);
        update_btn = findViewById(R.id.btnUpdate);
        delete_btn = findViewById(R.id.btnDelete);

        student = new Student();

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Student");
                student.setID(id_student.getText().toString().trim());
                student.setName(name_student.getText().toString().trim());
                student.setAddress(address_student.getText().toString().trim());
                student.setContNum(Integer.parseInt(contact_student.getText().toString().trim()));

                dbRef.push().setValue(student);

                Toast.makeText(getApplicationContext(), "Adding Success", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void clearData() {
        id_student.setText("");
        name_student.setText("");
        address_student.setText("");
        contact_student.setText("");
    }
}
