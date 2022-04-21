
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author brener
 */

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome é um campo obrigatório.")
    @NotBlank(message = "O nome não pode ficar em branco.")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres.")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    
    @Min(value = 0, message = "O valor não pode ser negativo.")
    @NotNull(message = "O valor deve ser informado.")
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(6,2)")
    private Double valor;
    
    @ManyToMany
    @JoinTable(name = "produtos",
            // Se refere a classe usuário.
            joinColumns = 
                    @JoinColumn(name = "produto", referencedColumnName = "id", 
                                nullable = false),
            // Se refere ao tipo da lista <Servico>
            inverseJoinColumns = 
                    @JoinColumn(name = "servico", referencedColumnName = "id", 
                                nullable = false)
    )            
    private Set<Servico> servicos = new HashSet<>();
    
    public Produto() {

    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    /**
     * @return the servicos
     */
    public Set<Servico> getServicos() {
        return servicos;
    }

    /**
     * @param servicos the servicos to set
     */
    public void setServicos(Set<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}