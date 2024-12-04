package com.example.bee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaCodec;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    public String baseUrl = "https://8gk4nxiuc2.execute-api.ap-south-1.amazonaws.com/dev/";

    public static String Uid;

    private EditText loginemail,loginpassword;
    private Button loginbutton;
    private TextView signupRedirectText;
    TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginemail = findViewById(R.id.login_email);
        loginpassword = findViewById(R.id.login_password);
        loginbutton = findViewById(R.id.login_button);
        signupRedirectText = findViewById(R.id.signuptext);
        forgotPassword=findViewById(R.id.forget_password_login);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginemail.getText().toString();
                String pass = loginpassword.getText().toString();
                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if(!pass.isEmpty()) {



                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(baseUrl)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        BeeAPI beeapi = retrofit.create(BeeAPI.class);
                        Call<Post> call = beeapi.getPosts(100, email);

                        call.enqueue(new Callback<Post>() {
                            @Override
                            public void onResponse(Call<Post> call, Response<Post> response) {
                                if (response.isSuccessful()) {
                                    Post post = response.body();
                                    // Handle the post
                                     Uid =post.getUid();
                                     String fetched_pass = post.getPassword();

                                    if (fetched_pass.equals(pass)) {
                                        // Passwords match
                                        // Add your desired logic here, such as navigating to the next screen

                                        Intent intent = new Intent(LoginActivity.this, Homepage.class);
                                        intent.putExtra("uid", Uid); // Pass the UID value as an extra
                                        startActivity(intent);

                                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this, Homepage.class));

                                    } else {
                                        // Passwords do not match
                                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                                    }


                                    //  Hey GPT add code to compare if the fetched password is same as written password


                                }


                            }

                            @Override
                            public void onFailure(Call<Post> call, Throwable t) {
                                // Handle network failure

                            }
                        });




                    };
                    }else{
                        loginpassword.setError("Enter the Password !");
                    }
                }


        });

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ForgotActivity.class));
            }
        });



    }
}