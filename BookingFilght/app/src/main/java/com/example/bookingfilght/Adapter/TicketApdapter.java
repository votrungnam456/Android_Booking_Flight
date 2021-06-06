package com.example.bookingfilght.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookingfilght.Models.ModelTinh;
import com.example.bookingfilght.Models.ModelsTicket;
import com.example.bookingfilght.R;

import java.util.ArrayList;

public class TicketApdapter extends BaseAdapter {

    ArrayList<ModelsTicket> data = new ArrayList<>();

    public TicketApdapter(ArrayList<ModelsTicket> data, Context context) {
        this.data = data;
        this.context = context;
    }

    Context context;

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_yicket, null);
        }
        TextView tv_Gia = convertView.findViewById(R.id.tv_giaVe);
        TextView tv_Dia = convertView.findViewById(R.id.tv_DauCuoi);
        TextView tv_hahtrinh = convertView.findViewById(R.id.tv_hanhTrinh);
        TextView tv_TongTime = convertView.findViewById(R.id.tv_Time);
        TextView tv_htbay = convertView.findViewById(R.id.tv_HTbay);
        ImageView imageView = convertView.findViewById(R.id.imageViewNhaBay);

        ModelsTicket bay = data.get(position);
        String s = Double.toString(bay.GiaVe);
        tv_Gia.setText(s + "đ");
        tv_hahtrinh.setText(bay.NoiDi + " - " + bay.NoiDen);
        tv_Dia.setText(bay.ThoiGianBay + "  :  " + bay.ThoiGianDen);
        tv_TongTime.setText(bay.Time);
        tv_htbay.setText(bay.HinhThucBay);
        imageView.setImageResource(bay.HangBay);
        return convertView;
    }

    public void update(ArrayList<ModelsTicket> ho) {
        if (data.size() > 0){
            data.clear();
            data.addAll(ho);
        }
        notifyDataSetChanged();
    }
}
