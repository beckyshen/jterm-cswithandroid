package com.sqh.scarne;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import static android.R.attr.id;

public class ScarneActivity extends AppCompatActivity {
    /**the user's overall score state*/
    public int uScore;
    /**the user's turn score*/
    public int uTurn;
    /**the computer's overall score*/
    public int cScore;
    /**the computer's turn score*/
    public int cTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scarne);
    }
    public void RollDice(View view){
        Random dice =  new Random();
        int diceNumber = dice.nextInt(6)+1;
        ImageView Scarnedice = (ImageView) findViewById(R.id.dice);

        switch (diceNumber) {
            case 1:
                Scarnedice.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                uTurn = 0;
                break;
            case 2:
                Scarnedice.setImageDrawable(getResources().getDrawable(R.drawable.dice2));
                uTurn += 2;
                break;
            case 3:
                Scarnedice.setImageDrawable(getResources().getDrawable(R.drawable.dice3));
                uTurn += 3;
                break;
            case 4:
                Scarnedice.setImageDrawable(getResources().getDrawable(R.drawable.dice4));
                uTurn += 4;
                break;
            case 5:
                Scarnedice.setImageDrawable(getResources().getDrawable(R.drawable.dice5));
                uTurn += 5;
                break;
            case 6:
                Scarnedice.setImageDrawable(getResources().getDrawable(R.drawable.dice6));
                uTurn += 6;
                break;
        }

        TextView scores = (TextView) findViewById(R.id.score);
        scores.setText("Your score: "+ Integer.toString(uScore +=diceNumber) +" Computer score: 0");
        if (uTurn == 0){
            computerTurn(view);

        }

        //Log.d("Testing",Integer.toString(diceNumber));
    }
    public void Hold(View view){
        TextView scores = (TextView) findViewById(R.id.score);
        scores.setText("Your score: "+ Integer.toString(uScore) +" Computer score: 0");
        computerTurn(view);
        uTurn = 0;
    }
    private void computerTurn(View view){
        Button roll = (Button) findViewById(R.id.roll);

        // This is "final" because we need to access it from within Runnable.run() below.
        final TextView textView = (TextView) findViewById(R.id.random_text);

        // Initialize a new Random variable for use later.
        final Random mRandom = new Random();

    // Create a new Handler. This schedules runnables.
        final Handler mHandler = new Handler();

    // Create a new Runnable. This executes some code when run by the handler.
        final Runnable mRunnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Next number: " + mRandom.nextInt(100));
                mHandler.postDelayed(this, 1000);
            }
        };
        mHandler.postDelayed(mRunnable, 1000);
    }
    public void ResetScore(View view){
        uScore = 0;
        uTurn = 0;
        cScore = 0;
        cTurn = 0;
        TextView scores = (TextView) findViewById(R.id.score);
        scores.setText("Your score: 0  Computer score: 0");

    }

}
