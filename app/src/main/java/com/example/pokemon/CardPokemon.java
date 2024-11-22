package com.example.pokemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CardPokemon extends CardAdapterPokemon {

    private ImageView imagenPokemon;
    private TextView nombrePokemon;
    private TextView valorHP;
    private TextView valorAtaque;
    private TextView valorDefensa;
    private TextView valorAtaqueEspecial;
    private TextView valorDefensaEspecial;

    // Constructor
    public CardPokemon(View itemView) {
        super(itemView);
        imagenPokemon = itemView.findViewById(R.id.imagenPokemon);
        nombrePokemon = itemView.findViewById(R.id.nombrePokemon);
        valorHP = itemView.findViewById(R.id.valorHP);
        valorAtaque = itemView.findViewById(R.id.valorAtaque);
        valorDefensa = itemView.findViewById(R.id.valorDefensa);
        valorAtaqueEspecial = itemView.findViewById(R.id.valorAtaqueEspecial);
        valorDefensaEspecial = itemView.findViewById(R.id.valorDefensaEspecial);
    }

    // Método para enlazar los datos del Pokémon con las vistas
    public void bind(Pokemon pokemon) {
        nombrePokemon.setText(pokemon.getNombre());
        valorHP.setText(String.valueOf(pokemon.getHp()));
        valorAtaque.setText(String.valueOf(pokemon.getAtaque()));
        valorDefensa.setText(String.valueOf(pokemon.getDefensa()));
        valorAtaqueEspecial.setText(String.valueOf(pokemon.getAtaqueEspecial()));
        valorDefensaEspecial.setText(String.valueOf(pokemon.getDefensaEspecial()));

        // Usamos Glide para cargar el gif en lugar de setImageResource
        Glide.with(imagenPokemon.getContext())
                .load(pokemon.getImagen())  // Cargar el gif desde los recursos
                .into(imagenPokemon);  // Asignar el gif al ImageView
    }

}
