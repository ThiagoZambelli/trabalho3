package com.trabalho.trabalho_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;

public class PostsActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/posts", null,this,this);
        queue.add(requisicao);
        getSupportActionBar().hide();;
        getWindow() .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
    @Override
    public void onResponse(JSONArray response) {
        EditText ed1 = findViewById(R.id.posts1);
        try {
            ed1.setText(response.length()+response.getJSONObject(1).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        EditText ed2 = findViewById(R.id.posts2);
        try {
            ed2.setText(response.length()+response.getJSONObject(2).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        EditText ed3 = findViewById(R.id.posts3);
        try {
            ed3.setText(response.length()+response.getJSONObject(3).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Deu Erro:"+error.getMessage(), Toast.LENGTH_LONG).show();
    }
}