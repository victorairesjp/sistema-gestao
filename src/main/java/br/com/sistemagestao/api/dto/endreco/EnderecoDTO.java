package br.com.sistemagestao.api.dto.endreco;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EnderecoDTO(

        Long id,

        @NotBlank(message = "O CEP é obrigatório.")
        String cep,

        @NotBlank(message = "O logradouro é obrigatório.")
        String logradouro,

        @NotBlank(message = "O numero é obrigatório.")
        String numero,

        String complemento,

        @NotBlank(message = "O bairro é obrigatório.")
        String bairro,

        @NotBlank(message = "A cidade é obrigatória.")
        String cidade,

        @NotBlank(message = "A UF é obrigatória.")
        @Size(min = 2, max = 2, message = "A UF deve ter 2 letras.")
        String uf
) {
}
