package br.edu.ifpe.oxefood.api.cliente;

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
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService service) {
        this.clienteService = service;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid ClienteDTO dto) {

        Cliente clienteCadastrado = clienteService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCadastrado);
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizar(@RequestBody @Valid ClienteDTO dto) {

	    Cliente clienteAtualizado = clienteService.atualizar(dto);
	    return ResponseEntity.ok(clienteAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {

        return ResponseEntity.ok(clienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {

        clienteService.remover(id);
        return ResponseEntity.noContent().build();
   }

     @PostMapping("/endereco/{clienteId}")
   public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(@PathVariable("clienteId") Long clienteId, @RequestBody @Valid EnderecoClienteDTO dto) {

       EnderecoCliente endereco = clienteService.adicionarEnderecoCliente(clienteId, dto);
       return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
   }

   @PutMapping("/endereco/{enderecoId}")
   public ResponseEntity<EnderecoCliente> atualizarEnderecoCliente(@PathVariable("enderecoId") Long enderecoId, @RequestBody EnderecoClienteDTO dto) {

       EnderecoCliente endereco = clienteService.atualizarEnderecoCliente(enderecoId, dto);
       return ResponseEntity.ok(endereco);
   }

   @DeleteMapping("/endereco/{enderecoId}")
   public ResponseEntity<Void> removerEnderecoCliente(@PathVariable("enderecoId") Long enderecoId) {

       clienteService.removerEnderecoCliente(enderecoId);
       return ResponseEntity.noContent().build();
   }



    



}

