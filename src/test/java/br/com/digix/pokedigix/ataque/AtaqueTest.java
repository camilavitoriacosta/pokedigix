package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtaqueTest {

    @Test
    public void deve_poder_criar_um_ataque() throws AcuraciaInvalida{
        // Arrange
        String nomeEsperado = "Choque do Trovao";
        int forca = 40;
        int acuracia = 50;
        int pontosDePoder = 80;
        Categoria categoria = Categoria.ESPECIAL;
        String descricao = "Da choque nos outros";

        //Act
        Ataque ataque = new Ataque(forca, acuracia, pontosDePoder, categoria, descricao, nomeEsperado);

        //Assert
        assertEquals(nomeEsperado, ataque.getNome());
        assertEquals(forca, ataque.getForca());
        assertEquals(acuracia, ataque.getAcuracia());
        assertEquals(pontosDePoder, ataque.getPontosDePoder());
        assertEquals(categoria, ataque.getCategoria());
        assertEquals(descricao, ataque.getDescricao());
    }

    @Test
    public void nao_deve_criar_um_ataque_com_acuracia_negativa() throws AcuraciaInvalida{
        // Arrange
        String nomeEsperado = "Choque do Trovao";
        int forca = 40;
        int acuracia = -50;
        int pontosDePoder = 80;
        Categoria categoria = Categoria.ESPECIAL;
        String descricao = "Da choque nos outros";

        Assertions.assertThrows(AcuraciaInvalida.class, () -> {
            new Ataque(forca, acuracia, pontosDePoder, categoria, descricao, nomeEsperado);
        });
    }
    
}
