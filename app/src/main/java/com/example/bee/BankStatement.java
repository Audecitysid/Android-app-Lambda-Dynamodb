package com.example.bee;

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

public class BankStatement extends AppCompatActivity {

    public static String PublicAccountNumber = Integrated_options.PublicAccountNumber;

    EditText ATMPIN_field,amount_field;

    Button seeamount;

    public static String Accountnum = Integrated_options.PublicAccountNumber;

    public String baseUrl = "https://8gk4nxiuc2.execute-api.ap-south-1.amazonaws.com/dev/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_statement);

        //id = atmpin
        //id = seeamount ( button)
        //id = amount

        ATMPIN_field = findViewById(R.id.atmpin);
        amount_field=findViewById(R.id.amount);

        seeamount = findViewById(R.id.seeamount);

        seeamount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ATMNO = ATMPIN_field.getText().toString();

                if(ATMNO.isEmpty()){

                    Toast.makeText(BankStatement.this, "Fill all the details", Toast.LENGTH_SHORT).show();
                }
                else{


                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    BeeAPI beeapi = retrofit.create(BeeAPI.class);
                    Call<PostBankshow1Activity> call = beeapi.closeacc(160, Accountnum , ATMNO);


                    call.enqueue(new Callback<PostBankshow1Activity>() {

                        @Override
                        public void onResponse(Call<PostBankshow1Activity> call, Response<PostBankshow1Activity> response) {
                            if (response.isSuccessful()) {

                                PostBankshow1Activity post = response.body();

                                String fetched_uid = post.getUid();
                                int fetched_atmno = Integer.parseInt(post.getAtmNo());
                                String fetched_accno = post.getAccNo();

                                int convertertemp = Integer.parseInt(ATMNO);

                                if(convertertemp == fetched_atmno && fetched_accno.equals(Accountnum)) {

                                    Toast.makeText(BankStatement.this, fetched_uid + " Balance",
                                            Toast.LENGTH_SHORT).show();

                                    //startActivity(new Intent(BankStatement.this,Homepage.class));
                                    amount_field.setText(fetched_uid);



                                }
                                else {

                                    Toast.makeText(BankStatement.this, "invalid credentials",
                                            Toast.LENGTH_SHORT).show();
                                }



                            } else {
                                // Handle API call failure
                                Toast.makeText(BankStatement.this, "API response failure",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<PostBankshow1Activity> call, Throwable t) {
                            // Handle network failure or API call failure
                            Toast.makeText(BankStatement.this, "Network failure",
                                    Toast.LENGTH_SHORT).show();


                        }
                    });






                }





            }
        });






    }
}