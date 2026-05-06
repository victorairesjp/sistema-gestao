package br.com.sistemagestao.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "fornecedores")
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_fantasia", nullable = false)
    private String nomeFantasia;

    @Column(name = "cnpj", nullable = false, updatable = false, unique = true)
    private String cnpj;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone_principal", nullable = false)
    private String telefonePrincipal;

    @Column(name = "telefone_secundario")
    private String telefoneSecundario;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fornecedor_id", nullable = false) // FK na tabela fornecedores
    private Endereco endereco;
}
