package com.example.glowcare.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.glowcare.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class HomeFragment extends Fragment{

    private FirebaseFirestore db;
    private HomeAdapter adapter;
    private RecyclerView recyclerView;
    ArrayList<HomeModel> products;
    HomeModel product;
    String description;
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
                                snapshot.getString("image")
                                );
                        products.add(product);
                    }
                    adapter = new HomeAdapter(products,getActivity().getApplicationContext());
                    recyclerView.setAdapter(adapter);

                    adapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {

                        }
                        @Override
                        public void onButtonClick(int position, Button imageView) {
                                db.collection("Cart").add(products.get(position)).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentReference> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(getActivity().getApplicationContext(),"Added!!",Toast.LENGTH_LONG).show();
                                        }
                                        else {
                                            Toast.makeText(getActivity().getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                        }

                                    }
                                });
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
