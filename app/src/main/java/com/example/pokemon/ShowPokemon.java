package com.example.pokemon;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ShowPokemon extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardPokemon.PokemonAdapter adapter;
    private List<Pokemon> pokemonList;
    private ListPokemon pokemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pokemon);

        recyclerView = findViewById(R.id.recyclerViewCards);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Inicializamos la lista de Pokémon
        pokemons = new ListPokemon(); // Inicialización del objeto
        pokemonList = pokemons.listaPokemons();

        // Configuramos el adaptador
        adapter = new CardPokemon.PokemonAdapter(pokemonList);
        recyclerView.setAdapter(adapter);

        // Botón de volver (opcional)
        findViewById(R.id.button).setOnClickListener(v -> finish());
    }
}
