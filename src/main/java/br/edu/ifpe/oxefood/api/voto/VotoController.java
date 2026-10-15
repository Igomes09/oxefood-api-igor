package br.edu.ifpe.oxefood.api.voto;

import java.util.List;

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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/voto")
public class VotoController {

    private final VotoService VotoService;

    public VotoController(VotoService service) {
        this.VotoService = service;
    }

    @PostMapping
    public ResponseEntity<Voto> cadastrar(@RequestBody @Valid VotoDTO dto) {

        Voto VotoCadastrado = VotoService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(VotoCadastrado);
    }

    @PutMapping
    public ResponseEntity<Voto> atualizar(@RequestBody @Valid VotoDTO dto) {

	    Voto VotoAtualizado = VotoService.atualizar(dto);
	    return ResponseEntity.ok(VotoAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<Voto>> listar() {

        return ResponseEntity.ok(VotoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voto> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(VotoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {

        VotoService.remover(id);
        return ResponseEntity.noContent().build();
   }


    



}