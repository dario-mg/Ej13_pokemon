package com.example.pokemon;

public class Pokemon {
    private String nombre;  // Nombre del Pokémon
    private int imagenResId; // ID de la imagen (recurso en drawable)
    private int hp; // Puntos de vida
    private int ataque; // Ataque
    private int defensa; // Defensa
    private int ataqueEspecial; // Ataque Especial
    private int defensaEspecial;
    private int vidaMaxima;

    // Constructor
    public Pokemon(String nombre, int imagenResId, int hp, int ataque, int defensa, int ataqueEspecial, int defensaEspecial) {
        this.nombre = nombre;
        this.imagenResId = imagenResId;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.vidaMaxima = hp;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public void setImagenResId(int imagenResId) {
        this.imagenResId = imagenResId;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    // Getters y Setters para cada atributo
    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagenResId;
    }

    public int getHp() {
        return hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }
}
