package com.example.glowcare.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.glowcare.ProductActivity1;
import com.example.glowcare.ProductActivity2;
import com.example.glowcare.ProductActivity3;
import com.example.glowcare.ProductActivity4;
import com.example.glowcare.R;

public class HomeFragment extends Fragment{

    View view;
    ImageView imageView;
    TextView text1 ,text2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView img1=(ImageView) view.findViewById(R.id.img1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeFragment.this.getActivity(), ProductActivity1.class));
            }
        });
        ImageView img2=(ImageView) view.findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeFragment.this.getActivity(), ProductActivity2.class));
            }
        });
        ImageView img3=(ImageView) view.findViewById(R.id.img3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeFragment.this.getActivity(), ProductActivity3.class));
            }
        });
        ImageView img4=(ImageView) view.findViewById(R.id.img4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeFragment.this.getActivity(), ProductActivity4.class));
            }
        });
        return view;


    }


}