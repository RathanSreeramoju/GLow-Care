package com.example.glowcare.ui.home;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.example.glowcare.R;
import com.example.glowcare.ui.cart.CartAdapter;
import com.example.glowcare.ui.cart.CartModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import com.example.glowcare.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    ArrayList<HomeModel> homeModel;
    ArrayList<CartModel> cartModelList;
    Context context;
    CartModel model;
    String input;
    FirebaseFirestore db;

    public HomeAdapter( ArrayList<HomeModel> homeModel, Context context) {
        this.homeModel = homeModel;
        this.context = context;
    }


    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_home, parent, false);
        return new HomeAdapter.ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.itemName.setText(homeModel.get(position).getName());
        holder.itemPrice.setText("$ " +homeModel.get(position).getPrice());
        Picasso.get().load(homeModel.get(position).getImageurl()).into(holder.itemImage);
    }


    @Override
    public int getItemCount() {
        return homeModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemName, itemPrice;
        Button addtocart;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            addtocart =itemView.findViewById(R.id.addtocart);
            itemName = itemView.findViewById(R.id.name1);
            itemPrice = itemView.findViewById(R.id.price1);
            itemImage = itemView.findViewById(R.id.image1);
            itemView.setTag(this);



        }
    }
}
