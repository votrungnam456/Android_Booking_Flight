package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bookingfilght.Models.ChuyenBayDTO;
import com.example.bookingfilght.R;
import com.example.bookingfilght.SearchFlight.AdapterFlight;
import com.example.bookingfilght.SearchFlight.FlightCallBack;

import java.util.ArrayList;
import androidx.core.util.Pair;

public class ResultSearchActivity extends AppCompatActivity implements FlightCallBack {

    ListView listView;
    ArrayList<ChuyenBayDTO> arrayListCB;
    AdapterFlight adapter;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_search);
        mapping();

        adapter = new AdapterFlight(this, R.layout.item_flight, arrayListCB, this);
        listView.setAdapter(adapter);

        back.setOnClickListener(v -> {
//            Intent intent = new Intent(ResultSearchActivity.this, DashBoard.class);
//            startActivity(intent);
            finish();
        });
    }

    private void mapping() {
        listView = (ListView) findViewById(R.id.listFlight);
        back =  findViewById(R.id.back);
        arrayListCB = new ArrayList<>();

       ChuyenBayDTO chuyenBayDTO = new ChuyenBayDTO("25/05/2021", "07:30", 2f,"Vietnam Airlines", "HCM", "HAN", "2.000.000", R.drawable.vnairline);
        ChuyenBayDTO chuyenBayDTO1 = new ChuyenBayDTO("25/05/2021", "07:30", 2f,"Vietnam Airlines", "HCM", "HAN", "2.000.000", R.drawable.vnairline);
        ChuyenBayDTO chuyenBayDTO2 = new ChuyenBayDTO("25/05/2021", "07:30", 2f,"Vietnam Airlines", "HCM", "HAN", "2.000.000", R.drawable.vnairline);


        arrayListCB.add(chuyenBayDTO);
        arrayListCB.add(chuyenBayDTO1);
        arrayListCB.add(chuyenBayDTO2);
        arrayListCB.add(chuyenBayDTO2);
        arrayListCB.add(chuyenBayDTO2);
        arrayListCB.add(chuyenBayDTO2);
        arrayListCB.add(chuyenBayDTO2);
        arrayListCB.add(chuyenBayDTO2);
        arrayListCB.add(chuyenBayDTO2);
        arrayListCB.add(chuyenBayDTO2);
    }

    @Override
    public void onFlightItemClick(int pos,
                                  ImageView hangBay,
                                  TextView gioDi,
                                  TextView gioDen,
                                  TextView maDi,
                                  TextView maDen,
                                  TextView tenHang,
                                  TextView slogan,
                                  TextView gia) {

        Intent intent = new Intent(ResultSearchActivity.this, InfoBookingActivity.class);
        Pair<View, String> a2 = Pair.create(hangBay, "ImgHangTN");
        Pair<View, String> a3 = Pair.create(gioDi, "GioDiTN");
        Pair<View, String> a4 = Pair.create(gioDen, "GioDenTN");
        Pair<View, String> a5 = Pair.create(maDi, "MaDiTN");
        Pair<View, String> a6 = Pair.create(maDen, "MaDenTN");
        Pair<View, String> a7 = Pair.create(tenHang, "HangTN");
        Pair<View, String> a8 = Pair.create(slogan, "sloganTN");
        Pair<View, String> a9 = Pair.create(gia, "giaTN");

        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, a2, a3, a4, a5, a6, a7, a8, a9);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent, optionsCompat.toBundle());
        } else
        {
            startActivity(intent);
        }

    }
}