package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author edudieguez
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_estado", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 50, message = "ESTADO - O número máximo de caracteres é: {max}")
    @NotBlank(message = "ESTADO - O campo nome deve ser informado!")
    @NotNull(message = "ESTADO - Não pode ser nulo!!!")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Length(max = 2, message = "UF - O número máximo de caracteres é: {max}")
    @NotBlank(message = "UF - O campo nome deve ser informado!")
    @NotNull(message = "UF - Não pode ser nulo!!!")
    @Column(name = "uf", length = 2, nullable = false)    
    private String uf;

    @NotNull(message = "PAÍS - Não pode ser nulo!!!")
    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_pais")
    private Pais pais;
 
    
    public Estado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
