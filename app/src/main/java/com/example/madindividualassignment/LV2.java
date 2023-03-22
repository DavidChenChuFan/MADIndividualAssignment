package com.example.madindividualassignment;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LV2 extends AppCompatActivity {

    private View[] views;
    private int highlightedIndex;
    private int accurateTaps;
    private  TextView accurateTapsTextView;
    private CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv2);



    views = new View[] {
        findViewById(R.id.view1),
                findViewById(R.id.view2),
                findViewById(R.id.view3),
                findViewById(R.id.view4),
                findViewById(R.id.view5),
                findViewById(R.id.view6),
                findViewById(R.id.view7),
                findViewById(R.id.view8),
                findViewById(R.id.view9)
    };
    highlightedIndex = -1;
    accurateTapsTextView = findViewById(R.id.accurateTapsTextView);

    accurateTaps = getIntent().getIntExtra("score_level1",1);


    highlightRandomView();


        for (View view : views) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v == views[highlightedIndex]) {
                    // Player touched the highlighted view
                    accurateTaps++;
                    accurateTapsTextView.setText("Accurate Taps" + accurateTaps);
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
                // Exit the application
                finish();
            }
        });


    countDownTimer = new CountDownTimer(5000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {}

        @Override
        public void onFinish() {

            Intent intent = new Intent(LV2.this, LV3.class);
            intent.putExtra("Level", 1);
            intent.putExtra("score_level2", accurateTaps);
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