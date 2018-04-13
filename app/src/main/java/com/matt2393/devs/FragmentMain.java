package com.matt2393.devs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by matt2393 on 11-04-18.
 * Fragment que contendra un solo recyclerView que usaremos 2 veces
 */

public class FragmentMain extends Fragment {
    RecyclerView rec;

    /**
     * Método sobreescrito del padre Fragment
     * para crear la vista del Fragment
     * @param inflater objeto para inflar la vista
     * @param container contenedor ViewGroup donde se colocara la vista
     * @param savedInstanceState Datos que se le envian a esta funcion (no se toco en las clases)
     * @return retorna un View que sera la vista del Fragment
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_main,container,false);
        rec=vista.findViewById(R.id.rec_main);

        int op=getArguments().getInt("OPCION",0);

        if(op==0){
            peticionDev();
            getActivity().setTitle("Devs");
        }
        else{
            ModelDev dd=getArguments().getParcelable("DATO");
            getActivity().setTitle(dd.getLogin());
            peticionRep(dd.getRepos_url());
        }



        return vista;
    }

    /**
     * Petición Get usando Volley para obtener la lista de desarrolladores
     * de github
     * se obtiene un JSONArray por lo que se debe recorrer el JSONArray y obtener
     * cada uno de sus elementos que seran JSONObject
     * en el JSONObject se puede acceder a sus elementos mediante su clave
     *
     * es necesario usar un Try Catch porque el uso de cualquier JSON puede ocasionar
     * una excepción
     */
    private void peticionDev(){
         JsonArrayRequest req=new JsonArrayRequest(
                Request.Method.GET, "https://api.github.com/users",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        rec.setLayoutManager(new GridLayoutManager(getActivity(),3));
                        ArrayList<ModelDev> lista=new ArrayList<>();
                        for(int i=0;i<response.length();i++){
                            try {
                                JSONObject obj=response.getJSONObject(i);
                                ModelDev d=new ModelDev();
                                d.setId(obj.getInt("id"));
                                d.setLogin(obj.getString("login"));
                                d.setAvatar_url(obj.getString("avatar_url"));
                                d.setHtml_url(obj.getString("html_url"));
                                d.setRepos_url(obj.getString("repos_url"));
                                lista.add(d);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        rec.setAdapter(new AdapterMain(lista,getActivity()));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),"Error al recibir datos DEvs",Toast.LENGTH_LONG).show();
                        Log.e("DEVS",error.getMessage());
                    }
                }
        );

         DevsVolley.getInstance(getActivity()).add(req);
    }

    /**
     * Petición para obtener JSONArray de los repositorios de un desarrollador
     * @param url unico de cada desarrollador
     *
     * Se comporta de la misma manera que la otra petición
     */
    private void peticionRep(String url){
        JsonArrayRequest req=new JsonArrayRequest(
                Request.Method.GET, url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        rec.setLayoutManager(new LinearLayoutManager(getContext()));
                        ArrayList<ModelRep> lista=new ArrayList<>();
                        for(int i=0;i<response.length();i++){
                            try {
                                JSONObject obj=response.getJSONObject(i);
                                ModelRep d=new ModelRep();
                                d.setName(obj.getString("name"));
                                d.setLanguage(obj.getString("language"));
                                d.setClone_url(obj.getString("clone_url"));
                                lista.add(d);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        rec.setAdapter(new AdapterRep(lista,getActivity()));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),"Error al recibir datos",Toast.LENGTH_LONG).show();
                    }
                }
        );

        DevsVolley.getInstance(getActivity()).add(req);
    }
}
