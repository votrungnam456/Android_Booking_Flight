package com.example.bookingfilght.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookingfilght.Models.DataOuputHistory;
import com.example.bookingfilght.R;

import java.util.List;

public class AdapterHistoryTick extends BaseAdapter {

    List<DataOuputHistory> datas;
    private Context context;
    private int layout;

    public AdapterHistoryTick(Context context, int layout, List<DataOuputHistory> datas) {
        this.context = context;
        this.layout = layout;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // tránh render lại row trong view
    private class ViewHoldel {
        ImageView img;
        TextView ngayBayHistory, lotrinhHistory, giaHistory, hangVeHistory;
        Button btn_Booking;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AdapterHistoryTick.ViewHoldel viewHoldel;

        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);

            viewHoldel = new AdapterHistoryTick.ViewHoldel();

            //Mapping view
            viewHoldel.ngayBayHistory = (TextView) convertView.findViewById(R.id.ngaybayHistory);
            viewHoldel.lotrinhHistory = (TextView) convertView.findViewById(R.id.lotrinhHistory);
            viewHoldel.giaHistory = (TextView) convertView.findViewById(R.id.giaVeHistory);
            viewHoldel.hangVeHistory = (TextView) convertView.findViewById(R.id.hangveHistory);
            viewHoldel.btn_Booking = (Button) convertView.findViewById(R.id.btn_giaHistory);
            viewHoldel.img = (ImageView) convertView.findViewById(R.id.imageViewHistory);
            convertView.setTag(viewHoldel);
        } else {
            viewHoldel = (AdapterHistoryTick.ViewHoldel) convertView.getTag();
        }
        // Gan gia tri
        DataOuputHistory dataOuputHistory = datas.get(position);

        viewHoldel.ngayBayHistory.setText(dataOuputHistory.getNgayBay());
        viewHoldel.lotrinhHistory.setText(dataOuputHistory.getLoTrinh());
        viewHoldel.giaHistory.setText(dataOuputHistory.getGiaVe());
        viewHoldel.hangVeHistory.setText(dataOuputHistory.getHangHangKhong());
        viewHoldel.btn_Booking.setTag(1);
        viewHoldel.img.setImageResource(dataOuputHistory.getImageHangVe());


        viewHoldel.btn_Booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }
}
