package com.example.madindividualassignment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LV1 extends AppCompatActivity {

    private View[] views;
    private int highlightedIndex;
    private int accurateTaps;
    private  TextView accurateTapsTextView;
    private CountDownTimer countDownTimer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv1);


        views = new View[] {
                findViewById(R.id.view1),
                findViewById(R.id.view2),
                findViewById(R.id.view3),
                findViewById(R.id.view4)
        };
        highlightedIndex = -1;
        accurateTaps = 0;
        accurateTapsTextView = findViewById(R.id.accurateTapsTextView);








        highlightRandomView();


        for (View view : views) {
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (v == views[highlightedIndex]) {
                        // Player touched the highlighted view
                        accurateTaps++;
                        accurateTapsTextView.setText("Accurate Taps: " + accurateTaps);
                        highlightRandomView();


                    }
                    return true;
                }
            });
        }
        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


        countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {}

            @Override
            public void onFinish() {
                // Proceed to Level 2
                Intent intent = new Intent(LV1.this, LV2.class);
                intent.putExtra("Level", 1);
                intent.putExtra("score_level1", accurateTaps);
                startActivity(intent);
                finish();
            }
        };
        countDownTimer.start();
    }


    private void highlightRandomView() {

        if (highlightedIndex != -1) {
            views[highlightedIndex].setBackgroundColor(Color.parseColor("#FF744D"));
        }

        int randomIndex = highlightedIndex;
        while (randomIndex == highlightedIndex) {
            randomIndex = (int) (Math.random() * views.length);
        }
        highlightedIndex = randomIndex;
        views[highlightedIndex].setBackgroundColor(Color.YELLOW);
    }

}