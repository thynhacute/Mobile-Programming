package com.example.myloginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myloginapplication.screen.MainScreen;
import com.google.android.material.button.MaterialButton;


public class MainActivity extends Activity {

    private EditText username;
    private EditText password;
    private MaterialButton loginBtn;
    public static final String NAME = "NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        loginBtn = (MaterialButton) findViewById(R.id.loginbtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("123456")) {
                    Intent intent = new Intent(MainActivity.this, MainScreen.class);
                    intent.putExtra(NAME, username.getText().toString());
                    startActivity(intent);
                    finish();
                } else
                    Toast.makeText(MainActivity.this, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("This is the pause");
        username.getText().clear();
        password.getText().clear();
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("This is the START");
    }


}