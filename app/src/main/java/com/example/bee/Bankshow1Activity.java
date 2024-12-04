package com.example.bee;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class Bankshow1Activity extends AppCompatActivity {

    Button enterbank;

    EditText Accountnumber , ATM;

    public String baseUrl = "https://8gk4nxiuc2.execute-api.ap-south-1.amazonaws.com/dev/";
    public String Uid = Homepage.Uid;

    public static String PublicAccountNumber = "";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankshow1);

        enterbank=findViewById(R.id.enterbank);

        Accountnumber= findViewById(R.id.account_number);
        ATM= findViewById(R.id.ATMPIN);

        boolean flag = true;


        enterbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Accountnum = Accountnumber.getText().toString();
                String ATMNO = ATM.getText().toString();

                PublicAccountNumber = Accountnum;

                if(Accountnum.isEmpty() || ATMNO.isEmpty()){

                    Toast.makeText(Bankshow1Activity.this, "Fill all the details", Toast.LENGTH_SHORT).show();
                }
                else{


                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    BeeAPI beeapi = retrofit.create(BeeAPI.class);
                    Call<PostBankshow1Activity> call = beeapi.verify(102, Accountnum);


                    call.enqueue(new Callback<PostBankshow1Activity>() {

                        @Override
                        public void onResponse(Call<PostBankshow1Activity> call, Response<PostBankshow1Activity> response) {
                            if (response.isSuccessful()) {

                                PostBankshow1Activity post = response.body();

                                String fetched_uid = post.getUid();
                                String fetched_atmno = post.getAtmNo();
                                String fetched_accno = post.getAccNo();


                                if(fetched_atmno.equals(ATMNO) && fetched_accno.equals(Accountnum)) {


                                    Toast.makeText(Bankshow1Activity.this, "success",
                                            Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Bankshow1Activity.this,Integrated_options.class));



                                }
                                else {

                                    Toast.makeText(Bankshow1Activity.this, "invalid credentials",
                                            Toast.LENGTH_SHORT).show();
                                }



                            } else {
                                // Handle API call failure
                                Toast.makeText(Bankshow1Activity.this, "API response failure",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<PostBankshow1Activity> call, Throwable t) {
                            // Handle network failure or API call failure
                            Toast.makeText(Bankshow1Activity.this, "Network failure",
                                    Toast.LENGTH_SHORT).show();


                        }
                    });






                }





            }
        });

    }
}