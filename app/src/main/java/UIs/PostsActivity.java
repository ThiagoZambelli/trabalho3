package UIs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.trabalho.trabalho_3.R;
import com.trabalho.trabalho_3.ui.Adapters.PostAdapter;
import com.trabalho.trabalho_3.ui.Adapters.TodoAdapter;
import com.trabalho.trabalho_3.ui.Models.Post;
import com.trabalho.trabalho_3.ui.Models.Todo;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class PostsActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{

    private List<Post> post = new ArrayList<>();

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
        post.clear();
        try {
            for (int i=0; i< response.length(); i++){
                post.add(new Post(response.getJSONObject(i)));
            }

            RecyclerView rv = findViewById(R.id.rvPost);
            PostAdapter adapter = new PostAdapter(post);

            LinearLayoutManager llm = new LinearLayoutManager(this);
            LinearLayoutManager llm1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            rv.setLayoutManager(llm);
            rv.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Deu Erro:"+error.getMessage(), Toast.LENGTH_LONG).show();
    }
        /*EditText ed1 = findViewById(R.id.posts1);
        try {
            ed1.setText(response.length()+response.getJSONObject(1).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Deu Erro:"+error.getMessage(), Toast.LENGTH_LONG).show();*/

}