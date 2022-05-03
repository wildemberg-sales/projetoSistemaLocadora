package GerenciadorLocatarios;
import exceptions.CampoEmBrancoException;
public class PessoaFisica extends Locatario{
    protected String nome, cpf, estadoCivil;

    public PessoaFisica(String endereco, String bairro, String cidade, String estado, String cep, String email,
            String dddCelular, String numeroCelular, String nome, String cpf, String estadoCivil) throws CampoEmBrancoException {
        super(endereco, bairro, cidade, estado, cep, email, dddCelular, numeroCelular);

        if(nome.isEmpty() || cpf.isEmpty()){
            throw new CampoEmBrancoException("Falta informações importantes como nome, email ou cpf");
        }else{
        this.nome = nome;
        this.cpf = cpf;
        this.estadoCivil = estadoCivil;
        }
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