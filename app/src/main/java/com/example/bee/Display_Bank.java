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

public class Display_Bank extends AppCompatActivity {



    EditText accountno,ATMPIN_field,amount,bankname,bank,branch,ifsc,phone;

    Button seedetails;

    public static String Accountnum = Integrated_options.PublicAccountNumber;

    public String baseUrl = "https://8gk4nxiuc2.execute-api.ap-south-1.amazonaws.com/dev/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_bank);

        //id = atmpin
        //id = seeamount ( button)
        //id = amount
        accountno = findViewById(R.id.account_number);
        ATMPIN_field = findViewById(R.id.ATMPIN);

        bank = findViewById(R.id.Bank_name);
        branch = findViewById(R.id.Branch_name);
        ifsc = findViewById(R.id.IFSC);
        phone = findViewById(R.id.phone);

        //amount=findViewById(R.id.amount);
        seedetails = findViewById(R.id.seedetailbutton);
        bankname = findViewById(R.id.Bank_name);

        seedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ATMNO = ATMPIN_field.getText().toString();
                String Account_no = accountno.getText().toString();

                if(ATMNO.isEmpty() || Account_no.isEmpty()){

                    Toast.makeText(Display_Bank.this, "Fill all the details", Toast.LENGTH_SHORT).show();
                }
                else{


                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    BeeAPI beeapi = retrofit.create(BeeAPI.class);
                    Call<PostBankshow1Activity> call = beeapi.closeacc(165, Account_no , ATMNO);


                    call.enqueue(new Callback<PostBankshow1Activity>() {

                        @Override
                        public void onResponse(Call<PostBankshow1Activity> call, Response<PostBankshow1Activity> response) {
                            if (response.isSuccessful()) {

                                PostBankshow1Activity post = response.body();

                                String fetched_uid = post.getUid();
                                String fetched_bank = post.getBank();
                                String fetched_branch = post.getBranch();
                                String fetched_ifsc = post.getIfsc();
                                String fetched_phone = post.getPhone();

                                int fetched_atmno = Integer.parseInt(post.getAtmNo());
                                String fetched_accno = post.getAccNo();

                                int convertertemp = Integer.parseInt(ATMNO);

                                if(convertertemp == fetched_atmno && fetched_accno.equals(Account_no)) {

                                    //startActivity(new Intent(BankStatement.this,Homepage.class));
                                    bankname.setText("Bank is : "+fetched_bank);
                                    branch.setText("Branch is : "+fetched_branch);
                                    ifsc.setText("IFSC is : "+fetched_ifsc);
                                    phone.setText("Phone is : "+fetched_phone);



                                }
                                else {

                                    Toast.makeText(Display_Bank.this, "invalid credentials",
                                            Toast.LENGTH_SHORT).show();
                                }



                            } else {
                                // Handle API call failure
                                Toast.makeText(Display_Bank.this, "API response failure",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<PostBankshow1Activity> call, Throwable t) {
                            // Handle network failure or API call failure
                            Toast.makeText(Display_Bank.this, "Network failure",
                                    Toast.LENGTH_SHORT).show();



                        }
                    });






                }





            }
        });






    }
}