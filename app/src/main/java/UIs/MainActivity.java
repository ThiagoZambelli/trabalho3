package UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.trabalho.trabalho_3.R;

public class MainActivity extends AppCompatActivity {
    private Button todosB;
    private Button postsB;
    private Button albumsB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();;
        getWindow() .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        todosB = (Button) findViewById(R.id.todosB);
        postsB = (Button) findViewById(R.id.postsB);
        albumsB = (Button) findViewById(R.id.albumsB);


        todosB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todosBActivity();
            }
        });
        postsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                postsBActivity();
            }
        });
        albumsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                albumsBActivity();
            }
        });

    }

    private void albumsBActivity() {
        startActivity(new Intent(MainActivity.this, AlbumsActivity.class));
    }

    private void postsBActivity() {
        startActivity(new Intent(MainActivity.this, PostsActivity.class));
    }

    private void todosBActivity() {
        startActivity(new Intent(MainActivity.this, TodosActivity.class));
    }



}
