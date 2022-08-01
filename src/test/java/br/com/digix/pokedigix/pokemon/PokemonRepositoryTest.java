package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.ataque.AcuraciaInvalidaException;
import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.ataque.AtaqueBuilder;
import br.com.digix.pokedigix.tipo.Tipo;

@DataJpaTest
public class PokemonRepositoryTest {
    @Autowired // spring gera as dependencias automaticamente
    private PokemonRepository pokemonRepository;

    @Test
    public void deve_salvar_um_pokemon() throws AcuraciaInvalidaException {
        Tipo tipoCadastrado = new Tipo("Eletrico");
        Pokemon pokemon = new PokemonBuilder().comTipo(tipoCadastrado).construir();

        pokemonRepository.save(pokemon);

        assertNotNull(pokemon.getId());
    }

    @Test
    public void deve_salvar_um_pokemon_com_tipo() throws AcuraciaInvalidaException {
        Tipo tipoCadastrado = new Tipo("Eletrico");
        Pokemon pokemon = new PokemonBuilder().comTipo(tipoCadastrado).construir();
        pokemonRepository.save(pokemon);

        Pokemon pokemonRetornado = pokemonRepository.findById(pokemon.getId()).get();

        int quantidadeEsperada = 1;
        assertNotNull(pokemonRetornado.getTipos());
        assertEquals(quantidadeEsperada, pokemonRetornado.getTipos().size());
        assertTrue(pokemonRetornado.getTipos().contains(tipoCadastrado));
    }

    @Test
    public void deve_salvar_um_pokemon_com_ataque() throws Exception {
        Ataque ataque = new AtaqueBuilder().construir();
        Pokemon pokemon = new PokemonBuilder().comAtaque(ataque).construir();

        pokemonRepository.save(pokemon);

        assertTrue(pokemon.getAtaques().contains(ataque));
    }
}
