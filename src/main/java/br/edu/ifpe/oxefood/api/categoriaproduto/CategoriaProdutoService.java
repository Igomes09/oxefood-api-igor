package br.edu.ifpe.oxefood.api.categoriaproduto;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CategoriaProdutoService {

    private final CategoriaProdutoRepository repository;

    public CategoriaProdutoService(CategoriaProdutoRepository repository) {
        this.repository = repository;
    }

    public CategoriaProduto build(CategoriaProdutoDTO dto) {

         CategoriaProduto CategoriaProduto = null;

      if (dto.getId() == null) { //Montado para o cadastro

         CategoriaProduto = new CategoriaProduto();

      } else { //Consultado para a alteração

         CategoriaProduto = repository.findById(dto.getId()).get();
      }
        CategoriaProduto.setDescricao(dto.getDescricao());

        return CategoriaProduto;
    }

    @Transactional
    public CategoriaProduto cadastrar(CategoriaProdutoDTO dto) {

        CategoriaProduto CategoriaProduto = build(dto);
        CategoriaProduto.setHabilitado(true);
        return repository.save(CategoriaProduto); // Insert
    }

    @Transactional
    public CategoriaProduto atualizar(CategoriaProdutoDTO dto) {

        CategoriaProduto CategoriaProduto = build(dto);
        return repository.save(CategoriaProduto);
    } //Update



    public List<CategoriaProduto> listar() {

        return repository.findAll(); // SELECT * FROM CategoriaProduto
    }

    public CategoriaProduto buscarPorId(Long id) {

        return repository.findById(id).get(); // SELECT * FROM CategoriaProduto WHERE id = ?
    }

    @Transactional
    public void remover(Long id) {

        CategoriaProduto CategoriaProduto = repository.findById(id).get();
        CategoriaProduto.setHabilitado(false);

        repository.save(CategoriaProduto);
   }


    
}