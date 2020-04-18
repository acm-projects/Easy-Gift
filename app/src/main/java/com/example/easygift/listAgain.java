package com.example.easygift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.*;

import java.util.*;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.*;

public class listAgain extends AppCompatActivity implements View.OnClickListener{
    private FirebaseFirestore database;
    private Map<String, String> map;
    private String s;
    private String a;
    private String item2;
    private String[] arr;
    private String[] arr2;
    private int[] arr3;
    private String eventName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_list);
        s = getIntent().getStringExtra("name");
        item2 = getIntent().getStringExtra("item");
        arr = getIntent().getStringArrayExtra("arr");
        a = getIntent().getStringExtra("num");
        arr2 = getIntent().getStringArrayExtra("arr2");
        arr3 = getIntent().getIntArrayExtra("arr3");
        eventName = getIntent().getStringExtra("event");
        sortArray();
        changeTitle();

        database = FirebaseFirestore.getInstance();
    }

    public void sortArray()
    {
        if (arr[1] != null)
        {
            String temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
        /*
        String[] tempArr = new String[10];
        Map<Integer, Integer> beforeSort = new HashMap<>();
        for(int i = 0; i < 10; i++)
        {
            beforeSort.put(arr3[i], i);
        }
        Arrays.sort(arr3);
        Map<Integer, Integer> afterSort = new HashMap<>();
        for(int i = 0; i < 10; i++)
        {
            afterSort.put(arr3[i], i);
        }

        for(int i = 0; i < 10; i++)
        {
            int prevInd = beforeSort.get(arr3[i]);
            int newInd = afterSort.get(arr3[i]);
            String str = arr[prevInd];
            tempArr[newInd] = str;
        }
        List<String> list = Arrays.asList(tempArr);
        while (list.get(0) != null)
        {
            list.add(list.remove(0));
        }
        arr = (String[]) list.toArray();
         */

    }

    public void changeTitle()
    {
        for (int i = 0; i < 10; i++)
        {
            if (arr[i] != null)
            {
                    if (i == 0)
                    {
                        TextView text = (TextView) findViewById(R.id.wish1);
                        text.setText(arr[i]);
                    }
                    else if (i == 1)
                    {
                        TextView text = (TextView)findViewById(R.id.wish2);
                        text.setText(arr[i]);
                    }
                    else if (i == 2)
                    {
                        TextView text = (TextView)findViewById(R.id.wish3);
                        text.setText(arr[i]);
                    }
                    else if (i == 3)
                    {
                        TextView text = (TextView)findViewById(R.id.wish4);
                        text.setText(arr[i]);
                    }
                    else if (i == 4)
                    {
                        TextView text = (TextView)findViewById(R.id.wish5);
                        text.setText(arr[i]);
                    }
                    else if (i == 5)
                    {
                        TextView text = (TextView)findViewById(R.id.wish6);
                        text.setText(arr[i]);
                    }
                    else if (i == 6)
                    {
                        TextView text = (TextView)findViewById(R.id.wish7);
                        text.setText(arr[i]);
                    }
                    else if (i == 7)
                    {
                        TextView text = (TextView)findViewById(R.id.wish8);
                        text.setText(arr[i]);
                    }
                    else if (i == 8)
                    {
                        TextView text = (TextView)findViewById(R.id.wish9);
                        text.setText(arr[i]);
                    }
                    else if (i == 9)
                    {
                        TextView text = (TextView)findViewById(R.id.wish10);
                        text.setText(arr[i]);
                    }
            }
        }
    }

    @Override
    public void onClick(View v)
    {
        int i = v.getId();
        if (i == R.id.wish1)
        {
            Intent item = new Intent(listAgain.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "1");
            item.putExtra("event", eventName);
            item.putExtra("arr", arr);
            item.putExtra("arr2", arr2);
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish2)
        {
            Intent item = new Intent(listAgain.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "2");
            item.putExtra("event", eventName);
            item.putExtra("arr", arr);
            item.putExtra("arr2", arr2);
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish3)
        {
            Intent item = new Intent(listAgain.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "3");
            item.putExtra("event", eventName);
            item.putExtra("arr", arr);
            item.putExtra("arr2", arr2);
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish4)
        {
            Intent item = new Intent(listAgain.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "4");
            item.putExtra("event", eventName);
            item.putExtra("arr", arr);
            item.putExtra("arr2", arr2);
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish5)
        {
            Intent item = new Intent(listAgain.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "5");
            item.putExtra("event", eventName);
            item.putExtra("arr", arr);
            item.putExtra("arr2", arr2);
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish6)
        {
            Intent item = new Intent(listAgain.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "6");
            item.putExtra("event", eventName);
            item.putExtra("arr", arr);
            item.putExtra("arr2", arr2);
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish7)
        {
            Intent item = new Intent(listAgain.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "7");
            item.putExtra("event", eventName);
            item.putExtra("arr", arr);
            item.putExtra("arr2", arr2);
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish8)
        {
            Intent item = new Intent(listAgain.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "8");
            item.putExtra("event", eventName);
            item.putExtra("arr", arr);
            item.putExtra("arr2", arr2);
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish9)
        {
            Intent item = new Intent(listAgain.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "9");
            item.putExtra("event", eventName);
            item.putExtra("arr", arr);
            item.putExtra("arr2", arr2);
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.wish10)
        {
            Intent item = new Intent(listAgain.this, item1.class);
            item.putExtra("name", s);
            item.putExtra("num", "10");
            item.putExtra("event", eventName);
            item.putExtra("arr", arr);
            item.putExtra("arr2", arr2);
            item.putExtra("arr3", arr3);
            startActivity(item);
        }
        else if (i == R.id.finishButton)
        {
            final String eventName2 = eventName;
            final DocumentReference docRef = database.collection("Users").document(s);
            docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    User user = documentSnapshot.toObject(User.class);
                    user.setEventsParticipatingIn(eventName2);
                    for (int i = 0; i < 10; i++)
                    {
                        if (arr[i] != null && arr2[i] != null)
                        {
                            user.addToWishList("Item" + Integer.toString(i +1), arr[i]);
                            user.addToWishList("Link" + Integer.toString(i +1), arr2[i]);
                        }
                    }

                    docRef.set(user, SetOptions.merge());
                }
            });

            Intent confirm = new Intent(listAgain.this, confirm.class);
            confirm.putExtra("name", s);
            confirm.putExtra("event", eventName);
            confirm.putExtra("arr", arr);
            confirm.putExtra("check", "true");
            startActivity(confirm);
        }
    }

}
