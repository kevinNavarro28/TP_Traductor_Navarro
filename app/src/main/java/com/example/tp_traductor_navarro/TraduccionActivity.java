package com.example.tp_traductor_navarro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.tp_traductor_navarro.Modelo.Palabra;
import com.example.tp_traductor_navarro.databinding.ActivityTraduccionBinding;

public class TraduccionActivity extends AppCompatActivity {

    private TraduccionActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActivityTraduccionBinding binding= ActivityTraduccionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(TraduccionActivityViewModel.class);
        Intent intent= getIntent();
        String p=(String) intent.getStringExtra("texto");
        mv.getPalabraM().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra pal) {
                binding.EtTraducido.setText(pal.getIngles());
                binding.Foto.setImageResource(pal.getFoto());

            }
        });
        mv.comparar(p);

    }
}