package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.example.bookingfilght.R;
import com.thecode.aestheticdialogs.AestheticDialog;
import com.thecode.aestheticdialogs.DialogAnimation;
import com.thecode.aestheticdialogs.DialogStyle;
import com.thecode.aestheticdialogs.DialogType;

public class Info_Customer_Activity extends AppCompatActivity {


    Button btn_muave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info__customer_);

        btn_muave = findViewById(R.id.btn_muave);

        btn_muave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AestheticDialog.Builder(Info_Customer_Activity.this, DialogStyle.FLAT, DialogType.SUCCESS)
                        .setTitle("Thành Công")
                        .setMessage("Đặt Vé Thành Công")
                        .setCancelable(false)
                        .setDarkMode(false)
                        .setGravity(Gravity.CENTER)
                        .setAnimation(DialogAnimation.SHRINK).show();
            }
        });
    }
}