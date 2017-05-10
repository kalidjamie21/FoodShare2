package com.example.android.foodshare;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by User on 2017-05-07.
 */

public class Donation extends AppCompatActivity {

    EditText company_name;
    EditText phone_number;
    EditText location;
    EditText foodType;
    EditText quantity;

    String companyNameString;
    String phoneNumberString;
    String locationString;
    String foodTypeString;
    String quantityString;

    String emailTo = "kalid.mawi@briswieth.com";
    String emailSubject = "New Food Pickup Request From " + companyNameString; // maybe add from which company


    String emailContent = "You have received a Food Pickup Request. Please find further details below:\n\n" +
            "Name of Organization (or Individual): " + companyNameString + "\n" +
            "Telephone Number: " + phoneNumberString + "\n" +
            "Location: " + locationString + "\n" +
            "Available Food Type: " + foodTypeString + "\n" +
            "Quantity Available: " + quantityString;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donation);

        company_name = (EditText) findViewById(R.id.etCompName);
        phone_number = (EditText) findViewById(R.id.etPhone);
        location = (EditText) findViewById(R.id.etLocation);
        foodType = (EditText) findViewById(R.id.etFoodType);
        quantity = (EditText) findViewById(R.id.etQuantity);

    }

    public void onButtonClickSend(View v) {
        companyNameString = company_name.getText().toString();
        phoneNumberString = phone_number.getText().toString();
        locationString = location.getText().toString();
        foodTypeString = foodType.getText().toString();
        quantityString = quantity.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailTo});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailContent);

        ////use below 3 commented lines if need to send attachment
        //emailIntent.setType("image/jpeg");
       // emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My Picture");
        //emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://sdcard/captureimage.png"));

        //need this to prompts email client only
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Select an Email Client:"));

    }

    //@Override
    //protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // super.onActivityResult(requestCode, resultCode, data);
       // Intent i = new Intent(Donation.this, ThankYou.class);
      //  startActivity(i);
  //  }

    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_main, menu);
        //return true;
    //}



    }



