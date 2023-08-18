package com.example.tp_traductor_navarro;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp_traductor_navarro.Modelo.Palabra;

import java.util.ArrayList;
import java.util.List;

public class TraduccionActivityViewModel extends AndroidViewModel {
    private List<Palabra> lista=new ArrayList<>();



    private Context context;
    private MutableLiveData<Palabra> traducido;
    /*= new Palabra("hola", "hola", R.drawable.error);*/
    public TraduccionActivityViewModel(@NonNull Application application) {
        super(application);

        this.context= application.getApplicationContext();
        lista.add(new Palabra("gato","cat",R.drawable.gato));
        lista.add(new Palabra("perro", "dog", R.drawable.perro));
        lista.add(new Palabra("casa", "house", R.drawable.casa));
        lista.add(new Palabra("auto","car", R.drawable.auto));
        lista.add(new Palabra("bicicleta", "bike", R.drawable.bici));


    }
    public void comparar(String texto) {
        boolean found = false;
        for (Palabra palabra : lista
        ) {
            if (palabra.getCastellano().equals(texto)) {
                traducido.setValue(palabra);
                found = true;
                break;

            }

        }
        if (!found) {
            traducido.setValue(new Palabra("No se encontro la palabra", "No se encontro la palabra", R.drawable.error));
        }
    }


    public LiveData<Palabra> getPalabraM() {

        if (traducido == null) {

            traducido = new MutableLiveData<Palabra>();
        }
        return traducido;
    }
}
