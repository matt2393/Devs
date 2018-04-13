package com.matt2393.devs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ChangeData {

    /**
     * Método sobreescrito del padre
     * Pertenece al ciclo de vida del Activity
     * sirve para crear todas las  vistas o iniciar todo
     * @param savedInstanceState paquete que obtiene valores cuando se recupera (no se toco en clases)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creando un Bundle y mandando la opcion 0
        Bundle bn=new Bundle();
        bn.putInt("OPCION",0);

        //creamos el fragment y mandamos el bundle
        FragmentMain fr=new FragmentMain();
        fr.setArguments(bn);
        //mostramos el fragment en nuestro activiry
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor_main,fr)
                .commit();
    }

    /**
     * Método sobreescrito del padre que se llama
     * cuando el usuario presiona la tecla de Atrás
     */
    @Override
    public void onBackPressed() {

        //antes de hacer lo que hace este método preguntamos
        //si existen fragments en la pila de fragment, si existen lo saca
        //sino ejecuta el atras original de la aplicación
        if(getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }
        else {
            super.onBackPressed();
        }
    }

    /**
     * Método sobreescrito de la interface ChangeData
     * se llama cuando el usuario presiona el botón del dialogo
     * para abrir los repositorios
     * @param d Clase ModelDev que se manda para mostrar
     *          el repositorio de este en el fragment
     */
    @Override
    public void cambiar(ModelDev d) {
        //se crea el bundle para pasar la opcion y tambien el dato
        Bundle bn=new Bundle();
        bn.putInt("OPCION",1);
        bn.putParcelable("DATO",d);

        //se crea el fragment y se manda los datos
        FragmentMain fr=new FragmentMain();
        fr.setArguments(bn);
        //se cambia el fragment que estaba por este nuevo
        //es el mismo pero tendra un distinto comportamiento
        //dos fragments iguales que se comportan diferente

        //tambien se llama al metodo addToBackStack()
        //para poner en la pila de fragment a este.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor_main,fr)
                .addToBackStack(null)
                .commit();

    }
}
