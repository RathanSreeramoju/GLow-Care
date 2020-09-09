package com.example.glowcare.ui.Profile;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glowcare.R;
import com.example.glowcare.ui.home.HomeAdapter;
import com.example.glowcare.ui.home.HomeModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {


    ImageView pimageView;
    TextView txt_name,txt_email;
    UserProfile  profile;
    private FirebaseFirestore db;

    public ProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);


    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pimageView = view.findViewById(R.id.profile_image);
        txt_name = view.findViewById(R.id.p_name);
        txt_email = view.findViewById(R.id.p_email);
        db = FirebaseFirestore.getInstance();

        db.collection("Profile").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if(task.isSuccessful()){

                            for(DocumentSnapshot snapshot:task.getResult()){

                                profile = new UserProfile(snapshot.getId(),
                                        snapshot.getString("Name"),
                                        snapshot.getString("Email"),
                                        snapshot.getString("imageUrl")
                                );

                            }

                            Picasso.get().load(profile.getImageUrl()).into(pimageView);
                            txt_name.setText("Name :"+profile.getName());
                            txt_email.setText("Email :"+profile.getEmail());
                        }
                    }
                });





    }





// this method used to display profile image, name and email
    public void generateView()
    {
        Picasso.get().load(profile.getImageUrl()).into(pimageView);
        txt_name.setText("Name :"+profile.getName());
        txt_email.setText("Email :"+profile.getEmail());


    }
}
