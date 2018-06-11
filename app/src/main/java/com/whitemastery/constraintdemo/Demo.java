package com.whitemastery.constraintdemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Demo extends AppCompatActivity {

    ImageView relativeLay;
    private CustomProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        relativeLay = findViewById(R.id.relativeLay);
        progressBar = CustomProgressBar.getInstance();

        progressBar.show(Demo.this);


       /* final ObjectAnimator flip = ObjectAnimator.ofFloat(relativeLay, View.ROTATION_Y, 0f, 360f);
        flip.setDuration(1800);
        flip.setRepeatCount(ValueAnimator.INFINITE);
        flip.setRepeatMode(ValueAnimator.REVERSE);
        flip.setInterpolator(new LinearInterpolator());
        flip.start();*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                progressBar.dismiss();
                // flip.cancel();

            }
        }, 6000);

    }
}
