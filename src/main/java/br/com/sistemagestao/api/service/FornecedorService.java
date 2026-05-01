package br.com.sistemagestao.api.service;

import br.com.sistemagestao.api.dto.fornecedor.FornecedorRequestDTO;
import br.com.sistemagestao.api.dto.fornecedor.FornecedorResponseDTO;
import java.util.List;

public interface FornecedorService {
    FornecedorResponseDTO criarFornecedor(FornecedorRequestDTO dto);
    List<FornecedorResponseDTO> listarTodosFornecedores();
    FornecedorResponseDTO buscarFornecedorPorId(Long id);
    FornecedorResponseDTO atualizarFornecedorPorId(Long id, FornecedorRequestDTO dto);
    void deletarFornecedorPorId(Long id);
}
