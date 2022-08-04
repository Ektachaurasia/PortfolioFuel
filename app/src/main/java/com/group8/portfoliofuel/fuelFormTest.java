package com.group8.portfoliofuel;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

public class fuelFormTest {
    /* - Gallons Requested (numeric, required)
	- Delivery Address (Non-editable, comes from client profile)
	- Delivery Date (Calender, date picker)
	- Suggested Price / gallon (numeric non-editable, price will be calculated by Pricing Module - we are not building pricing module yet)
	- Total Amount Due (numeric non-editable, calculated (gallons * price))
     */
        private Fuel FuelForm = new Fuel();
    @Test(expected = IllegalArgumentException.class)
    public void sum_shouldThrowForNullParam() throws Exception {
        FuelForm.getGallonsRequested();
        FuelForm.getDeliveryAddress();
        FuelForm.getDeliveryDate();
        FuelForm.getSuggestedPrice();
        FuelForm.getTotalAmount();
    }
    @Test(expected = IllegalArgumentException.class)
    public void sum_shouldThrowForEmptyParam() throws Exception {
        FuelForm.getGallonsRequested();
        FuelForm.getDeliveryAddress();
        FuelForm.getDeliveryDate();
        FuelForm.getSuggestedPrice();
        FuelForm.getTotalAmount();
    }
}
