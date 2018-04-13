package com.matt2393.devs;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by matt2393 on 11-04-18.
 * ViewHolder de los repositorios
 * contiene dos Textos y el cardView para escuchar si evento Click
 */

public class ViewHolderRep extends RecyclerView.ViewHolder {
    public CardView contenedor;
    public TextView nombre,lenguaje;
    public ViewHolderRep(View itemView) {
        super(itemView);
        contenedor=itemView.findViewById(R.id.contendor_rep);
        nombre=itemView.findViewById(R.id.nombre_rep);
        lenguaje=itemView.findViewById(R.id.lenguaje_rep);
    }
}
