package com.example.rentit.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentit.AltLogin;
import com.example.rentit.CategoryActivity;
import com.example.rentit.Model.Products;
import com.example.rentit.NavigationActivity;
import com.example.rentit.Prevalent.Prevalent;
import com.example.rentit.RegisterActivity;
import com.example.rentit.R;
import com.example.rentit.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;


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
    SharedPreferences sharedPref;
    private boolean logoutVisible = false;
    private boolean loginVisible = false;

    private HomeViewModel homeViewModel;
    private DatabaseReference ProductsRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        sharedPref = getActivity().getSharedPreferences("com.example.rentit", Context.MODE_PRIVATE);
        NavigationView navigationView = root.findViewById(R.id.nav_view);



        toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        View headerView = navigationView.getHeaderView(0);
        TextView userNameTextView = headerView.findViewById(R.id.user_profile_name);
        ImageView profileImageView = headerView.findViewById(R.id.user_profile_img);
        userNameTextView.setText(sharedPref.getString("Username", ""));





        if (sharedPref.getBoolean("IsUserLogined", true )){
            loginVisible = false;
            logoutVisible= true;


            navigationView.setNavigationItemSelectedListener(this);
            Menu nav_Menu = navigationView.getMenu();

            nav_Menu.findItem(R.id.logout).setVisible(logoutVisible);
            nav_Menu.findItem(R.id.login).setVisible(loginVisible);
        }
        else  {
            loginVisible = true;
            logoutVisible= false;

            navigationView.setNavigationItemSelectedListener(this);
            Menu nav_Menu = navigationView.getMenu();

            nav_Menu.findItem(R.id.logout).setVisible(logoutVisible);
            nav_Menu.findItem(R.id.login).setVisible(loginVisible);

        }


        recyclerView = root.findViewById(R.id.recycler_menu);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
        mDrawerlayout = (DrawerLayout) root.findViewById(R.id.drawer);

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



        categoryItem = (HorizontalScrollView) root.findViewById(R.id.categoryItem);
        popular = (ScrollView) root.findViewById(R.id.popular);



        tvCate = (TextView) root.findViewById(R.id.tvCate);

        tvRare = (TextView) root.findViewById(R.id.tvRare);


        popular.startAnimation(fromtopbottomfour);



        return root;


    }
    @Override
    public void onStart()
    {
        super.onStart();

        FirebaseRecyclerOptions<Products> options =
                new FirebaseRecyclerOptions.Builder<Products>()
                        .setQuery(ProductsRef, Products.class)
                        .build();


        FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter =
                new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull Products model)
                    {
                        holder.txtProductName.setText(model.getPname());
                        holder.txtProductDescription.setText(model.getDescription());
                        holder.txtProductPrice.setText("Price = " + model.getPrice() + "$");
                        Picasso.get().load(model.getImage()).into(holder.imageView);
                    }

                    @NonNull
                    @Override
                    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
                    {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items_layout, parent, false);
                        ProductViewHolder holder = new ProductViewHolder(view);
                        return holder;
                    }
                };
//        recyclerView.setAdapter(adapter);
//        adapter.startListening();
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.login:
                Intent intent = new Intent(getActivity(), AltLogin.class);
                this.startActivity(intent);
                break;
            case R.id.all_properties:
                intent = new Intent(getActivity(), RegisterActivity.class);
                this.startActivity(intent);
                break;
            case R.id.logout:
                sharedPref.edit().putBoolean("IsUserLogined", false).apply();
                sharedPref.edit().putString("Username", "").apply();
                intent = new Intent(getActivity(), NavigationActivity.class);
                this.startActivity(intent);
        }

        return true;
    }


}
