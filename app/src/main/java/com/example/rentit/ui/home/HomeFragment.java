package com.example.rentit.ui.home;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.rentit.AltLogin;
import com.example.rentit.CategoryActivity;
import com.example.rentit.RegisterActivity;
import com.example.rentit.R;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    Toolbar toolbar;
    TextView tvSweet, tvSweetSub, tvCate, tvRare, tvItemOne, tvItemPriceOne,
            tvItemTwo, tvItemPriceTwo, tvItemThree, tvItemPriceThree;
    Animation fromtopbottom, fromtopbottomtwo, fromtopbottomthree, fromtopbottomfour;
    LinearLayout itemOne, itemTwo, itemThree;
    HorizontalScrollView categoryItem;
    ScrollView popular;

    private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);



        mDrawerlayout = (DrawerLayout) root.findViewById(R.id.drawer);
        NavigationView navigationView = root.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mToggle = new ActionBarDrawerToggle(getActivity(), mDrawerlayout, toolbar, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();


        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);




        fromtopbottom = AnimationUtils.loadAnimation(getActivity(), R.anim.fromtopbottom);
        fromtopbottomtwo = AnimationUtils.loadAnimation(getActivity(), R.anim.fromtopbottomtwo);
        fromtopbottomthree = AnimationUtils.loadAnimation(getActivity(), R.anim.fromtopbottomthree);
        fromtopbottomfour = AnimationUtils.loadAnimation(getActivity(), R.anim.fromtoptobottomfour);


        Typeface MMedium = Typeface.createFromAsset(getActivity().getAssets(), "fonts/MMedium.ttf");
        Typeface MLight = Typeface.createFromAsset(getActivity().getAssets(), "fonts/MLight.ttf");
        Typeface MRegular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/MRegular.ttf");

//        itemOne = (LinearLayout) findViewById(R.id.itemOne);
//        itemTwo = (LinearLayout) findViewById(R.id.itemTwo);
//        itemThree = (LinearLayout) findViewById(R.id.itemThree);

        categoryItem = (HorizontalScrollView) root.findViewById(R.id.categoryItem);
        popular = (ScrollView) root.findViewById(R.id.popular);


//        tvSweet = (TextView) findViewById(R.id.tvSweet);
//        tvSweetSub = (TextView) findViewById(R.id.tvSweetSub);
        tvCate = (TextView) root.findViewById(R.id.tvCate);

        tvRare = (TextView) root.findViewById(R.id.tvRare);
//        tvItemOne = (TextView) findViewById(R.id.tvItemOne);
//        tvItemPriceOne = (TextView) findViewById(R.id.tvItemPriceOne);
//
//        tvItemTwo = (TextView) findViewById(R.id.tvItemTwo);
//        tvItemPriceTwo = (TextView) findViewById(R.id.tvItemPriceTwo);
//
//        tvItemThree = (TextView) findViewById(R.id.tvItemThree);
//        tvItemPriceThree = (TextView) findViewById(R.id.tvItemPriceThree);

//        tvSweet.setTypeface(MMedium);
//        tvSweetSub.setTypeface(MLight);
//        tvCate.setTypeface(MMedium);
//
//        tvRare.setTypeface(MMedium);
//        tvItemOne.setTypeface(MRegular);
//        tvItemPriceOne.setTypeface(MLight);
//
//        tvItemTwo.setTypeface(MRegular);
//        tvItemPriceTwo.setTypeface(MLight);
//
//        tvItemThree.setTypeface(MRegular);
//        tvItemPriceThree.setTypeface(MLight);


//        tvSweet.startAnimation(fromtopbottom);
//        tvSweetSub.startAnimation(fromtopbottom);
//
//        tvCate.startAnimation(fromtopbottom);
//        tvRare.startAnimation(fromtopbottom);
//
//        categoryItem.startAnimation(fromtopbottom);

        popular.startAnimation(fromtopbottomfour);

//        itemOne.startAnimation(fromtopbottom);
//        itemTwo.startAnimation(fromtopbottomtwo);
//        itemThree.startAnimation(fromtopbottomthree);

        return root;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.login:
                Intent intent = new Intent(getActivity(), AltLogin.class);
                this.startActivity(intent);
                break;
            case R.id.add_properties:
                intent = new Intent(getActivity(), CategoryActivity.class);
                this.startActivity(intent);

        }

        return true;
    }
}
