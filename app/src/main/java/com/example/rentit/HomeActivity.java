package com.example.rentit;

import android.graphics.Typeface;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import static com.example.rentit.R.string.app_name;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    Toolbar toolbar;


    TextView tvSweet, tvSweetSub, tvCate, tvRare, tvItemOne, tvItemPriceOne,
            tvItemTwo, tvItemPriceTwo, tvItemThree, tvItemPriceThree;
    Animation fromtopbottom, fromtopbottomtwo, fromtopbottomthree, fromtopbottomfour;
    LinearLayout itemOne, itemTwo, itemThree;
    HorizontalScrollView categoryItem;
    ScrollView popular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpToolbar();




        fromtopbottom = AnimationUtils.loadAnimation(this, R.anim.fromtopbottom);
        fromtopbottomtwo = AnimationUtils.loadAnimation(this, R.anim.fromtopbottomtwo);
        fromtopbottomthree = AnimationUtils.loadAnimation(this, R.anim.fromtopbottomthree);
        fromtopbottomfour = AnimationUtils.loadAnimation(this, R.anim.fromtoptobottomfour);


        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

//        itemOne = (LinearLayout) findViewById(R.id.itemOne);
//        itemTwo = (LinearLayout) findViewById(R.id.itemTwo);
//        itemThree = (LinearLayout) findViewById(R.id.itemThree);

        categoryItem = (HorizontalScrollView) findViewById(R.id.categoryItem);
        popular = (ScrollView) findViewById(R.id.popular);


//        tvSweet = (TextView) findViewById(R.id.tvSweet);
//        tvSweetSub = (TextView) findViewById(R.id.tvSweetSub);
        tvCate = (TextView) findViewById(R.id.tvCate);

        tvRare = (TextView) findViewById(R.id.tvRare);
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


    }

    private void setUpToolbar() {

        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, toolbar, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);



//        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//
//        mToggle = new ActionBarDrawerToggle(this,mDrawerlayout,toolbar,);
//        mDrawerlayout.addDrawerListener(mToggle);
//        mToggle.syncState();

    }


}

