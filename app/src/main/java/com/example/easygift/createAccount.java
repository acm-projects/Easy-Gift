package com.example.easygift;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.firestore.*;

import android.view.View;
import android.widget.TextView;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

public class createAccount extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth auth;
    private FirebaseFirestore database;

    private TextView nameText;
    private String name;
    private String em;
    private TextView emailText;
    private TextView passText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        nameText = findViewById(R.id.editText3);
        emailText = findViewById(R.id.editText5);
        passText = findViewById(R.id.editText6);

        auth = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.button3) {
            createAccount(emailText.getText().toString(), passText.getText().toString(), nameText.getText().toString());
        }
    }

    private void createAccount(String email, String password, String nam) {
        if (!validateForm()) {
            return;
        }
        name = nam;
        em = email;
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            User user = new User(name, em);
                            database.collection("Users").document(name).set(user, SetOptions.merge());
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent create1 = new Intent(createAccount.this, createFirst.class);
                                    create1.putExtra("name", name);
                                    startActivity(create1);
                                    finish();
                                }
                            }, 4000);

                        }
                        else
                        {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent create1 = new Intent(createAccount.this, createFirst.class);
                                    create1.putExtra("name", name);
                                    startActivity(create1);
                                    finish();
                                }
                            }, 5000);
                        }
                    }
                });
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = emailText.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailText.setError("Required.");
            valid = false;
        } else {
            emailText.setError(null);
        }

        String password = passText.getText().toString();
        if (TextUtils.isEmpty(password)) {
            passText.setError("Required.");
            valid = false;
        } else {
            passText.setError(null);
        }

        return valid;
    }
}
