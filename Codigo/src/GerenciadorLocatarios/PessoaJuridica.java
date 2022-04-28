package GerenciadorLocatarios;

import java.util.LinkedList;
import java.util.List;

public class PessoaJuridica extends Locatario {
    
    protected String nomeSocial, cnpj;

    protected List<PessoaFisica> funcionarios;

    public PessoaJuridica(String endereco, String bairro, String cidade, String estado, String cep, String email,
            int dddCelular, int numeroCelular, String nomeSocial, String cnpj) {
        super(endereco, bairro, cidade, estado, cep, email, dddCelular, numeroCelular);
        this.nomeSocial = nomeSocial;
        this.cnpj = cnpj;
        this.funcionarios = new LinkedList<PessoaFisica>();
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

    public boolean cadastrarFuncionario(PessoaFisica func){
        boolean resultado = false;
        for(PessoaFisica t: funcionarios){
            if(t == func){
                //Funcionario ja cadastrado
            } else {
                resultado = funcionarios.add(func);
            }
        }
        return resultado;
    }
    
}
