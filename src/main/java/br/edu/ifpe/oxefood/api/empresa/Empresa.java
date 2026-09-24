
package br.edu.ifpe.oxefood.api.empresa;

import org.hibernate.annotations.SQLRestriction;

import br.edu.ifpe.oxefood.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Empresa")
@SQLRestriction("habilitado = true")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends EntidadeAuditavel  {
    
    @Column
   private String site;

   @Column
   private String cnpj;

   @Column
   private String inscricaoEstadual;

   @Column
   private String nomeEmpresarial;

   @Column
   private String nomeFantasia;

   @Column
   private String fone;

   @Column
   private Double foneAlternativo;

}
