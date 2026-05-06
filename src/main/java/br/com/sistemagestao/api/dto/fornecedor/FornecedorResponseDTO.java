package br.com.sistemagestao.api.dto.fornecedor;

import br.com.sistemagestao.api.dto.endreco.EnderecoDTO;
import br.com.sistemagestao.api.model.Endereco;

public record FornecedorResponseDTO(
        Long id,
        String nomeFantasia,
        String cnpj,
        String email,
        String telefonePrincipal,
        String telefoneSecundario,
        EnderecoDTO endereco
) {
}
