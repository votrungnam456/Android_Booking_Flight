package com.example.bookingfilght.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bookingfilght.Models.ModelTinh;
import com.example.bookingfilght.R;

import java.util.ArrayList;

public class ChooseAdapter extends BaseAdapter {

    ArrayList<ModelTinh> data = new ArrayList<>();

    public ChooseAdapter(ArrayList<ModelTinh> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public Context context;
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
        if(convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_tinhbay,null);
        }
        TextView tv_ma = convertView.findViewById(R.id.tv_matinh);
        TextView tv_ten = convertView.findViewById(R.id.tv_tentinh);
        ModelTinh tinh = data.get(position);
        tv_ma.setText(tinh.MaTinh);
        tv_ten.setText(tinh.TenTinh);
        return convertView;
    }
    public  void update(ArrayList<ModelTinh> ho){
        data = ho;
        notifyDataSetChanged();
    }
}
