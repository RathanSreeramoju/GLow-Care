package com.example.glowcare.product;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.glowcare.R;
import com.example.glowcare.ui.home.HomeFragment;

public class ProductActivity1 extends AppCompatActivity {
    Button button,button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product1_);
        button = (Button) findViewById(R.id.back);
        button1 = (Button) findViewById(R.id.cart1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductActivity1.this, HomeFragment.class));
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductActivity1.this, "Added to cart", Toast.LENGTH_SHORT).show();
            }
        });
    }
}