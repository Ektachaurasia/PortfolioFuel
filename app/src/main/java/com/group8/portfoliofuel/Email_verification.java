package com.group8.portfoliofuel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.regex.Pattern;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.base.MoreObjects;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Email_verification extends AppCompatActivity {

    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
    private boolean mIsValid = false;
    public boolean isValid() {
        return mIsValid;
    }
    public static boolean isValidEmail(CharSequence email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
    final public void afterTextChanged(Editable editableText) {
        mIsValid = isValidEmail(editableText);
    }
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {/*No-op*/}

    final public void onTextChanged(CharSequence s, int start, int before, int count) {/*No-op*/}





    TextView verifymsg;
    Button verify, cont;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);
        auth = FirebaseAuth.getInstance();
        verifymsg = findViewById(R.id.verifymsg);
        verify = findViewById(R.id.verify);
        cont = findViewById(R.id.cont);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!auth.getCurrentUser().isEmailVerified()) {
                    Toast.makeText(Email_verification.this, "", Toast.LENGTH_SHORT).show();
                    cont.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(Email_verification.this, "Verification Successful.Please Continue !!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Email_verification.this, Options.class));
                        }
                    });

                } else {
                    //send verification email
                    auth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(Email_verification.this, "Verification Email", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            ;

        });
    }
}