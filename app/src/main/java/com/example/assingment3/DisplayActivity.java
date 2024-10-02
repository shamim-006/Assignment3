package com.example.assingment3;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textViewInfo = findViewById(R.id.textViewInfo);


        String name = getIntent().getStringExtra("NAME");
        String studentId = getIntent().getStringExtra("ID");
        String email = getIntent().getStringExtra("EMAIL");
        String password = getIntent().getStringExtra("PASSWORD");


        textViewInfo.setText("Name: " + name + "\nStudent ID: " + studentId + "\nEmail: " + email + "\nPassword: " + password);

        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearInformation();
            }
        });
    }

    private void clearInformation() {
        textViewInfo.setText("Information cleared");
    }
}
