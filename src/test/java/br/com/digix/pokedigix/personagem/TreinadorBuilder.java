package br.com.digix.pokedigix.personagem;

import br.com.digix.pokedigix.ataque.AcuraciaInvalida;
import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.pokemon.PokemonBuilder;

public class TreinadorBuilder {

    private String nome;
    private Endereco endereco;
    private Pokemon primeiroPokemon;

    public TreinadorBuilder() throws AcuraciaInvalida {
        this.nome = "Ash";
        this.endereco = new EnderecoBuilder().construir();
        this.primeiroPokemon = new PokemonBuilder().construir();
    }

    public Treinador construir(){
        return new Treinador(nome, endereco, primeiroPokemon);
    }
    
}
