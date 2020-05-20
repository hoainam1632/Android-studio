package com.example.rcv_getdatamysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {
    private TextView txtHeader;
    private ImageView img2;
    String getName, getImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtHeader = (TextView) findViewById(R.id.txtheader);
        img2 = (ImageView) findViewById(R.id.imgView);
        getdata();
        setData();
    }
    private void getdata() {
        Intent intent = getIntent();
        if (intent.hasExtra("name") && intent.hasExtra("img")){
            getName = intent.getStringExtra("name");
            getImg = intent.getStringExtra("img");
        }else Toast.makeText(this, "No has data", Toast.LENGTH_SHORT).show();
    }
    private void setData() {
        txtHeader.setText(getName);
        Picasso.get().load(getImg)
                .resize(1100,600)
                .into(img2);
    }
}
