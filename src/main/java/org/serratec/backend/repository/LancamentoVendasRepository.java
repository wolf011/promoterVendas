package org.serratec.backend.repository;

import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LancamentoVendasRepository extends JpaRepository<LancamentoVendas, Long> {
}
