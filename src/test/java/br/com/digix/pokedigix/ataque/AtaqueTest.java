package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueTest {

    @Test
    public void deve_poder_criar_um_ataque(){
        // Arrange
        String nomeEsperado = "Choque do Trovao";

        //Act
        Ataque ataque = new Ataque(40, 40, 80, 
        Categoria.ESPECIAL, "Da choque nos outros",
        nomeEsperado);

        //Assert
        assertEquals(nomeEsperado, ataque.getNome());
    }
    
}
