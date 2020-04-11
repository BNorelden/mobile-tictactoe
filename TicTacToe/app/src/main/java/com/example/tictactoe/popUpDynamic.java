package com.example.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import static com.example.tictactoe.MainActivity.holder;


public class popUpDynamic extends Activity  {


    TextView tView2;
    Button b,exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);

         tView2 = findViewById(R.id.tView2);
         tView2.setText(holder);

        DisplayMetrics dm =  new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        b = findViewById(R.id.play2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(popUpDynamic.this, MainActivity.class));
                finish();
               // MainActivity.PlayAgain();

            }

        });



        getWindow().setLayout((int)(width*0.70), (int)(height*0.70));

        exit = findViewById(R.id.Exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });



    }



}
