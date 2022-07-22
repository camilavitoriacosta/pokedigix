package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PokemonRepositoryTest {
    @Autowired // spring gera as dependencias automaticamente
    private PokemonRepository pokemonRepository;

    @Test
    public void deve_salvar_um_pokemon(){
        var nome = "Pikachu";
        var nivel = 10;
        var felicidade = 80;
        var altura = 40;
        var peso = 2;
        var genero = 'M';
        var numeroPokedex = 26;
        Pokemon pokemon = new Pokemon(nome, nivel, felicidade, altura, peso, genero, numeroPokedex);

        pokemonRepository.save(pokemon);

        assertNotNull(pokemon.getId());
    }
}

