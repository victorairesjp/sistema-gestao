package br.com.sistemagestao.api.dto.fornecedor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FornecedorRequestDTO(
        @NotBlank(message = "O nome fantasia do fornecedor é obrigatório.")
        String nomeFantasia,

        @NotNull(message = "O CNPJ do fornecedor é obrigatório.")
        String cnpj,

        @NotNull(message = "O email do fornecedor é obrigatório.")
        String email,

        @NotNull(message = "O Telefone do fornecedor é obrigatório.")
        String telefonePrincipal,

        String telefoneSecundario
) {
}
