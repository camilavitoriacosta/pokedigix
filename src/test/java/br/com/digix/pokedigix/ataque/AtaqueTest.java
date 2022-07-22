package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.tipo.Tipo;

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
        Tipo tipo = new Tipo("Eletrico");

        //Act
        Ataque ataque = new Ataque(forca, acuracia, pontosDePoder, categoria, descricao, nomeEsperado, tipo);

        //Assert
        assertEquals(nomeEsperado, ataque.getNome());
        assertEquals(forca, ataque.getForca());
        assertEquals(acuracia, ataque.getAcuracia());
        assertEquals(pontosDePoder, ataque.getPontosDePoder());
        assertEquals(categoria, ataque.getCategoria());
        assertEquals(descricao, ataque.getDescricao());
    }

    @Test
    public void deve_criar_um_ataque_da_categoria_efeito() throws AcuraciaInvalida{
        // Arrange
        String nomeEsperado = "Choque do Trovao";
        int acuracia = 50;
        int pontosDePoder = 80;
        Categoria categoria = Categoria.EFEITO;
        String descricao = "Da choque nos outros";
        Tipo tipo = new Tipo("Eletrico");
        
        var ataque = new Ataque(acuracia, pontosDePoder, categoria, descricao, nomeEsperado, tipo);

        assertEquals(nomeEsperado, ataque.getNome());
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
        Tipo tipo = new Tipo("Eletrico");

        Assertions.assertThrows(AcuraciaInvalida.class, () -> {
            new Ataque(forca, acuracia, pontosDePoder, categoria, descricao, nomeEsperado, tipo);
        });
    }

    @Test
    public void deve_ser_obrigatorio_informar_um_tipo() throws AcuraciaInvalida{
        String nome = "Choque do Trovao";
        int forca = 60;
        int acuracia = 50;
        int pontosDePoder = 80;
        Categoria categoria = Categoria.EFEITO;
        String descricao = "Da choque nos outros";
        Tipo tipoEsperado = new Tipo("Eletrico");
        
        Ataque ataque = new Ataque(forca, acuracia, pontosDePoder, categoria, descricao, nome, tipoEsperado);

        assertEquals(tipoEsperado, ataque.getTipo());
    }
}
