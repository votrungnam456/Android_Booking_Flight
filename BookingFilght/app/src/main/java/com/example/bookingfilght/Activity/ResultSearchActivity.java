package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bookingfilght.Models.ChuyenBayDTO;
import com.example.bookingfilght.R;
import com.example.bookingfilght.SearchFlight.AdapterFlight;

import java.util.ArrayList;

public class ResultSearchActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ChuyenBayDTO> arrayListCB;
    AdapterFlight adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_search);
        mapping();

        adapter = new AdapterFlight(this, R.layout.item_flight, arrayListCB);
        listView.setAdapter(adapter);
    }

    private void mapping() {
        listView = (ListView) findViewById(R.id.listFlight);
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
}