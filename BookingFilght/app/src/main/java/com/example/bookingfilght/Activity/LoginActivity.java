package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button callSignUp, btnlogin;
    ImageView imageView;
    TextView logoText, sloganText;
    TextInputLayout emailAddress, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //bỏ thanh bar trên cùng.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        mapping();
        callNhanVien();
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
            Intent intent = new Intent(LoginActivity.this, DashBoard.class);
            startActivity(intent);
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
    }

    private void callNhanVien() {
        KhachHangCallAPI.callapi.getAll().enqueue(new Callback<List<KhachHangDTO>>() {
            @Override
            public void onResponse(Call<List<KhachHangDTO>> call, Response<List<KhachHangDTO>> response) {

            }

            @Override
            public void onFailure(Call<List<KhachHangDTO>> call, Throwable t) {

            }
        });
    }
}





























