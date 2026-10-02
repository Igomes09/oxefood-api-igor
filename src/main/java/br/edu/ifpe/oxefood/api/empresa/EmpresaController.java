package br.edu.ifpe.oxefood.api.empresa;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService service) {
        this.empresaService = service;
    }

    @PostMapping
    public ResponseEntity<Empresa> cadastrar(@RequestBody EmpresaDTO dto) {

        Empresa empresaCadastrado = empresaService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listar() {

        return ResponseEntity.ok(empresaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(empresaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
   public ResponseEntity<Void> remover(@PathVariable Long id) {

        empresaService.remover(id);
        return ResponseEntity.noContent().build();
   }



}