package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookingfilght.Models.KhachHangDTO;
import com.example.bookingfilght.R;
import com.example.bookingfilght.api.KhachHangCallAPI;
import com.example.bookingfilght.api.callAPI;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    List<KhachHangDTO> listKH;
    Button callSignUp, btnlogin;
    ImageView imageView;
    TextView logoText, sloganText;
    TextInputLayout emailAddress, password;
    TextInputEditText txtEmailAdress, txtPassword;
    KhachHangDTO userLogin;
    public static String MyUSER = "MYUSER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //bỏ thanh bar trên cùng.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        mapping();
        callAPIKhachHang();
        callSignUp.setOnClickListener(v -> {

            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            Pair[] pairs =new Pair[7];
            pairs[0] = new Pair<View, String>(imageView, "logo_image");
            pairs[1] = new Pair<View, String>(logoText, "logo_text");
            pairs[2] = new Pair<View, String>(sloganText, "text_dec");
            pairs[3] = new Pair<View, String>(emailAddress, "email_tran");
            pairs[4] = new Pair<View, String>(password, "password_tran");
            pairs[5] = new Pair<View, String>(btnlogin, "button_tran");
            pairs[6] = new Pair<View, String>(callSignUp, "login_signup_tran");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });

        btnlogin.setOnClickListener(v -> {

            if(checkLogin(listKH)){
                SharedPreferences sharedpreferences = getSharedPreferences(MyUSER, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("Id", userLogin.getId().toString());
                editor.putString("FullName", userLogin.getHoTen());
                editor.putString("CMND", userLogin.getCMND());
                editor.putString("PhoneNumber", userLogin.getSoDienThoai());
                editor.putString("Email", userLogin.getEmail());
                editor.commit();
                Intent intent = new Intent(LoginActivity.this, DashBoard.class);
                startActivity(intent);
            }
            else{
                sloganText.setText("Email or password is wrong, please check again");
                sloganText.setTextColor(Color.RED);
            }
        });

    }

    private void mapping()
    {
        callSignUp = findViewById(R.id.callsignup);
        imageView = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        emailAddress = findViewById(R.id.emailAddress);
        password = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btnlogin);
        txtEmailAdress = findViewById(R.id.txtEmailAdress);
        txtPassword = findViewById(R.id.txtPassword);
    }


    private boolean checkLogin(List<KhachHangDTO> lstKH){
        if(TextUtils.isEmpty(txtEmailAdress.getText().toString()) || TextUtils.isEmpty(txtPassword.getText().toString()))
        {
            return false;
        }
        String email = txtEmailAdress.getText().toString();
        String pwd = txtPassword.getText().toString();
        for (KhachHangDTO item: lstKH) {
            if(item.getEmail().equals(email) && item.getMatKhau().equals(pwd)){
                userLogin = item;
                return true;
            }
        }
        return false;
    }

    private void callAPIKhachHang() {
        KhachHangCallAPI.callapi.getAll().enqueue(new Callback<List<KhachHangDTO>>() {
            @Override
            public void onResponse(Call<List<KhachHangDTO>> call, Response<List<KhachHangDTO>> response) {
                listKH = response.body();
            }

            @Override
            public void onFailure(Call<List<KhachHangDTO>> call, Throwable t) {

            }
        });
    }
}





























