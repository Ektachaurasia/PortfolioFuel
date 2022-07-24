package com.group8.portfoliofuel;

public class profile {

        // variables for storing our data.
            private String firstname, lastname, address1, address2, city, state, zip;

        public profile() {
            // empty constructor
            // required for Firebase.
        }

        // Constructor for all variables.
        public profile(String firstname, String lastname, String address1, String address2, String city, String state, String zip) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.address1 = address1;
            this.address2 = address2;
            this.city = city;
            this.state = state;
            this.zip = zip;
        }

        // getter methods for all variables.
        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }
        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }
        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }
        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }
        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
        public String getState() {
            return getState();
        }

        public void setState(String state) {
            this.state = state;
        }
        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

    }

