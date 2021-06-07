package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bookingfilght.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout txtEmail, txtFullName, txtCmnd, txtPassWord, txtPhone;
    Button btnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mapping();

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void mapping() {
        txtEmail = findViewById(R.id.emailname);
        txtFullName = findViewById(R.id.fullname);
        txtCmnd = findViewById(R.id.cmnd);
        txtPassWord = findViewById(R.id.password);
        txtPhone = findViewById(R.id.soDienThoai);
        btnButton = findViewById(R.id.btnregister);
    }



    private Boolean validateFullName() {
        String val = txtFullName.getEditText().getText().toString();
        if(val.isEmpty()) {
            txtFullName.setError("Field can be empty");
            return false;
        } else {
            txtFullName.setError(null);
            return true;
        }

    }

    private Boolean validateEmail() {
        String val = txtEmail.getEditText().getText().toString();
        String emailPatten = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()) {
            txtEmail.setError("Field can be empty");
            return false;
        } else if (val.matches(emailPatten)) {
            txtEmail.setError("Invalid Email address");
            return false;
        }
        else {
            txtFullName.setError(null);
            return true;
        }

    }

    private Boolean validateCMND() {
        String val = txtCmnd.getEditText().getText().toString();

        if(val.isEmpty()) {
            txtCmnd.setError("Field can be empty");
            return false;
        } else if(val.length() >= 15){
            txtCmnd.setError("CMND too long");
            return false;
        } else {
            txtCmnd.setError(null);
            return true;
        }
    }

    private Boolean validatePhone() {
        String val = txtPhone.getEditText().getText().toString();

        if(val.isEmpty()) {
            txtPhone.setError("Field can be empty");
            return false;
        } else if(val.length() >= 12){
            txtPhone.setError("Phone no too long");
            return false;
        } else {
            txtPhone.setError(null);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = txtPassWord.getEditText().getText().toString();
        String valPassword = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
        if(val.isEmpty()) {
            txtPassWord.setError("Field can be empty");
            return false;
        } else if(!val.matches(valPassword)) {
            txtPassWord.setError("Password is too weak");
            return false;
        } else {
            txtPassWord.setError(null);
            return true;
        }
    }


    public void registerUser() {
        if(!validateCMND() || !validateEmail() || !validateFullName() || !validatePassword() || !validatePhone()) {
            return;
        }
    }
}