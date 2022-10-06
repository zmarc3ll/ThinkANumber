package com.example.thinkanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnPlusz;
    private Button btnMinusz;
    private Button btnTipp;
    private ImageView hp1;
    private ImageView hp2;
    private ImageView hp3;
    private ImageView hp4;
    private TextView tippErtek;
    private int tipp;
    private int gondolt;
    private int elet;
    private Random rnd;
    private ImageView[] eletek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListeners();
    }
    private void init(){
        btnPlusz =findViewById(R.id.btnPlusz);
        btnMinusz=findViewById(R.id.btnMinusz);
        btnTipp= findViewById(R.id.btnTipp);
        hp1=findViewById(R.id.hp1);
        hp2=findViewById(R.id.hp2);
        hp3=findViewById(R.id.hp3);
        hp4=findViewById(R.id.hp4);
        tippErtek=findViewById(R.id.tippErtek);
        rnd=new Random();
        tipp=1;
        gondolt=rnd.nextInt(10)+1;
        Log.d("gondolt",String.valueOf(gondolt));
        elet=4;
        //eletek
    }

    private void addListeners(){
        btnPlusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp<10){
                    tipp++;
                    tippErtek.setText(String.valueOf(tipp));
                } else {
                    Toast.makeText(MainActivity.this, "A gondolt szám nem lehet nagyobb mint 10", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnMinusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp>1){
                    tipp--;
                    tippErtek.setText(String.valueOf(tipp));
                } else {
                    Toast.makeText(MainActivity.this, "A gondolt szám nem lehet kisebb mint 1", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnTipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp < gondolt) {
                    eletCsokkentSwitchCase();
                    elet--;
                    Toast.makeText(MainActivity.this, "A gondolt szám nagyobb", Toast.LENGTH_SHORT).show();
                } else if(tipp > gondolt){
                    Toast.makeText(MainActivity.this, "A gondolt szám kisebb", Toast.LENGTH_SHORT).show();
                } else {
                    //TODO győzelem
                }
            }
        });
    }

    private void eletCsokkentSwitchCase() {
        elet--;
        switch (elet) {
            case 3:
                hp4.setImageResource(R.drawable.heart1);
                break;
            case 2:
                hp3.setImageResource(R.drawable.heart1);
                break;
            case 1:
                hp2.setImageResource(R.drawable.heart1);
                break;
            case 0:
                hp1.setImageResource(R.drawable.heart1);
                break;
        }
        if (elet == 0) {
            //TODO vereseg
        }

    }
}