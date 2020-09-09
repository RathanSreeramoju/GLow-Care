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
 *To get the items in the cart we use the CartAdapter.
 */
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    ArrayList<CartModel> cartModelList;
    OnDeleteListener listener;
    Context context;
    String input;
    FirebaseFirestore db;

    /**
     *Constructor with cardModel and context as parameters.
     * @param cartModelList : List of cardModels
     * @param context : Context element
     */
    public CartAdapter( ArrayList<CartModel> cartModelList, Context context) {
        this.cartModelList = cartModelList;
        this.context = context;
    }


    /**
     * Interface to delete the items.
     */
    public interface OnDeleteListener {
       void onDeleteClick(int position);
    }

    /**
     * setOnClickListener is clickable method
     * @param listener : onDelete Listener parameter.
     */
    public void setOnItemClickListener(OnDeleteListener listener) {
        this.listener = listener;
    }

    /**
     * Override method of viewHolder to create a new recyclerView.viewHolder and initialize some
     * private fields to be used by the recyclerView.
     * @param parent :ViewGroup element.
     * @param viewType : integer type element.
     * @return : returns the viewHolder.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_layout, parent, false);
        return new ViewHolder(view);
    }

    /**
     * This method uses to update the recycler.
     * @param holder :
     * @param position : Gives the position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemName.setText(cartModelList.get(position).getName());
        holder.itemPrice.setText("$ " + cartModelList.get(position).getPrice());
        Picasso.get().load(cartModelList.get(position).getImageurl()).into(holder.itemImage);
    }

    /**
     * Gets the count.
     * @return :Returns the total number of items in the data set held by the adapter.
     */
    @Override
    public int getItemCount() {
        return cartModelList.size();
    }


    /**
     * ViewHolder class for the recycler view.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage,itemDel;
        TextView itemName, itemPrice;

        /**
         * Constructor with view element.
         * @param itemView :View element.
         */
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
