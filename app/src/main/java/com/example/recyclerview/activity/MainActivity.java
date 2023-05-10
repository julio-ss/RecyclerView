package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.adapter.Adapter;
import com.example.recyclerview.activity.model.Filme;
import com.example.recyclerview.activity.model.RecyclerItemClickListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //listar filmes
        this.criarFilmes();

        //confirando adapter
        Adapter adapter = new Adapter(listaFilmes);

        //configurando RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(),"Item pressionado " + filme.getTituloFilme(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(),"Clique longo " + filme.getTituloFilme(),Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
                )
        );
    }

    public void criarFilmes(){

        Filme filme = new Filme("A Chegada", "Ficção", "2016");
        listaFilmes.add(filme);

        filme = new Filme("A Origem", "Ficção", "2010");
        listaFilmes.add(filme);

        filme = new Filme("Duna", "Ficção", "2021");
        listaFilmes.add(filme);

        filme = new Filme("Perdido em Marte", "Ficção", "2015");
        listaFilmes.add(filme);

        filme = new Filme("Aniquilação", "Ficção", "2018");
        listaFilmes.add(filme);

        filme = new Filme("Blade Runner 2049", "Ficção", "2017");
        listaFilmes.add(filme);

        filme = new Filme("2001 Uma odisseia no espaço", "Ficção", "1968");
        listaFilmes.add(filme);

        filme = new Filme("No limite do amanhã", "Ficção", "2014");
        listaFilmes.add(filme);
    }
}