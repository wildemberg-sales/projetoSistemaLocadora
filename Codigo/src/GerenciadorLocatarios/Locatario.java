package GerenciadorLocatarios;

public class Locatario {
    
    protected String endereco,
                     bairro,
                     cidade,
                     estado,
                     cep,
                     email;

    protected int dddCelular, numeroCelular;

    public Locatario(String endereco, String bairro, String cidade, String estado, String cep, String email,
            int dddCelular, int numeroCelular) {
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.email = email;
        this.dddCelular = dddCelular;
        this.numeroCelular = numeroCelular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(int dddCelular) {
        this.dddCelular = dddCelular;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }


    
}