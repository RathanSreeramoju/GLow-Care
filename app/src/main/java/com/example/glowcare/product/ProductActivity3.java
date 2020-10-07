package com.example.glowcare.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.glowcare.R;
import com.example.glowcare.ui.home.HomeFragment;

public class ProductActivity3 extends AppCompatActivity {
    Button button,button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product3);
        button=(Button)findViewById(R.id.back3);
        button1=(Button)findViewById(R.id.cart3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductActivity3.this, HomeFragment.class));
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductActivity3.this, "Added to cart", Toast.LENGTH_SHORT).show();

            }
        });
    }
}