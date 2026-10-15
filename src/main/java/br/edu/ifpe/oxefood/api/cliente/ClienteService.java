package br.edu.ifpe.oxefood.api.cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final EnderecoClienteRepository enderecoClienteRepository;

    public ClienteService(ClienteRepository repository, EnderecoClienteRepository enderecoClienteRepository) {
        this.repository = repository;
        this.enderecoClienteRepository = enderecoClienteRepository;
    }

    public Cliente build(ClienteDTO dto) {

        Cliente cliente = null;

        if (dto.getId() == null) { // Montado para o cadastro

            cliente = new Cliente();

        } else { // Consultado para a alteração

            cliente = repository.findById(dto.getId()).get();
        }
        cliente.setNome(dto.getNome());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setCpf(dto.getCpf());
        cliente.setFoneCelular(dto.getFoneCelular());
        cliente.setFoneFixo(dto.getFoneFixo());

        return cliente;
    }

    public EnderecoCliente buildEnderecoCliente(EnderecoClienteDTO dto, Long id) {

        EnderecoCliente endereco = null;

        if (id == null) { // Montado para o cadastro
            endereco = new EnderecoCliente();
        } else { // Consultado para a alteração
            endereco = enderecoClienteRepository.findById(id).get();
        }

        endereco.setRua(dto.getRua());
        endereco.setNumero(dto.getNumero());
        endereco.setBairro(dto.getBairro());
        endereco.setCep(dto.getCep());
        endereco.setCidade(dto.getCidade());
        endereco.setEstado(dto.getEstado());
        endereco.setComplemento(dto.getComplemento());

        return endereco;
    }

    @Transactional
    public Cliente cadastrar(ClienteDTO dto) {

        Cliente cliente = build(dto);
        cliente.setHabilitado(true);
        return repository.save(cliente); // Insert
    }

    @Transactional
    public Cliente atualizar(ClienteDTO dto) {

        Cliente cliente = build(dto);
        return repository.save(cliente);
    } // Update

    public List<Cliente> listar() {

        return repository.findAll(); // SELECT * FROM Cliente
    }

    public Cliente buscarPorId(Long id) {

        return repository.findById(id).get(); // SELECT * FROM Cliente WHERE id = ?
    }

    @Transactional
    public void remover(Long id) {

        Cliente cliente = repository.findById(id).get();
        cliente.setHabilitado(false);

        repository.save(cliente);
    }

    @Transactional
    public EnderecoCliente adicionarEnderecoCliente(Long clienteId, EnderecoClienteDTO dto) {

        EnderecoCliente endereco = buildEnderecoCliente(dto, null);

        Cliente cliente = this.buscarPorId(clienteId);

        // Primeiro salva o EnderecoCliente:

        endereco.setCliente(cliente);
        endereco.setHabilitado(Boolean.TRUE);
        enderecoClienteRepository.save(endereco);

        // Depois acrescenta o endereço criado ao cliente e atualiza o cliente:

        List<EnderecoCliente> listaEnderecoCliente = cliente.getEnderecos();

        if (listaEnderecoCliente == null) {
            listaEnderecoCliente = new ArrayList<EnderecoCliente>();
        }

        listaEnderecoCliente.add(endereco);
        cliente.setEnderecos(listaEnderecoCliente);
        repository.save(cliente);

        return endereco;
    }

    @Transactional
    public EnderecoCliente atualizarEnderecoCliente(Long id, EnderecoClienteDTO dto) {

        EnderecoCliente endereco = buildEnderecoCliente(dto, id);
        return enderecoClienteRepository.save(endereco);
    }

    @Transactional
    public void removerEnderecoCliente(Long idEndereco) {

        EnderecoCliente endereco = enderecoClienteRepository.findById(idEndereco).get();
        endereco.setHabilitado(Boolean.FALSE);
        enderecoClienteRepository.save(endereco);

        Cliente cliente = this.buscarPorId(endereco.getCliente().getId());
        cliente.getEnderecos().remove(endereco);
        repository.save(cliente);
    }

}
