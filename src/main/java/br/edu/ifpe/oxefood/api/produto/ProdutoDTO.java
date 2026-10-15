package br.edu.ifpe.oxefood.api.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

   private Long id;

   private Long idCategoria;
 
   private String codigo;

   private String titulo;

   private String descricao;

   private String tempoEntregaMinimo;

   private Double valorUnitario;

   private String tempoEntregaMaximo;
}