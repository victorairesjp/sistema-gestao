package br.com.sistemagestao.api.dto.fornecedor;

import br.com.sistemagestao.api.dto.endreco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FornecedorRequestDTO(
        @NotBlank(message = "O nome fantasia do fornecedor é obrigatório.")
        String nomeFantasia,

        @NotBlank(message = "O CNPJ do fornecedor é obrigatório.")
        String cnpj,

        @NotBlank(message = "O email do fornecedor é obrigatório.")
        String email,

        @NotBlank(message = "O telefone do fornecedor é obrigatório.")
        String telefonePrincipal,

        String telefoneSecundario,

        @NotNull(message = "O endereço é obrigatório.")
        @Valid
        EnderecoDTO endereco
) {
}
