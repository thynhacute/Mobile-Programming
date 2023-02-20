package com.example.myloginapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class product_detail extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    private Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        String id = getIntent().getStringExtra("id");
        String name = getIntent().getStringExtra("name");
        int image = Integer.parseInt(getIntent().getStringExtra("id"));

        TextView name_tv = findViewById(R.id.item_name);
        name_tv.setText(name);

        button = findViewById(R.id.callbuton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makephonecall();
            }
        });
    }

    private void makephonecall (){
        String number = "123456789" ;
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= getPackageManager().PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }else{
                String dial = "tel: " + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }else{
            Toast.makeText(this,"something wrong",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makephonecall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
