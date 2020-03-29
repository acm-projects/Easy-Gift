package com.example.easygift;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import android.text.TextUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth auth;

    private TextView emailText;
    private TextView passText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailText = findViewById(R.id.editText);
        passText = findViewById(R.id.editText2);

        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser curUser = auth.getCurrentUser();
        // SHOW HOME SCREEN
        // SHOW HOME SCREEN
        // SHOW HOME SCREEN
        // SHOW HOME SCREEN
        // SHOW HOME SCREEN
        // SHOW HOME SCREEN
        // SHOW HOME SCREEN
        // SHOW HOME SCREEN
        // SHOW HOME SCREEN
        // SHOW HOME SCREEN
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.button2) {
            Intent createAccount = new Intent(this, createAccount.class);
            //createAccount.putExtra("auth", (Parcelable) auth);
            startActivity(createAccount);
        } else if (i == R.id.button) {
            signIn(emailText.getText().toString(), passText.getText().toString());
        }
    }

    private void signIn(String email, String password)
    {
        if (!validateForm())
            return;

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            FirebaseUser user = auth.getCurrentUser();
                            Intent test = new Intent(LoginActivity.this, homeTest.class);
                            startActivity(test);
                        }
                        else
                        {
                            Intent test2 = new Intent(LoginActivity.this, wrongPassword.class);
                            startActivity(test2);
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
