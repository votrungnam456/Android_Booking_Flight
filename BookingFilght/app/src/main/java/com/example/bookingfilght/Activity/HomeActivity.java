package com.example.bookingfilght.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.bookingfilght.Adapter.ChooseAdapter;
import com.example.bookingfilght.MainActivity;
import com.example.bookingfilght.Models.ModelTinh;
import com.example.bookingfilght.R;
import com.google.android.material.chip.Chip;
import com.thecode.aestheticdialogs.AestheticDialog;
import com.thecode.aestheticdialogs.DialogAnimation;
import com.thecode.aestheticdialogs.DialogStyle;
import com.thecode.aestheticdialogs.DialogType;
import com.thecode.aestheticdialogs.OnDialogClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    int REQUEST_CODE1 = 111;
    int REQUEST_CODE2 = 222;

    TextView ngaydi;
    TextView ngayve;
    TextView tv_Di;
    TextView tv_Den;
    Chip chip;
    Calendar calendar;
    ImageButton btnchangetv;
    Button buttons;

    TextView nguoiHon12;
    TextView nguoiDuoi12;
    TextView treNho;

    Button plus12;
    Button plus11;
    Button plus1;

    Button minus12;
    Button minus11;
    Button minus1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}