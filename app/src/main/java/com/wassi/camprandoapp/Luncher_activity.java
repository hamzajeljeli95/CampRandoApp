package com.wassi.camprandoapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Luncher_activity extends AppCompatActivity implements Animation.AnimationListener {
    private static int SPLASH_TIME_OUT = 2000;
    String msg = "Android : ";
    // Animation
    Animation animFadein;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luncher);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.green_200));
            window.setNavigationBarColor(this.getResources().getColor(R.color.green_200));
        }

        img = (ImageView) findViewById(R.id.image);
        // load the animation
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        // set animation listener
        animFadein.setAnimationListener(this);
        img.setVisibility(View.VISIBLE);

        // start the animation
        img.startAnimation(animFadein);

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // TODO Auto-generated method stub


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent intent = new Intent(Luncher_activity.this, LoginActivity.class);
                startActivity(intent);
                // close this activity
                finish();

            }


            // close this activity

        }, SPLASH_TIME_OUT);


    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }


    /**
     * Called when the activity is about to become visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    /**
     * Called when the activity has become visible.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    /**
     * Called when another activity is taking focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    /**
     * Called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /**
     * Called just before the activity is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }

}
