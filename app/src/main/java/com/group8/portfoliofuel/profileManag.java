package com.group8.portfoliofuel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.widget.Spinner;


public class profileManag extends AppCompatActivity {

    private EditText firstNameedt, lastNameedt, addressedt, unitNoedt, cityedt, stateedt, zipCodeedt;
    private Button completeRegbtn;
    private String firstName, lastName, address, unitNo, city, state, zipCode;
    // creating a variable
    // for firebasefirestore.
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilemanag);

        db = FirebaseFirestore.getInstance();
        firstNameedt = findViewById(R.id.edtFirstName);
        lastNameedt = findViewById(R.id.edtLastName);
        addressedt = findViewById(R.id.edtAddress1);
        unitNoedt = findViewById(R.id.edtAddress2);
        cityedt = findViewById(R.id.edtCity);
        stateedt = findViewById(R.id.Spinner);
        zipCodeedt = findViewById(R.id.ZipCode);

        completeRegbtn = findViewById(R.id.edtcomplete);


        completeRegbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });
    }

    private void createUser() { //extract the data from the form
        String firstname = firstNameedt.getText().toString();
        String lastname = lastNameedt.getText().toString();
        String address1 = addressedt.getText().toString();
        String address2 = unitNoedt.getText().toString();
        String mcity = cityedt.getText().toString();
        String mstate = stateedt.getText().toString();
        String mzipcode = zipCodeedt.getText().toString();


        if (firstname.length() < 50) {
            firstNameedt.setError("Invalid Field: character limit needs to be 50");
            return;
        } else if (lastname.length() < 50) {
            firstNameedt.setError("Invalid Field: character limit needs to be 50");
            return;
        } else if (address1.length() < 100) {
            addressedt.setError("Invalid Field: character limit needs to be 100");
            return;
        } else if (address2.length() < 100) {
            unitNoedt.setError("Invalid Field: character limit needs to be 100");
            return;
        } else if (mcity.length() < 100) {
            cityedt.setError("Invalid Field: character limit needs to be 100");
            return;
        } else if (mzipcode.length() < 9) {
            zipCodeedt.setError("Invalid Field: character limit needs to be 9");
            return;
        } else
            // calling method to add data to Firebase Firestore.
            Toast.makeText(profileManag.this, "Data validated", Toast.LENGTH_SHORT).show();
        addDataToFirestore(firstname, lastname, address1, address2, mcity, mstate, mzipcode);
    }

    void addDataToFirestore(String fn, String ls, String add1, String add2, String cty, String st, String zip) {

        // creating a collection reference
        // for our Firebase Firetore database.
        CollectionReference dbprofile = db.collection("profile");

        // adding our data to our courses object class.
        profile profile = new profile(firstName, lastName, address, unitNo, city, state, zipCode);

        // below method is use to add data to Firebase Firestore.
        dbprofile.add(profile).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // after the data addition is successful
                // we are displaying a success toast message.
                Toast.makeText(profileManag.this, "Your profile has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(profileManag.this, "Fail to add profile \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }
}