package br.com.sistemagestao.api.dto.cliente;

import br.com.sistemagestao.api.dto.endreco.EnderecoDTO;
import java.time.LocalDate;

public record ClienteResponseDTO(
        Long id,
        String nomeCompleto,
        String cpf,
        String email,
        String telefone,
        LocalDate dataNascimento,
        EnderecoDTO endereco
) {}
