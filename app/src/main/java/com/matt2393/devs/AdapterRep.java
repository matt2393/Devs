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

public class AdapterRep extends RecyclerView.Adapter<ViewHolderRep> {
    private ArrayList<ModelRep> lista;
    private Context ctx;

    public AdapterRep(ArrayList<ModelRep> lista, Context ctx) {
        this.lista = lista;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolderRep onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rec_rep,parent,false);
        return new ViewHolderRep(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRep holder, int position) {
        holder.nombre.setText(lista.get(position).getName());
        holder.lenguaje.setText(lista.get(position).getLanguage());

        holder.contenedor.setOnClickListener(new View.OnClickListener() {
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
