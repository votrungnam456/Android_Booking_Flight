package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bookingfilght.R;

public class TicketActivity extends AppCompatActivity {

    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        mapping();
        event();
    }

    private void event(){
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketActivity.this, DashBoard.class);
                startActivity(intent);
            }
        });
    }

    private void mapping(){
        btnReturn = findViewById(R.id.btn_return);
    }
}