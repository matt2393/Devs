package com.matt2393.devs;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by matt2393 on 11-04-18.
 */

public class DevsVolley {
    private static DevsVolley instance;
    private RequestQueue cola;
    private Context ctx;

    private DevsVolley(Context ctx){
        this.ctx=ctx;
        cola=getCola();
    }

    private RequestQueue getCola() {
        if(cola==null)
            cola= Volley.newRequestQueue(ctx);
        return cola;
    }
    public static synchronized DevsVolley getInstance(Context ctx){
        if(instance==null)
            instance=new DevsVolley(ctx);
        return instance;
    }
    public void add(Request req){
        getCola().add(req);
    }
}
