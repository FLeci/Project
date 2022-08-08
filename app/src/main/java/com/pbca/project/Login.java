package com.pbca.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$");

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputUserName;
    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEmail = findViewById(R.id.text_input_email);
        textInputUserName = findViewById(R.id.text_input_username);
        textInputPassword = findViewById(R.id.text_input_pass);

    }

    private boolean validateEmail() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError("Please enter a valid email address");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean validateUserName() {
        String userName = textInputUserName.getEditText().getText().toString().trim();

        if (userName.isEmpty()) {
            textInputUserName.setError("Field can't be empty");
            return false;
        } else if (userName.length() > 15) {
            textInputUserName.setError("Username to long");
            return false;
        } else {
            textInputUserName.setError(null);
            return true;
        }
    }

    private boolean validatePass() {
        String passInput = textInputPassword.getEditText().getText().toString().trim();

        if (passInput.isEmpty()) {
            textInputPassword.setError("Field can't be empty");
            return false;
        }
        else if(!PASSWORD_PATTERN.matcher(passInput).matches()){
            textInputPassword.setError("Password to weak");
            return false;
        }
        else {
            textInputPassword.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateEmail() | !validateUserName() | !validatePass()) {
            return;
        } else {
            Intent intent = new Intent(Login.this, OurCuisine.class);
            startActivity(intent);
        }

//          String input = "Email: " + textInputEmail.getEditText().getText().toString();
//          input += "\n";
//          input += "UserName: " + textInputUserName.getEditText().getText().toString();
//          input += "\n";
//          input += "Password: " + textInputPassword.getEditText().getText().toString();
//


//        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();

    }
}