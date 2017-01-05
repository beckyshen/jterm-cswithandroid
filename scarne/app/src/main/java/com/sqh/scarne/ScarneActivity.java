package com.sqh.scarne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        TextView scores = (TextView) findViewById(R.id.score);
        switch (diceNumber){
            case 1:
                Scarnedice.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                uTurn = 0;
                break;
            case 2:
                Scarnedice.setImageDrawable(getResources().getDrawable(R.drawable.dice2));
                uTurn +=2;
                break;
            case 3:
                Scarnedice.setImageDrawable(getResources().getDrawable(R.drawable.dice3));
                uTurn +=3;
                break;
            case 4:
                Scarnedice.setImageDrawable(getResources().getDrawable(R.drawable.dice4));
                uTurn +=4;
                break;
            case 5:
                Scarnedice.setImageDrawable(getResources().getDrawable(R.drawable.dice5));
                uTurn +=5;
                break;
            case 6:
                Scarnedice.setImageDrawable(getResources().getDrawable(R.drawable.dice6));
                uTurn +=6;
                break;
        }
        scores.setText("Your score: "+ Integer.toString(uScore +=uTurn) +" Computer score: 0");
        uTurn = 0;

        //Log.d("Testing",Integer.toString(diceNumber));


    }

}
