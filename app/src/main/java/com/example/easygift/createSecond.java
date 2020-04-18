package com.example.easygift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.firestore.*;
import java.util.*;

public class createSecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_second);

        final String str = getIntent().getStringExtra("name");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent select = new Intent(createSecond.this, selectEvent.class);
                select.putExtra("name", str);
                startActivity(select);
                finish();
            }
        }, 4000);
    }
}
