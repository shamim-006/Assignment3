package com.example.assingment3;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextId, editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextId = findViewById(R.id.editTextId);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        findViewById(R.id.buttonRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String name = editTextName.getText().toString().trim();
        String studentId = editTextId.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();


        if (TextUtils.isEmpty(name) || !name.matches("^[a-zA-Z-]+$")) {
            editTextName.setError("Enter a valid name (letters and hyphen only)");
            return;
        }


        if (studentId.length() != 16 || !TextUtils.isDigitsOnly(studentId)) {
            editTextId.setError("Enter a valid 16-digit ID");
            return;
        }


        if (TextUtils.isEmpty(email) || !email.matches("[a-z\\d]+@gmail\\.com")) {
            editTextEmail.setError("Enter a valid Gmail address");
            return;
        }


        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Enter a password");
            return;
        }


        Intent intent = new Intent(MainActivity.this,DisplayActivity.class);
        intent.putExtra("NAME", name);
        intent.putExtra("ID", studentId);
        intent.putExtra("EMAIL", email);
        intent.putExtra("PASSWORD", password);
        startActivity(intent);
    }
}
