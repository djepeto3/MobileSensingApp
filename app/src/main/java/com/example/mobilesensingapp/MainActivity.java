package com.example.mobilesensingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView userTV;
    private Button reportBtn;
    private Button yourReportBtn;
    private Button infoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userTV=findViewById(R.id.userTV);
        reportBtn=findViewById(R.id.toReportBtn);
        yourReportBtn=findViewById(R.id.toYourReportBtn);

        reportBtn.setOnClickListener(this);
        yourReportBtn.setOnClickListener(this);
        //infoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==reportBtn){

        }else if(v==yourReportBtn){

        }else if(v==infoBtn){

        }

    }
}
