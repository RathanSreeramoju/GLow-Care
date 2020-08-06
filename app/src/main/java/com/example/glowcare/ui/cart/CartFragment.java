package com.example.glowcare.ui.cart;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.glowcare.R;

public class CartFragment extends Fragment {


View view;
Button button1;
private Context context;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_cart, container, false);
        button1 = (Button) view.findViewById(R.id.order);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Order Placed", Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }
}