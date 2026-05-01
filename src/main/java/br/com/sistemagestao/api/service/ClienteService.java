package br.com.sistemagestao.api.service;

import br.com.sistemagestao.api.dto.cliente.ClienteRequestDTO;
import br.com.sistemagestao.api.dto.cliente.ClienteResponseDTO;
import br.com.sistemagestao.api.dto.produto.ProdutoRequestDTO;
import br.com.sistemagestao.api.dto.produto.ProdutoResponseDTO;

import java.util.List;

public interface ClienteService {
    ClienteResponseDTO criarCliente(ClienteRequestDTO dto);
    List<ClienteResponseDTO> listarTodosCliente();
    ClienteResponseDTO buscarClientePorId(Long id);
    ClienteResponseDTO atualizarClientePorId(Long id, ClienteRequestDTO dto);
    void deletarClientePorId(Long id);
}
