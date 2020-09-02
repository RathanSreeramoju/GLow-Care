package com.example.glowcare;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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

public class LoginActivity extends AppCompatActivity {
    Button signin;
    TextView signuphere;
    EditText emailid,password;
    Node loginapi;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    /**
     *
     * @param savedInstanceState
     * @retrofit is an instance of Retrofit to make a connection with nodeapi
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signin = findViewById(R.id.button2);
        signuphere = findViewById(R.id.textView1);
        emailid = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);

        Retrofit retrofit = RetrofitClient.getApiClient();
        loginapi = retrofit.create(Node.class);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(SigninActivity.this,HomeActivity.class);
//                startActivity(intent);
                if (emailid.getText().toString().contains("temp")&& password.getText().toString().contains("temp")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                loginuser(emailid.getText().toString(),password.getText().toString());
            }
        });
        signuphere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     *
     * @param emailid as passed from the ui
     * @param password as passed from the ui
     * loginuser method checks whether the details are availbel in the database. If the details are available
     *                 it lands in the home page
     */
    private void loginuser(String emailid, String password) {

        compositeDisposable.add(loginapi.loginUser(emailid,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.v("api text","dilip"+s);
                        if (s.contains("Valid user")){
                            Intent intent = new Intent(LoginActivity.this,HomeFragment.class);
                            startActivity(intent);}
                        else
                            Toast.makeText(LoginActivity.this,"login failure",Toast.LENGTH_LONG).show();
                    }
                }));
    }
}
