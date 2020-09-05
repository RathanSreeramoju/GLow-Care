package com.example.glowcare.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.glowcare.ProductActivity1;
import com.example.glowcare.ProductActivity2;
import com.example.glowcare.ProductActivity3;
import com.example.glowcare.ProductActivity4;
import com.example.glowcare.R;
import com.example.glowcare.ui.cart.CartAdapter;
import com.example.glowcare.ui.cart.CartModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class HomeFragment extends Fragment{

    private FirebaseFirestore db;
    private HomeAdapter adapter;
    private RecyclerView recyclerView;
    ArrayList<HomeModel> products;
    HomeModel product;
    private Context context;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView = view.findViewById(R.id.firestore_list);
        recyclerView.setLayoutManager(layoutManager);
        products = new ArrayList<>();


        db.collection("Products").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(DocumentSnapshot snapshot:task.getResult()){
                        product = new HomeModel(snapshot.getId(),
                                snapshot.getString("name"),
                                snapshot.getDouble("price"),
                                snapshot.getString("image"));
                        products.add(product);
                    }
                    adapter = new HomeAdapter(products,getActivity().getApplicationContext());
                    recyclerView.setAdapter(adapter);


                }
                else {
                    Toast.makeText(getActivity().getApplicationContext(),task.getException()+"", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

}
