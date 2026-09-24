package br.edu.ifpe.oxefood.api.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
 

   private String codigo;

   private String titulo;

   private String descricao;

   private Integer tempoEntregaMinimo;

   private Double valorUnitario;

   private Integer tempoEntregaMaximo;
}