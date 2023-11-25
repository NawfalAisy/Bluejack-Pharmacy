package com.example.mcs_lab_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Register extends AppCompatActivity {

    ArrayList<dataPeople> dataPeople_temp = new ArrayList<dataPeople>();

    int UserID_inc = 0;

    private EditText register_username, register_email, register_phone, register_password, register_confirmpassword;

    Button register_button, backtologin;

    boolean username_check = false, rangeUser_5 = false;

    boolean email_check = false, end_com = false;

    boolean password_check = false, rangeChar_5 = false;

    boolean phone_check = false, min_phoneNum = false;

    boolean confirmpass_check = false, same_pass = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_username = findViewById(R.id.register_username);
        register_email = findViewById(R.id.register_email);
        register_phone = findViewById(R.id.register_phone);
        register_password = findViewById(R.id.register_password);
        register_confirmpassword = findViewById(R.id.register_confirmpassword);
        register_button = findViewById(R.id.register_button);
        backtologin = findViewById(R.id.backtologin);

        register_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String user_con = register_username.getText().toString();
                if (!user_con.isEmpty()){
                    username_check = true;
                    if (user_con.length() >= 5){
                        rangeUser_5 = true;
                    } else if (user_con.length() < 5){
                        rangeUser_5 = false;
                        register_username.setError("Minimum 5 character");
//                        Toast.makeText(Register.this, "Minimum 5 character", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    username_check = false;
                }
            }



            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        register_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email_con = register_email.getText().toString();
                if (!email_con.isEmpty()){
                    email_check = true;
                    if (Patterns.EMAIL_ADDRESS.matcher(email_con).matches()){
                        end_com = true;
                    } else if(!Patterns.EMAIL_ADDRESS.matcher(email_con).matches()){
                        email_check = false;
                        register_email.setError("Email need contain @ and .com");
//                        Toast.makeText(Register.this, "Email need contain @ and .com", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    email_check = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        register_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String phone_con = register_phone.getText().toString();
                if(!phone_con.isEmpty()){
                    phone_check = true;
                    if (phone_con.length() == 12){
                        min_phoneNum = true;
                    } else if (phone_con.length() < 12){
                        min_phoneNum = false;
                        register_phone.setError("The phone number must be 12 digits");
//                        Toast.makeText(Register.this, "The phone number must be 12 digits", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    phone_check = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        register_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pass_con = register_password.getText().toString();
                if (!pass_con.isEmpty()){
                    password_check = true;
                    if (pass_con.length() >= 5 && pass_con.matches("(.*[A-Z].*)") && pass_con.matches("(.*[0-9].*)") && pass_con.matches("(.*[@,#,\\,$,%,^,&,+,=,!].*)") && pass_con.matches("(.*[a-z].*)")){
                        rangeChar_5 = true;
                    } else if (!(pass_con.length() >= 5 && pass_con.matches("(.*[A-Z].*)") && pass_con.matches("(.*[0-9].*)") && pass_con.matches("(.*[@,#,\\,$,%,^,&,+,=,!].*)") && pass_con.matches("(.*[a-z].*)"))){
                        rangeChar_5 = false;
                        register_password.setError("Password must have atleast 5 characters, 1 Uppercase, 1 lowecase, 1 special Character too");
//                        Toast.makeText(Register.this, "Password must have atleast 5 characters", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    password_check = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        register_confirmpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String confpass_con = register_confirmpassword.getText().toString();
                String passcon_con = register_password.getText().toString();
                if (!confpass_con.isEmpty()){
                    confirmpass_check = true;
                    if (confpass_con.equals(passcon_con)){
                        same_pass = true;
                    } else {
                        same_pass = false;
                        register_confirmpassword.setError("Must be the same as the password entered");
//                        Toast.makeText(Register.this, "Must be the same as the password entered", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    confirmpass_check = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username_check && email_check && phone_check && password_check && confirmpass_check){
                    Toast.makeText(Register.this, "Registration Succeed", Toast.LENGTH_SHORT).show();
                   if (same_pass == true && rangeChar_5 == true && rangeUser_5 == true && end_com == true && min_phoneNum == true){
                        Toast.makeText(Register.this, "Registration Succeed", Toast.LENGTH_SHORT).show();
                        String username = register_username.getText().toString();
                        String email = register_email.getText().toString();
                        String password = register_password.getText().toString();
                        String phone = register_phone.getText().toString();
                        dataPeople_temp.add(new dataPeople(username, email, phone, password, UserID_inc+=1));
                        Intent i = new Intent(Register.this, MainActivity.class);
                        i.putParcelableArrayListExtra("DataAcount", dataPeople_temp);
                        startActivity(i);
                    }
                   else if(same_pass == false && rangeChar_5 == false && rangeUser_5 == false && end_com == false && min_phoneNum == false){
                       Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                   }
                }
                if (username_check == false && email_check == false && phone_check == false && password_check == false && confirmpass_check == false){
                    Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}