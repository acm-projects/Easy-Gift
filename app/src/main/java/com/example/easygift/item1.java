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
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.*;

import java.io.ByteArrayOutputStream;
import com.google.firebase.storage.*;

public class item1 extends AppCompatActivity implements View.OnClickListener{

    private FirebaseFirestore database;
    private FirebaseStorage storage;
    private String name;
    private String a;
    private String first;
    private String[] arr;
    private String[] arr2;

    private String item;
    private String link;
    private String eventName;

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
    }

    private void storeData()
    {
        TextView text = findViewById(R.id.itemField);
        final String str = text.getText().toString();
        item = str;

        TextView text2 = findViewById(R.id.linkText);
        final String link2 = text2.getText().toString();
        link = link2;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bitmap bitmap = getPath(data.getData());
            img.setImageBitmap(bitmap);

            StorageReference storageRef = storage.getReference();
            StorageReference imgRef = storageRef.child("images/"+ data.getData().getLastPathSegment());

            Bitmap map = ((BitmapDrawable) img.getDrawable()).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] dat = baos.toByteArray();

            UploadTask uploadTask = imgRef.putBytes(dat);
        }
    }

    private Bitmap getPath(Uri uri) {

        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String filePath = cursor.getString(column_index);
        // cursor.close();
        // Convert file path into bitmap image using below line.
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);

        return bitmap;
    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        if (id == R.id.imageField)
        {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
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
            again.putExtra("arr", arr);
            again.putExtra("arr2", arr2);
            startActivity(again);
        }
    }
}
