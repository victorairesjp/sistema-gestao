package br.com.sistemagestao.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "clientes")
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // Cascade = toda operação feita em Cliente, será feito também em Endereço. orphanRemoval = Se o Endereço ficar sem cliente apontando para ele, será apagado do banco automaticamente.
    @JoinColumn(name = "endereco_id", nullable = false) // FK na tabela clientes
    private Endereco endereco;

}
