package com.example.glowcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glowcare.ui.home.HomeFragment;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class SignUpActivity extends AppCompatActivity {
    Button signup;
    TextView signinhere;
    EditText emailid,password;
    Node loginapi;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signup = findViewById(R.id.Signup);
        signinhere = findViewById(R.id.signin);
        emailid = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        Retrofit retrofit = RetrofitClient.getApiClient();
        loginapi = retrofit.create(Node.class);
        signup.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v
             */
            @Override
            public void onClick(View v) {
                register(emailid.getText().toString(),password.getText().toString());
            }
        });
        signinhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     *
     * @param emailidpass
     * @param passwordpass
     * calls register api with nodejs and creates a new login when a new email id entered
     */
    private void register(String emailidpass, String passwordpass) {

        Log.v("rathan","inouts"+emailidpass+passwordpass);
        compositeDisposable.add(loginapi.registerUser(emailidpass,passwordpass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.v("api text","rathan"+s);
                        if (s.contains("Register Success")){
                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(intent);}
                        else
                            Toast.makeText(SignUpActivity.this,"User Already exists",Toast.LENGTH_LONG).show();
                    }
                }));
    }

}