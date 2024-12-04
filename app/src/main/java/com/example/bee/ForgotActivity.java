package com.example.bee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotActivity extends AppCompatActivity {

    EditText account_number_field;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        reset = findViewById(R.id.btnReset);
        account_number_field = findViewById(R.id.emailBox);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String accountNum = account_number_field.getText().toString();

                if (TextUtils.isEmpty(accountNum)) {
                    Toast.makeText(ForgotActivity.this, "Fill all the details", Toast.LENGTH_SHORT).show();
                } else {
                    String url = "https://www.sbicard.com/creditcards/app/user/forgotpassword-page";  // Replace with the desired URL

                    // Create an intent with the ACTION_VIEW action
                    Intent intent = new Intent(Intent.ACTION_VIEW);

                    // Set the URL of the webpage to open
                    intent.setData(Uri.parse(url));

                    // Start the browser activity explicitly
                    startActivity(Intent.createChooser(intent, "Open with"));
                }
            }
        });
    }
}
