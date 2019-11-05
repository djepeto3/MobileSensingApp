package com.example.mobilesensingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email;
    private EditText password;
    private Button register;
    private TextView logIn;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.registerBtn);
        logIn = findViewById(R.id.signInTextView);
        progressBar = findViewById(R.id.progressBar);

        register.setOnClickListener(this);
        logIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==register){
            Intent homeIntent = new Intent(this, MainActivity.class);
            startActivity(homeIntent);

        }else if(v==logIn){
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
        }

    }
}
