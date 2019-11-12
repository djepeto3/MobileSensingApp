package com.example.mobilesensingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView userTV;
    private Button reportBtn;
    private Button yourReportBtn;
    private Button infoBtn;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        userTV=findViewById(R.id.userTV);
        userTV.setText(firebaseUser.getEmail());
        reportBtn=findViewById(R.id.toReportBtn);
        yourReportBtn=findViewById(R.id.toYourReportBtn);

        reportBtn.setOnClickListener(this);
        yourReportBtn.setOnClickListener(this);
        //infoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==reportBtn){
            Intent reportIntent = new Intent(this, ReportActivity.class);
            startActivity(reportIntent);

        }else if(v==yourReportBtn){
            Intent yourReportIntent = new Intent(this, SelfReportActivity.class);
            startActivity(yourReportIntent);

        }else if(v==infoBtn){

        }

    }
}
