package com.example.app_dm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class Join extends AppCompatActivity {

    TextInputEditText joinCode;
    Button btnJoin;
    FloatingActionButton joinToHome;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        joinCode= findViewById(R.id.joinCode);
        btnJoin = findViewById(R.id.btn_join);
        joinToHome = findViewById(R.id.joinToHome);

        joinToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
                finish();
            }
        });

    }
}