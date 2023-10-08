package com.decode.disastershield;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.decode.disastershield.ui.login.LoginFragment;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    String[] permisssions = {"android.permission.READ_EXTERNAL_STORAGE","android.permission.WRITE_EXTERNAL_STORAGE","android.permission.ACCESS_FINE_LOCATION","android.permission.CALL_PHONE","android.permission.POST_NOTIFICATIONS"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.Address);
        TextView password = (TextView) findViewById(R.id.Password);
        TextView otp = (TextView) findViewById(R.id.otp);
        Button Rescuer = (Button) findViewById(R.id.Rescuer);
        t1 = (TextView) findViewById(R.id.createaccount);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permisssions,8);
        }
        Rescuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().equals("Aditya") && password.getText().toString().equals("Aditya@123") && otp.getText().toString().equals("123456")) {
                    Toast.makeText(MainActivity.this, "You Are Ready to Rescue!!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Rescuer_view.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                }


            }

        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent = new Intent(MainActivity.this, LoginFragment.class);
                startActivity(intent);
            }
        });


    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 8)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this, "you are ready to go", Toast.LENGTH_SHORT).show();
            }
        }
    }
}