package com.ngtkn.animation_splash_screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        imageView = findViewById(R.id.image_view);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_transition);
        textView.startAnimation(animation);
        imageView.startAnimation(animation);
        final Intent intent = new Intent(this, Activity_2.class);

        // Sleep then transition to activity 2
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
