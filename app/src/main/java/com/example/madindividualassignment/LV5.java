package com.example.madindividualassignment;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LV5 extends AppCompatActivity {


        private View[] views;
        private int highlightedIndex;
    private int accurateTaps;
    private  TextView accurateTapsTextView;
        private CountDownTimer countDownTimer;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lv5);



            views = new View[] {
                    findViewById(R.id.view1),
                    findViewById(R.id.view2),
                    findViewById(R.id.view3),
                    findViewById(R.id.view4),
                    findViewById(R.id.view5),
                    findViewById(R.id.view6),
                    findViewById(R.id.view7),
                    findViewById(R.id.view8),
                    findViewById(R.id.view9),
                    findViewById(R.id.view10),
                    findViewById(R.id.view11),
                    findViewById(R.id.view12),
                    findViewById(R.id.view13),
                    findViewById(R.id.view14),
                    findViewById(R.id.view15),
                    findViewById(R.id.view16),
                    findViewById(R.id.view17),
                    findViewById(R.id.view18),
                    findViewById(R.id.view19),
                    findViewById(R.id.view20),
                    findViewById(R.id.view21),
                    findViewById(R.id.view22),
                    findViewById(R.id.view23),
                    findViewById(R.id.view24),
                    findViewById(R.id.view25),
                    findViewById(R.id.view26),
                    findViewById(R.id.view27),
                    findViewById(R.id.view28),
                    findViewById(R.id.view29),
                    findViewById(R.id.view30),
                    findViewById(R.id.view31),
                    findViewById(R.id.view32),
                    findViewById(R.id.view33),
                    findViewById(R.id.view34),
                    findViewById(R.id.view35),
                    findViewById(R.id.view36)

            };
            highlightedIndex = -1;

            accurateTapsTextView = findViewById(R.id.accurateTapsTextView);
            accurateTaps = getIntent().getIntExtra("score_level4",1);


            highlightRandomView();

            // Set up touch listeners for views
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
                    Intent intent = new Intent(LV5.this, InputName.class);
                    intent.putExtra("Level", 2);
                    intent.putExtra("score_level5", accurateTaps);
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