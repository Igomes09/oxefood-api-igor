package br.edu.ifpe.oxefood.api.produto;

import org.hibernate.annotations.SQLRestriction;

import br.edu.ifpe.oxefood.api.categoriaproduto.CategoriaProduto;
import br.edu.ifpe.oxefood.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Produto")
@SQLRestriction("habilitado = true")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends EntidadeAuditavel  {
    
    
   @ManyToOne
   private CategoriaProduto categoria;

   @Column
   private String codigo;

   @Column
   private String titulo;

   @Column
   private String descricao;

   @Column
   private String tempoEntregaMinimo;

   @Column
   private Double valorUnitario;

   @Column
   private String tempoEntregaMaximo;

}
