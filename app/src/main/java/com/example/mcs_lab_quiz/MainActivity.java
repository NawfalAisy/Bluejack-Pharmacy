package com.example.mcs_lab_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button loginbutton, registerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginbutton = findViewById(R.id.loginbutton);
        registerbutton = findViewById(R.id.registerbutton);

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_people = email.getText().toString();
                String password_people = password.getText().toString();

                Intent i = getIntent();
                ArrayList<dataPeople> dataPeopleArray = i.getParcelableArrayListExtra("DataAcount", dataPeople.class);

                for (int x = 0; x < dataPeopleArray.size(); x++){
                    String email_data, password_data;
                    email_data = dataPeopleArray.get(x).getRegister_email();
                    password_data = dataPeopleArray.get(x).getRegister_password();

                    if (email_data.equals(email_people) == true && password_data.equals(password_people) == true){
                        Toast.makeText(MainActivity.this, "Login has been succesfull", Toast.LENGTH_SHORT).show();
                        Intent Home_Page = new Intent(MainActivity.this, Home.class);
                        startActivity(Home_Page);
                    }
                    if (email_data.equals(email_people) && !password_data.equals(password_people)){
                        loginbutton.setError("The password you entered is incorrect");
                        Toast.makeText(MainActivity.this, "The password you entered is incorrect", Toast.LENGTH_SHORT).show();
                    }
                    if (!email_data.equals(email_people) && password_data.equals(password_people)){
                        loginbutton.setError("The email you entered has not been registered");
                        Toast.makeText(MainActivity.this, "The email you entered has not been registered", Toast.LENGTH_SHORT).show();
                    }
                    if(!email_data.equals(email_people) && !password_data.equals(password_people)){
                        loginbutton.setError("The email you entered has not been registered");
                        Toast.makeText(MainActivity.this, "The email and password you entered doesn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}