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
import com.trabalho.trabalho_3.ui.Adapters.AlbumAdapter;
import com.trabalho.trabalho_3.ui.Adapters.PostAdapter;
import com.trabalho.trabalho_3.ui.Models.Album;
import com.trabalho.trabalho_3.ui.Models.Post;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class AlbumsActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{

    private List<Album> album = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/albums", null,this,this);
        queue.add(requisicao);
        getSupportActionBar().hide();;
        getWindow() .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
    @Override
    public void onResponse(JSONArray response) {
        album.clear();
        try {
            for (int i=0; i< response.length(); i++){
                album.add(new Album(response.getJSONObject(i)));
            }

            RecyclerView rv = findViewById(R.id.rvAlbum);
            AlbumAdapter adapter = new AlbumAdapter(album);

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
}