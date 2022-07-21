package br.com.digix.pokedigix.tipo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest // indica conexao com o banco
public class TipoRepositoryTest {
    
    @Autowired // spring gera as dependencias automaticamente
    private TipoRepository tipoRepository;

    @Test
    public void deve_salvar_um_tipo(){
        String nomeEsperado = "Eletrico";
        Long idEsperado = 4L;
        Tipo tipo = new Tipo(nomeEsperado);

        tipoRepository.save(tipo);

        assertEquals(idEsperado, tipo.getId());
    }
  
    // @Test
    // public void deve_procurar_um_tipo_por_nome(){
    //     String nome = "Eletrico";
    //     Tipo tipo = new Tipo(nome);
    //     tipoRepository.save(tipo);

    //     var tipoRetornado = tipoRepository.findByName(nome);

    //     assertEquals(tipo.getId(), tipoRetornado.getId());
    // }
}
