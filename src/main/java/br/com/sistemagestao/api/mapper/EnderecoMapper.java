package br.com.sistemagestao.api.mapper;

import br.com.sistemagestao.api.dto.endreco.EnderecoDTO;
import br.com.sistemagestao.api.model.Endereco;

public class EnderecoMapper {

    // EnderecoDTO → Endereco (entidade)
    public static Endereco toEntity(EnderecoDTO dto) {

        Endereco endereco = new Endereco();

        endereco.setCep(dto.cep());
        endereco.setLogradouro(dto.logradouro());
        endereco.setNumero(dto.numero());
        endereco.setComplemento(dto.complemento());
        endereco.setBairro(dto.bairro());
        endereco.setCidade(dto.cidade());
        endereco.setUf(dto.uf());

        return endereco;
    }

    // Endereco (entidade) → EnderecoDTO
    public static EnderecoDTO toResponseDTO(Endereco endereco) {

        return new EnderecoDTO(
                endereco.getId(),
                endereco.getCep(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getUf()
        );
    }

}
