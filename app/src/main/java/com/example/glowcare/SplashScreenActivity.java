package com.example.glowcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.glowcare.Handler.ConnectivityReceiver;
import com.example.glowcare.Handler.MyApp;

/**
 * Splash Screen Activity loads the app icon with animation
 */
public class SplashScreenActivity extends AppCompatActivity{

    private ImageView home;
    private TextView name;
    private Animation top,bottom,expected_anim;
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        context = getApplicationContext();

        init();



    }

    /**
     * Animation with top, bottom and center position 
     */
    private void init() {

        home = findViewById(R.id.imageView4);
        name = findViewById(R.id.name);

        //for animation initialization
        top = AnimationUtils.loadAnimation(context,R.anim.top_anim);
        bottom = AnimationUtils.loadAnimation(context,R.anim.bottom_anim);
        expected_anim = AnimationUtils.loadAnimation(context,R.anim.current_position_to_expected_position);

        //setAnim

        home.startAnimation(top);
        name.startAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            /**
             * This method allows to open the splashcreen activity runs for particular amount of time.
             */
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this,SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);


    }

}