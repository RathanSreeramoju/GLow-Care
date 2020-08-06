package com.example.glowcare;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button button1,button2;
    EditText edit1,edit2;
    TextView text1, text2;
    int counter = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Variables assignment
        button1 = (Button)findViewById(R.id.button2);
        edit1 = (EditText)findViewById(R.id.editText);
        edit2 = (EditText)findViewById(R.id.editText2);
        button2 = (Button)findViewById(R.id.button2);
        text1 = (TextView)findViewById(R.id.textView1);

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        text1.setVisibility(View.GONE);
        //Method to compare user credentials when Login is clicked
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit1.getText().toString().equals("admin") &&
                        edit2.getText().toString().equals("password")) {
                    Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    // to be continued ...
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                    text1.setVisibility(View.VISIBLE);
                    text1.setBackgroundColor(Color.RED);
                    counter--;
                    text1.setText(Integer.toString(counter));
                    if (counter == 0) {
                        button1.setEnabled(false);
                    }
                }
            }
        });
        //Method to be executed when Cancel button is clicked
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
