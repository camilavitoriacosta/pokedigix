package br.com.digix.pokedigix.pokemon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 15)
    private String nome;

    @Column(nullable = false)
    private int nivel;

    @Column(nullable = false)
    private int felicidade;

    @Column(nullable = false)
    private double altura;

    @Column(nullable = false)
    private double peso;

    @Column(nullable = false)
    private char genero;

    @Column(nullable = false)
    private int numeroPokedex;

    public Pokemon(String nome, int nivel, int felicidade, double altura, double peso, char genero,
            int numeroPokedex) {
        this.nome = nome;
        this.nivel = nivel;
        this.felicidade = felicidade;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.numeroPokedex = numeroPokedex;
    }

    public Pokemon(String nome, int nivel, int felicidade, double altura, double peso,
            int numeroPokedex) {
        this.nome = nome;
        this.nivel = nivel;
        this.felicidade = felicidade;
        this.altura = altura;
        this.peso = peso;
        this.numeroPokedex = numeroPokedex;
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

    public int getNumeroPokedex() {
        return numeroPokedex;
    }

    public void setNumeroPokedex(int numeroPokedex) {
        this.numeroPokedex = numeroPokedex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
