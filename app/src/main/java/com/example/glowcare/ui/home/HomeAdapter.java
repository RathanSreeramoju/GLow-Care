package com.example.glowcare.ui.home;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

<<<<<<< HEAD

import com.example.glowcare.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;
=======
import com.bumptech.glide.Glide;
import com.example.glowcare.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
>>>>>>> cf72d5328f84b1a20ab1a8c489c40cc334f803a6

import java.util.ArrayList;

public class HomeAdapter extends FirestoreRecyclerAdapter<HomeModel,HomeAdapter.HomeViewHolder> {

    ArrayList<HomeModel> products = new ArrayList<>();
    private Context context;
<<<<<<< HEAD
    //private String imageurl = "https://images.unsplash.com/photo-1494548162494-384bba4ab999?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2000&q=80";
=======
>>>>>>> cf72d5328f84b1a20ab1a8c489c40cc334f803a6
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public HomeAdapter(@NonNull FirestoreRecyclerOptions<HomeModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull HomeViewHolder holder, int position, @NonNull HomeModel model) {
        holder.listName.setText(model.getName());
<<<<<<< HEAD
        holder.listPrice.setText(model.getPrice()+"$");
      //  Picasso.get().load("URL of image").into(imageView);
        Picasso.get().load(model.getImageurl())
                .fit()
                .centerCrop()
                .into(holder.image);
=======
        holder.listPrice.setText(model.getPrice()+"");
        // Glide.with(context).load(model.getImageurl()).into(holder.image);
>>>>>>> cf72d5328f84b1a20ab1a8c489c40cc334f803a6
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_home,parent,false);

        return new HomeViewHolder(view1);
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {

        private TextView listName,listPrice;
        private ImageView image;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            listName = itemView.findViewById(R. id.list_name);
            listPrice = itemView.findViewById(R.id.list_price);
<<<<<<< HEAD
            image = itemView.findViewById(R.id.imageView8);
=======
            // image = itemView.findViewById(R.id.imageView8);
>>>>>>> cf72d5328f84b1a20ab1a8c489c40cc334f803a6
        }
    }
}
