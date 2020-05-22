package com.example.rentit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.rentit.R.string.app_name;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    Toolbar toolbar;


    TextView tvSweet, tvSweetSub, tvCate, tvRare, tvItemOne, tvItemPriceOne,
            tvItemTwo, tvItemPriceTwo, tvItemThree, tvItemPriceThree;
    Animation fromtopbottom, fromtopbottomtwo, fromtopbottomthree, fromtopbottomfour;
    LinearLayout itemOne, itemTwo, itemThree;
    HorizontalScrollView categoryItem;
    ScrollView popular;
    SharedPreferences sharedPref;
    private boolean logoutVisible = false;
    private boolean loginVisible = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, toolbar, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);




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

        sharedPref = this.getSharedPreferences("com.example.rentit", Context.MODE_PRIVATE);




        if (sharedPref.getBoolean("IsUserLogined", true )){
            loginVisible = false;
            logoutVisible= true;
            Menu nav_Menu = navigationView.getMenu();
            nav_Menu.findItem(R.id.logout).setVisible(logoutVisible);
            nav_Menu.findItem(R.id.login).setVisible(loginVisible);


        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.login:
                Intent intent = new Intent(this, RegisterActivity.class);
                this.startActivity(intent);
            break;
            case R.id.add_properties:
                 intent = new Intent(this, RegisterActivity.class);
                this.startActivity(intent);
                break;
           case R.id.logout:
                FirebaseAuth.getInstance().signOut();
//                Auth.GoogleSignInApi.signOut(GoogleSignIn.getClient(this, gso)).setResultCallback(
//                        new ResultCallback<Status>() {
//                            @Override
//                            public void onResult(Status status) {
//
//
//                            }
//                        });
        }

        return true;
    }

}