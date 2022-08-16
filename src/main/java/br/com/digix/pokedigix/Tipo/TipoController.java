package br.com.digix.pokedigix.tipo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = { "/api/v1/tipos" }, produces = { "application/json" })
public class TipoController {
    @Autowired
    private TipoRepository tipoRepository;

    @PostMapping(consumes = "application/json")
    public TipoResponseDTO criar(@RequestBody TipoRequestDTO novoTipo) {
        Tipo tipo = new Tipo(novoTipo.getNome());
        tipoRepository.save(tipo);
        return new TipoResponseDTO(tipo.getId(), tipo.getNome());
    }

    @GetMapping()
    public List<TipoResponseDTO> buscarTodos() {
        List<TipoResponseDTO> tiposRetornados = new ArrayList<TipoResponseDTO>();
        for (Tipo tipo : tipoRepository.findAll()) {
            tiposRetornados.add(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
        }
        return tiposRetornados;
    }

    @GetMapping(path = "/{id}")
    public TipoResponseDTO buscarPorId(@PathVariable Long id) {
        Tipo tipoRetornado = tipoRepository.findById(id).get();
        return new TipoResponseDTO(tipoRetornado.getId(), tipoRetornado.getNome());
    }

}
