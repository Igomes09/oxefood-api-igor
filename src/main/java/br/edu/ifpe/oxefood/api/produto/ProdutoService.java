package br.edu.ifpe.oxefood.api.produto;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpe.oxefood.exception.ProdutoException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
       this.repository = repository;
    }

    public Produto build(ProdutoDTO dto) {

        Produto produto = new Produto();
        produto.setCodigo(dto.getCodigo());
        produto.setTitulo(dto.getTitulo());
        produto.setDescricao(dto.getDescricao());
        produto.setTempoEntregaMinimo(dto.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(dto.getTempoEntregaMaximo());



        return produto;
    }

    @Transactional
    public Produto cadastrar(ProdutoDTO dto) {

        Produto produto = build(dto);

        if (produto.getValorUnitario() < 10) {
        		throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
       	}

        produto.setHabilitado(true);
        return repository.save(produto);
    }

    public List<Produto> listar() {

        return repository.findAll(); // SELECT * FROM Produto
    }

    public Produto buscarPorId(Long id) {

        return repository.findById(id).get(); // SELECT * FROM Produto WHERE id = ?
    }

    @Transactional
   public void remover(Long id) {

        Produto produto = repository.findById(id).get();
        produto.setHabilitado(false);

        repository.save(produto);
   }



}
