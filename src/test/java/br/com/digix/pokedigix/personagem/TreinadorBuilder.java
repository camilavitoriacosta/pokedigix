package br.com.digix.pokedigix.personagem;

import br.com.digix.pokedigix.ataque.AcuraciaInvalidaException;
import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.pokemon.PokemonBuilder;

public class TreinadorBuilder {

    private String nome;
    private Endereco endereco;
    private Pokemon primeiroPokemon;

    public TreinadorBuilder() throws AcuraciaInvalidaException {
        this.nome = "Ash";
        this.endereco = new EnderecoBuilder().construir();
        this.primeiroPokemon = new PokemonBuilder().construir();
    }

    public Treinador construir() throws LimiteDePokemonException{
        return new Treinador(nome, endereco, primeiroPokemon);
    }

    public TreinadorBuilder comPokemonInicial(Pokemon primeiroPokemon) {
        this.primeiroPokemon = primeiroPokemon;
        return this;
    }
    
}
