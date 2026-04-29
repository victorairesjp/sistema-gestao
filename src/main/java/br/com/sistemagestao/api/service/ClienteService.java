package br.com.sistemagestao.api.service;


import br.com.sistemagestao.api.model.Cliente;
import br.com.sistemagestao.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void criarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void atualizarClientePorId(Long id, Cliente clienteAttFront) {

        // Recebendo do DB
        Optional<Cliente> cliente = clienteRepository.findById(id);

        // Validando cliente no DB
        if (cliente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado.");
        }

        // Setando atualização
        Cliente clienteAtt = cliente.get(); // Tira do Optional e coloca numa variável do tipo Entity

        clienteAtt.setNome(clienteAttFront.getNome());
        clienteAtt.setEmail(clienteAttFront.getEmail());
        clienteAtt.setTelefone(clienteAttFront.getTelefone());

        clienteRepository.save(clienteAtt);
    }

    public void deletarClientePorId(Long id) {
        clienteRepository.deleteById(id);
    }
}
