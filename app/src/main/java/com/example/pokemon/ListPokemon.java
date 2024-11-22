package com.example.pokemon;

import java.util.ArrayList;
import java.util.List;

public class ListPokemon {
    private List<Pokemon> pokemonList;

    public ListPokemon() {
        pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon("Pikachu", R.drawable.pikachu, 250, 220, 180, 200, 240));
        pokemonList.add(new Pokemon("Charizard", R.drawable.charizard, 600, 250, 220, 270, 230));
        pokemonList.add(new Pokemon("Bulbasaur", R.drawable.bulbasaur, 550, 240, 200, 250, 230));
        pokemonList.add(new Pokemon("Squirtle", R.drawable.squirtle, 520, 220, 210, 230, 210));
        pokemonList.add(new Pokemon("Eevee", R.drawable.eevee, 600, 180, 160, 200, 190));
        pokemonList.add(new Pokemon("Jigglypuff", R.drawable.jigglypuff, 550, 150, 120, 180, 170));
        pokemonList.add(new Pokemon("Mewtwo", R.drawable.mewtwo, 700, 290, 250, 270, 250));
        pokemonList.add(new Pokemon("Meowth", R.drawable.meowth, 510, 170, 140, 180, 190));
        pokemonList.add(new Pokemon("Snorlax", R.drawable.snorlax, 800, 260, 220, 240, 210));
        pokemonList.add(new Pokemon("Lucario", R.drawable.lucario, 550, 250, 210, 240, 220));
        pokemonList.add(new Pokemon("Magikarp", R.drawable.magikarp, 500, 100, 50, 90, 80));
        pokemonList.add(new Pokemon("Gengar", R.drawable.gengar, 560, 280, 220, 260, 230));
        pokemonList.add(new Pokemon("Blastoise", R.drawable.blastoise, 650, 280, 250, 270, 240));
        pokemonList.add(new Pokemon("Raichu", R.drawable.raichu, 530, 240, 200, 210, 220));
        pokemonList.add(new Pokemon("Mew", R.drawable.mew, 600, 260, 230, 250, 240));
        pokemonList.add(new Pokemon("Arcanine", R.drawable.arcanine, 700, 270, 240, 260, 250));
        pokemonList.add(new Pokemon("Vaporeon", R.drawable.vaporeon, 600, 230, 210, 250, 220));
        pokemonList.add(new Pokemon("Dragonite", R.drawable.dragonite, 800, 290, 270, 280, 270));
        pokemonList.add(new Pokemon("Togepi", R.drawable.togepi, 510, 150, 120, 180, 170));
        pokemonList.add(new Pokemon("Greninja", R.drawable.greninja, 650, 280, 220, 240, 230));
    }

    public List<Pokemon> listaPokemons() {
        return pokemonList;
    }

    // Devuelve un Pokémon por su nombre
    public Pokemon obtenerPokemonPorNombre(String nombre) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getNombre().equals(nombre)) {
                return pokemon;
            }
        }
        return null;
    }
}
