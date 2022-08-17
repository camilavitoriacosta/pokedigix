package br.com.digix.pokedigix.ataque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoRepository;
import br.com.digix.pokedigix.tipo.TipoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(path = { "/api/v1/ataques" }, produces = { "application/json" })
public class AtaqueController {
    @Autowired
    private AtaqueRepository ataqueRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Operation(summary = "Buscar ataques cadastrados por id")
    @ApiResponse(responseCode = "200")
    @GetMapping(path = "/{id}")
    public ResponseEntity<AtaqueResponseDTO> buscarPorId(@PathVariable Long id) {
        Ataque ataque = ataqueRepository.findById(id).get();
        TipoResponseDTO tipo = new TipoResponseDTO(ataque.getTipo().getId(), ataque.getTipo().getNome());
        return ResponseEntity
                .ok(new AtaqueResponseDTO(ataque.getId(), ataque.getNome(), ataque.getAcuracia(), ataque.getCategoria(),
                        ataque.getDescricao(), ataque.getPontosDePoder(), ataque.getForca(), tipo));
    }

    @Operation(summary = "Criar um novo ataque que pode ser usado para Pokemons")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = "application/json")
    public ResponseEntity<AtaqueResponseDTO> criar(@RequestBody AtaqueRequestDTO novoAtaque) throws Exception {
        Tipo tipo = tipoRepository.findById(novoAtaque.getIdTipo()).get();
        Ataque ataque = new Ataque(novoAtaque.getForca(), novoAtaque.getAcuracia(), novoAtaque.getPontosDePoder(),
                novoAtaque.getCategoria(), novoAtaque.getDescricao(), novoAtaque.getNome(), tipo);

        ataqueRepository.save(ataque);

        TipoResponseDTO tipoDTO = new TipoResponseDTO(tipo.getId(), tipo.getNome());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new AtaqueResponseDTO(ataque.getId(), ataque.getNome(), ataque.getAcuracia(),
                        ataque.getCategoria(), ataque.getDescricao(), ataque.getPontosDePoder(), ataque.getForca(),
                        tipoDTO));
    }
}
