package com.example.mobilesensingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private EditText emailET;
    private EditText passwordET;
    private TextView signUpTV;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.loginBtn);
        emailET = findViewById(R.id.email);
        passwordET = findViewById(R.id.password);
        signUpTV = findViewById(R.id.signUpTextView);

        firebaseAuth = FirebaseAuth.getInstance();
        Log.v("LoginActivity", "uzeo instancu");
        if(firebaseAuth.getCurrentUser() != null){
            Intent homeIntent = new Intent(this, MainActivity.class);
            startActivity(homeIntent);
            Log.v("LoginActivity", "uspeo");
        }
        loginButton.setOnClickListener(this);
        signUpTV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == loginButton){
            login();
        }
        if(v == signUpTV){
            //finish(); // proveriti tacno sta znaci finish()
            Intent registerIntent = new Intent(this, RegisterActivity.class);
            startActivity(registerIntent);
        }
    }

    private void login() {
        //Intent homeIntent = new Intent(this, MainActivity.class);
        //startActivity(homeIntent);
        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,R.string.enter_email_please, Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,R.string.enter_password_please, Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent homeIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(homeIntent);
                }
                else{
                    Toast.makeText(LoginActivity.this,R.string.wrong, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
