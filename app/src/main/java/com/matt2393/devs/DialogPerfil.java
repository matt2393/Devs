package com.matt2393.devs;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by matt2393 on 11-04-18.
 */

public class DialogPerfil extends DialogFragment {

    ImageView imagen;
    TextView nombre;
    Button url,repo,cerrar;
    ModelDev devs;


    /**
     * Método sobreescrito del padre
     * para crear el dialogo, creamos un AlertDialog.Builder,
     * creamos y pasamos la vista a este AlertDialog.Builder
     * creamos y retornamos el dialogo
     * @param savedInstanceState
     * @return
     */
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alert=new AlertDialog.Builder(getContext());

        View vista=getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_perfil,null);

        imagen=vista.findViewById(R.id.imagen_perfil);
        nombre=vista.findViewById(R.id.user_perfil);
        url=vista.findViewById(R.id.link_perfil);
        repo=vista.findViewById(R.id.repos_perfil);
        cerrar=vista.findViewById(R.id.cerrar_perfil);

        devs=getArguments().getParcelable("DEV");

        GlideApp.with(getActivity())
                .load(devs.getAvatar_url())
                .into(imagen);

        nombre.setText(devs.getLogin());

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Funcion para poder abrir un navegador, con la uri que se le pasa
                 */
                Intent in=new Intent(Intent.ACTION_VIEW,
                        Uri.parse(devs.getHtml_url()));
                startActivity(in);
            }
        });

        repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * usando la Interface para notificar al activity que
                 * se quiere cambiar de fragment y cerrar el dialogo
                 */
                ((ChangeData)getActivity()).cambiar(devs);



                /**
                 * Otra forma de cambiar de fragment
                 */
                /*
                Bundle bn=new Bundle();
                bn.putInt("OPCION",1);
                bn.putParcelable("DATO",devs);

                FragmentMain fr=new FragmentMain();
                fr.setArguments(bn);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contenedor_main,fr)
                        .addToBackStack(null)
                        .commit();
                */
                dismiss();
            }
        });


        alert.setView(vista);

        return alert.create();
    }

    /**
     * Método sobreescrito de la clase padre DialogFragment
     * se llama cuando la vista ya a sido creada.
     * editamos aca para hacer que el fondo del dialogo sea transparente
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
