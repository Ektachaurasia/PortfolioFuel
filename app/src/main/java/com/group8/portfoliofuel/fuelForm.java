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
    public String getSuggestedPrice() {
        return SuggestedPrice;
    }
 
    public void setSuggestedPrice(String suggestedPrice) {
        this.SuggestedPrice = SuggestedPrice;
    }
    public String getTotalAmount() {
        return TotalAmount;
    }
 
    public void setTotalAmount(String totalAmount) {
        this.TotalAmount = TotalAmount;
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
