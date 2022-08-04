package com.group8.portfoliofuel;
         
         
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

