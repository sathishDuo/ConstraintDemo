package com.whitemastery.constraintdemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;


public class CustomProgressBar {

    private Dialog dialog;
    private static CustomProgressBar mInstance;
    private ObjectAnimator flip;

    public static synchronized CustomProgressBar getInstance() {
        if (mInstance == null) {
            mInstance = new CustomProgressBar();
        }
        return mInstance;
    }

    @SuppressLint("NewApi")
    public void show(Context context) {
        if (dialog != null && dialog.isShowing()) {
            return;
        }
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_progress_bar);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();

        final CircleImageView ivFlip = dialog.findViewById(R.id.ivFlip);

        flip = ObjectAnimator.ofFloat(ivFlip, View.ROTATION_Y, 0f, 360f);
        flip.setDuration(1800);
        flip.setRepeatCount(ValueAnimator.INFINITE);
        flip.setRepeatMode(ValueAnimator.REVERSE);
        flip.setInterpolator(new LinearInterpolator());
        flip.start();

        /* Testing Purpose*/
    }

    public void dismiss() {
        if (dialog != null && dialog.isShowing()) {

            dialog.dismiss();
            flip.cancel();
        }
    }
}
