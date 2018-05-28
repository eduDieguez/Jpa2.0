package modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "pessoafisica")
public class PessoaFisica extends Pessoa implements Serializable {

    @Length(max = 12, message = "RG PESSOA - O número máximo de caracteres é: {max}")
    @NotBlank(message = "RG PESSOA - O campo deve ser informado!")
    @NotNull(message = "RG PESSOA - Não pode ser nulo!!!")
    @Column(name = "rg", length = 12, nullable = false)
    private String rg;
    
    @Length(max = 14, message = "CPF PESSOA - O número máximo de caracteres é: {max}")
    @NotBlank(message = "CPF PESSOA - O campo deve ser informado!")
    @NotNull(message = "CPF PESSOA - Não pode ser nulo!!!")
    @CPF(message = "Nr do CPF Inválido")
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
    
    @NotNull(message = "Data de Nascimento da PESSOA - Não pode ser nulo!!!")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", length = 14, nullable = false)
    private Calendar nascimento;

    @NotBlank(message = "Nome de Usuário - O campo deve ser informado!")
    @NotNull(message = "Nome de Usuário - Não pode ser nulo!!!")
    @Length(max = 20, message = "Nome de Usuário - O número máximo de caracteres é: {max}")
    @Column(name = "nomeUsuario", length = 20, nullable = false, unique = true)    
    private String nomeUsuario;
    
    @NotBlank(message = "Senha de Usuário - O campo deve ser informado!")
    @NotNull(message = "Senha de Usuário - Não pode ser nulo!!!")
    @Length(max = 10, message = "Senha de Usuário - O número máximo de caracteres é: {max}")
    @Column(name = "senha", length = 10, nullable = false)    
    private String senha;

    public PessoaFisica() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
