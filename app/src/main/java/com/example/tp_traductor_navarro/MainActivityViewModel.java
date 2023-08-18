package com.example.tp_traductor_navarro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();

    }
    public void enviar(String texto){
        if(texto.length()==0){
            Toast.makeText(context, "Debe ingresar una palabra", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent= new Intent(context, TraduccionActivity.class);
            intent.putExtra("texto",texto);
            intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

    }
}
