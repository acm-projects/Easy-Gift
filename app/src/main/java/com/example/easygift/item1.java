package com.example.easygift;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.content.Intent;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.google.firebase.storage.*;

public class item1 extends AppCompatActivity implements View.OnClickListener{

    private FirebaseFirestore database;
    private FirebaseStorage storage;
    private String name;
    private String a;
    private String first;
    private String[] arr;
    private String[] arr2;
    private int[] arr3;

    private String item;
    private String link;
    private String eventName;
    private int price;

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onResume();
        setContentView(R.layout.activity_item1);

        database = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();

        img = (ImageView)findViewById(R.id.imageField);

        name = getIntent().getStringExtra("name");
        a = getIntent().getStringExtra("num");
        first = getIntent().getStringExtra("first");
        arr = getIntent().getStringArrayExtra("arr");
        arr2 = getIntent().getStringArrayExtra("arr2");
        eventName = getIntent().getStringExtra("event");
        arr3 = getIntent().getIntArrayExtra("arr3");
    }

    private void storeData()
    {
        TextView text = findViewById(R.id.itemField);
        final String str = text.getText().toString();
        item = str;

        TextView text2 = findViewById(R.id.linkText);
        final String link2 = text2.getText().toString();
        link = link2;

        TextView text3 = findViewById(R.id.priceField);
        if (!(text3.getText().toString().isEmpty()))
        {
            price = Integer.parseInt(text3.getText().toString());
        }
        else
        {
            price = 99;
        }
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        ImageView img = findViewById(R.id.imageField);
        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                img.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }else {
        }
    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        if (id == R.id.imageField)
        {
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, 1);
        }
        if (id == R.id.doneButton)
        {
            storeData();
            Intent again = new Intent(item1.this, listAgain.class);
            again.putExtra("name", name);
            again.putExtra("item", item);
            again.putExtra("num", a);
            again.putExtra("event", eventName);

            int ind = Integer.parseInt(a);
            arr[ind - 1] = item;
            arr2[ind - 1] = link;
            arr3[ind - 1] = price;
            again.putExtra("arr", arr);
            again.putExtra("arr2", arr2);
            again.putExtra("arr3", arr3);
            startActivity(again);
        }
    }
}
