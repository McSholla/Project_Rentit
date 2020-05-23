package com.example.rentit.ViewHolder;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rentit.Interface.ItemClickListner;
import com.example.rentit.R;

import org.w3c.dom.Text;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtProductName, txtProductDescription, txtProductPrice;
    public ImageView imageView;
    public ItemClickListner listner;


    public ProductViewHolder(View itemView)
    {
        super(itemView);


        imageView = (ImageView) itemView.findViewById(R.id.property_img);
        txtProductName = (TextView) itemView.findViewById(R.id.property_name);
        txtProductDescription = (TextView) itemView.findViewById(R.id.property_description);
        txtProductPrice = (TextView) itemView.findViewById(R.id.property_price);
    }

    public void setItemClickListner(ItemClickListner listner)
    {
        this.listner = listner;
    }

    @Override
    public void onClick(View view)
    {
        listner.onClick(view, getAdapterPosition(), false);
    }
}