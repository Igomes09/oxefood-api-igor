package br.edu.ifpe.oxefood.api.categoriaproduto;

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
@RequestMapping ("/api/categoriaproduto")
public class CategoriaProdutoController {

    private final CategoriaProdutoService CategoriaProdutoService;

    public CategoriaProdutoController(CategoriaProdutoService service) {
        this.CategoriaProdutoService = service;
    }

    @PostMapping
    public ResponseEntity<CategoriaProduto> cadastrar(@RequestBody @Valid CategoriaProdutoDTO dto) {

        CategoriaProduto CategoriaProdutoCadastrado = CategoriaProdutoService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaProdutoCadastrado);
    }

    @PutMapping
    public ResponseEntity<CategoriaProduto> atualizar(@RequestBody @Valid CategoriaProdutoDTO dto) {

	    CategoriaProduto CategoriaProdutoAtualizado = CategoriaProdutoService.atualizar(dto);
	    return ResponseEntity.ok(CategoriaProdutoAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaProduto>> listar() {

        return ResponseEntity.ok(CategoriaProdutoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProduto> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(CategoriaProdutoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {

        CategoriaProdutoService.remover(id);
        return ResponseEntity.noContent().build();
   }


    



}
