package com.example.balbalan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.annotation.Annotation;

public class SpashScreen extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);

        textView =(TextView) findViewById(R.id.txtSplashScreen);
        imageView =(ImageView) findViewById(R.id.imageView);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        textView.setAnimation(myanim);
        imageView.setAnimation(myanim);
        final Intent i = new Intent (this, MainActivity.class);
        Thread time = new Thread(){
            public  void run(){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
              time.start();

    }
}
