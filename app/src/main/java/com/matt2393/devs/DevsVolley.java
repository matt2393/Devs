package com.matt2393.devs;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by matt2393 on 11-04-18.
 * Clase Singleton para crear la cola de Volley
 */

public class DevsVolley {
    private static DevsVolley instance;
    private RequestQueue cola;
    private Context ctx;

    /**
     * Constructor privado para q no se puede acceder desde fuera de la clase
     * @param ctx contexrto que sirve para crear la cola
     */
    private DevsVolley(Context ctx){
        this.ctx=ctx;
        cola=getCola();
    }

    /**
     * Se obtiene la cola de peticiones
     * @return retorna la cola (RequestQueue)
     */
    private RequestQueue getCola() {
        if(cola==null)
            cola= Volley.newRequestQueue(ctx);
        return cola;
    }

    /**
     * Método estatico para obtener la instancia de la clase
     * @param ctx contexto que sirve para crear la cola
     * @return retorna la instancia de la clase, si existe retorna esa
     *          sino existe, la crea y la retorna
     */
    public static synchronized DevsVolley getInstance(Context ctx){
        if(instance==null)
            instance=new DevsVolley(ctx);
        return instance;
    }

    /**
     * Método para añadir Peticiones a la cola.
     * @param req Peticion que se añadira
     */
    public void add(Request req){
        getCola().add(req);
    }
}
