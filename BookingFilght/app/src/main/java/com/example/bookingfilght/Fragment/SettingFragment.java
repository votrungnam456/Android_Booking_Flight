package com.example.bookingfilght.Fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookingfilght.Activity.ResultSearchActivity;
import com.example.bookingfilght.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SettingFragment extends Fragment {

    AutoCompleteTextView autoCompleteTextViewSBDi, autoCompleteTextViewSBDen, autoCompleteTextViewLoaiVe;
    TextInputEditText txtNgayDi, txtNgayVe;
    TextInputLayout layoutNgayVe;
    Calendar calendar;
    CheckBox checkBox;
    Button btnSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.setting_fragment, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        autoCompleteTextViewSBDi = view.findViewById(R.id.drop_SB);
        autoCompleteTextViewSBDen = view.findViewById(R.id.drop_SBDen);
        autoCompleteTextViewLoaiVe = view.findViewById(R.id.drop_loaive);
        layoutNgayVe = view.findViewById(R.id.ngayve);
        txtNgayVe = view.findViewById(R.id.txtngayve);
        checkBox = view.findViewById(R.id.checkedKhuHoi);
        txtNgayDi = view.findViewById(R.id.txtngaydi);
        btnSearch = view.findViewById(R.id.btnSearch);


        checkBox.setChecked(true);

        String[] sb = getResources().getStringArray(R.array.id_SanBay);
        ArrayAdapter<String> adapters = new ArrayAdapter<String>(requireContext(), R.layout.dropdown_item, sb);

        autoCompleteTextViewSBDi.setAdapter(adapters);
        autoCompleteTextViewSBDen.setAdapter(adapters);

        String[] arrTyleTickers =  {"Phổ thông", "Thương gia"};
        ArrayAdapter<String> adapterTyleTickers = new ArrayAdapter<String>(requireContext(), R.layout.dropdown_item, arrTyleTickers);
        autoCompleteTextViewLoaiVe.setAdapter(adapterTyleTickers);

        //dat ngay textview ngaydi and ngayve
        calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        txtNgayDi.setText(simpleDateFormat.format(calendar.getTime()));
        txtNgayVe.setText(simpleDateFormat.format(calendar.getTime()));

        //chon ngay di
        txtNgayDi.setOnClickListener(v -> {
            DatePickerDialog.OnDateSetListener chonngaydi = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view1, int year, int month, int dayOfMonth) {
                    txtNgayDi.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                }
            };
            String[] mang = txtNgayDi.getText().toString().split("/");
            int day = Integer.parseInt(mang[0]);
            int month =Integer.parseInt(mang[1]);
            int year = Integer.parseInt(mang[2]);
            DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(),chonngaydi,year,month,day);
            datePickerDialog.show();
        });

        //chon ngay ve
        txtNgayVe.setOnClickListener(v -> {
            DatePickerDialog.OnDateSetListener chonngaydi = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view12, int year, int month, int dayOfMonth) {
                    txtNgayVe.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                }
            };
            String[] mang = txtNgayVe.getText().toString().split("/");
            int day = Integer.parseInt(mang[0]);
            int month =Integer.parseInt(mang[1]);
            int year = Integer.parseInt(mang[2]);
            DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(),chonngaydi,year,month,day);
            datePickerDialog.show();
        });

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                layoutNgayVe.setVisibility(View.VISIBLE);
            } else {
                layoutNgayVe.setVisibility(View.INVISIBLE);
            }
        });

        btnSearch.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ResultSearchActivity.class);
            startActivity(intent);
        });

    }
}
