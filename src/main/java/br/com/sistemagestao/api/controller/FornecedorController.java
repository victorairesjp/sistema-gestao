package br.com.sistemagestao.api.controller;

import br.com.sistemagestao.api.dto.fornecedor.FornecedorRequestDTO;
import br.com.sistemagestao.api.dto.fornecedor.FornecedorResponseDTO;
import br.com.sistemagestao.api.model.Fornecedor;
import br.com.sistemagestao.api.service.FornecedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fornecedores")
@RequiredArgsConstructor
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FornecedorResponseDTO criarFornecedor(@Valid @RequestBody FornecedorRequestDTO dto) {
        return fornecedorService.criarFornecedor(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FornecedorResponseDTO> listarTodosFornecedores() {
        return fornecedorService.listarTodosFornecedores();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FornecedorResponseDTO buscarFornecedorPorId(@PathVariable Long id) {
        return fornecedorService.buscarFornecedorPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FornecedorResponseDTO atualizarFornecedorPorId(@PathVariable Long id,
                                                          @Valid @RequestBody FornecedorRequestDTO dto) {
        return fornecedorService.atualizarFornecedorPorId(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarFornecedorPorId(@PathVariable Long id) {
        fornecedorService.deletarFornecedorPorId(id);
    }
}
