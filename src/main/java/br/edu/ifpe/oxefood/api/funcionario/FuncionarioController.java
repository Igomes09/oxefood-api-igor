package br.edu.ifpe.oxefood.api.funcionario;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/funcionario")
@Tag(
   name = "API Funcionário",
   description = "API responsável pelos serviços do Funcionário no sistema"
)

public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService service) {

        this.funcionarioService = service;
    }

    @Operation(
       summary = "Serviço responsável por salvar um funcionário no sistema.",
       description = "Exemplo de descrição de um endpoint responsável por inserir um funcionário no sistema."
   )


    @PostMapping
    public ResponseEntity<Funcionario> cadastrar(@RequestBody @Valid FuncionarioDTO dto) {

        Funcionario funcionarioCadastrado = funcionarioService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listar() {

        return ResponseEntity.ok(funcionarioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(funcionarioService.buscarPorId(id));
    }

    @PutMapping
    public ResponseEntity<Funcionario> atualizar(@RequestBody FuncionarioDTO dto) {

        Funcionario funcionarioAtualizado = funcionarioService.atualizar(dto);
        return ResponseEntity.ok(funcionarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {

        funcionarioService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
