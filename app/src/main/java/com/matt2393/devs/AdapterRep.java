package com.matt2393.devs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

    /**
     * Método sobreescrito de la clase Adapter
     * Se usa para crear un ViewHolder que controle las vistas
     * que llenaran al RecyclerView
     * @param parent ViewGroup donde se llenara la vista creada
     * @param viewType tipo de vista que se desea mostrar (no usado en el curso)
     * @return retorna un objeto de una Clase que extienda de ViewHolder
     */
    @NonNull
    @Override
    public ViewHolderRep onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rec_rep,parent,false);
        return new ViewHolderRep(vista);
    }

    /**
     * Método Sobreescrito de la Clase Adapter
     * Se llema este método las veces que indica getItemCount
     * en este método se puede cambiar el comportamiento de cada item
     * del RecyclerView
     * @param holder ViewHolder declarado al crear la clase
     *               el cual controla la vista de un item del RecyclerView
     * @param position posicion que se mostrara, desde 0 a getItemCount() - 1
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolderRep holder, int position) {
        holder.nombre.setText(lista.get(position).getName());
        holder.lenguaje.setText(lista.get(position).getLanguage());

        final int p=position;
        holder.contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Intent.ACTION_VIEW,
                        Uri.parse(lista.get(p).getClone_url()));
                ctx.startActivity(in);
            }
        });
    }

    /**
     * Método Sobreescrito de la clase Adapter
     * Obtiene la cantidad de items que tendra el RecyclerView
     * @return entero que es la cantidad
     */
    @Override
    public int getItemCount() {
        return lista.size();
    }
}
