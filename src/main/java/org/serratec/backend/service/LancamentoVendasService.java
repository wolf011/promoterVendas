package org.serratec.backend.service;

import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.exception.LancamentoVendasException;
import org.serratec.backend.repository.LancamentoVendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LancamentoVendasService {

    @Autowired
    private LancamentoVendasRepository repository;

    public LancamentoVendasResponseDTO inserir(LancamentoVendas lancamento) {
        Optional<LancamentoVendas> lances = repository.findById(lancamento.getIdVenda());
        if (lances.isEmpty()) {
            throw new LancamentoVendasException("Venda não encontrada");
        }

        LancamentoVendas lancamentoEntity = new LancamentoVendas();
        lancamentoEntity.setDataVenda(lances.get().getDataVenda());
        lancamentoEntity.setValorVenda(lances.get().getValorVenda());
        lancamentoEntity.getVendedor().setNome(lances.get().getVendedor().getNome());
        lancamentoEntity = repository.save(lancamentoEntity);

        return new LancamentoVendasResponseDTO(lancamentoEntity.getDataVenda(),
                lancamentoEntity.getValorVenda(), lancamentoEntity.getVendedor().getNome());

    }

    public List<LancamentoVendasResponseDTO> listar () {
        List<LancamentoVendas> lancamentos = repository.findAll();
        List<LancamentoVendasResponseDTO> lancamentosDTO = new ArrayList<>();

        for (LancamentoVendas l: lancamentos) {
            lancamentosDTO.add(new LancamentoVendasResponseDTO(l.getDataVenda(), l.getValorVenda(), l.getVendedor().getNome()));
        }
        return lancamentosDTO;
    }
    

}
