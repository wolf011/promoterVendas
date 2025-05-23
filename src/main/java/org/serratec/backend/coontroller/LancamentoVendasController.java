package org.serratec.backend.coontroller;

import jakarta.validation.Valid;
import org.serratec.backend.dto.LancamentoVendasRequestDTO;
import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.service.LancamentoVendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoVendasController {

    @Autowired
    private LancamentoVendasService service;

    @GetMapping("/listar")
    public ResponseEntity<List<LancamentoVendasResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }


    @GetMapping("/listar/{id}")
    public ResponseEntity<LancamentoVendasResponseDTO> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPorId(id));
    }


    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public LancamentoVendasResponseDTO inserirLancamento(@Valid @RequestBody LancamentoVendas lancamento) { //######ERRRROOOO
        return service.inserirLancamento(lancamento);
    }

}
