package br.edu.ifpe.oxefood.api.empresa;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
       this.repository = repository;
    }

    public Empresa build(EmpresaDTO dto) {

        Empresa empresa = new Empresa();
        empresa.setCnpj(dto.getCnpj());
        empresa.setSite(dto.getSite());
        empresa.setInscricaoEstadual(dto.getInscricaoEstadual());
        empresa.setNomeEmpresarial(dto.getNomeEmpresarial());
        empresa.setNomeFantasia(dto.getNomeFantasia());
        empresa.setFone(dto.getFone());
        empresa.setFoneAlternativo(dto.getFoneAlternativo());


        return empresa;
    }

    @Transactional
    public Empresa cadastrar(EmpresaDTO dto) {

        Empresa empresa = build(dto);
        empresa.setHabilitado(true);
        return repository.save(empresa);
    }

    public List<Empresa> listar() {

        return repository.findAll(); // SELECT * FROM Empresa
    }

    public Empresa buscarPorId(Long id) {

        return repository.findById(id).get(); // SELECT * FROM Empresa WHERE id = ?
    }

    @Transactional
   public void remover(Long id) {

        Empresa empresa = repository.findById(id).get();
        empresa.setHabilitado(false);

        repository.save(empresa);
   }



}
