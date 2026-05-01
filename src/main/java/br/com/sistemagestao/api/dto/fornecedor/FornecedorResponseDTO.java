package br.com.sistemagestao.api.dto.fornecedor;

public record FornecedorResponseDTO(
        Long id,
        String nomeFantasia,
        String cnpj,
        String email,
        String telefonePrincipal,
        String telefoneSecundario
) {
}
