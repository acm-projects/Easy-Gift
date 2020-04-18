package com.example.easygift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;


public class createFirst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_first);

        final String savedExtra = getIntent().getStringExtra("name");
        TextView myText = (TextView) findViewById(R.id.textView3);
        myText.setText(savedExtra + ".");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent create2 = new Intent(createFirst.this, createSecond.class);
                create2.putExtra("name", savedExtra);
                startActivity(create2);
                finish();
            }
        }, 4000);
    }
}
