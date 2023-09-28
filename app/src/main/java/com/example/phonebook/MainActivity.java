package com.example.phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    static int DURATION_OF_ANIMATION=3500;
    Animation topAnim;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //animacja
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);


        imageView = findViewById(R.id.imageView2);

        imageView.setAnimation(topAnim);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainWindow.class);
                startActivity(intent);
                finish();
            }
        }, DURATION_OF_ANIMATION);
     }
}