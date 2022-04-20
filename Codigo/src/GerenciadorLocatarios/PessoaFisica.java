package GerenciadorLocatarios;

public class PessoaFisica extends Locatario{
    protected String nome, cpf, estadoCivil;

    public PessoaFisica(String endereco, String bairro, String cidade, String estado, String cep, String email,
            int dddCelular, int numeroCelular, String nome, String cpf, String estadoCivil) {
        super(endereco, bairro, cidade, estado, cep, email, dddCelular, numeroCelular);
        this.nome = nome;
        this.cpf = cpf;
        this.estadoCivil = estadoCivil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    
}