package br.com.sistemagestao.api.dto.produto;

import br.com.sistemagestao.api.enums.CategoriaProdutoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public record ProdutoRequestDTO(
        @NotBlank(message = "O nome do produto é obrigatório.")
        String nome,

        String descricao,

        @NotNull(message = "O preço é obrigatório.")
        @PositiveOrZero(message = "O preço deve ser maior ou igual a zero.")
        BigDecimal preco,

        @NotNull(message = "A quantidade em estoque é obrigatória.")
        @PositiveOrZero(message = "A quantidade em estoque não pode ser negativa.")
        Integer quantidadeEstoque,

        @NotNull(message = "A categoria é obrigatória.")
        CategoriaProdutoEnum categoria,

        @NotNull(message = "O ID do fornecedor é obrigatório.")
        Long fornecedorId
) {
}
