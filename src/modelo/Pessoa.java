/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author edudieguez
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_ir", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Length(max = 50, message = "NOME PESSOA - O número máximo de caracteres é: {max}")
    @NotBlank(message = "NOME PESSOA - O campo nome deve ser informado!")
    @NotNull(message = "NOME PESSOA - Não pode ser nulo!!!")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Length(max = 50, message = "EMAIL PESSOA - O número máximo de caracteres é: {max}")
    @NotBlank(message = "EMAIL PESSOA - O campo email deve ser informado!")
    @NotNull(message = "EMAIL PESSOA - Não pode ser nulo!!!")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Length(max = 14, message = "FONE PESSOA - O número máximo de caracteres é: {max}")
    @NotBlank(message = "FONE PESSOA - O campo fone deve ser informado!")
    @NotNull(message = "FONE PESSOA - Não pode ser nulo!!!")
    @Column(name = "fone", length = 14, nullable = false)    
    private String fone;
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<>();
    
    public Pessoa() {
    }
    
    public void adicionarEndereco(Endereco end){
        end.setPessoa(this);
        this.enderecos.add(end);
    }
    
    public void removerEndereco(int index){
        this.enderecos.remove(index);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

}
