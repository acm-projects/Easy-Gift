package com.example.easygift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class inviteFriend extends AppCompatActivity implements View.OnClickListener{

    private String name;
    private String eventName;
    private String[] arr;
    private String check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friend);

        name = getIntent().getStringExtra("name");
        eventName = getIntent().getStringExtra("event");
        arr = getIntent().getStringArrayExtra("arr");
        check = getIntent().getStringExtra("check");
    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        if (id == R.id.imageView10)
        {
            Intent done = new Intent(inviteFriend.this, homePage.class);
            done.putExtra("name", name);
            done.putExtra("event", eventName);
            done.putExtra("arr", arr);
            done.putExtra("check", "true");
            startActivity(done);
        }
    }
}
