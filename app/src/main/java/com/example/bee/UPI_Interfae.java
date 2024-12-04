package com.example.bee;

import static com.example.bee.LoginActivity.Uid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UPI_Interfae extends AppCompatActivity {

    EditText source, destination, upiamount, atm;
    Button sendbutton;
    BeeAPI beeAPI;

    public static String Uid = Homepage.Uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upi_interfae);

        source = findViewById(R.id.source);
        destination = findViewById(R.id.destination);
        upiamount = findViewById(R.id.amount_upi);
        atm = findViewById(R.id.upi_pass);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://8gk4nxiuc2.execute-api.ap-south-1.amazonaws.com/dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        beeAPI = retrofit.create(BeeAPI.class);

        sendbutton = findViewById(R.id.send_button);

        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String source_account = source.getText().toString();
                String destination_account = destination.getText().toString();
                int amount = Integer.parseInt(upiamount.getText().toString());
                String atmvalue = atm.getText().toString();

                if(source_account.isEmpty() || destination_account.isEmpty() || atmvalue.isEmpty() ){
                    Toast.makeText(UPI_Interfae.this, "Fill all the details", Toast.LENGTH_SHORT).show();
                }
                else {
                    Call<PostUPI_Interface> call = beeAPI.transferAmount(111, Uid, source_account, destination_account, amount, atmvalue );

                    call.enqueue(new Callback<PostUPI_Interface>() {

                        @Override
                        public void onResponse(Call<PostUPI_Interface> call, Response<PostUPI_Interface> response) {
                            if (response.isSuccessful()) {

                                PostUPI_Interface post = response.body();
                                String request = "Request : " + post.getRequest() + " Transaction : " + post.getTransStatus();


                               Toast.makeText(UPI_Interfae.this, request,
                               Toast.LENGTH_SHORT).show();

                               Intent intent = new Intent(UPI_Interfae.this, Homepage.class);
                               startActivity(intent);

                            } else {
                                // Handle API call failure
                                Toast.makeText(UPI_Interfae.this, "API call failed",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<PostUPI_Interface> call, Throwable t) {
                            // Handle network failure or API call failure
                            Toast.makeText(UPI_Interfae.this, "Network failure",
                                    Toast.LENGTH_SHORT).show();


                        }
                    });

                    }





                //}








            }
        });
    }
}
