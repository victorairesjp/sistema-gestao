package br.com.sistemagestao.api.service;

import br.com.sistemagestao.api.dto.fornecedor.FornecedorRequestDTO;
import br.com.sistemagestao.api.dto.fornecedor.FornecedorResponseDTO;
import br.com.sistemagestao.api.mapper.FornecedorMapper;
import br.com.sistemagestao.api.model.Fornecedor;
import br.com.sistemagestao.api.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedorServiceImpl implements FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    @Override
    public FornecedorResponseDTO criarFornecedor(FornecedorRequestDTO dto) {
        Fornecedor fornecedor = FornecedorMapper.toEntity(dto);
        fornecedorRepository.save(fornecedor);

        return FornecedorMapper.toResponseDTO(fornecedor);
    }

    @Override
    public List<FornecedorResponseDTO> listarTodosFornecedores() {
        return fornecedorRepository.findAll()
                .stream()
                .map(FornecedorMapper::toResponseDTO)
                .toList();
    }

    @Override
    public FornecedorResponseDTO buscarFornecedorPorId(Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));

        return FornecedorMapper.toResponseDTO(fornecedor);
    }

    @Override
    public FornecedorResponseDTO atualizarFornecedorPorId(Long id, FornecedorRequestDTO dto) {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));

        fornecedor.setNomeFantasia(dto.nomeFantasia());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setEmail(dto.email());
        fornecedor.setTelefonePrincipal(dto.telefonePrincipal());
        fornecedor.setTelefoneSecundario(dto.telefoneSecundario());

        fornecedorRepository.save(fornecedor);

        return FornecedorMapper.toResponseDTO(fornecedor);
    }

    @Override
    public void deletarFornecedorPorId(Long id) {
        fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));

        fornecedorRepository.deleteById(id);
    }
}
