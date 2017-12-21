package com.firstapp.myapplication;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button roll_button = (Button) findViewById(R.id.rollButton);

        final ImageView left_dice = (ImageView) findViewById(R.id.left_dice);

        final ImageView right_dice = (ImageView) findViewById(R.id.right_dice);

        final int[] dice_array = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        roll_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Dicce", "button was press");

                Random random_number = new Random();
                int num1 = random_number.nextInt(6);
                int num2 = random_number.nextInt(6);

                right_dice.setImageResource(dice_array[num1]);
                left_dice.setImageResource(dice_array[num2]);
            }
        });
    }
}
