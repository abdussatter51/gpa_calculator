package com.abdussatter.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    Animation zoomIn, fadeIn;
    ImageView imageSquareLogo;
    TextView tvCollege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        imageSquareLogo = findViewById(R.id.imageSquareLogo);
        tvCollege = findViewById(R.id.tvCollege);
        imageSquareLogo.startAnimation(zoomIn);
        tvCollege.startAnimation(fadeIn);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this,MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}