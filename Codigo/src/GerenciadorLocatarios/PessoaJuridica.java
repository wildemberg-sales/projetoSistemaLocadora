package GerenciadorLocatarios;
import exceptions.CampoEmBrancoException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class PessoaJuridica extends Locatario {
    
    protected String nomeSocial, cnpj;

    protected List<PessoaFisica> funcionarios;

    public PessoaJuridica(String endereco, String bairro, String cidade, String estado, String cep, String email,
            String dddCelular, String numeroCelular, String nomeSocial, String cnpj) throws CampoEmBrancoException {
        super(endereco, bairro, cidade, estado, cep, email, dddCelular, numeroCelular);

        if(nomeSocial.isEmpty() || cnpj.isEmpty()){
            throw new CampoEmBrancoException("Falta informações como cnpj ou nome social");
        }else{
        this.nomeSocial = nomeSocial;
        this.cnpj = cnpj;
        this.funcionarios = new LinkedList<PessoaFisica>();
        }
        
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

    public PessoaFisica escolherFuncionario(){
        
        String resultado = "Locatários encontrados:\n";
        int escolha;
 
    
        PessoaFisica listaDeBuscaCPF[]; 
        listaDeBuscaCPF = new PessoaFisica[50];
        int i = 0; 

        for (PessoaFisica t: funcionarios){
            listaDeBuscaCPF[i] = t;
            i++;
            resultado += i + " - " + t.getNome() + "\n";
                 
        }
         
        resultado += "\nIndique o número do funcionário que deseja escolher";
        escolha = Integer.parseInt(JOptionPane.showInputDialog(null, resultado));
 
        return listaDeBuscaCPF[escolha -1]; 
    }
    
    
}