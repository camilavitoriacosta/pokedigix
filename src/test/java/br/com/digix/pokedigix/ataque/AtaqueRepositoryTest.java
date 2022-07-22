package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoRepository;

@DataJpaTest // indica conexao com o banco
public class AtaqueRepositoryTest {
    @Autowired // spring gera as dependencias automaticamente
    private AtaqueRepository ataqueRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Test
    public void deve_salvar_um_ataque() throws AcuraciaInvalida {
        String nomeEsperado = "Choque do Trovao";
        int forca = 40;
        int acuracia = 50;
        int pontosDePoder = 80;
        Categoria categoria = Categoria.ESPECIAL;
        String descricao = "Da choque nos outros";
        Tipo tipo = new Tipo("Eletrico");
        Ataque ataque = new Ataque(forca, acuracia, pontosDePoder, categoria, descricao, nomeEsperado, tipo);

        ataqueRepository.save(ataque);

        assertNotNull(ataque.getId());
    }

    @Test
    public void deve_salvar_um_ataque_com_categoria_efeito() throws AcuraciaInvalida {
        String nomeEsperado = "Choque do Trovao";
        int acuracia = 50;
        int pontosDePoder = 80;
        Categoria categoria = Categoria.EFEITO;
        String descricao = "Da choque nos outros";
        Tipo tipo = new Tipo("Eletrico");
        var ataque = new Ataque(acuracia, pontosDePoder, categoria, descricao, nomeEsperado, tipo);

        ataqueRepository.save(ataque);

        assertNotNull(ataque.getId());
    }

    @Test
    public void deve_salvar_um_tipo_para_um_ataque() throws AcuraciaInvalida {
        String nomeEsperado = "Choque do Trovao";
        int acuracia = 50;
        int pontosDePoder = 80;
        Categoria categoria = Categoria.EFEITO;
        String descricao = "Da choque nos outros";
        Tipo tipo = new Tipo("Eletrico");
        tipoRepository.save(tipo);
        var tipoRetornado = tipoRepository.findById(tipo.getId()).get();
        var ataque = new Ataque(acuracia, pontosDePoder, categoria, descricao, nomeEsperado, tipoRetornado);
        ataqueRepository.save(ataque);

        var ataqueRetornado = ataqueRepository.findById(ataque.getId()).get();

        assertEquals(tipo.getNome(), ataqueRetornado.getTipo().getNome());
        assertEquals(ataque.getTipo().getId(), ataqueRetornado.getTipo().getId());
        assertNotNull(ataqueRetornado.getTipo().getId());
        ;
    }

    @Test
    public void deve_procurar_um_ataque_pelo_tipo() throws AcuraciaInvalida {
        String nomeEsperado = "Choque do Trovao";
        int acuracia = 50;
        int pontosDePoder = 80;
        Categoria categoria = Categoria.EFEITO;
        String descricao = "Da choque nos outros";
        Tipo tipo = new Tipo("Eletrico");
        tipoRepository.save(tipo);
        var tipoRetornado = tipoRepository.findById(tipo.getId()).get();
        var ataque = new Ataque(acuracia, pontosDePoder, categoria, descricao, nomeEsperado, tipoRetornado);
        ataqueRepository.save(ataque);

        Collection<Ataque> ataquesRetornados = ataqueRepository.findByTipo(tipo);

        assertTrue(ataquesRetornados.contains(ataque));
    }
    
    @Test
    public void deve_procurar_um_ataque_pela_categoria() throws AcuraciaInvalida {
        String nomeEsperado = "Choque do Trovao";
        int acuracia = 50;
        int pontosDePoder = 80;
        Categoria categoria = Categoria.EFEITO;
        String descricao = "Da choque nos outros";
        Tipo tipo = new Tipo("Eletrico");
        tipoRepository.save(tipo);
        var tipoRetornado = tipoRepository.findById(tipo.getId()).get();
        var ataque = new Ataque(acuracia, pontosDePoder, categoria, descricao, nomeEsperado, tipoRetornado);
        ataqueRepository.save(ataque);

        Collection<Ataque> ataquesRetornados = ataqueRepository.findByCategoria(categoria);

        assertTrue(ataquesRetornados.contains(ataque));
    }
}
