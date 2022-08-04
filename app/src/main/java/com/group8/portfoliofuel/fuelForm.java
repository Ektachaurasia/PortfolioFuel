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
                
 /*
                // validating the text fields if empty or not.
                if (TextUtils.isEmpty(courseName)) {
                    courseNameEdt.setError("Please enter Course Name");
                } else if (TextUtils.isEmpty(courseDescription)) {
                    courseDescriptionEdt.setError("Please enter Course Description");
                } else if (TextUtils.isEmpty(courseDuration)) {
courseDurationEdt.setError("Please enter Course Duration");
                } else {
                    // calling method to add data to Firebase Firestore.
                    addDataToFirestore(courseName, courseDescription, courseDuration);
                }
            }
        });
    }  */

                private void addDataToFirestore(String GallonsRequested, String DeliveryAddress, String; DeliveryDate, String SuggestedPrice, String TotalAmount ){

                    // creating a collection reference
                    // for our Firebase Firetore database.
                    CollectionReference dbCourses = db.collection("fuelForm");

                    // adding our data to our form object class.
                    Fuel Fuel = new Fuel(GallonsRequested, DeliveryAddress, DeliveryDate, SuggestedPrice, TotalAmount);

                    // below method is use to add data to Firebase Firestore.
                    dbCourses.add(fuelForm.this).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override1
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
                }
            }
        });
    }
}
