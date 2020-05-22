package com.example.rentit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CategoryActivity extends AppCompatActivity {

    private ImageView apartments, servAppartments, offices, villas;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        apartments = (ImageView) findViewById(R.id.apart_cat);
        servAppartments = (ImageView) findViewById(R.id.serv_cat);
        offices = (ImageView) findViewById(R.id.off_cat);
        villas = (ImageView) findViewById(R.id.vill_cat);



        apartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, AddProperties.class);
                intent.putExtra("category", "apartments");
                startActivity(intent);
            }
        });


        servAppartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, AddProperties.class);
                intent.putExtra("category", "Service Apartments");
                startActivity(intent);
            }
        });


        offices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, AddProperties.class);
                intent.putExtra("category", "offices");
                startActivity(intent);
            }
        });


        villas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CategoryActivity.this, AddProperties.class);
                intent.putExtra("category", "villas");
                startActivity(intent);
            }
        });



    }
}
