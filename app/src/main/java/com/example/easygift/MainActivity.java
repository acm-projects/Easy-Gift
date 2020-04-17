package com.example.easygift;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

public class MainActivity extends AppCompatActivity{

    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_start);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                if (user == null)
                {
                    Intent login = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(login);
                }
                /*
                else
                {
                    New intent for home page
                }
                 */
                finish();
            }
        }, 3000);

        Intent start = new Intent(MainActivity.this, onStartActivity.class);
        startActivity(start);

    }


}
