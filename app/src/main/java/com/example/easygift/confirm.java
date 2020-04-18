package com.example.easygift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class confirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        final String s = getIntent().getStringExtra("name");
        final String event = getIntent().getStringExtra("event");
        final String[] arr = getIntent().getStringArrayExtra("arr");
        final String check = getIntent().getStringExtra("check");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent done = new Intent(confirm.this, homePage.class);
                done.putExtra("name", s);
                done.putExtra("event", event);
                done.putExtra("arr", arr);
                done.putExtra("check", "true");
                startActivity(done);
                finish();
            }
        }, 4000);
    }
}
