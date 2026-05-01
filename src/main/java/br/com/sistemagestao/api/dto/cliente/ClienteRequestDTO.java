package br.com.sistemagestao.api.dto.cliente;

import jakarta.validation.constraints.NotNull;

public record ClienteRequestDTO(
        @NotNull
        String nome,

        @NotNull
        String cpf,

        @NotNull
        String email,

        @NotNull
        String telefone
) {
}
