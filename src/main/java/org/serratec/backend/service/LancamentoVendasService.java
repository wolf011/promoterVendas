package org.serratec.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

    @PersistenceContext
    private EntityManager entityManager;

    public LancamentoVendasResponseDTO inserirLancamento(LancamentoVendas lancamento) {
        Vendedor vendedor = entityManager.find(Vendedor.class, lancamento.getVendedor().getIdVendedor());
        if (vendedor == null) {
            throw new LancamentoVendasException("Vendedor não encontrado");
        }
        LancamentoVendas lancamentoEntity = new LancamentoVendas();
        lancamentoEntity.setDataVenda(lancamento.getDataVenda());
        lancamentoEntity.setValorVenda(lancamento.getValorVenda());
        lancamentoEntity.setVendedor(vendedor);
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
