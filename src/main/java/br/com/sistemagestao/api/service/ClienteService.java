package br.com.sistemagestao.api.service;


import br.com.sistemagestao.api.model.Cliente;
import br.com.sistemagestao.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

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

    public Optional<Cliente> atualizarClientePorId(Long id) {

    }
}
