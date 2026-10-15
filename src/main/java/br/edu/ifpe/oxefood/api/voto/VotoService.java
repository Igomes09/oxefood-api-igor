package br.edu.ifpe.oxefood.api.voto;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class VotoService {

    private final VotoRepository repository;

    public VotoService(VotoRepository repository) {
        this.repository = repository;
    }

    public Voto build(VotoDTO dto) {

         Voto Voto = null;

      if (dto.getId() == null) { //Montado para o cadastro

         Voto = new Voto();

      } else { //Consultado para a alteração

         Voto = repository.findById(dto.getId()).get();
      }
        Voto.setNomeEleitor(dto.getNomeEleitor());
        Voto.setDataVotacao(dto.getDataVotacao());
        Voto.setNumeroRegistroEleitoral(dto.getNumeroRegistroEleitoral());
        Voto.setNumeroCandidatoDepFederal(dto.getNumeroCandidatoDepFederal());
        Voto.setNumeroCandidatoDepEstadual(dto.getNumeroCandidatoDepEstadual());

        Voto.setNumeroCandidatoSenador(dto.getNumeroCandidatoSenador());

        Voto.setNumeroCandidatoGovernador(dto.getNumeroCandidatoGovernador());
        Voto.setNumeroCandidatoPresidente(dto.getNumeroCandidatoPresidente());

        return Voto;
    }

    @Transactional
    public Voto cadastrar(VotoDTO dto) {

        Voto Voto = build(dto);
        Voto.setHabilitado(true);
        return repository.save(Voto); // Insert
    }

    @Transactional
    public Voto atualizar(VotoDTO dto) {

        Voto Voto = build(dto);
        return repository.save(Voto);
    } //Update



    public List<Voto> listar() {

        return repository.findAll(); // SELECT * FROM Voto
    }

    public Voto buscarPorId(Long id) {

        return repository.findById(id).get(); // SELECT * FROM Voto WHERE id = ?
    }

    @Transactional
    public void remover(Long id) {

        Voto Voto = repository.findById(id).get();
        Voto.setHabilitado(false);

        repository.save(Voto);
   }

    
}
