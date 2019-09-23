package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button reset_button;
    private int current_player=0;

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

        if(current_player == 0){
            any_button.setText("X");
            any_button.setTextColor(Color.WHITE);
            any_button.setTextSize(40f);
            current_player = 1;
        }
        else if(current_player == 1){
            any_button.setText("O");
            any_button.setTextColor(Color.WHITE);
            any_button.setTextSize(40f);
            current_player = 0;
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
    }
}
