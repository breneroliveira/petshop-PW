
package br.edu.ifsul.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author brener
 */

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {
    
    @NotNull(message = "O nome do funcionario é um campo obrigatório.")
    @NotBlank(message = "O nome do funcionario não pode ficar em branco.")
    @Length(max = 40, message = "O nome do funcionario não pode ter mais que {max} caracteres.")
    @Column(name = "nome_funcionario", length = 40, nullable = false)
    private String nomeUsuario;
    
    @NotNull(message = "A senha é um campo obrigatório.")
    @NotBlank(message = "A senha não pode ficar em branco.")
    @Length(max = 40, message = "A senha não pode ter mais que {max} caracteres.")
    @Column(name = "senha", length = 40, nullable = false)
    private String senha;
    
    @NotNull(message = "O campo ativo deve ser informado.")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    public Funcionario() {
        
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /*@Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nomeUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        return true;
    }*/
}