package UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.trabalho.trabalho_3.R;

import com.trabalho.trabalho_3.ui.Models.Todo;

public class DetalheTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_todo);
        getSupportActionBar().hide();;
        getWindow() .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent =getIntent();
        TextView tv = findViewById(R.id.tvID);
        Todo todo = intent.getParcelableExtra("obj");
        tv.setText(""+todo.getId());
        tv = findViewById(R.id.tvTitulo);
        tv.setText(todo.getTitle());
    }
}