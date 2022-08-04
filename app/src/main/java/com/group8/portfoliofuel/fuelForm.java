package com.group8.portfoliofuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class fuelForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText GallonsRequestedEditText = (EditText) findViewById(R.id.gallonsRequested);
        String GallonsRequested = GallonsRequestedEditText.getText().toString();

        EditText DeliveryAddressEditText = (EditText) findViewById(R.id.deliveryAddress);
        String DeliveryAddress = DeliveryAddressEditText.getText().toString();
        EditText DeliveryDateEditText = (EditText) findViewById(R.id.deliveryDate);
        String DeliveryDate = DeliveryDateEditText.getText().toString();


        EditText SuggestedPriceEditText = (EditText) findViewById(R.id.suggestedPrice);
        String SuggestedPrice = SuggestedPriceEditText.getText().toString();

        EditText TotalAmountEditText = (EditText) findViewById(R.id.totalAmount);
        String TotalAmount = TotalAmountEditText.getText().toString();

        Button SubmitForm = findViewById(R.id.SubmitForm);
    }
} 
    
    ///this is for the same file that connectes with fuel form " fuel"

public class Fuel {
 
    // variables for storing our data.
    private String GallonsRequested, DeliveryAddress, DeliveryDate, SuggestedPrice, TotalAmount;
 
    public Fuel() {
        // empty constructor
        // required for Firebase.
    }
 
    // Constructor for all variables.
    public Courses(String GallonsRequested, String DeliveryAddress, String DeliveryDate, String SuggestedPrice, String TotalAmount) {
        this.GallonsRequested = GallonsRequested;
        this.DeliveryAddress = DeliveryAddress;
        this.DeliveryDate = DeliveryDate;
        this.SuggestedPrice = SuggestedPrice;
        this.TotalAmount = TotalAmount;

    }
 
    // getter methods for all variables.
    public String getGallonsRequested() {
        return GallonsRequested;
    }
 
    public void setGallonsRequested(String gallonsrequested) {
        this.GallonsRequested = GallonsRequested;
    }
 
    public String getDeliveryAddress() {
        return DeliveryAddress;
    }
    // setter method for all variables.
    public void setDeliveryAddress(String deliveryAddress) {
        this.DeliveryAddress = DeliveryAddress;
    }
 
    public String getDeliveryDate() {
        return DeliveryDate;
    }
 
    public void setDeliveryDate(String deliveryDate) {
        this.DeliveryDate = DeliveryDate;
    }
}





/// for the main java file for fuel form

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
    private EditText GallonsRequestedEdt, DeliveryAddressEdt, DeliveryDateEdt, SuggestedPriceEdt, TotalAmountEdt ;
 
    // creating variable for button
    private Button SubmitForm;
 
    // creating a strings for storing
    // our values from edittext fields.
    private String GallonsRequested, DeliveryAddress, DeliveryDate, SuggestedPrice, TotalAmount ;
 
    // creating a variable
    // for firebasefirestore.
    private FirebaseFirestore db;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuelForm);
 
        // getting our instance
        // from Firebase Firestore.
        db = FirebaseFirestore.getInstance();
 
        // initializing our edittext and buttons
        GallonsRequestedEdt = findViewById(R.id.GallonsRequested);
        DeliveryAddressEdt = findViewById(R.id.DeliveryAddress);
        DeliveryDateEdt = findViewById(R.id.DeliveryDate);
        SuggestedPriceEdt = findViewById(R.id.SuggestedPrice);
        TotalAmountEdt = findViewById(R.id.TotalAmount);
        SubmitFormBtn = findViewById(R.id.Submitform);
 
        // adding on click listener for button
        submitCourseBtn.setOnClickListener(new View.OnClickListener() {
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
 
    private void addDataToFirestore(String GallonsRequested, String DeliveryAddress, String DeliveryDate, String SuggestedPrice, String TotalAmount ) {
 
        // creating a collection reference
        // for our Firebase Firetore database.
        CollectionReference dbCourses = db.collection("fuelForm");
 
        // adding our data to our form object class.
        FuelForm fuelForm = new FuelForm(GallonsRequested, DeliveryAddress, DeliveryDate, SuggestedPrice, TotalAmount);
 
        // below method is use to add data to Firebase Firestore.
        dbCourses.add(fuelForm).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
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
    }
}


























    
    /* private String gallonsRequested;
    private String deliveryAddress;
    private String deliveryDate;
    private String suggestedPrice;
    private String totalAmount;

    public fuelForm() {

    }

    public String getGallonsRequested() {
        return gallonsRequested;
    }

    public void setGallonsRequested(String gallonsRequested) {
        this.gallonsRequested = gallonsRequested;
         }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getSuggestedPrice() {
        return suggestedPrice;
    }

    public void setSuggestedPrice(String suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
} */
