package com.example.glowcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.glowcare.ui.home.HomeFragment;

/**
 * Items class shows the items previously bought
 */
public class Items extends AppCompatActivity {
    Button button;

    /**
     * sets the layout items_previously_bought
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_you_previously_bought);

    }
}
