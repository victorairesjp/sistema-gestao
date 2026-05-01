package br.com.sistemagestao.api.mapper;

import br.com.sistemagestao.api.dto.fornecedor.FornecedorRequestDTO;
import br.com.sistemagestao.api.dto.fornecedor.FornecedorResponseDTO;
import br.com.sistemagestao.api.model.Fornecedor;

public class FornecedorMapper {

    public static Fornecedor toEntity(FornecedorRequestDTO dto) {
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNomeFantasia(dto.nomeFantasia());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setEmail(dto.email());
        fornecedor.setTelefonePrincipal(dto.telefonePrincipal());
        fornecedor.setTelefoneSecundario(dto.telefoneSecundario());

        return fornecedor;
    }


    public static FornecedorResponseDTO toResponseDTO(Fornecedor fornecedor) {
        FornecedorResponseDTO dto = new FornecedorResponseDTO(
                fornecedor.getId(),
                fornecedor.getNomeFantasia(),
                fornecedor.getCnpj(),
                fornecedor.getEmail(),
                fornecedor.getTelefonePrincipal(),
                fornecedor.getTelefoneSecundario()
        );

        return dto;
    }
}
