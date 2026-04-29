package br.com.sistemagestao.api.service;

import br.com.sistemagestao.api.dto.produto.ProdutoRequestDTO;
import br.com.sistemagestao.api.dto.produto.ProdutoResponseDTO;
import br.com.sistemagestao.api.mapper.ProdutoMapper;
import br.com.sistemagestao.api.model.Fornecedor;
import br.com.sistemagestao.api.model.Produto;
import br.com.sistemagestao.api.repository.FornecedorRepository;
import br.com.sistemagestao.api.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final FornecedorRepository fornecedorRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO dto) {
        // Resgatar do DB o fornecedor desse produto
        Fornecedor fornecedor = fornecedorRepository.findById(dto.fornecedorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Fornecedor não encontrado."));

        // Converter o DTO para Entity, para salvar no DB
        Produto produto = ProdutoMapper.toEntity(dto, fornecedor);

        // Salvar no DB a Entity
        produtoRepository.save(produto);

        // Para o front passamos o DTO
        return ProdutoMapper.toResponseDTO(produto);
    }

    @Override
    public List<ProdutoResponseDTO> listarTodosProdutos(ProdutoRequestDTO dto) {
        return List.of();
    }

    @Override
    public ProdutoResponseDTO buscarProdutoPorId(Long id) {
        return null;
    }

    @Override
    public ProdutoResponseDTO atualizarProdutoPorId(Long id, ProdutoRequestDTO dto) {
        return null;
    }

    @Override
    public void deletarProdutoPorId(Long id) {

    }

}
