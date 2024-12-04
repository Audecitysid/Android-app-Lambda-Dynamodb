package com.example.bee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Integrated_options extends AppCompatActivity {

    Button statement,passbook,card,closing,payment,remove;

    public static String PublicAccountNumber = Bankshow1Activity.PublicAccountNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrated_options);

        statement = findViewById(R.id.bankstate);
        passbook = findViewById(R.id.bankpass);
        closing = findViewById(R.id.Closing);
        payment = findViewById(R.id.online_pay);

        statement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Integrated_options.this,BankStatement.class));
            }
        });

        passbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String url = "https://upload.wikimedia.org/wikipedia/commons/2/20/SampleBankbook.png";  // Replace with the desired URL

                // Create an intent with the ACTION_VIEW action
                Intent intent = new Intent(Intent.ACTION_VIEW);

                // Set the URL of the webpage to open
                intent.setData(Uri.parse(url));

                // Start the browser activity explicitly
                startActivity(Intent.createChooser(intent, "Open with"));
            }
        });

        closing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Integrated_options.this,Closing_Account.class));
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Integrated_options.this,UPI_Interfae.class));
            }
        });

    }
}