package br.com.digix.pokedigix.pokemon;

import java.util.ArrayList;
import java.util.List;

import br.com.digix.pokedigix.ataque.AcuraciaInvalida;
import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonBuilder {
    private List<Ataque> ataques;
    private String nome;
    private int nivel;
    private int felicidade;
    private int altura;
    private int peso;
    private Genero genero;
    private int numeroPokedex;
    private List<Tipo> tipos;

    public PokemonBuilder() throws AcuraciaInvalida {
        this.nome = "Pikachu";
        this.nivel = 10;
        this.felicidade = 80;
        this.altura = 40;
        this.peso = 2;
        this.genero = Genero.MASCULINO;
        this.numeroPokedex = 26;
        this.tipos = new ArrayList<Tipo>();
        this.ataques = new ArrayList<Ataque>();
    }

    public Pokemon construir() {
        return new Pokemon(nome, nivel, felicidade, altura, peso, genero, numeroPokedex, tipos, ataques);
    }

    public PokemonBuilder comAtaque(Ataque ataque) {
        ataques.add(ataque);
        return this;
    }

    public PokemonBuilder comTipo(Tipo tipoCadastrado) {
        tipos.add(tipoCadastrado);
        return this;
    }
}
