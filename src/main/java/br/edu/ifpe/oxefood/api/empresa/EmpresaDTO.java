package br.edu.ifpe.oxefood.api.empresa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDTO {
    
    private String site;

   private String cnpj;

   private String inscricaoEstadual;

   private String nomeEmpresarial;

   private String nomeFantasia;

   private String fone;

   private Double foneAlternativo;
}