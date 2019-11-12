package com.example.mobilesensingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class SelfReportActivity extends AppCompatActivity {

    private CheckBox runnyNose;
    private CheckBox coughing;
    private CheckBox sneezing;
    private CheckBox headache;
    private CheckBox fatigue;
    private CheckBox musclePain;
    private CheckBox chestpain;

    private CheckBox feelGood;
    List<CheckBox> checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_report);

        checkBoxes = new ArrayList<>();
        runnyNose=findViewById(R.id.runnyNose);
        checkBoxes.add(runnyNose);
        coughing=findViewById(R.id.coughing);
        checkBoxes.add(coughing);
        sneezing=findViewById(R.id.sneezing);
        checkBoxes.add(sneezing);
        headache=findViewById(R.id.headache);
        checkBoxes.add(headache);
        fatigue=findViewById(R.id.fatigue);
        checkBoxes.add(fatigue);
        musclePain=findViewById(R.id.musclePain);
        checkBoxes.add(musclePain);
        chestpain=findViewById(R.id.chestPain);
        checkBoxes.add(chestpain);
        feelGood=findViewById(R.id.feelGood);
    }

    public void onCheckboxClicked(View view) {

        for (CheckBox ch: checkBoxes) {
            if(ch.isChecked()){
                feelGood.setChecked(false);
                return;
            }
        }
        feelGood.setChecked(true);
    }
}
