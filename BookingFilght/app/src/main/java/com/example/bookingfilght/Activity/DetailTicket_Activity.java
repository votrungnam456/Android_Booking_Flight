 package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookingfilght.R;

import org.w3c.dom.Text;

 public class DetailTicket_Activity extends AppCompatActivity {

    TextView tv_NgayDi;
    TextView tv_NgayDen;
    TextView tv_GiaVe;
    TextView tv_HTbay;
    ImageView hangbay;
    TextView time_di;
    TextView time_den;
    TextView time_total;
     TextView tv_noidi;
     TextView tv_noiden;
     TextView soluong;

     Button btn_tiepTuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ticket_);
        //ping
        tv_GiaVe = findViewById(R.id.giave);
        tv_NgayDen = findViewById(R.id.ngaydi1);
        tv_noiden = findViewById(R.id.tv_noiden);
        tv_noidi = findViewById(R.id.tv_noidi);
        tv_NgayDi = findViewById(R.id.ngaydi);
        tv_HTbay = findViewById(R.id.tv_htbay);
        hangbay = findViewById(R.id.imghangbay);
        time_di = findViewById(R.id.tv_timedi);
        time_den = findViewById(R.id.tv_timeden);
        time_total = findViewById(R.id.timetotal);
        soluong = findViewById(R.id.tv_sl);
        btn_tiepTuc = findViewById(R.id.btnmuave);

        //get data in intent
        Intent intent1 = getIntent();
        double giaVe = intent1.getDoubleExtra("gia_ve",0);
        double soVe = intent1.getIntExtra("tong_ve",0);
        giaVe = soVe*giaVe;
        tv_GiaVe.setText(String.valueOf(giaVe));
        tv_noiden.setText( intent1.getStringExtra("noi_den"));
        tv_noidi.setText(intent1.getStringExtra("noi_di"));
        time_di.setText(intent1.getStringExtra("time_di"));
        time_den.setText(intent1.getStringExtra("time_den"));
        time_total.setText(intent1.getStringExtra("time"));
        tv_NgayDi.setText(intent1.getStringExtra("date_go"));
        tv_HTbay.setText(intent1.getStringExtra("htb_ayy"));
        hangbay.setImageResource(intent1.getIntExtra("hang",0));
        tv_NgayDen.setText(intent1.getStringExtra("date_go"));



        int str = intent1.getIntExtra("11",0);
        int str1 = intent1.getIntExtra("12",0);
        soluong.setText(String.valueOf(soVe));

        Log.v("tah",String.valueOf(soVe));
        Log.v("tg",String.valueOf(giaVe));


        btn_tiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailTicket_Activity.this,Info_Customer_Activity.class);
                startActivity(intent);
            }
        });
    }
}