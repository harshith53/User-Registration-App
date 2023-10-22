package com.example.userloginapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText firstEditText, emailEditText, passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstEditText = findViewById(R.id.Firstname);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);



         MaterialButton regbtn = findViewById(R.id.signupbtn);

          regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                registerUser();
            }
          });
    }
    private void registerUser() {
        String username = firstEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        Toast.makeText(MainActivity.this,"Username is"+username,Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"email"+email,Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"password"+password,Toast.LENGTH_SHORT).show();

        if (!isPasswordStrong(password)) {
            Toast.makeText(this, "Password is not strong enough.", Toast.LENGTH_SHORT).show();
        }

        // Perform user registration logic here, e.g., sending data to a server.

        // Display a success message or handle errors.
    }

    private boolean isPasswordStrong(String password) {
        // Password strength validation based on your criteria.
        // You can customize this method as per your requirements.
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}