package com.example.adiligencia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity implements Runnable{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash);


            Handler handler = new Handler();
            handler.postDelayed(this,2000);
        }

        @Override
        public void run(){

            startActivity(new Intent(this, MainActivity.class));
            finish();
        }



    }

