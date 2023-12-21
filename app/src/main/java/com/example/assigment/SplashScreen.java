package com.example.assigment;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    sleep(1000);
                }

                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    Intent intent=new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }

            }
        }); thread.start();
    }
}