package com.group8.portfoliofuel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.base.MoreObjects;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class profileManag extends AppCompatActivity {


    private String firstName;
    private String lastName;
    private String address;
    private String unitNumber = null;
    private String city;
    private String state;
    private String zipCode;

    public profileManag() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;   
         }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    
 
    // for first name character limit is 50
    TextView textView = findViewById(R.id.edtFirstName);

    String FirstName = textView.getText().toString();

    {
        if (firstName.length() < 50) {
            textView.setError("\"Invalid Field:  character limit needs to be 50 \" ");
        }
    }
    
    // for last name character limit is 50
    TextView textView2 = findViewById(R.id.edtLastName);

    String LastName = textView2.getText().toString();

    {
        if (lastName.length() < 50) {
            textView2 .setError("\"Invalid Field:  character limit needs to be 50 \" ");
        }
    }
    
    // for address the character limit is 100
     TextView textView3 = findViewById(R.id.edtAddress1);
    
    String address1 = textView3.getText().toString();

    {
        if (address1.length() < 100) {
            textView3.setError("\"Invalid Field:  character limit needs to be 100 \" ");
        }
    }

   //address2 limit and edt button

    TextView textView4 = findViewById(R.id.edtAddress2);

    String address2 = textView4.getText().toString();

    {
        if (address2.length() < 100) {
            textView4.setError("\"Invalid Field:  character limit needs to be 100 \" ");
        }
    }
    
    
     //city limit and edt button

    TextView textView5 = findViewById(R.id.edtCity);

    String City = textView5.getText().toString();

    {
        if (city.length() < 100) {
            textView5.setError("\"Invalid Field:  character limit needs to be 100 \" ");
        }
    }
    
    
      //city zipcode and edt button

    TextView textView6 = findViewById(R.id.edtZipCode);

    String zipcode = textView6.getText().toString();

    {
        if (city.length() < 9) {
            textView6.setError("\"Invalid Field:  character limit needs to be 100 \" ");
        }
    }
    
    // For the State, we will use spinner for the drop down

        Spinner spinner = findViewById(R.id.Spinner);
        db.collection("ClientInformation").document(doc).void collection("State");


    void addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
  @Override
   public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
        int index = 0;
        for (QueryDocumentSnapshot document : task.getResult()) {
        Log.d(TAG, document.getId() + " => " + document.getData());
       list.add((document.get("State").toString());
        listOfDocs.add(document.toObject(profileManag.class));
        }
        }
        else {
        Log.d(TAG, "Error getting documents: ", task.getException());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(State.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        }

    }

    TextView textView7 = findViewById(R.id.edtcomplete);

}
    
}
    
    
