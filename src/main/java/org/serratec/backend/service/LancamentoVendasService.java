package org.serratec.backend.service;

import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.entity.Vendedor;
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

//    ## EM CONTRUCAO
    public LancamentoVendasResponseDTO inserirLancamento(LancamentoVendas lancamento) {
//        Optional<LancamentoVendas> lances = repository.findById(lancamento.getIdVenda());
//        Optional<Vendedor> vendedor = repository.findById(lancamento.getVendedor().getIdVendedor());
//        if (lances.isPresent()) {
//            throw new LancamentoVendasException("Venda já existe");
//        }
        LancamentoVendas lancamentoEntity = new LancamentoVendas();
        lancamentoEntity.setDataVenda(lancamento.getDataVenda());
        lancamentoEntity.setValorVenda(lancamento.getValorVenda());
        lancamentoEntity.getVendedor().setNome(lancamento.getVendedor().getNome());
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

    public LancamentoVendasResponseDTO listarPorId(Long id) {
        Optional<LancamentoVendas> lancamento = repository.findById(id);

        if (lancamento.isEmpty()) {
            throw new LancamentoVendasException("Lançamento não existente");
        }

        return new LancamentoVendasResponseDTO(lancamento.get().getDataVenda(), lancamento.get().getValorVenda(), lancamento.get().getVendedor().getNome());
    }


}
