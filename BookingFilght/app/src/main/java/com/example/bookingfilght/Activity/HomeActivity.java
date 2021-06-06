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

        //ping
        tv_Den = findViewById(R.id.tv_NoiDen);
        tv_Di = findViewById(R.id.tv_NoiDi);
        ngaydi = findViewById(R.id.tv_MotChieu);
        ngayve = findViewById(R.id.tv_KhuHoi);
        btnchangetv = findViewById(R.id.btnchange);
        chip = findViewById(R.id.chip4);
        buttons = findViewById(R.id.button_SearchTiket);
        //ping textview SL
        nguoiHon12 = findViewById(R.id.display12);
        nguoiDuoi12 = findViewById(R.id.display11);
        treNho = findViewById(R.id.display1);
        //ping button plus
        plus12 = findViewById(R.id.plus12);
        plus11 = findViewById(R.id.plus11);
        plus1 = findViewById(R.id.plus1);
        //ping button minus
        minus12 = findViewById(R.id.minus12);
        minus11 = findViewById(R.id.minus11);
        minus1 = findViewById(R.id.minus1);

        //an textview ngayve
        ngayve.setVisibility(View.INVISIBLE);

        //dat ngay textview ngaydi and ngayve
        calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
        ngaydi.setText(simpleDateFormat.format(calendar.getTime()));
        ngayve.setText(simpleDateFormat.format(calendar.getTime()));

        //chon ngay di
        ngaydi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener chonngaydi = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        ngaydi.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                };
                String[] mang = ngaydi.getText().toString().split("/");
                int day = Integer.parseInt(mang[0]);
                int month =Integer.parseInt(mang[1]);
                int year = Integer.parseInt(mang[2]);
                DatePickerDialog datePickerDialog = new DatePickerDialog(HomeActivity.this,chonngaydi,year,month,day);
                datePickerDialog.show();
            }
        });
        //chon ngay ve
        ngayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener chonngayve = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        ngayve.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                };
                String[] mag = ngayve.getText().toString().split("/");
                int day = Integer.parseInt(mag[0]);
                int month = Integer.parseInt(mag[1]);
                int year = Integer.parseInt(mag[2]);

                DatePickerDialog datePickerDialog = new DatePickerDialog(HomeActivity.this,chonngayve,year,month,day);
                datePickerDialog.show();

            }
        });
        // chon noi di
        tv_Di.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,Select_1_Activity.class);
                startActivityForResult(intent,REQUEST_CODE1);
            }
        });
        //chon noi den
        tv_Den.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,Select_1_Activity.class);
                startActivityForResult(intent,REQUEST_CODE2);
            }
        });

        // change textview tv_Di and tv_Den
        btnchangetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = tv_Di.getText().toString();
                tv_Di.setText(tv_Den.getText().toString());
                tv_Den.setText(temp);
            }
        });

        //show textview Ngayve ve khu hoi
        chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    ngayve.setVisibility(View.VISIBLE);
                }
                else
                {
                    ngayve.setVisibility(View.INVISIBLE);
                }
            }
        });

        //search ticket
        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] mang = tv_Di.getText().toString().split("-");
                String ndi = mang[0];
                String[] mang1 = tv_Den.getText().toString().split("-");
                String nde = mang1[0];
                String date = ngaydi.getText().toString();
                //lay so luong nguoi di
                //co the intent them so ghe em be de tru so luong ghe co san
                int sl12 = Integer.parseInt(nguoiHon12.getText().toString());
                int sl11 = Integer.parseInt(nguoiDuoi12.getText().toString());
                int tongSoVe = sl11 + sl12;
                if(chip.isCheckable())
                {
                    tongSoVe = tongSoVe*2;
                }
                if(sl12 > 0) {
                    Intent intent = new Intent(HomeActivity.this, Ticket_Activity.class);
                    intent.putExtra("noi_di", ndi);
                    intent.putExtra("noi_den", nde);
                    intent.putExtra("tong_ve",tongSoVe);
                    intent.putExtra("date_go", date);
                    intent.putExtra("12",sl12);
                    intent.putExtra("11",sl11);
                    setResult(RESULT_OK, intent);
                    startActivityForResult(intent, REQUEST_CODE1);
                }
                else
                {
                    new AestheticDialog.Builder(HomeActivity.this, DialogStyle.FLASH, DialogType.ERROR)
                            .setTitle("Lỗi")
                            .setMessage("Trẻ Con Thì Không Đi Một Mình Được Nha Quý Khách!!")
                            .setCancelable(false)
                            .setDarkMode(false)
                            .setGravity(Gravity.CENTER)
                            .setAnimation(DialogAnimation.SHRINK)
                            .show();
                }
            }
        });

        //plus button click
        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = treNho.getText().toString();
                int s = Integer.parseInt(str);
                s++;
                treNho.setText(String.valueOf(s));
            }
        });
        plus11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = nguoiDuoi12.getText().toString();
                int s = Integer.parseInt(str);
                s++;
                nguoiDuoi12.setText(String.valueOf(s));
            }
        });
        plus12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = nguoiHon12.getText().toString();
                int s = Integer.parseInt(str);
                s++;
                nguoiHon12.setText(String.valueOf(s));
            }
        });

        //minus button click
        minus12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = nguoiHon12.getText().toString();
                int s = Integer.parseInt(str);
                s--;
                nguoiHon12.setText(String.valueOf(s));
            }
        });
        minus11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = nguoiDuoi12.getText().toString();
                int s = Integer.parseInt(str);
                s--;
                nguoiDuoi12.setText(String.valueOf(s));
            }
        });
        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = treNho.getText().toString();
                int s = Integer.parseInt(str);
                s--;
                treNho.setText(String.valueOf(s));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE1 == requestCode && resultCode == RESULT_OK) {
            String ma = data.getStringExtra("matinh");
            String ten = data.getStringExtra("tentinh");
            String str = ma +"-" +ten;
            tv_Di.setText(str);
        }
        else if(REQUEST_CODE2 == requestCode && resultCode == RESULT_OK)
        {
            String mat = data.getStringExtra("matinh");
            String tent = data.getStringExtra("tentinh");
            String str = mat +"-" +tent;
            tv_Den.setText(str);
        }
    }
}