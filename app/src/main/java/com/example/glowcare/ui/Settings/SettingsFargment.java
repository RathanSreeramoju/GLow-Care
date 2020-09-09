package com.example.glowcare.ui.Settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.glowcare.Contact;
import com.example.glowcare.Items;
import com.example.glowcare.LoginActivity;
import com.example.glowcare.R;
import com.example.glowcare.ui.home.HomeFragment;

/**
 * Settings fragment shows the options to sign out and contact us
 */
public class SettingsFargment extends Fragment {
    Button button1, button2, button3;
    View view;

    /**
     *settings activity has been inflated
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_settings, container, false);
        button2 = (Button) view.findViewById(R.id.contact);
        button3 = (Button) view.findViewById(R.id.signout);

        button2.setOnClickListener(new View.OnClickListener() {
            /**
             * onclick event moves to another fragment when button clicked
             * @param v
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsFargment.this.getActivity(), Contact.class));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            /**
             * onclick event moves to another fragment when button clicked
             * @param v
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsFargment.this.getActivity(), LoginActivity.class));
            }
        });
        return view;
    }
}

