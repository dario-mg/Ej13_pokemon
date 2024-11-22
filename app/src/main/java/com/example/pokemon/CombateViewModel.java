package com.example.pokemon;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CombateViewModel extends AndroidViewModel {
    private Executor executor;
    private CombateModel combatiente;

    public MutableLiveData<Pokemon> pokemonAliado = new MutableLiveData<>();
    public MutableLiveData<Pokemon> pokemonEnemigo = new MutableLiveData<>();

    public CombateViewModel(@NonNull Application application) {
        super(application);
        executor = Executors.newSingleThreadExecutor();
        combatiente = new CombateModel();
    }

    public void combate(Pokemon pokemon1, Pokemon pokemon2) {
        CombateModel.EnviarAlCombate combate = new CombateModel.EnviarAlCombate(pokemon1, pokemon2);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                combatiente.combate(combate, new CombateModel.Callback() {
                    @Override
                    public void cuandoEsteCombate(Pokemon uno, Pokemon dos) {
                        pokemonAliado.postValue(uno);
                        pokemonEnemigo.postValue(dos);
                    }

                });
            }
        });
    }
}
