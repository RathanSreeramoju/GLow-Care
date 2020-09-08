package com.example.glowcare.ui.cart;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowcare.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    private FirebaseFirestore db;
    private CartAdapter adapter;
    private RecyclerView recyclerView;
    ArrayList<CartModel> cartList;
    TextView buyNow;
    CartModel cart;
    private Context context;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_cart, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView = view.findViewById(R.id.cartRecycle);
        recyclerView.setLayoutManager(layoutManager);
        cartList = new ArrayList<>();
        buyNow = view.findViewById(R.id.btnBuyNow);

        db.collection("Cart").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(DocumentSnapshot snapshot:task.getResult()){
                        cart = new CartModel(snapshot.getId(),
                                             snapshot.getString("name"),
                                             snapshot.getDouble("price"),
                                             snapshot.getString("imageurl"));
                        cartList.add(cart);
                    }
                    adapter = new CartAdapter(cartList,getActivity().getApplicationContext());
                    recyclerView.setAdapter(adapter);

                    adapter.setOnItemClickListener(new CartAdapter.OnDeleteListener() {
                        @Override
                        public void onDeleteClick(int position) {
                            db.collection("Cart").document(cartList.get(position).getId()).delete();
                        }
                    });

                }
                else {
                    Toast.makeText(getActivity().getApplicationContext(),task.getException()+"", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}