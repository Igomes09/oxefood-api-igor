package br.edu.ifpe.oxefood.api.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EnderecoClienteDTO {

    
   private String rua;

   private String numero;

   private String bairro;

   private String cep;

   private String cidade;

   private String estado;

   private String complemento;


    
}
