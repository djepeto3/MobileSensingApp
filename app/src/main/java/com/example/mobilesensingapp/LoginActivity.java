package com.example.mobilesensingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private EditText email;
    private EditText password;
    private TextView signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.loginBtn);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signUp = findViewById(R.id.signUpTextView);

        loginButton.setOnClickListener(this);
        signUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == loginButton){
            login();
        }
        if(v == signUp){
            //finish(); // proveriti tacno sta znaci finish()

            Intent registerIntent = new Intent(this, RegisterActivity.class);
            startActivity(registerIntent);
        }
    }

    private void login() {
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
    }
}
