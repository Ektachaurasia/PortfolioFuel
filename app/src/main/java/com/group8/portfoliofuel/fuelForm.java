package com.group8.portfoliofuel;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
 
public class fuelForm extends AppCompatActivity {

    // creating variables for our edit text
    private EditText GallonsRequestedEdt, DeliveryAddressEdt, DeliveryDateEdt, SuggestedPriceEdt, TotalAmountEdt;

    // creating variable for button
    //private Button SubmitForm;

    // creating a strings for storing
    // our values from edittext fields.
    private String GallonsRequested, DeliveryAddress, DeliveryDate, SuggestedPrice, TotalAmount;
    private Button SubmitForm;

    // creating a variable
    // for firebasefirestore.
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuelform);

        // getting our instance
        // from Firebase Firestore.
        db = FirebaseFirestore.getInstance();

        // initializing our edittext and buttons
        GallonsRequestedEdt = findViewById(R.id.gallonsRequested);
        DeliveryAddressEdt = findViewById(R.id.deliveryAddress);
        DeliveryDateEdt = findViewById(R.id.deliveryDate);
        SuggestedPriceEdt = findViewById(R.id.suggestedPrice);
        TotalAmountEdt = findViewById(R.id.totalAmount);
        SubmitForm = findViewById(R.id.SubmitForm);

        // adding on click listener for button
        SubmitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // getting data from edittext fields.
                GallonsRequested = GallonsRequestedEdt.getText().toString();
                DeliveryAddress = DeliveryAddressEdt.getText().toString();
                DeliveryDate = DeliveryDateEdt.getText().toString();
                SuggestedPrice = SuggestedPriceEdt.getText().toString();
                TotalAmount = TotalAmountEdt.getText().toString();

                    // creating a collection reference
                    // for our Firebase Firetore database.
                    CollectionReference dbCourses = db.collection("fuelForm");

                    // adding our data to our form object class.
                    Fuel Fuel = new Fuel(GallonsRequested, DeliveryAddress, DeliveryDate, SuggestedPrice, TotalAmount);

                    // below method is use to add data to Firebase Firestore.
                    dbCourses.add(fuelForm.this).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            // after the data addition is successful
                            // we are displaying a success toast message.
                            Toast.makeText(fuelForm.this, "Your form has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) { // this method is called when the data addition process is failed.
                            // displaying a toast message when data addition is failed.
                            Toast.makeText(fuelForm.this, "Fail to add course \n" + e, Toast.LENGTH_SHORT).show();
                        }
                    });
                //pricing module
                findPrice();
                }
            });
        }
    private void findPrice() {
        //suggested price = current + margin
        //first initialize current price
        double current = 1.5; //in dollars

        //margin = current * (location - rate history + gal requested factor + profit)
        //location : 0.02 for texas, 0.04 for anywhere else
        double location = 0.04;
        String strTexas = "Texas";
        String strTX = "TX";
        if (strTexas.toUpperCase().contains(DeliveryAddress.toUpperCase()) || strTX.toUpperCase().contains(DeliveryAddress.toUpperCase()))
        {
            location = 0.02;
        }

        //rate history : 0.01 if returning client, 0.00 if first order
        Double rate_history = 0.0;
        if (Double.parseDouble(TotalAmount) > 0)
        {
            rate_history = 0.01;
        }

        //gal requested factor : 0.02 if gal requested >= 1000, 0.03 if gal requested < 1000
        Double galreqFactor = 0.03;
        Double galreq  = Double.parseDouble(GallonsRequested);
        Double GallonsRequested = galreq;
        if (GallonsRequested >= 1000)
        {
            galreqFactor = 0.02;
        }

        //profit = 0.1
        Double profit = 0.1;

        //now calculate suggested price
        double margin = current * (location - rate_history + galreqFactor + profit);
        Double SuggestedPrice = current + margin;
        Double TotalAmount = SuggestedPrice * GallonsRequested;

        //display price quote to client's side
        Log.i("price", "Suggested Price/gallon: " + SuggestedPrice);
        Log.i("total", "Total Amount: " + TotalAmount);


        //strings.xml
        String row1GR = getString(R.string.row1GR, GallonsRequested + "");
        Toast.makeText(getApplicationContext(), row1GR, Toast.LENGTH_LONG).show();
        String row1AD = getString(R.string.row1GR, DeliveryAddress);
        Toast.makeText(getApplicationContext(), row1GR, Toast.LENGTH_LONG).show();
        String row1DD = getString(R.string.row1GR, DeliveryDate);
        Toast.makeText(getApplicationContext(), row1GR, Toast.LENGTH_LONG).show();
        String row1SP = getString(R.string.row1GR, "$" + SuggestedPrice);
        Toast.makeText(getApplicationContext(), row1GR, Toast.LENGTH_LONG).show();
        String row1TA = getString(R.string.row1GR, "$" + TotalAmount);
        Toast.makeText(getApplicationContext(), row1GR, Toast.LENGTH_LONG).show();
    }

}
