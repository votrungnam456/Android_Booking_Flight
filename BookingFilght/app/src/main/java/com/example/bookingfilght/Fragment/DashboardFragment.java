package com.example.bookingfilght.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookingfilght.Models.CovidCaseDTO;
import com.example.bookingfilght.Models.KhachHangDTO;
import com.example.bookingfilght.R;
import com.example.bookingfilght.api.HomeCallAPI;
import com.example.bookingfilght.api.KhachHangCallAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {

    CovidCaseDTO lstDataCovid;
    TextView Case,Death,todayCase,Recovered,todayDeath,todayRecovered,Test;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.dashoard_fragment, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapping(view);
        callAPI();
        Case.setText(lstDataCovid.getCases().toString());
//        Death.setText(lstDataCovid.get(0).getDeaths().toString());
//        todayCase.setText(lstDataCovid.get(0).getTodayCases().toString());
//        Recovered.setText(lstDataCovid.get(0).getRecovered().toString());
//        todayDeath.setText(lstDataCovid.get(0).getTodayDeaths().toString());
//        todayRecovered.setText(lstDataCovid.get(0).getRecovered().toString());
//        Test.setText(lstDataCovid.get(0).getTests().toString());
    }

    private void mapping(View v){
        Case = v.findViewById(R.id.TxtCase);
        Death = v.findViewById(R.id.txtDeath);
        todayCase = v.findViewById(R.id.txtTodayCase);
        Recovered = v.findViewById(R.id.txtRecovered);
        todayDeath = v.findViewById(R.id.txtTodayDeath);
        todayRecovered = v.findViewById(R.id.txtTodayRecovered);
        Test = v.findViewById(R.id.txtTest);
    }

    private  void callAPI(){
        HomeCallAPI.callapi.getVietNamCovidCase().enqueue(new Callback<CovidCaseDTO>() {
            @Override
            public void onResponse(Call<CovidCaseDTO> call, Response<CovidCaseDTO> response) {
                lstDataCovid = response.body();
            }

            @Override
            public void onFailure(Call<CovidCaseDTO> call, Throwable t) {
            }
        });
    }
}
