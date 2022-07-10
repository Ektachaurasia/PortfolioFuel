package com.group8.portfoliofuel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_password extends AppCompatActivity {

    private EditText mEmail, moldPass, mnewPass;
    private Button resetBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        mEmail = findViewById(R.id.Email);
        moldPass = findViewById(R.id.oldpass);
        mnewPass = findViewById(R.id.newpass);
        resetBtn = findViewById(R.id.resetpass);

        mAuth = FirebaseAuth.getInstance();

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }
        private void reset() {
            String Email2 = mEmail.getText().toString();
            String oldpass = moldPass.getText().toString();
            String newpass = mnewPass.getText().toString();

            if (!Email2.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(Email2).matches()) {
                if (!oldpass.isEmpty()) {
                    if (!newpass.isEmpty()) {
                        mAuth.createUserWithEmailAndPassword(Email2, newpass)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        Toast.makeText(Forgot_password.this, "Reset Successfully !!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Forgot_password.this, SignIn.class));
                                        finish();
                                    }
                                });
                    } else {
                        mnewPass.setError("Empty Fields are not allowed");
                    }
                } else {
                    moldPass.setError("Empty Fields are not allowed");
                }
            }else if (Email2.isEmpty()){
                mEmail.setError("Empty Fields are not allowed");
            }else{
                mEmail.setError("Empty Fields are not allowed");
            }
        }
}
