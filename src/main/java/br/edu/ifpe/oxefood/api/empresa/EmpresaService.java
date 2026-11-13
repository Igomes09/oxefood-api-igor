package br.edu.ifpe.oxefood.api.empresa;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpe.oxefood.api.acesso.Perfil;
import br.edu.ifpe.oxefood.api.acesso.PerfilRepository;
import br.edu.ifpe.oxefood.api.acesso.Usuario;
import br.edu.ifpe.oxefood.api.acesso.UsuarioService;
import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

    private final EmpresaRepository repository;
    private final UsuarioService usuarioService;
    private final PerfilRepository perfilUsuarioRepository;

    public EmpresaService(EmpresaRepository repository, UsuarioService usuarioService,
            PerfilRepository perfilUsuarioRepository) {
        this.repository = repository;
        this.usuarioService = usuarioService;
        this.perfilUsuarioRepository = perfilUsuarioRepository;

    }

    public Empresa build(EmpresaDTO dto) {

        
        Empresa empresa = null;

        if (dto.getId() == null) { // Montado para o cadastro

            empresa = new Empresa();

            Usuario usuario = new Usuario();
            usuario.setUsername(dto.getEmail());
            usuario.setPassword(dto.getPassword());
            usuario.getRoles().add(new Perfil(Perfil.ROLE_CLIENTE));
            empresa.setUsuario(usuario);


        empresa.setCnpj(dto.getCnpj());
        empresa.setSite(dto.getSite());
        empresa.setInscricaoEstadual(dto.getInscricaoEstadual());
        empresa.setNomeEmpresarial(dto.getNomeEmpresarial());
        empresa.setNomeFantasia(dto.getNomeFantasia());
        empresa.setFone(dto.getFone());
        empresa.setFoneAlternativo(dto.getFoneAlternativo());

        }

        return empresa;
    
}

    @Transactional
    public Empresa cadastrar(EmpresaDTO dto) {

        Empresa empresa = build(dto);
        usuarioService.save(empresa.getUsuario());

        for (Perfil perfil : empresa.getUsuario().getRoles()) {
            perfil.setHabilitado(Boolean.TRUE);
            perfilUsuarioRepository.save(perfil);
        }

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
