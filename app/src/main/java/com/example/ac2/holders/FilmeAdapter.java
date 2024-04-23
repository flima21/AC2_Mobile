package com.example.ac2.holders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ac2.R;
import com.example.ac2.models.Filme;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import android.os.Handler;
import android.widget.Toast;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeHolder> {
    private final ArrayList<Filme> filmes;

    public FilmeAdapter(ArrayList<Filme> filmes) {
        this.filmes = filmes;
    }

    @NonNull
    @Override
    public FilmeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FilmeHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item_film,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeHolder holder, int position) {
        Filme filme = filmes.get(position);

        holder.nomeFilme.setText(filme.getTitulo());
        holder.diretorFilme.setText(filme.getDiretor());
        holder.anoFilme.setText((filme.getAno()+""));

        new Thread(() -> {
            URL url = null;

            try {
                url = new URL(filme.getImagems());
                final Bitmap bmp;

                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

                new Handler(Looper.getMainLooper()).post(() -> {
                    holder.imageView.setImageBitmap(bmp);
                });
            }
            catch(IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        holder.button.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), filme.getSinopse(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return filmes != null ? filmes.size() : 0;
    }
}
