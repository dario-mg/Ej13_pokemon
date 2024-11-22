package com.example.pokemon;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

public class CombateView extends AppCompatActivity {
    private ListPokemon pokemons;
    private Pokemon pokemon1, pokemon2;
    private Button botonAtacar;

    private TextView tvPokemonAliado, tvPokemonEnemigo, textoGanador;
    private ImageView imagenAliado, imagenEnemigo, imagenGanador;
    private ProgressBar barraAliado, barraEnemigo;
    private View fondoGanador;


    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combate_pokemon);

        // Inicializar vistas
        imagenAliado = findViewById(R.id.imagenAliado);
        imagenEnemigo = findViewById(R.id.imagenEnemigo);
        tvPokemonAliado = findViewById(R.id.textoAliado);
        tvPokemonEnemigo = findViewById(R.id.textoEnemigo);
        barraAliado = findViewById(R.id.barraProgresoAliado);
        barraEnemigo = findViewById(R.id.barraProgresoEnemigo);
        botonAtacar = findViewById(R.id.botonAtacar);
        textoGanador = findViewById(R.id.textoGanador);
        fondoGanador = findViewById(R.id.fondoGanador);
        imagenGanador = findViewById(R.id.imageGanador);

        // ViewModel
        CombateViewModel viewModelCombatiente = new ViewModelProvider(this).get(CombateViewModel.class);

        // Obtener índices del intent
        int pokemon1Index = getIntent().getIntExtra("pokemon1Index", -1);
        int pokemon2Index = getIntent().getIntExtra("pokemon2Index", -1);

        // Validar índices y cargar Pokémon
        if (viewModelCombatiente.pokemonAliado.getValue() == null || viewModelCombatiente.pokemonEnemigo.getValue() == null) {
            pokemons = new ListPokemon();

            if (pokemon1Index >= 0 && pokemon1Index < pokemons.listaPokemons().size() &&
                    pokemon2Index >= 0 && pokemon2Index < pokemons.listaPokemons().size()) {

                pokemon1 = pokemons.listaPokemons().get(pokemon1Index);
                pokemon2 = pokemons.listaPokemons().get(pokemon2Index);

                viewModelCombatiente.pokemonAliado.postValue(pokemon1);
                viewModelCombatiente.pokemonEnemigo.postValue(pokemon2);
            } else {
                throw new IllegalArgumentException("Índices de Pokémon inválidos");
            }
        } else {
            pokemon1 = viewModelCombatiente.pokemonAliado.getValue();
            pokemon2 = viewModelCombatiente.pokemonEnemigo.getValue();
        }

        // Cargar imágenes y textos
        Glide.with(this).load(pokemon1.getImagen()).into(imagenAliado);
        Glide.with(this).load(pokemon2.getImagen()).into(imagenEnemigo);
        tvPokemonAliado.setText(pokemon1.getNombre());
        tvPokemonEnemigo.setText(pokemon2.getNombre());

        // Configurar barra de progreso
        barraAliado.setProgress(valoresBarra(pokemon1, pokemon1.getVidaMaxima()));
        barraEnemigo.setProgress(valoresBarra(pokemon2, pokemon2.getVidaMaxima()));

        botonAtacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelCombatiente.combate(pokemon1, pokemon2);
                barraAliado.setProgress(valoresBarra(pokemon1, pokemon1.getVidaMaxima()));
                barraEnemigo.setProgress(valoresBarra(pokemon2, pokemon2.getVidaMaxima()));
                haGnado();
            }
        });

        haGnado();


    }

    private void haGnado() {
        if (pokemon1.getHp() < 1) {
            fondoGanador.setVisibility(View.VISIBLE);
            textoGanador.setText("¡Ha ganado el pokemon!\n" + pokemon2.getNombre());
            textoGanador.setVisibility(View.VISIBLE);
            imagenGanador.setVisibility(View.VISIBLE);
            Glide.with(this).load(pokemon2.getImagen()).into(imagenGanador);
        } else if (pokemon2.getHp() < 1) {
            fondoGanador.setVisibility(View.VISIBLE);
            textoGanador.setText("¡Ha ganado el pokemon!\n" + pokemon1.getNombre());
            textoGanador.setVisibility(View.VISIBLE);
            Glide.with(this).load(pokemon1.getImagen()).into(imagenGanador);
            imagenGanador.setVisibility(View.VISIBLE);
        }
    }


    public int valoresBarra(Pokemon pokemon, int vidaTotal) {
        return (pokemon.getHp() * 100) / vidaTotal;
    }
}
