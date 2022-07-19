package br.com.digix.pokedigix.pokemon;

import java.util.ArrayList;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.treinador.Treinador;

public class Pokemon {
    private String nome;
    private int nivel;
    private int felicidade;
    private Tipo tipo;
    private double altura;
    private double peso;
    private char genero;
    private String numeroPokedex;
    private Treinador treinador;
    private ArrayList<Ataque> ataques;

    public Pokemon(String nome, int nivel, int felicidade, Tipo tipo, double altura, double peso, char genero,
            String numeroPokedex, Treinador treinador, ArrayList<Ataque> ataques) {
        this.nome = nome;
        this.nivel = nivel;
        this.felicidade = felicidade;
        this.tipo = tipo;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.numeroPokedex = numeroPokedex;
        this.treinador = treinador;
        this.ataques = ataques;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getFelicidade() {
        return felicidade;
    }

    public void setFelicidade(int felicidade) {
        this.felicidade = felicidade;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getNumeroPokedex() {
        return numeroPokedex;
    }

    public void setNumeroPokedex(String numeroPokedex) {
        this.numeroPokedex = numeroPokedex;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }

    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(ArrayList<Ataque> ataques) {
        this.ataques = ataques;
    }
}
