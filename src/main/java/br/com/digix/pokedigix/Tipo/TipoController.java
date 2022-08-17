package br.com.digix.pokedigix.tipo;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(path = { "/api/v1/tipos" }, produces = { "application/json" })
public class TipoController {
    @Autowired
    private TipoRepository tipoRepository;

    @Operation(summary = "Criar um novo tipo que pode ser usado para Pokemons e Ataques")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = "application/json")
    public ResponseEntity<TipoResponseDTO> criar(@RequestBody TipoRequestDTO novoTipo) {
        Tipo tipo = new Tipo(novoTipo.getNome());
        tipoRepository.save(tipo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
    }

    @GetMapping()
    @Operation(summary = "Buscar todos os tipos, com nome opcional")
    @ApiResponse(responseCode = "200", description = "Lista de tipos cadastrados")
    // buscarTodos(@RequestParam(required = false, name = "termo") String nome)
    public ResponseEntity<List<TipoResponseDTO>> buscarTodos(@RequestParam(required = false) String nome) {
        Iterable<Tipo> tipos;

        if (nome != null) {
            tipos = tipoRepository.findByNomeContaining(nome);
        } else {
            tipos = tipoRepository.findAll();
        }

        List<TipoResponseDTO> tiposRetornados = new ArrayList<TipoResponseDTO>();
        for (Tipo tipo : tipos) {
            tiposRetornados.add(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
        }
        return ResponseEntity.ok(tiposRetornados);
    }

    @Operation(summary = "Buscar tipos cadastrados por id")
    @ApiResponse(responseCode = "200")
    @GetMapping(path = "/{id}")
    public ResponseEntity<TipoResponseDTO> buscarPorId(@PathVariable Long id) {
        Tipo tipoRetornado = tipoRepository.findById(id).get();
        return ResponseEntity.ok(new TipoResponseDTO(tipoRetornado.getId(), tipoRetornado.getNome()));
    }

    @Operation(summary = "Atualiza um tipo cadastro por meio do id")
    @ApiResponse(responseCode = "200")
    @PutMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<TipoResponseDTO> atualizarPorId(@RequestBody TipoResponseDTO tipoResponseDTO,
            @PathVariable Long id) {
        Tipo tipo = tipoRepository.findById(id).get();
        tipo.setNome(tipoResponseDTO.getNome());
        tipoRepository.save(tipo);
        return ResponseEntity.ok(new TipoResponseDTO(tipo.getId(), tipo.getNome()));
    }

    @Operation(summary = "Deleta um tipo cadastro por meio do id")
    @ApiResponse(responseCode = "204")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id) {
        tipoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Deleta um tipo cadastro por seu nome parcional ou inteiro")
    @ApiResponse(responseCode = "204")
    @DeleteMapping()
    @Transactional
    public ResponseEntity<?> deletarPorNome(@RequestParam(required = true) String nome) {
        tipoRepository.deleteByNomeContaining(nome);
        return ResponseEntity.noContent().build();
    }
}
