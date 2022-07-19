package br.com.digix.pokedigix.treinador;

import java.util.ArrayList;

import br.com.digix.pokedigix.pokemon.Pokemon;

public class Treinador {
    private String nome;
    private int dinheiro;
    private int nivel;
    private ArrayList<Pokemon> pokemons;

    public Treinador(String nome, int dinheiro, int nivel, ArrayList<Pokemon> pokemons) {
        this.nome = nome;
        this.dinheiro = dinheiro;
        this.nivel = nivel;
        this.pokemons = pokemons;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
