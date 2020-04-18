package com.example.easygift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import java.util.*;

import com.google.firebase.firestore.*;

public class firstList extends AppCompatActivity implements View.OnClickListener{

    private FirebaseFirestore database;
    private String s;
    private String eventName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_list);
        s = getIntent().getStringExtra("name");
        eventName = getIntent().getStringExtra("event");

        database = FirebaseFirestore.getInstance();
    }

    @Override
    public void onClick(View v)
    {
        int i = v.getId();
        if (i == R.id.wish1)
        {
            Intent item = new Intent(firstList.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "1");
            String[] arr = new String[10];
            item.putExtra("arr", arr);
            String[] arr2 = new String[10];
            item.putExtra("arr2", arr2);
            item.putExtra("event", eventName);
            int[] arr3 = new int[10];
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish2)
        {
            Intent item = new Intent(firstList.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "2");
            item.putExtra("event", eventName);
            String[] arr = new String[10];
            item.putExtra("arr", arr);
            String[] arr2 = new String[10];
            item.putExtra("arr2", arr2);
            int[] arr3 = new int[10];
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish3)
        {
            Intent item = new Intent(firstList.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "3");
            item.putExtra("event", eventName);
            String[] arr = new String[10];
            item.putExtra("arr", arr);
            String[] arr2 = new String[10];
            item.putExtra("arr2", arr2);
            int[] arr3 = new int[10];
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish4)
        {
            Intent item = new Intent(firstList.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "4");
            item.putExtra("event", eventName);
            String[] arr = new String[10];
            item.putExtra("arr", arr);
            String[] arr2 = new String[10];
            item.putExtra("arr2", arr2);
            int[] arr3 = new int[10];
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish5)
        {
            Intent item = new Intent(firstList.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "5");
            item.putExtra("event", eventName);
            String[] arr = new String[10];
            item.putExtra("arr", arr);
            String[] arr2 = new String[10];
            item.putExtra("arr2", arr2);
            int[] arr3 = new int[10];
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish6)
        {
            Intent item = new Intent(firstList.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "6");
            item.putExtra("event", eventName);
            String[] arr = new String[10];
            item.putExtra("arr", arr);
            String[] arr2 = new String[10];
            item.putExtra("arr2", arr2);
            int[] arr3 = new int[10];
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish7)
        {
            Intent item = new Intent(firstList.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "7");
            item.putExtra("event", eventName);
            String[] arr = new String[10];
            item.putExtra("arr", arr);
            String[] arr2 = new String[10];
            item.putExtra("arr2", arr2);
            int[] arr3 = new int[10];
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish8)
        {
            Intent item = new Intent(firstList.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "8");
            item.putExtra("event", eventName);
            String[] arr = new String[10];
            item.putExtra("arr", arr);
            String[] arr2 = new String[10];
            item.putExtra("arr2", arr2);
            int[] arr3 = new int[10];
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish9)
        {
            Intent item = new Intent(firstList.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "9");
            item.putExtra("event", eventName);
            String[] arr = new String[10];
            item.putExtra("arr", arr);
            String[] arr2 = new String[10];
            item.putExtra("arr2", arr2);
            int[] arr3 = new int[10];
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish10)
        {
            Intent item = new Intent(firstList.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "10");
            item.putExtra("event", eventName);
            String[] arr = new String[10];
            item.putExtra("arr", arr);
            String[] arr2 = new String[10];
            item.putExtra("arr2", arr2);
            int[] arr3 = new int[10];
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        if (i == R.id.finishButton)
        {
            Intent confirm = new Intent(firstList.this, confirm.class);
            confirm.putExtra("name", s);
            startActivity(confirm);
        }
    }

}
