package com.matt2393.devs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

/**
 * Created by matt2393 on 11-04-18.
 */

public class DialogPerfil extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alert=new AlertDialog.Builder(getContext());

        View vista=getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_perfil,null);

        alert.setView(vista);

        return alert.create();
    }
}
