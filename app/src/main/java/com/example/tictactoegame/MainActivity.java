package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button reset_button;
    private RelativeLayout reset_winnerMessage_layout;
    private String winner;
    private TextView winnerMessage;
    private int current_player=0;
    private int no_winner_counter=2;
    private int[] gameState = {2,2,2,2,2,2,2,2,2};
    private int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button_click(View view){

        Button any_button = (Button) view;
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(any_button,"scaleX",1.1f);
        animator1.setDuration(100);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(any_button, "scaleX", 1.0f);
        animator2.setDuration(100);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(any_button, "scaleY", 1.1f);
        animator3.setDuration(100);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(any_button, "scaleY", 1.0f);
        animator3.setDuration(100);

        AnimatorSet set = new AnimatorSet();
        set.play(animator1).before(animator2).with(animator3).before(animator4);
        set.start();

        int tag;
        tag = Integer.parseInt(any_button.getTag().toString());

        if(gameState[tag] == 2) {

            gameState[tag] = current_player;

            if (current_player == 0) {
                any_button.setText("X");
                any_button.setTextColor(Color.WHITE);
                any_button.setTextSize(40f);
                current_player = 1;
            } else if (current_player == 1) {
                any_button.setText("O");
                any_button.setTextColor(Color.WHITE);
                any_button.setTextSize(40f);
                current_player = 0;
            }
            for (int[] i : winningPositions) {
                if (gameState[i[0]] == gameState[i[1]] && gameState[i[1]] == gameState[i[2]] && gameState[i[0]] != 2) {

                    winner = "PLAYER 1 HAS WON!";
                    if (gameState[i[0]] == 1) {
                        winner = "PLAYER 2 HAS WON!";
                    }

                    winnerMessage = findViewById(R.id.winnerMessage_textView);
                    winnerMessage.setText(winner);
                    reset_winnerMessage_layout = findViewById(R.id.reset_winnerMessage_layout);
                    reset_winnerMessage_layout.animate().alpha(1f).scaleX(1.2f).setDuration(500);

                }

            }
            for(int i=0;i <9; i++){
                if(gameState[i] == 2){
                    no_winner_counter = 1;
                }
                else{
                    no_winner_counter = 0;
                }
            }
            if(no_winner_counter == 0){
                winnerMessage = findViewById(R.id.winnerMessage_textView);
                winnerMessage.setTextSize(20);
                winnerMessage.setText("IT'S A DRAW");
                reset_winnerMessage_layout = findViewById(R.id.reset_winnerMessage_layout);
                reset_winnerMessage_layout.animate().alpha(1f).scaleX(1.2f).setDuration(500);
            }
        }

}
    public void reset_game(View view){

        reset_button = findViewById(R.id.reset_button);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(reset_button,"scaleX",1.1f);
        animator1.setDuration(100);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(reset_button, "scaleX", 1.0f);
        animator2.setDuration(100);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(reset_button, "scaleY", 1.1f);
        animator3.setDuration(100);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(reset_button, "scaleY", 1.0f);
        animator3.setDuration(100);

        AnimatorSet set = new AnimatorSet();
        set.play(animator1).before(animator2).with(animator3).before(animator4);
        set.start();

        reset_winnerMessage_layout.setAlpha(0f);
        current_player = 0;

        for(int i=0;i < gameState.length; i++){
            gameState[i] = 2;
        }

        Button reset_button00 = findViewById(R.id.button_00);
        reset_button00.setText("");
        Button reset_button01 = findViewById(R.id.button_01);
        reset_button01.setText("");
        Button reset_button02 = findViewById(R.id.button_02);
        reset_button02.setText("");
        Button reset_button10 = findViewById(R.id.button_10);
        reset_button10.setText("");
        Button reset_button11 = findViewById(R.id.button_11);
        reset_button11.setText("");
        Button reset_button12 = findViewById(R.id.button_12);
        reset_button12.setText("");
        Button reset_button20 = findViewById(R.id.button_20);
        reset_button20.setText("");
        Button reset_button21 = findViewById(R.id.button_21);
        reset_button21.setText("");
        Button reset_button22 = findViewById(R.id.button_22);
        reset_button22.setText("");

    }
}
