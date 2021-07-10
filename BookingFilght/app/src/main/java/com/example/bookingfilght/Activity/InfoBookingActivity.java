package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bookingfilght.R;

public class InfoBookingActivity extends AppCompatActivity {

    Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_booking);
        mapping();
        event();
    }

    private void event(){
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoBookingActivity.this, TicketActivity.class);
                startActivity(intent);
            }
        });
    }

    private void mapping(){
        btnBuy = findViewById(R.id.btnbuy);
    }
}