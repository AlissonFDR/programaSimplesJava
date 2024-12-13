package Modelo;
import java.util.Date;

public class Pessoa {
    private String nome;
    private String endereco;
    private String cpf;
    private Date dataNascimento;

    public Date getDataNascimento() {
        return dataNascimento;
    }
    
     public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
