package com.example.easygift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.*;

public class selectEvent extends AppCompatActivity implements View.OnClickListener{

    FirebaseFirestore database;
    private String str;
    private String eventName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_event);

        str = getIntent().getStringExtra("name");

        database = FirebaseFirestore.getInstance();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.bdayButton)
        {
            final String s = str + "'s Birthday";
            Event event = new Event(s, "Birthday", str);
            database.collection("Events").document(s).set(event, SetOptions.merge());

            eventName = s;
        }
        else if(i == R.id.santaButton)
        {
            final String s = str + "'s Secret Santa";
            Event event = new Event(s, "SecretSanta", str);
            database.collection("Events").document(s).set(event, SetOptions.merge());

            eventName = s;
        }
        else if(i == R.id.wedButton)
        {
            final String s = str + "'s Wedding";
            Event event = new Event(s, "Wedding", str);
            database.collection("Events").document(s).set(event, SetOptions.merge());

            eventName = s;
        }
        else if(i == R.id.gradButton)
        {
            final String s = str + "'s Graduation";
            Event event = new Event(s, "Graduation", str);
            database.collection("Events").document(s).set(event, SetOptions.merge());

            eventName = s;
        }
        else if (i == R.id.otherButton)
        {
            final String s = str + "'s Event";
            Event event = new Event(s, "Event", str);
            database.collection("Events").document(s).set(event, SetOptions.merge());

            eventName = s;
        }

        Intent firstList = new Intent(selectEvent.this, firstList.class);
        firstList.putExtra("name", str);
        firstList.putExtra("event", eventName);
        startActivity(firstList);
    }
}
