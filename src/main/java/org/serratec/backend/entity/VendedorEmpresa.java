package org.serratec.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
public class VendedorEmpresa extends Vendedor{

    @NotBlank
    private String numeroCarteiraTrabalho;

    @Temporal(TemporalType.DATE)
    private LocalDate dataAdmissao;

    public String getNumeroCarteiraTrabalho() {
        return numeroCarteiraTrabalho;
    }

    public void setNumeroCarteiraTrabalho(String numeroCarteiraTrabalho) {
        this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
}
