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
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Register extends AppCompatActivity {

    private EditText mName, mEmail, mPass, mconfpass;
    private TextView mTextView;
    private Button registerBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mName = findViewById(R.id.edtName);
        mEmail = findViewById(R.id.edtEmail);
        mPass = findViewById(R.id.edtPass);
        mTextView = findViewById(R.id.textView3);
        mconfpass = findViewById(R.id.edtPass2);
        registerBtn = findViewById(R.id.btnRegister1);

        mAuth = FirebaseAuth.getInstance();

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, SignIn.class));
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });
    }

    private void createUser() { //extract the data from the form
        String name = mName.getText().toString();
        String email = mEmail.getText().toString();
        String password = mPass.getText().toString();
        String confpass = mconfpass.getText().toString();


        if (name.isEmpty()) {
            mName.setError("Full Name is required");
            return;
        }
        if (email.isEmpty()) {
            mEmail.setError("Email is required");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("Invalid email. Please enter a valid Email");
        }
        if (password.isEmpty()) {
            mPass.setError("Password is required");
            return;
        }if (password.length()<8 && !isValidPassword(password)){
            mPass.setError("Password length must be least eight characters ");
            return;
        }
        if (confpass.isEmpty()) {
            mconfpass.setError("Confirm password is required");
            return;
        }
        if (!password.equals(confpass)) {
            mconfpass.setError("Password do not match");
            return;
        }
//Data is validated
//Register the user using firebase
        Toast.makeText(Register.this,"Data validated", Toast.LENGTH_SHORT).show();
        mAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(Register.this, "Registered Successfully !!", Toast.LENGTH_SHORT).show();
                FirebaseUser firebaseUser = mAuth.getCurrentUser();

                //Send Verification Email
                firebaseUser.sendEmailVerification();

                //Open user Profile after successful
                Intent intent = new Intent(Register.this, Email_verification.class);
                //To prevent user from returning back to register activity on pressing bcak button after registration
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Register.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    //Password validation
    public static boolean isValidPassword(String s) {
        Pattern PASSWORD_PATTERN
                = Pattern.compile(
                "[a-zA-Z0-9\\!\\@\\#\\$]{8,24}");

        return !TextUtils.isEmpty(s) && PASSWORD_PATTERN.matcher(s).matches();
    }
}