package br.edu.ifpe.oxefood.api.voto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VotoDTO {

    private Long id;

    @NotNull(message = "O Nome é de preenchimento obrigatório")
    @NotEmpty(message = "O Nome é de preenchimento obrigatório")
    @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
    private String nomeEleitor;

    private LocalDateTime dataVotacao;

    @NotBlank(message = "O Título de Eleitor é de preenchimento obrigatório")
   
    private String numeroRegistroEleitoral;
    
    @Length(min = 4, max = 4, message = "O campo Deputado Federal tem que ter 4 caracteres")
    private Integer numeroCandidatoDepFederal;

    @Length(min = 5, max = 5, message = "O campo Deputado Estadual tem que ter 5 caracteres")
    private Integer numeroCandidatoDepEstadual;

    @Length(min = 3, max = 3, message = "O campo Senador tem que ter 3 caracteres")
    private Integer numeroCandidatoSenador;

    @Length(min = 2, max = 2, message = "O campo Governador tem que ter 2 caracteres")
    private Integer numeroCandidatoGovernador;

    @Length(min = 2, max = 2, message = "O campo Presidente tem que ter 2 caracteres")
    private Integer numeroCandidatoPresidente;

   

}
