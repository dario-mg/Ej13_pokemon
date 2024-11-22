package com.example.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListPokemon pokemons;
    private List<Pokemon> pokemonList;

    // AutoCompleteTextViews
    private AutoCompleteTextView autoCompletarPokemon1, autoCompletarPokemon2;

    // Elementos de las tarjetas (tarjeta 1)
    private ImageView tarjetaImagen1;
    private TextView tarjetaNombre1, tarjetaHP1, tarjetaAtaque1, tarjetaDefensa1, tarjetaAtaqueEspecial1, tarjetaDefensaEspecial1;

    // Elementos de las tarjetas (tarjeta 2)
    private ImageView tarjetaImagen2;
    private TextView tarjetaNombre2, tarjetaHP2, tarjetaAtaque2, tarjetaDefensa2, tarjetaAtaqueEspecial2, tarjetaDefensaEspecial2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar la lista de Pokémon
        pokemons = new ListPokemon();
        pokemonList = pokemons.listaPokemons();

        // Configurar elementos del layout
        autoCompletarPokemon1 = findViewById(R.id.autoCompletarPokemon1);
        autoCompletarPokemon2 = findViewById(R.id.autoCompletarPokemon2);

        // Tarjeta 1
        tarjetaImagen1 = findViewById(R.id.tarjetaEstadisticasPokemon1).findViewById(R.id.imagenPokemon);
        tarjetaNombre1 = findViewById(R.id.tarjetaEstadisticasPokemon1).findViewById(R.id.nombrePokemon);
        tarjetaHP1 = findViewById(R.id.tarjetaEstadisticasPokemon1).findViewById(R.id.valorHP);
        tarjetaAtaque1 = findViewById(R.id.tarjetaEstadisticasPokemon1).findViewById(R.id.valorAtaque);
        tarjetaDefensa1 = findViewById(R.id.tarjetaEstadisticasPokemon1).findViewById(R.id.valorDefensa);
        tarjetaAtaqueEspecial1 = findViewById(R.id.tarjetaEstadisticasPokemon1).findViewById(R.id.valorAtaqueEspecial);
        tarjetaDefensaEspecial1 = findViewById(R.id.tarjetaEstadisticasPokemon1).findViewById(R.id.valorDefensaEspecial);

        // Tarjeta 2
        tarjetaImagen2 = findViewById(R.id.tarjetaEstadisticasPokemon2).findViewById(R.id.imagenPokemon);
        tarjetaNombre2 = findViewById(R.id.tarjetaEstadisticasPokemon2).findViewById(R.id.nombrePokemon);
        tarjetaHP2 = findViewById(R.id.tarjetaEstadisticasPokemon2).findViewById(R.id.valorHP);
        tarjetaAtaque2 = findViewById(R.id.tarjetaEstadisticasPokemon2).findViewById(R.id.valorAtaque);
        tarjetaDefensa2 = findViewById(R.id.tarjetaEstadisticasPokemon2).findViewById(R.id.valorDefensa);
        tarjetaAtaqueEspecial2 = findViewById(R.id.tarjetaEstadisticasPokemon2).findViewById(R.id.valorAtaqueEspecial);
        tarjetaDefensaEspecial2 = findViewById(R.id.tarjetaEstadisticasPokemon2).findViewById(R.id.valorDefensaEspecial);

        // Configurar los AutoCompleteTextView
        configurarAutoComplete();

        // Mostrar Pokémon por defecto
        actualizarTarjeta(tarjetaImagen1, tarjetaNombre1, tarjetaHP1, tarjetaAtaque1, tarjetaDefensa1, tarjetaAtaqueEspecial1, tarjetaDefensaEspecial1, pokemonList.get(0));
        actualizarTarjeta(tarjetaImagen2, tarjetaNombre2, tarjetaHP2, tarjetaAtaque2, tarjetaDefensa2, tarjetaAtaqueEspecial2, tarjetaDefensaEspecial2, pokemonList.get(1));

        // Listeners de selección
        autoCompletarPokemon1.setOnItemClickListener((parent, view, position, id) -> {
            String nombreSeleccionado = (String) parent.getItemAtPosition(position);
            Pokemon pokemon = pokemons.obtenerPokemonPorNombre(nombreSeleccionado);
            if (pokemon != null) {
                actualizarTarjeta(tarjetaImagen1, tarjetaNombre1, tarjetaHP1, tarjetaAtaque1, tarjetaDefensa1, tarjetaAtaqueEspecial1, tarjetaDefensaEspecial1, pokemon);
            }
        });

        autoCompletarPokemon2.setOnItemClickListener((parent, view, position, id) -> {
            String nombreSeleccionado = (String) parent.getItemAtPosition(position);
            Pokemon pokemon = pokemons.obtenerPokemonPorNombre(nombreSeleccionado);
            if (pokemon != null) {
                actualizarTarjeta(tarjetaImagen2, tarjetaNombre2, tarjetaHP2, tarjetaAtaque2, tarjetaDefensa2, tarjetaAtaqueEspecial2, tarjetaDefensaEspecial2, pokemon);
            }
        });

        Button botonPokemonsDisponibles = findViewById(R.id.botonPokemonsDisponibles);
        botonPokemonsDisponibles.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ShowPokemon.class);
            startActivity(intent);
        });

        Button botonCombate = findViewById(R.id.botonCombate);
        botonCombate.setOnClickListener(v -> {
            final int[] pokemon1Index = {0};
            final int[] pokemon2Index = {1};

            for (int i = 0; i < pokemonList.size(); i++) {
                if (pokemonList.get(i).getNombre().equals(autoCompletarPokemon1.getText().toString())) {
                    pokemon1Index[0] = i;
                }
                if (pokemonList.get(i).getNombre().equals(autoCompletarPokemon2.getText().toString())) {
                    pokemon2Index[0] = i;
                }
            }

            // Pantalla de carga
            Intent loadingIntent = new Intent(MainActivity.this, Loading.class);
            startActivity(loadingIntent);

            new Handler().postDelayed(() -> {
                Intent intent = new Intent(MainActivity.this, CombateView.class);
                intent.putExtra("pokemon1Index", pokemon1Index[0]);
                intent.putExtra("pokemon2Index", pokemon2Index[0]);
                startActivity(intent);
                finish();  // Finaliza MainActivity
            }, 2000);  // Espera 2 segundos antes de iniciar el combate
        });

    }

    private void configurarAutoComplete() {
        // Nombres de Pokémon para los AutoCompleteTextView
        String[] nombresPokemons = new String[pokemonList.size()];
        for (int i = 0; i < pokemonList.size(); i++) {
            nombresPokemons[i] = pokemonList.get(i).getNombre();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, nombresPokemons);
        autoCompletarPokemon1.setAdapter(adapter);
        autoCompletarPokemon2.setAdapter(adapter);
    }

    private void actualizarTarjeta(ImageView imagen, TextView nombre, TextView hp, TextView ataque, TextView defensa, TextView ataqueEspecial, TextView defensaEspecial, Pokemon pokemon) {
        Glide.with(this).load(pokemon.getImagen()).into(imagen);
        nombre.setText(pokemon.getNombre());
        hp.setText(String.valueOf(pokemon.getHp()));
        ataque.setText(String.valueOf(pokemon.getAtaque()));
        defensa.setText(String.valueOf(pokemon.getDefensa()));
        ataqueEspecial.setText(String.valueOf(pokemon.getAtaqueEspecial()));
        defensaEspecial.setText(String.valueOf(pokemon.getDefensaEspecial()));
    }
}
