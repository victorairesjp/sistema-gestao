package br.com.sistemagestao.api.service;

import br.com.sistemagestao.api.model.Fornecedor;
import br.com.sistemagestao.api.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;

    public void criarFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarTodosFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public void deletarFornecedorPorId(Long id) {
        fornecedorRepository.deleteById(id);
    }

    public void atualizarFornecedorPorId(Long id, Fornecedor fornecedorAtualizadoNoFront) {
        // 1 - Pegar o que existe
        Optional<Fornecedor> fornecedor = buscarFornecedorPorId(id);

        // 2 - Validar antes se fornecedor existe no DB
        if (fornecedor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado.");
        }

        // 3 - Sobrescrever com a att
        Fornecedor fornecedorAtualizado = fornecedor.get();

        fornecedorAtualizado.setNomeFantasia(fornecedorAtualizadoNoFront.getNomeFantasia());
        fornecedorAtualizado.setEmail(fornecedorAtualizadoNoFront.getEmail());
        fornecedorAtualizado.setTelefonePrincipal(fornecedorAtualizadoNoFront.getTelefonePrincipal());
        fornecedorAtualizado.setTelefoneSecundario(fornecedorAtualizadoNoFront.getTelefoneSecundario());

        // 4 - Devolver atualizado para o DB
        fornecedorRepository.save(fornecedorAtualizado);


    }
}