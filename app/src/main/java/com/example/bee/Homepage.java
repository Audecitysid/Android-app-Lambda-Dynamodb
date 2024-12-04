package com.example.bee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Homepage extends AppCompatActivity {

    private Button addbank,bankdetails,upi,integrated,logout;
    private DrawerLayout drawerLayout;
    EditText fillid;
    public static String Uid = LoginActivity.Uid;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Intent intent = getIntent();
        //Uid = intent.getStringExtra("uid");
         //Uid = LoginActivity.Uid;

        addbank = findViewById(R.id.Home_addbank);
        bankdetails = findViewById(R.id.Home_bankdetails);
        upi = findViewById(R.id.Home_upi);
        integrated = findViewById(R.id.Home_integratedop);
        logout=findViewById(R.id.logout);
        fillid=findViewById(R.id.Home_filluid);

        addbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this,Addbank.class));
            }
        });

        bankdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this,Display_Bank.class));
            }
        });

        upi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this,UPI_Interfae.class));
            }
        });

        integrated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this,Bankshow1Activity.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //LoginActivity.Uid = "";
                //Uid = "";

                startActivity(new Intent(Homepage.this,LoginActivity.class));
                finish();
                onDestroy();

            }
        });
        Toast.makeText(Homepage.this, "UID: " + Uid, Toast.LENGTH_SHORT).show();
        fillid.setText("Welcome "+Uid+" to BEE");


    }


}