package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookingfilght.Models.KhachHangDTO;
import com.example.bookingfilght.R;
import com.example.bookingfilght.api.KhachHangCallAPI;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout txtEmail, txtFullName, txtCmnd, txtPassWord, txtPhone;
    TextInputEditText txtInpputEmail, txtInpputFullName, txtInpputCmnd, txtInpputPassWord, txtInpputPhone;
    Button btnButton, btnBacklogin;
    KhachHangDTO customer;
    List<KhachHangDTO> listCustomer;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mapping();
        callAPIKhachHang();
        btnButton.setOnClickListener(v -> {
            if(registerUser()){
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
//                message.setText("Register success");
            }
            else{
                message.setText("Register failed");
                message.setTextColor(Color.RED);
            }
        });

        btnBacklogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });
        txtInpputFullName.setText("Nam");
        txtInpputEmail.setText("votrungnam@gmail.com");
        txtInpputPhone.setText("0123456789");
        txtInpputCmnd.setText("987654321");
        txtInpputPassWord.setText("123456");
    }

    private void mapping() {
        txtEmail = findViewById(R.id.emailname);
        txtFullName = findViewById(R.id.fullname);
        txtCmnd = findViewById(R.id.cmnd);
        txtPassWord = findViewById(R.id.password);
        txtPhone = findViewById(R.id.soDienThoai);
        btnButton = findViewById(R.id.btnregister);
        btnBacklogin = findViewById(R.id.btnBacklogin);
        txtInpputEmail=  findViewById(R.id.txtInputEmail);
        txtInpputCmnd=  findViewById(R.id.txtInputCMND);
        txtInpputFullName=  findViewById(R.id.txtInputName);
        txtInpputPassWord=  findViewById(R.id.txtInputPassword);
        txtInpputPhone=  findViewById(R.id.txtInputPhoneNumber);
        message = findViewById(R.id.tvMessage);
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
        }
//        } else if (val.matches(emailPatten)) {
//            txtEmail.setError("Invalid Email address");
//            return false;
//        }
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
        }
//        else if(!val.matches(valPassword)) {
//            txtPassWord.setError("Password is too weak");
//            return false;
//        }
        else {
            txtPassWord.setError(null);
            return true;
        }
    }


    public boolean registerUser() {
        if(!validateCMND() || !validateEmail() || !validateFullName() || !validatePassword() || !validatePhone()) {
            return false;
        }
        else if(TextUtils.isEmpty(txtInpputFullName.getText().toString()) || TextUtils.isEmpty(txtInpputEmail.getText().toString())|| TextUtils.isEmpty(txtInpputPhone.getText().toString())|| TextUtils.isEmpty(txtInpputCmnd.getText().toString())|| TextUtils.isEmpty(txtInpputPassWord.getText().toString()))
        {
            return false;
        }
        else{
            String hoTen = txtInpputFullName.getText().toString();
            String email = txtInpputEmail.getText().toString();
            String phoneNumber = txtInpputPhone.getText().toString();
            String cmnd = txtInpputCmnd.getText().toString();
            String pwd = txtInpputPassWord.getText().toString();

            for (KhachHangDTO item:listCustomer) {
                if (item.getEmail().equals(email) || item.getCMND().equals(cmnd) || item.getSoDienThoai().equals(phoneNumber)) {
                    return false;
                }
            }
            KhachHangDTO newCustomer = new KhachHangDTO(hoTen,cmnd,email,phoneNumber,pwd);

            postAPIKhachHang(newCustomer);
            if(customer != null){

                return true;
            }
            else return false;
        }
    }
    private void callAPIKhachHang() {
        KhachHangCallAPI.callapi.getAll().enqueue(new Callback<List<KhachHangDTO>>() {
            @Override
            public void onResponse(Call<List<KhachHangDTO>> call, Response<List<KhachHangDTO>> response) {
                listCustomer = response.body();
            }

            @Override
            public void onFailure(Call<List<KhachHangDTO>> call, Throwable t) {
                

            }
        });
    }
    private void postAPIKhachHang(KhachHangDTO newCustomer) {
        KhachHangCallAPI.callapi.postKhachHangDto(newCustomer).enqueue(new Callback<KhachHangDTO>() {
            @Override
            public void onResponse(Call<KhachHangDTO> call, Response<KhachHangDTO> response) {

                customer = response.body();
            }

            @Override
            public void onFailure(Call<KhachHangDTO> call, Throwable t) {

            }
        });
    }

}