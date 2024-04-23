package com.example.ac2;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ac2.holders.FilmeAdapter;
import com.example.ac2.models.Filme;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FilmeAdapter filmeAdapter;

    public ArrayList<Filme> filmes;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        filmes = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycleViewFilme);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getFilmes();
    }

    public void startRecycle() {
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);

        filmeAdapter = new FilmeAdapter(filmes);

        recyclerView.setAdapter(filmeAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
    }
    public void getFilmes() {
        Filme filmes_one   = new Filme("Coração Valente","Sinopse do filme coração valente","Mel Gibbson",1995,"https://br.web.img3.acsta.net/medias/nmedia/18/90/62/76/20105399.jpg");
        Filme filmes_two   = new Filme("O ultimo dos moicanos","Olá sou sinopse do ultimo...", "Michal Mann",1992,"https://upload.wikimedia.org/wikipedia/pt/e/e9/The_Last_of_the_Mohicans_%281992%29.jpg");
        Filme filmes_three = new Filme("Forrest Gump","Olá sou sinopse do forrest","Robert Zemeckis",1994,"https://br.web.img3.acsta.net/c_310_420/medias/nmedia/18/87/30/21/19874092.jpg");

        filmes.add(filmes_one);
        filmes.add(filmes_two);
        filmes.add(filmes_three);
        startRecycle();
    }
}