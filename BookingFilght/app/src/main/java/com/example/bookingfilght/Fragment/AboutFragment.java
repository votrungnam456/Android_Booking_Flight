package com.example.bookingfilght.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookingfilght.Adapter.AdapterHistoryTick;
import com.example.bookingfilght.Models.ChuyenBayDTO;
import com.example.bookingfilght.Models.DataOuputHistory;
import com.example.bookingfilght.R;
import com.example.bookingfilght.SearchFlight.AdapterFlight;

import java.util.ArrayList;

public class AboutFragment extends Fragment{


    ListView listView;
    ArrayList<DataOuputHistory> arrayListHistory = null;
    AdapterHistoryTick adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.about_fragment, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapping(view);

        adapter = new AdapterHistoryTick(requireContext(), R.layout.item_historylist, arrayListHistory);
        listView.setAdapter(adapter);


    }

    private void mapping(View view) {
        listView = (ListView) view.findViewById(R.id.listFlightHistory);
        arrayListHistory = new ArrayList<>();

        DataOuputHistory item = new DataOuputHistory("25/05/2021", "500.000", "HCM - HANOI", "Vietnam Airlines", R.drawable.vnairline, 1L);

        arrayListHistory.add(item);
        arrayListHistory.add(item);
        arrayListHistory.add(item);
        arrayListHistory.add(item);
        arrayListHistory.add(item);
        arrayListHistory.add(item);
        arrayListHistory.add(item);
        arrayListHistory.add(item);
        arrayListHistory.add(item);
        arrayListHistory.add(item);
        arrayListHistory.add(item);
    }
}
