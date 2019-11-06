package com.example.mobilesensingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailET;
    private EditText passwordET;
    private Button register;
    private TextView logInTV;
    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailET = findViewById(R.id.email);
        passwordET = findViewById(R.id.password);
        register = findViewById(R.id.registerBtn);
        logInTV = findViewById(R.id.signInTextView);
        progressBar = findViewById(R.id.progressBar);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            Intent homeIntent = new Intent(this, MainActivity.class);
            startActivity(homeIntent);
        }

        register.setOnClickListener(this);
        logInTV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==register){
            //Intent homeIntent = new Intent(this, MainActivity.class);
            //startActivity(homeIntent);
            register();

        }else if(v==logInTV){
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
        }

    }

    private void register() {
        String email = emailET.getText().toString().trim();
        String password= passwordET.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,R.string.enter_email_please, Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,R.string.enter_password_please, Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isComplete()){
                    Toast.makeText(RegisterActivity.this, "Registrated successfully", Toast.LENGTH_SHORT).show();
                    Intent homeIntent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(homeIntent);

                }else {
                    Toast.makeText(RegisterActivity.this, R.string.not_registrated, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
