package GerenciadorLocatarios;

public class PessoaJuridica extends Locatario {
    
    protected String nomeSocial, cnpj;

    //Falta implementar os funcionarios atraves das listas

    public PessoaJuridica(String endereco, String bairro, String cidade, String estado, String cep, String email,
            int dddCelular, int numeroCelular, String nomeSocial, String cnpj) {
        super(endereco, bairro, cidade, estado, cep, email, dddCelular, numeroCelular);
        this.nomeSocial = nomeSocial;
        this.cnpj = cnpj;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
}
