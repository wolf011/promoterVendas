package org.serratec.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class LancamentoVendas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVenda;

    @CurrentTimestamp
    private LocalDateTime dataVenda;

    private BigDecimal valorVenda;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    private Vendedor vendedor;


    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

//    public VendedorAutonomo getVendedorAutonomo() {
//        return vendedorAutonomo;
//    }
//
//    public void setVendedorAutonomo(VendedorAutonomo vendedorAutonomo) {
//        this.vendedorAutonomo = vendedorAutonomo;
//    }
//
//    public VendedorEmpresa getVendedorEmpresa() {
//        return vendedorEmpresa;
//    }
//
//    public void setVendedorEmpresa(VendedorEmpresa vendedorEmpresa) {
//        this.vendedorEmpresa = vendedorEmpresa;
//    }


    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
