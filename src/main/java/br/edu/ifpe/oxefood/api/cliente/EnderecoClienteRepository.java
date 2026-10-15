package br.edu.ifpe.oxefood.api.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoClienteRepository extends JpaRepository<EnderecoCliente, Long> {
  
}
