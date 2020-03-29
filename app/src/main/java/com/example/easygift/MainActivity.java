package com.example.easygift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_start);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent login = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(login);
                finish();
            }
        }, 3000);

        Intent start = new Intent(MainActivity.this, onStartActivity.class);
        startActivity(start);

    }


}
