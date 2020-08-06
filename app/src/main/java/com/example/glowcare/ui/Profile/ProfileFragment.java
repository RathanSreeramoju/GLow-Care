package com.example.glowcare.ui.Profile;

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

public class ProfileFragment extends Fragment {


    View view;
    Button button;
    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_profile, container, false);
        button = (Button) view.findViewById(R.id.SaveChanges);
        context = getContext();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Profile Saved", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}
