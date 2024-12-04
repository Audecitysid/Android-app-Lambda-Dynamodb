package com.example.bee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.bee.databinding.ActivityAddbankBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Addbank extends AppCompatActivity {

    ActivityAddbankBinding binding;
    BeeAPI beeAPI;

    public static String Uid = Homepage.Uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddbankBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://8gk4nxiuc2.execute-api.ap-south-1.amazonaws.com/dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        beeAPI = retrofit.create(BeeAPI.class);

        binding.applynewaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bankname = binding.BankName.getText().toString();
                String branchname = binding.BranchName.getText().toString();
                String accountnumber = binding.accountNumber.getText().toString();
                String IFSC = binding.IFSC.getText().toString();
                String phoneno = binding.phone.getText().toString();
                String ATM = binding.ATMPIN.getText().toString();

                if (bankname.isEmpty() || branchname.isEmpty() || accountnumber.isEmpty()
                        || IFSC.isEmpty() || phoneno.isEmpty() || ATM.isEmpty()) {
                    Toast.makeText(Addbank.this, "Fill all the details", Toast.LENGTH_SHORT).show();
                } else {
                    // Make API call to send the form data
                    Call<PostAddbank> call = beeAPI.addBank(136, Uid, bankname, branchname,
                            accountnumber, IFSC, phoneno, ATM);
                    call.enqueue(new Callback<PostAddbank>() {
                        @Override
                        public void onResponse(Call<PostAddbank> call, Response<PostAddbank> response) {
                            if (response.isSuccessful()) {
                                PostAddbank post = response.body();
                                // Handle the API response as per your requirements
                                if (post.getStatusCode() == 136) {
                                    // Application sent successfully
                                    Toast.makeText(Addbank.this, "Application sent successfully",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Addbank.this, Homepage.class);
                                    startActivity(intent);
                                } else {
                                    // Handle other status codes or error scenarios
                                }
                            } else {
                                // Handle API call failure
                            }
                        }

                        @Override
                        public void onFailure(Call<PostAddbank> call, Throwable t) {
                            // Handle network failure or API call failure
                        }
                    });
                }
            }
        });
    }
}
