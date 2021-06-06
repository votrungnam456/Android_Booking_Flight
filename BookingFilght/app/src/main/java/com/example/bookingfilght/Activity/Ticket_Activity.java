package com.example.bookingfilght.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.bookingfilght.Adapter.TicketApdapter;
import com.example.bookingfilght.Models.ModelTinh;
import com.example.bookingfilght.Models.ModelsTicket;
import com.example.bookingfilght.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ticket_Activity extends AppCompatActivity {

    ArrayList<ModelsTicket> data_selected = new ArrayList<>();

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_);
        //ping
        searchView = findViewById(R.id.searchView2);
        Intent intent = getIntent();
        //add data listview ticket
        data_selected.add(new ModelsTicket(550000,"HCM","HNN","18:00","23:00","7:00","Bay Thẳng","14/6/2021",R.drawable.vna));
        data_selected.add(new ModelsTicket(550000,"DNN","HNN","18:00","23:00","7:00","Bay Thẳng","14/7/2021",R.drawable.vjka));
        data_selected.add(new ModelsTicket(550000,"CLN","HNN","18:00","23:00","7:00","Bay Thẳng","14/8/2021",R.drawable.bba));


        TicketApdapter homeAdapter = new TicketApdapter(data_selected,this);
        ListView listView = findViewById(R.id.lv_ticket);
        listView.setAdapter(homeAdapter);



        String noiDi = intent.getStringExtra("noi_di");
        String noiDen = intent.getStringExtra("noi_den");
        String ngayDi = intent.getStringExtra("date_go");
        int sl11 = intent.getIntExtra("11",0);
        int sl12 = intent.getIntExtra("12",0);
        int tongSoVe = intent.getIntExtra("tong_ve",0);
        String query = noiDi + " - " +noiDen + " " +ngayDi;

        searchView.post(new Runnable() {
            @Override
            public void run() {
                searchView.setQuery(query, true);
                ArrayList<ModelsTicket> arrayList = fillter(data_selected, noiDi , noiDen , ngayDi);
                homeAdapter.update(arrayList);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double giave_intent = data_selected.get(position).GiaVe;
                 String nden = data_selected.get(position).NoiDen;
                 String ndi = data_selected.get(position).NoiDi;
                 String time_di = data_selected.get(position).ThoiGianBay;
                 String time_den = data_selected.get(position).ThoiGianDen;
                 String timetotal = data_selected.get(position).Time;
                 String ngaydi = data_selected.get(position).NgayDi;
                 int hangbay = data_selected.get(position).HangBay;
                 String htbay = data_selected.get(position).HinhThucBay;

                 Intent intent1 = new Intent(Ticket_Activity.this,DetailTicket_Activity.class);
                intent1.putExtra("11",sl11);
                intent1.putExtra("12",sl12);
                intent1.putExtra("tong_ve",tongSoVe);
                intent1.putExtra("gia_ve",giave_intent);
                intent1.putExtra("noi_den",nden);
                intent1.putExtra("noi_di",ndi);
                intent1.putExtra("time_di",time_di);
                intent1.putExtra("time_den",time_den);
                intent1.putExtra("time",timetotal);
                intent1.putExtra("date_go",ngaydi);
                intent1.putExtra("hang",hangbay);
                intent1.putExtra("htb_ayy",htbay);
                startActivity(intent1);
            }
        });
    }
    public ArrayList<ModelsTicket> fillter(ArrayList<ModelsTicket> home, String noiDi , String noiDen , String ngayDi)
    {
        List<ModelsTicket> arr = new ArrayList<>();
        arr = home.stream().filter(x -> {
          if( x.getNoiDi().toLowerCase().contains(noiDi.toLowerCase()) && x.getNoiDen().toLowerCase().contains(noiDen.toLowerCase()) && x.getNgayDi().toLowerCase().contains(ngayDi.toLowerCase())){
              return true;
          }
          return false;
        }).collect(Collectors.toList());
        Log.d("BBB",arr.toString());

        return new ArrayList<ModelsTicket>(arr);
    }
}