package com.example.ac2.holders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ac2.R;

public class FilmeHolder extends RecyclerView.ViewHolder {
    TextView nomeFilme;
    TextView anoFilme;
    TextView diretorFilme;
    ImageView imageView;
    Button button;
    public FilmeHolder(View item) {
        super(item);

        nomeFilme = item.findViewById(R.id.nomeFilme);
        anoFilme = item.findViewById(R.id.anoFilme);
        diretorFilme = item.findViewById(R.id.diretorFilme);
        imageView = item.findViewById(R.id.imageView);
        button = item.findViewById(R.id.button);
    }
}
