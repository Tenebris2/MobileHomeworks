package com.example.donation;

import static com.example.donation.R.id.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.example.donation.R; // ✅ correct
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {

    private Button donateButton;
    private RadioGroup paymentMethod;
    private ProgressBar progressBar;
    private NumberPicker amountPicker;
    private int totalDonated = 0;
    private TextView amountTotal;
    private EditText amountText;
    private boolean targetAchieved = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        paymentMethod = (RadioGroup) findViewById(R.id.paymentMethod);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        amountPicker = (NumberPicker) findViewById(R.id.amountPicker);
        donateButton = (Button) findViewById(R.id.donateButton);
        amountTotal   = (TextView)     findViewById(R.id.totalSoFar);


        if (donateButton != null) {
            Log.v("Donate", "Really got the donate button");
        }

        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(1000);
        amountTotal.setText("$0");
        progressBar.setMax(10000);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_donate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuReport) {
                Toast toast = Toast.makeText(this, "Report Selected",
                        Toast.LENGTH_SHORT);
                toast.show();
        }
        return super.onOptionsItemSelected(item);
    }
    public void donateButtonPressed(View view) {
//        int amount = amountPicker.getValue();
//        int radioId = paymentMethod.getCheckedRadioButtonId();
//        String method = "";
//
//        if (radioId == R.id.Paypal) {
//            method = "Paypal";
//        } else {
//            method = "Direct";
//        }
//
//
//        totalDonated = totalDonated + amount;
//        progressBar.setProgress(totalDonated);
//
//        Log.v("Donate", "Donate pressed! with amount " + amount + ", method: " + method);
//        Log.v("Donate", "Current total: " + totalDonated);

        String method = paymentMethod.getCheckedRadioButtonId() == R.id.PayPal ? "PayPal" : "Direct";

        int donatedAmount =  amountPicker.getValue();
        if (donatedAmount == 0)
        {
            String text = amountText.getText().toString();
            if (!text.equals(""))
                donatedAmount = Integer.parseInt(text);
        }

        if (!targetAchieved)
        {
            totalDonated  = totalDonated + donatedAmount;
            targetAchieved = totalDonated >= 10000;
            progressBar.setProgress(totalDonated);
            String totalDonatedStr = "$" + totalDonated;
            amountTotal.setText(totalDonatedStr);
        }
        else
        {
            Toast toast = Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT);
            toast.show();
        }

        Log.v("Donate", amountPicker.getValue() + " donated by " +  method + "\nCurrent total " + totalDonated);
    }
}

