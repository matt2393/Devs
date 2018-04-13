package com.matt2393.devs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by matt2393 on 11-04-18.
 * Clase Adapter para llenar el RecyclerView principal
 */

public class AdapterMain extends RecyclerView.Adapter<ViewHolderMain> {
    /**
     * Array de ModelDevs para llenar el RecyclerView con
     * estos datos
     */
    private ArrayList<ModelDev> lista;


    /**
     * FragmentActivity (Actividad), para usar Glide
     * y ademas para poder usar getSupportFragmentManager
     * para mostrar el DialogPerfil
     */
    private FragmentActivity act;


    /**
     * Constructor del Adapter
     * @param lista Array que contiene los datos a llenar
     * @param act FragmentActivity para usar Glide y FragmentManager
     */
    public AdapterMain(ArrayList<ModelDev> lista, FragmentActivity act) {
        this.lista = lista;
        this.act = act;
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
    public ViewHolderMain onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rec_main,parent,false);
        return new ViewHolderMain(vista);
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
    public void onBindViewHolder(@NonNull ViewHolderMain holder, int position) {
        holder.nombre.setText(lista.get(position).getLogin());
        GlideApp.with(act)
                .load(lista.get(position).getAvatar_url())
                .into(holder.imagen);
        final int p=position;


        holder.conten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPerfil dialogPerfil=new DialogPerfil();
                Bundle bn=new Bundle();
                bn.putParcelable("DEV",lista.get(p));
                dialogPerfil.setArguments(bn);
                dialogPerfil.show(act.getSupportFragmentManager(),"DialogPerfil");
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
