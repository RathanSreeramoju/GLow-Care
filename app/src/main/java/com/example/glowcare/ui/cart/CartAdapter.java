package com.example.glowcare.ui.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowcare.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 *
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    ArrayList<CartModel> cartModelList;
    OnDeleteListener listener;
    Context context;
    String input;
    FirebaseFirestore db;

    /**
     *
     * @param cartModelList
     * @param context
     */
    public CartAdapter( ArrayList<CartModel> cartModelList, Context context) {
        this.cartModelList = cartModelList;
        this.context = context;
    }

    public interface OnDeleteListener {
       void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnDeleteListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemName.setText(cartModelList.get(position).getName());
        holder.itemPrice.setText("$ " + cartModelList.get(position).getPrice());
        Picasso.get().load(cartModelList.get(position).getImageurl()).into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return cartModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage,itemDel;
        TextView itemName, itemPrice;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            itemDel = itemView.findViewById(R.id.itemDelete);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemView.setTag(this);

            itemDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(pos);
                        }
                    }
                }
            });

        }
    }

}
