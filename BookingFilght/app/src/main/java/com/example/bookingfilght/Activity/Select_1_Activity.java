package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.bookingfilght.Adapter.ChooseAdapter;
import com.example.bookingfilght.Models.ModelTinh;
import com.example.bookingfilght.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Select_1_Activity extends AppCompatActivity {

    SearchView searchView;
    Button button_hcm;
    Button button_hanoi;
    Button button_chulai;
    Button button_danang;
    Button button_haiphong;
    Button button_cantho;
    ArrayList<ModelTinh> data_selected = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_1);
        //ping
        searchView = findViewById(R.id.searchView_selected);
        button_hcm = findViewById(R.id.select_hcm);
        button_hanoi = findViewById(R.id.select_hanoi);
        button_chulai = findViewById(R.id.select_chulai);
        button_danang = findViewById(R.id.select_danang);
        button_haiphong = findViewById(R.id.select_haiphong);
        button_cantho = findViewById(R.id.select_cantho);
        Intent intent = getIntent();
        //add data listview
        data_selected.add(new ModelTinh("TBB","Tuy Hoà"));
        data_selected.add(new ModelTinh("HCM","Hồ Chí Minh"));
        data_selected.add(new ModelTinh("QNN","Quảng Ninh"));
        data_selected.add(new ModelTinh("QNG","Quảng Ngãi"));
        data_selected.add(new ModelTinh("DNN","Đà Nẵng"));
        data_selected.add(new ModelTinh("HAN","Hà Nội"));
        data_selected.add(new ModelTinh("HANA","Hội An"));
        data_selected.add(new ModelTinh("HPP","Hải Phòng"));
        data_selected.add(new ModelTinh("CTT","Cần Thơ"));
        data_selected.add(new ModelTinh("CLN","Chu Lai"));


        //set data in listview
        ChooseAdapter homeAdapter = new ChooseAdapter(data_selected,this);
        ListView listView = findViewById(R.id.lv_tinhdi);
        listView.setAdapter(homeAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<ModelTinh> arrayList = fillter(data_selected, newText);
                homeAdapter.update(arrayList);
                return false;
            }
        });
        //truyen data ve lai
        button_haiphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("matinh","HPP");
                intent.putExtra("tentinh","Hải Phòng");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        button_hanoi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("matinh","HNN");
                    intent.putExtra("tentinh","Hà Nội");
                    setResult(RESULT_OK,intent);
                    finish();
                }
            });
        button_danang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("matinh","DNN");
                intent.putExtra("tentinh","Đà Nẵng");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        button_cantho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("matinh","CTT");
                intent.putExtra("tentinh","Cần Thơ");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        button_hcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("matinh","HCM");
                intent.putExtra("tentinh","Hồ Chí Minh");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        button_chulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("matinh","CLN");
                intent.putExtra("tentinh","Chu Lai");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        //listview selected intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ma = data_selected.get(position).MaTinh;
                String ten = data_selected.get(position).TenTinh;
                intent.putExtra("matinh",ma);
                intent.putExtra("tentinh",ten);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
    public ArrayList<ModelTinh> fillter(ArrayList<ModelTinh> home,String chartex)
    {
        List<ModelTinh> arr = new ArrayList<>();
        arr = home.stream().filter(x -> x.getTenTinh().toLowerCase().contains(chartex.toLowerCase()) || x.getMaTinh().toLowerCase().contains(chartex.toLowerCase())).collect(Collectors.toList());
        return new ArrayList<ModelTinh>(arr);
    }
}