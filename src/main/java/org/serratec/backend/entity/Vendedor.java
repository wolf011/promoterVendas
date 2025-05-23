package org.serratec.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass
public abstract class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long idVendedor;

    protected String nome;
    
    @Email(message = "Email inválido")
    protected String email;
    
    @DecimalMin(value = "1518.00")
    protected BigDecimal salario;

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
