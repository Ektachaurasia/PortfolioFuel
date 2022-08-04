package com.group8.portfoliofuel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SignIn extends AppCompatActivity {

    private EditText mEmail1, mPass;
    private TextView mTextView,mTextView1;
    private Button signinBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mEmail1 = findViewById(R.id.edtEmail1);
        mPass = findViewById(R.id.edtPass);
        mTextView = findViewById(R.id.textView4);
        mTextView1 = findViewById(R.id.edtforgot);
        signinBtn = findViewById(R.id.btnsignin1);

        mAuth = FirebaseAuth.getInstance();

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, Register.class));
            }
        });
        mTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, Forgot_password.class));
            }
        });
        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    private void login() {
        String Email1 = mEmail1.getText().toString();
        String pass1 = mPass.getText().toString();

        if (Email1.isEmpty()) {
            mEmail1.setError("Email is required");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email1).matches()) {
            mEmail1.setError("Invalid email. Please enter a valid Email");
        }
        if (pass1.isEmpty()) {
            mPass.setError("Password is required");
            return;
        }
//Data is validated
//SignIn the user using firebase
        mAuth.signInWithEmailAndPassword(Email1,pass1).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(SignIn.this, "Log In Successfully !!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Email_verification.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignIn.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}