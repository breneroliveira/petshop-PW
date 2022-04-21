
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author brener
 */

@Entity
@Table(name = "ordem_servico")
public class OrdemServico implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_ordem_servico", sequenceName = "seq_ordem_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_ordem_servico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A descrição é um campo obrigatório.")
    @NotBlank(message = "A descrição não pode ficar em branco.")
    @Length(max = 40, message = "A descrição não pode ter mais que {max} caracteres.")
    @Column(name = "descricao", length = 40, nullable = false)
    private String descricao;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada.")
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @NotNull(message = "O valor total deve ser informado.")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(6,2)")
    private Double valorTotal;
    
    @OneToMany(mappedBy = "ordem_servico", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemServico> itemServicos = new ArrayList<>();
    
    @NotNull(message = "O pet deve ser informado.")
    @ManyToOne
    @JoinColumn(name = "pet", referencedColumnName = "id", nullable = false)
    private Pet pet;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)    
    private Pessoa pessoa;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "id"/*tentar nome_funcionario também*/, nullable = false)    
    private Funcionario funcionario;
    
    @OneToMany(mappedBy = "ordem_servico", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemServico> itensServicos = new ArrayList<>();
    
    public OrdemServico() {
        
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    /**
     * @return the itemServicos
     */
    public List<ItemServico> getItemServicos() {
        return itemServicos;
    }

    /**
     * @param itemServicos the itemServicos to set
     */
    public void setItemServicos(List<ItemServico> itemServicos) {
        this.itemServicos = itemServicos;
    }

    /**
     * @return the pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * @param pet the pet to set
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final OrdemServico other = (OrdemServico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}