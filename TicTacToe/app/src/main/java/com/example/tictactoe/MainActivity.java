package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0 for purp, 1 vortex n 2 for empty
    int CP = 0;
    boolean gameActive = true;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningP = {{0,1,2}, {0,3,6}, {0,4,8}, {1,4,7}, {2,5,8}, {2,4,6}, {3,4,5}, {6,7,8}};
    Button button;
    static String holder= "NO MORE MOVES";
    int moves = 9;

    public void dropIn(View view){

        ImageView counter = (ImageView) view;


        int tappedC = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedC] == 2 && gameActive) {

            gameState[tappedC] = CP;
            //moves--;
            counter.setTranslationY(-1500);

            if (CP == 0) {
                moves--;
                counter.setImageResource(R.drawable.purpsphere);
                CP=1;

            } else {
                moves--;
                counter.setImageResource(R.drawable.vortexsphere);
                CP=0;

            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] WP : winningP) {

                if (gameState[WP[0]] == gameState[WP[1]] && gameState[WP[1]] == gameState[WP[2]] && gameState[WP[0]] != 2) {  //making sure 0 = 1 = 2 and they aren't empty
                    //who won

                    String Winner;
                    if (CP == 0) {
                        Winner = "Vortex";
                        gameActive=false;
                    } else {
                        Winner = "Purple ";
                        gameActive=false;
                    }

                    //Toast.makeText(this, Winner + " has won!", Toast.LENGTH_SHORT).show();
//                    Button playAgain = findViewById(R.id.playbtn);
//                    TextView WanaPlay = findViewById(R.id.textView);
//                    WanaPlay.setText(Winner + " has won!");
                    holder = (Winner + " has won!");
//                    playAgain.setVisibility(View.VISIBLE);
//                    WanaPlay.setVisibility(View.VISIBLE);
                    startActivity(new Intent(MainActivity.this, popUpDynamic.class));
                    finish();

                } else if (moves == 0){
                   // holder = "NO MORE MOVES";
                    Toast.makeText(this, "num of moves left: "+moves, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, popUpDynamic.class));
                    finish();
                    System.exit(0);
                }

        }

        }
    }

    public void PlayAgain(View view){ // not using it since i m using 2 activities

        Button playAgain = findViewById(R.id.playbtn);
        TextView WanaPlay = findViewById(R.id.textView);

        playAgain.setVisibility(View.INVISIBLE);
        WanaPlay.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = findViewById(R.id.grid);

        for(int i=0; i<gridLayout.getChildCount(); i++) {

            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }

        for (int i=0; i<gameState.length; i++) {

            gameState[i] = 2;

        }

        CP = 0;

        gameActive = true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        button = findViewById(R.id.buttonpop); // was for testing
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(new Intent(MainActivity.this, popUpDynamic.class));
//                //openActivity();
//
//
//            }
//        });


    }

//    public void openActivity(){
//
//        Intent intent0 = new Intent(this, popUpDynamic.class);
//        startActivity(intent0);
//
//    }

}