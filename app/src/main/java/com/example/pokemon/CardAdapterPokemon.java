package com.example.pokemon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapterPokemon extends RecyclerView.ViewHolder {
    public CardAdapterPokemon(View itemView) {
        super(itemView);
    }

    // Adaptador para manejar la lista de Pokémon
    public static class PokemonAdapter extends RecyclerView.Adapter<CardPokemon> {

        private List<Pokemon> pokemonList;

        public PokemonAdapter(List<Pokemon> pokemonList) {
            this.pokemonList = pokemonList;
        }

        @Override
        public CardPokemon onCreateViewHolder(ViewGroup parent, int viewType) {
            // Inflamos la vista para cada tarjeta de Pokémon
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_pokemon, parent, false);
            return new CardPokemon(view);
        }

        @Override
        public void onBindViewHolder(CardPokemon holder, int position) {
            // Obtener el Pokémon de la lista y bindear los datos
            Pokemon pokemon = pokemonList.get(position);
            holder.bind(pokemon);
        }

        @Override
        public int getItemCount() {
            return pokemonList.size();
        }
    }
}
