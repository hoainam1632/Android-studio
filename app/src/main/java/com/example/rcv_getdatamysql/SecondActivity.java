package com.example.rcv_getdatamysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {
    private TextView txtHeader;
    private  TextView txtContent;
    private ImageView img2;
    private Button btnBack;
    public String getName, getImg, getcontent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtHeader = (TextView) findViewById(R.id.txtheader);
        txtContent = (TextView) findViewById(R.id.txtcontent);
        img2 = (ImageView) findViewById(R.id.imgView);
        btnBack = (Button) findViewById(R.id.btn_back);
        getdata();
    }
    private void getdata() {
        Intent intent = getIntent();
        if (intent.hasExtra("name")){
            String id = intent.getStringExtra("name");
            String url = "http://192.168.1.41/ThongTin.php?name="+id;
            getJson(url);
        }else Toast.makeText(this, "No has data", Toast.LENGTH_SHORT).show();
    }
    public void BackMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    protected  void getJson(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++ ){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                        getName = object.getString("name");
                                        getcontent = object.getString("NoiDung");
                                        getImg = object.getString("img");
                                        //set data from Json
                                    txtHeader.setText(getName);
                                    txtContent.setText(getcontent);
                                    Picasso.get().load(getImg)
                                            .into(img2);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SecondActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
}
