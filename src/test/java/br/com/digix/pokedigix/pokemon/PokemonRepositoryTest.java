package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.tipo.Tipo;

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
        var genero = Genero.MASCULINO;
        var numeroPokedex = 26;
        
        List<Tipo> tipos = new ArrayList<Tipo>();
        tipos.add(new Tipo("Eletrico"));

        Pokemon pokemon = new Pokemon(nome, nivel, felicidade, altura, peso, genero, numeroPokedex, tipos);

        pokemonRepository.save(pokemon);

        assertNotNull(pokemon.getId());
    }
}

