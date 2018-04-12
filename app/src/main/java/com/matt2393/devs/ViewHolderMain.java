package com.matt2393.devs;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by matt2393 on 11-04-18.
 */

public class ViewHolderMain extends RecyclerView.ViewHolder {
    public LinearLayout conten;
    public ImageView imagen;
    public TextView nombre;
    public ViewHolderMain(View itemView) {
        super(itemView);
        conten=itemView.findViewById(R.id.contenedor_dev);
        imagen=itemView.findViewById(R.id.imagen_dev);
        nombre=itemView.findViewById(R.id.nombre_dev);

    }
}
