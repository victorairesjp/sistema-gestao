package br.com.sistemagestao.api.dto.cliente;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone
) {
}
