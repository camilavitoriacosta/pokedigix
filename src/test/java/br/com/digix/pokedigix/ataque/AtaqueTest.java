package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueTest {

    @Test
    public void deve_poder_criar_um_ataque() throws Exception {
        // Arrange
        String nomeEsperado = "Choque do Trovao";
        int forca = 40;
        int acuracia = 50;
        int pontosDePoder = 80;
        Categoria categoria = Categoria.ESPECIAL;
        String descricao = "Da choque nos outros";
        Tipo tipo = new Tipo("Eletrico");

        // Act
        Ataque ataque = new Ataque(forca, acuracia, pontosDePoder, categoria, descricao, nomeEsperado, tipo);

        // Assert
        assertEquals(nomeEsperado, ataque.getNome());
        assertEquals(forca, ataque.getForca());
        assertEquals(acuracia, ataque.getAcuracia());
        assertEquals(pontosDePoder, ataque.getPontosDePoder());
        assertEquals(categoria, ataque.getCategoria());
        assertEquals(descricao, ataque.getDescricao());
        assertEquals(tipo, ataque.getTipo());

    }

    @Test
    public void nao_deve_ter_forca_nem_tipo_quando_a_categoria_for_efeito()
            throws Exception {
        // Arrange
        Categoria categoria = Categoria.EFEITO;
        int forca = 0;
        Tipo tipo = null;

        var ataque = new AtaqueBuilder().comCategoriaEfeito().construir();

        assertEquals(categoria, ataque.getCategoria());
        assertEquals(forca, ataque.getForca());
        assertEquals(tipo, ataque.getTipo());
    }

    @Test
    public void nao_deve_ter_ataque_da_categoria_fisico_sem_forca() {
        Categoria categoria = Categoria.FISICO;
        int forca = 0;

        assertThrows(ForcaInvalidaParaCategoriaException.class, () -> {
            new AtaqueBuilder().comForca(forca).comCategoria(categoria).construir();
        });

    }

    @Test
    public void nao_deve_ter_ataque_da_categoria_fisico_sem_tipo() {
        Categoria categoria = Categoria.FISICO;
        Tipo tipo = null;

        assertThrows(TipoInvalidoParaCategoriaException.class, () -> {
            new AtaqueBuilder().comTipo(tipo).comCategoria(categoria).construir();
        });

    }

    @Test
    public void nao_deve_ter_ataque_da_categoria_especial_sem_forca() {
        Categoria categoria = Categoria.ESPECIAL;
        int forca = 0;

        assertThrows(ForcaInvalidaParaCategoriaException.class, () -> {
            new AtaqueBuilder().comForca(forca).comCategoria(categoria).construir();
        });

    }

    @Test
    public void nao_deve_ter_ataque_da_categoria_especial_sem_tipo() {
        Categoria categoria = Categoria.ESPECIAL;
        Tipo tipo = null;

        assertThrows(TipoInvalidoParaCategoriaException.class, () -> {
            new AtaqueBuilder().comTipo(tipo).comCategoria(categoria).construir();
        });

    }

    @Test
    public void deve_poder_ter_acuracia_igual_a_zero()
            throws Exception {
        int acuraciaEsperada = 0;

        Ataque ataque = new AtaqueBuilder().comAcuracia(acuraciaEsperada).construir();

        assertEquals(acuraciaEsperada, ataque.getAcuracia());
    }

    @Test
    public void nao_deve_criar_um_ataque_com_acuracia_menor_que_zero() throws AcuraciaInvalidaException {
        int acuracia = -1;

        assertThrows(AcuraciaInvalidaException.class, () -> {
            new AtaqueBuilder().comAcuracia(acuracia).construir();
        });

        assertThrows(AcuraciaInvalidaException.class, () -> {
            new AtaqueBuilder().comCategoriaEfeito().comAcuracia(acuracia).construir();
        });
    }

    @Test
    public void nao_deve_criar_um_ataque_com_acuracia_maior_que_cem() throws AcuraciaInvalidaException {
        int acuracia = 101;

        assertThrows(AcuraciaInvalidaException.class, () -> {
            new AtaqueBuilder().comAcuracia(acuracia).construir();
        });

        assertThrows(AcuraciaInvalidaException.class, () -> {
            new AtaqueBuilder().comCategoriaEfeito().comAcuracia(acuracia).construir();
        });
    }

    @Test
    public void deve_ser_obrigatorio_informar_um_tipo()
            throws Exception {
        Tipo tipoEsperado = new Tipo("Eletrico");

        Ataque ataque = new AtaqueBuilder().comTipo(tipoEsperado).construir();

        assertEquals(tipoEsperado, ataque.getTipo());
    }
}
