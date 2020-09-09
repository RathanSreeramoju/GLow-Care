package com.example.glowcare.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.glowcare.R;
import com.example.glowcare.ui.home.HomeFragment;

public class ProductActivity2 extends AppCompatActivity {
    Button button,button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product2);
        button=(Button)findViewById(R.id.bac);
        button1=(Button)findViewById(R.id.cart9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductActivity2.this, HomeFragment.class));
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductActivity2.this, "Added to cart", Toast.LENGTH_SHORT).show();

            }
        });
    }
}