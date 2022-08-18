package br.com.digix.pokedigix.ataque;

import java.util.ArrayList;
import java.util.List;

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

        @Operation(summary = "Buscar Ataques cadastrados por id")
        @ApiResponse(responseCode = "200")
        @GetMapping(path = "/{id}")
        public ResponseEntity<AtaqueResponseDTO> buscarPorId(@PathVariable Long id) {
                Ataque ataque = ataqueRepository.findById(id).get();
                TipoResponseDTO tipo = new TipoResponseDTO(ataque.getTipo().getId(), ataque.getTipo().getNome());
                return ResponseEntity
                                .ok(new AtaqueResponseDTO(ataque.getId(), ataque.getNome(), ataque.getAcuracia(),
                                                ataque.getCategoria(),
                                                ataque.getDescricao(), ataque.getPontosDePoder(), ataque.getForca(),
                                                tipo));
        }

        @GetMapping()
        @Operation(summary = "Buscar todos os Ataques")
        @ApiResponse(responseCode = "200", description = "Lista de tipos cadastrados")
        public ResponseEntity<List<AtaqueResponseDTO>> buscarTodos() {
                Iterable<Ataque> ataquesRetornados = ataqueRepository.findAll();

                List<AtaqueResponseDTO> ataquesDTO = new ArrayList<AtaqueResponseDTO>();
                for (Ataque ataque : ataquesRetornados) {
                        TipoResponseDTO tipo = new TipoResponseDTO(ataque.getTipo().getId(),
                                        ataque.getTipo().getNome());

                        ataquesDTO.add(new AtaqueResponseDTO(ataque.getId(), ataque.getNome(), ataque.getAcuracia(),
                                        ataque.getCategoria(),
                                        ataque.getDescricao(), ataque.getPontosDePoder(), ataque.getForca(),
                                        tipo));
                }
                return ResponseEntity.ok(ataquesDTO);
        }

        @Operation(summary = "Criar um novo Ataque que pode ser usado para Pokemons")
        @ApiResponse(responseCode = "201")
        @PostMapping(consumes = "application/json")
        public ResponseEntity<AtaqueResponseDTO> criar(@RequestBody AtaqueRequestDTO novoAtaque) throws Exception {
                Tipo tipo = tipoRepository.findById(novoAtaque.getIdTipo()).get();
                Ataque ataque = new Ataque(novoAtaque.getForca(), novoAtaque.getAcuracia(),
                                novoAtaque.getPontosDePoder(),
                                novoAtaque.getCategoria(), novoAtaque.getDescricao(), novoAtaque.getNome(), tipo);

                ataqueRepository.save(ataque);

                TipoResponseDTO tipoDTO = new TipoResponseDTO(tipo.getId(), tipo.getNome());
                return ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(new AtaqueResponseDTO(ataque.getId(), ataque.getNome(), ataque.getAcuracia(),
                                                ataque.getCategoria(), ataque.getDescricao(), ataque.getPontosDePoder(),
                                                ataque.getForca(),
                                                tipoDTO));
        }

        @Operation(summary = "Atualiza um Ataque cadastro por meio do id")
        @ApiResponse(responseCode = "200")
        @PutMapping(path = "/{id}", consumes = "application/json")
        public ResponseEntity<AtaqueResponseDTO> atualizarPorId(@RequestBody AtaqueResponseDTO ataqueResponseDTO,
                        @PathVariable Long id) throws Exception {
                Ataque ataque = ataqueRepository.findById(id).get();

                ataque.setAcuracia(ataqueResponseDTO.getAcuracia());
                ataque.setCategoria(ataqueResponseDTO.getCategoria());
                ataque.setDescricao(ataqueResponseDTO.getDescricao());
                ataque.setForca(ataqueResponseDTO.getForca());
                ataque.setNome(ataqueResponseDTO.getNome());
                ataque.setPontosDePoder(ataqueResponseDTO.getPontosDePoder());

                TipoResponseDTO tipoDTO = ataqueResponseDTO.getTipo();
                Tipo tipo = tipoRepository.findById(tipoDTO.getId()).get();
                ataque.setTipo(tipo);

                ataqueRepository.save(ataque);

                return ResponseEntity
                                .ok(new AtaqueResponseDTO(ataque.getId(), ataque.getNome(), ataque.getAcuracia(),
                                                ataque.getCategoria(),
                                                ataque.getDescricao(), ataque.getPontosDePoder(), ataque.getForca(),
                                                tipoDTO));

        }

        @Operation(summary = "Deleta um Ataque cadastro por meio do id")
        @ApiResponse(responseCode = "204")
        @DeleteMapping(path = "/{id}")
        public ResponseEntity<?> deletarPorId(@PathVariable Long id) {
                ataqueRepository.deleteById(id);
                return ResponseEntity.noContent().build();
        }
}
