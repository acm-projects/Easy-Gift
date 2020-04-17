package com.example.easygift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.*;

import java.util.Map;

public class homePage extends AppCompatActivity implements View.OnClickListener{

    private String name;
    private String eventName;
    private String[] arr;
    private String check;

    private FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        database = FirebaseFirestore.getInstance();

        name = getIntent().getStringExtra("name");
        eventName = getIntent().getStringExtra("event");
        arr = getIntent().getStringArrayExtra("arr");
        check = getIntent().getStringExtra("check");

        if (check.equals("true"))
        {
            setList();
        }
        else
        {
            createArray();
            setList();
        }

        changeImage();
    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        if (id == R.id.imageButton9 || id == R.id.imageButton31 || id == R.id.imageButton32 || id == R.id.imageButton33 ||
                id == R.id.imageButton5 || id == R.id.imageButton6 || id == R.id.imageButton7 || id == R.id.imageButton8)
        {
            Intent invite = new Intent(homePage.this, inviteFriend.class);
            invite.putExtra("name", name);
            invite.putExtra("event", eventName);
            invite.putExtra("arr", arr);
            invite.putExtra("check", "true");
            startActivity(invite);
        }
    }

    private void createArray()
    {
        final DocumentReference docRef = database.collection("Users").document("Shan");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = documentSnapshot.toObject(User.class);
                eventName = user.getEventsParticipatingIn();

                Map<String, String> map = user.getWishList();
                for (int i = 0; i < 10; i++)
                {
                    if (map.keySet().contains("Item" + Integer.toString(i +1)))
                    {
                        arr[i] = map.get("Item" + Integer.toString(i +1));
                    }
                }

            }
        });
    }

    private void changeImage()
    {
        ImageButton img = findViewById(R.id.imageButton11);
        if (eventName.contains("Wed"))
        {
            img.setBackgroundResource(R.drawable.wedding);
        }
        else if (eventName.contains("Other"))
        {
            img.setBackgroundResource(R.drawable.other);
        }
        else if (eventName.contains("Santa"))
        {
            img.setBackgroundResource(R.drawable.secretsanta);
        }
        else if (eventName.contains("Grad"))
        {
            img.setBackgroundResource(R.drawable.graduation);
        }
    }

    private void setList()
    {
        for (int i = 0; i < 10; i++)
        {
            if (arr[i] != null)
            {
                if (i == 0)
                {
                    TextView text = (TextView) findViewById(R.id.imageButton15);
                    text.setText(arr[i]);
                }
                else if (i == 1)
                {
                    TextView text = (TextView)findViewById(R.id.imageButton16);
                    text.setText(arr[i]);
                }
                else if (i == 2)
                {
                    TextView text = (TextView)findViewById(R.id.imageButton17);
                    text.setText(arr[i]);
                }
                else if (i == 3)
                {
                    TextView text = (TextView)findViewById(R.id.imageButton18);
                    text.setText(arr[i]);
                }
                else if (i == 4)
                {
                    TextView text = (TextView)findViewById(R.id.imageButton19);
                    text.setText(arr[i]);
                }
                else if (i == 5)
                {
                    TextView text = (TextView)findViewById(R.id.imageButton20);
                    text.setText(arr[i]);
                }
                else if (i == 6)
                {
                    TextView text = (TextView)findViewById(R.id.imageButton21);
                    text.setText(arr[i]);
                }
                else if (i == 7)
                {
                    TextView text = (TextView)findViewById(R.id.imageButton22);
                    text.setText(arr[i]);
                }
                else if (i == 8)
                {
                    TextView text = (TextView)findViewById(R.id.imageButton23);
                    text.setText(arr[i]);
                }
                else if (i == 9)
                {
                    TextView text = (TextView)findViewById(R.id.imageButton24);
                    text.setText(arr[i]);
                }
            }
        }
    }
}
