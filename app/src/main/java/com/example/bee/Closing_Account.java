package com.example.bee;

import static com.example.bee.Homepage.Uid;

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

public class Closing_Account extends AppCompatActivity {



    EditText account_number_field, ATMPIN_field;



    Button enterbank;

    public String baseUrl = "https://8gk4nxiuc2.execute-api.ap-south-1.amazonaws.com/dev/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closing_account);

        enterbank=findViewById(R.id.enterbank);

        account_number_field = findViewById(R.id.account_number);
        ATMPIN_field = findViewById(R.id.ATMPIN);

        String Accountnum = account_number_field.getText().toString();
        String ATMNO = ATMPIN_field.getText().toString();



        enterbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Accountnum = account_number_field.getText().toString();
                String ATMNO = ATMPIN_field.getText().toString();

                if(Accountnum.isEmpty() || ATMNO.isEmpty()){

                    Toast.makeText(Closing_Account.this, "Fill all the details", Toast.LENGTH_SHORT).show();
                }
                else{


                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    BeeAPI beeapi = retrofit.create(BeeAPI.class);
                    Call<PostBankshow1Activity> call = beeapi.closeacc(118, Accountnum , ATMNO);


                    call.enqueue(new Callback<PostBankshow1Activity>() {

                        @Override
                        public void onResponse(Call<PostBankshow1Activity> call, Response<PostBankshow1Activity> response) {
                            if (response.isSuccessful()) {

                                PostBankshow1Activity post = response.body();

                                String fetched_uid = post.getUid();
                                int fetched_atmno = Integer.parseInt(post.getAtmNo());
                                String fetched_accno = post.getAccNo();

                                int convertertemp = Integer.parseInt(ATMNO);

                                if(convertertemp == fetched_atmno) {

                                    Toast.makeText(Closing_Account.this, fetched_uid + " Deleted Successfully",
                                            Toast.LENGTH_SHORT).show();

                                            startActivity(new Intent(Closing_Account.this,Homepage.class));



                                }
                                else {

                                    Toast.makeText(Closing_Account.this, "invalid credentials",
                                            Toast.LENGTH_SHORT).show();
                                }



                            } else {
                                // Handle API call failure
                                Toast.makeText(Closing_Account.this, "API response failure",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<PostBankshow1Activity> call, Throwable t) {
                            // Handle network failure or API call failure
                            Toast.makeText(Closing_Account.this, "Network failure",
                                    Toast.LENGTH_SHORT).show();


                        }
                    });






                }





            }
        });


    }
}