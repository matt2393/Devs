package com.matt2393.devs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by matt2393 on 11-04-18.
 */

public class AdapterMain extends RecyclerView.Adapter<ViewHolderMain> {

    private ArrayList<ModelDev> lista;
    private Context ctx;

    public AdapterMain(ArrayList<ModelDev> lista, Context ctx) {
        this.lista = lista;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolderMain onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rec_main,parent,false);
        return new ViewHolderMain(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMain holder, int position) {
        holder.nombre.setText(lista.get(position).getLogin());
        GlideApp.with(ctx)
                .load(lista.get(position).getAvatar_url())
                .into(holder.imagen);

        holder.conten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
