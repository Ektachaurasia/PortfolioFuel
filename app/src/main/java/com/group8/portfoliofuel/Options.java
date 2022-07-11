package com.group8.portfoliofuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Options extends AppCompatActivity {
    private Button quotehistory;
    private Button profileManag;
    private Button fuelForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        profileManag = findViewById(R.id.btnRegister2);

        fuelForm = findViewById(R.id.btnRegister3);

        quotehistory = findViewById(R.id.btnRegister4);

        Button logout = findViewById(R.id.btnlogout);

        // will take client to profile management
        profileManag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Options.this, profileManag.class));
            }
        });

        // will take client to fuel form
        fuelForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Options.this, fuelForm.class));
            }
        });


        // will take client to quote history
        quotehistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Options.this, quotehistory.class));
            }
        });


        //Log out will take user to main screen
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logOut = new Intent(Options.this, MainActivity.class);

                startActivity(logOut);
            }
        });
    }

}
