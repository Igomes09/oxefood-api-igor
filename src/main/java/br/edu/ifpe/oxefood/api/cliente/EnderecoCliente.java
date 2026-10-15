package br.edu.ifpe.oxefood.api.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.ifpe.oxefood.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

public class EnderecoCliente extends EntidadeAuditavel{

    @JsonIgnore
   @ManyToOne
   private Cliente cliente;

   @Column
   private String rua;

   @Column
   private String numero;

   @Column
   private String bairro;

   @Column
   private String cep;

   @Column
   private String cidade;

   @Column
   private String estado;

   @Column
   private String complemento;
  


    
}
