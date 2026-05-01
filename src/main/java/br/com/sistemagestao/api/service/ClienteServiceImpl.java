package br.com.sistemagestao.api.service;


import br.com.sistemagestao.api.dto.cliente.ClienteRequestDTO;
import br.com.sistemagestao.api.dto.cliente.ClienteResponseDTO;
import br.com.sistemagestao.api.mapper.ClienteMapper;
import br.com.sistemagestao.api.model.Cliente;
import br.com.sistemagestao.api.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;

    public ClienteResponseDTO criarCliente(ClienteRequestDTO dto) {
        Cliente cliente = ClienteMapper.toEntity(dto);
        clienteRepository.save(cliente);

        return ClienteMapper.toResponseDTO(cliente);
    }

    @Override
    public List<ClienteResponseDTO> listarTodosCliente() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ClienteResponseDTO buscarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));

        return ClienteMapper.toResponseDTO(cliente);
    }

    @Override
    public ClienteResponseDTO atualizarClientePorId(Long id, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));

        cliente.setNome(dto.nome());
        cliente.setCpf(dto.cpf());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());

        clienteRepository.save(cliente);

        return ClienteMapper.toResponseDTO(cliente);
    }

    @Override
    public void deletarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));

        clienteRepository.deleteById(id);
    }

}
