package com.example.easygift;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.view.View;
import android.widget.TextView;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth auth;

    private TextView emailText;
    private TextView passText;
    private TextView emailField;
    private TextView passField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailText = findViewById(R.id.editText);
        passText = findViewById(R.id.editText2);
        emailField = findViewById(R.id.textView2);
        passField = findViewById(R.id.textView3);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);

        auth = FirebaseAuth.getInstance();

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser curUser = auth.getCurrentUser();
        changeScreen(curUser);
    }

    private void changeScreen(FirebaseUser user)
    {
        if (user != null)
        {
            findViewById(R.id.button).setVisibility(View.GONE);
            findViewById(R.id.button2).setVisibility(View.GONE);
            findViewById(R.id.textView2).setVisibility(View.GONE);
            findViewById(R.id.textView3).setVisibility(View.GONE);
            findViewById(R.id.editText).setVisibility(View.GONE);
            findViewById(R.id.editText2).setVisibility(View.GONE);
            findViewById(R.id.signedIn).setVisibility(View.VISIBLE);
            findViewById(R.id.signOut).setVisibility(View.VISIBLE);
        }
        else
        {
            findViewById(R.id.button).setVisibility(View.VISIBLE);
            findViewById(R.id.button2).setVisibility(View.VISIBLE);
            findViewById(R.id.textView2).setVisibility(View.VISIBLE);
            findViewById(R.id.textView3).setVisibility(View.VISIBLE);
            findViewById(R.id.editText).setVisibility(View.VISIBLE);
            findViewById(R.id.editText2).setVisibility(View.VISIBLE);
            findViewById(R.id.signedIn).setVisibility(View.GONE);
            findViewById(R.id.signOut).setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.button2) {
            createAccount(emailText.getText().toString(), passText.getText().toString());
        } else if (i == R.id.button) {
            signIn(emailText.getText().toString(), passText.getText().toString());
        }
        else if (i == R.id.signOut)
        {
            auth.signOut();
            changeScreen(null);
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
                            changeScreen(user);
                        }
                        else
                        {
                            changeScreen(null);
                        }
                    }
                });
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
                            changeScreen(user);
                        }
                        else
                        {
                            changeScreen(null);
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
