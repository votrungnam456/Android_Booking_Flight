package com.example.bookingfilght.Activity;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.bookingfilght.Adapter.DrawerAdapter;
import com.example.bookingfilght.Adapter.DrawerItem;
import com.example.bookingfilght.Adapter.SimpleItem;
import com.example.bookingfilght.Adapter.SpaceItem;
import com.example.bookingfilght.Fragment.AboutFragment;
import com.example.bookingfilght.Fragment.DashboardFragment;
import com.example.bookingfilght.Fragment.MyProfileFragment;
import com.example.bookingfilght.Fragment.SettingFragment;
import com.example.bookingfilght.R;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.lang.reflect.Array;
import java.util.Arrays;

import static androidx.core.content.ContentProviderCompat.requireContext;

public class DashBoard extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener{

    private static final int POS_CLOSE = 0;
    private static final int POS_DASHBOARD = 1;
    private static final int POS_MY_PROFILE = 2;
    private static final int POS_SETTING = 3;
    private static final int POS_ABOUT_US = 4;
    private static final int POS_LOGOUT = 5;

    String[] screenTitles;
    Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //bỏ thanh bar trên cùng.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dash_board);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withDragDistance(180)
                .withRootViewScale(0.75f)
                .withRootViewElevation(25)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.drawer_menu)
                .inject();

        screenTitles = loadScreenTitles();
        screenIcons = loadScreenIcons();


        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_CLOSE),
                createItemFor(POS_DASHBOARD).setChecked(true),
                createItemFor(POS_MY_PROFILE),
                createItemFor(POS_SETTING),
                createItemFor(POS_ABOUT_US),
                new SpaceItem(250),
                createItemFor(POS_LOGOUT)
        ));

        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.drawer_list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_DASHBOARD);
    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                //.withIconInit(color(R.color.Black))
                .withTextInit(color(R.color.Black))
                //.withSelectedItemIconInit(color(R.color.Black))
                .withSelectedItemTextInit(color(R.color.Red));
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }




    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.id_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];

        for(int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if(id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.id_activityScreenTitles);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onItemSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(position == POS_DASHBOARD) {
            DashboardFragment dashboardFragment = new DashboardFragment();
            transaction.replace(R.id.container, dashboardFragment);

        }

        else if(position == POS_MY_PROFILE) {
            MyProfileFragment myProfileFragment = new MyProfileFragment();
            transaction.replace(R.id.container, myProfileFragment);
        }

        else if(position == POS_SETTING) {
            SettingFragment settingFragment = new SettingFragment();
            transaction.replace(R.id.container, settingFragment);
        }

        else if(position == POS_ABOUT_US) {
            AboutFragment aboutFragment = new AboutFragment();
            transaction.replace(R.id.container, aboutFragment);
        }

        else if (position == POS_LOGOUT) {
            finish();
        }

        slidingRootNav.closeMenu();
        transaction.addToBackStack(null);
        transaction.commit();
    }
}



















