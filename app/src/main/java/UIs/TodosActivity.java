package UIs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.trabalho.trabalho_3.R;


import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import com.trabalho.trabalho_3.ui.Adapters.TodoAdapter;
import com.trabalho.trabalho_3.ui.Models.Todo;

import UIs.DetalheTodoActivity;


public class TodosActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{

    private List<Todo> todos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/todos", null,this,this);
        queue.add(requisicao);
        getSupportActionBar().hide();;
        getWindow() .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @Override
    public void onResponse(JSONArray response) {
        //ScrollView sv = findViewById(R.id.scrollTodos);
       // LinearLayout ll = findViewById(R.id.lvTodos);
        todos.clear();
        try {
            for (int i=0; i< response.length(); i++){
                todos.add(new Todo(response.getJSONObject(i)));
            }

            RecyclerView rv = findViewById(R.id.rvTodos);
            TodoAdapter adapter = new TodoAdapter(todos);
            //vertical
            LinearLayoutManager llm = new LinearLayoutManager(this);
            // horizontal
            LinearLayoutManager llm1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            rv.setLayoutManager(llm);
            rv.setAdapter(adapter);
            /*String txt = "";
            for (Todo td : todos){
                Button btn = new Button(this);
                btn.setText("Id: "+td.getId());
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), DetalheTodoActivity.class);
                        intent.putExtra("obj", td);
                        startActivity(intent);
                    }
                });
                ll.addView(btn);
            }

             */
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Deu Erro:"+error.getMessage(), Toast.LENGTH_LONG).show();
    }
}