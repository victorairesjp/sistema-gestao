package br.com.sistemagestao.api.mapper;

import br.com.sistemagestao.api.dto.cliente.ClienteRequestDTO;
import br.com.sistemagestao.api.dto.cliente.ClienteResponseDTO;
import br.com.sistemagestao.api.dto.endreco.EnderecoDTO;
import br.com.sistemagestao.api.model.Cliente;
import br.com.sistemagestao.api.model.Endereco;

public class ClienteMapper {

    // Converte RequestDTO → Entidade (criando o Endereco junto!)
    public static Cliente toEntity(ClienteRequestDTO dto) {

        Cliente cliente = new Cliente();

        cliente.setNomeCompleto(dto.nomeCompleto());
        cliente.setCpf(dto.cpf());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());
        cliente.setDataNascimento(dto.dataNascimento());

        // Cria o Endereco a partir do DTO aninhado e seta no cliente
        cliente.setEndereco(toEnderecoEntity(dto.endereco()));

        return cliente;
    }

    // Converte Entidade → ResponseDTO
    public static ClienteResponseDTO toResponseDTO(Cliente cliente) {

        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNomeCompleto(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getDataNascimento(),
                toEnderecoDTO(cliente.getEndereco())  // converte o Endereco aninhado
        );
    }

    // EnderecoDTO → Endereco (entidade)
    public static Endereco toEnderecoEntity(EnderecoDTO dto) {

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
    public static EnderecoDTO toEnderecoDTO(Endereco endereco) {

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
