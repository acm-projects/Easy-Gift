package com.example.easygift;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.view.View;
import android.widget.TextView;
import android.text.TextUtils;

public class createAccount extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth auth;

    private TextView emailText;
    private TextView passText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        emailText = findViewById(R.id.editText5);
        passText = findViewById(R.id.editText6);

        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.button3) {
            createAccount(emailText.getText().toString(), passText.getText().toString());
        }
    }

    private void createAccount(String email, String password) {
        if (!validateForm()) {
            return;
        }

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            FirebaseUser user = auth.getCurrentUser();
                            Intent test = new Intent(createAccount.this, homeTest.class);
                            startActivity(test);
                        }
                        else
                        {
                            Intent test2 = new Intent(createAccount.this, wrongPassword.class);
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
