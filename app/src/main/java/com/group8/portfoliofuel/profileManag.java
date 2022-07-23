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
import android.widget.Spinner;


public class profileManag extends AppCompatActivity {

    private EditText firstName, lastName, address, unitNo, city, state, zipCode;
    private Button completeRegbtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilemanag);

        firstName = findViewById(R.id.edtFirstName);
        lastName = findViewById(R.id.edtLastName);
        address = findViewById(R.id.edtAddress1);
        unitNo = findViewById(R.id.edtAddress2);
        city = findViewById(R.id.edtCity);
        state = findViewById(R.id.Spinner);
        zipCode= findViewById(R.id.ZipCode);

        completeRegbtn = findViewById(R.id.edtcomplete);

        mAuth = FirebaseAuth.getInstance();

        completeRegbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });
    }

    private void createUser() { //extract the data from the form
        String firstname = firstName.getText().toString();
        String lastname = lastName.getText().toString();
        String address1 = address.getText().toString();
        String address2 = unitNo.getText().toString();
        String mcity = city.getText().toString();
        String mstate = state.getText().toString();
        String mzipcode = zipCode.getText().toString();


        if (firstname.length() < 50) {
            firstName.setError("Invalid Field: character limit needs to be 50");
            return;
        }
        if (lastname.length() < 50 ) {
            firstName.setError("Invalid Field: character limit needs to be 50");
            return;
        }
        if (address1.length() < 100) {
            address.setError("Invalid Field: character limit needs to be 100");
            return;
        }
        if (address2.length() < 100) {
            unitNo.setError("Invalid Field: character limit needs to be 100");
            return;
        }
        if (mcity.length() < 100) {
            city.setError("Invalid Field: character limit needs to be 100");
            return;
        }
        if (mzipcode.length() < 9) {
            zipCode.setError("Invalid Field: character limit needs to be 9");
            return;
        }



//Data is validated
//Register the user using firebase
        Toast.makeText(Register.this,"Data validated", Toast.LENGTH_SHORT).show();
        mAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(profileManag.this, "Registered Successfully !!", Toast.LENGTH_SHORT).show();
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
}