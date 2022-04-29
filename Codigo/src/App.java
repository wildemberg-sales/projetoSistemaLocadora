import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import GerenciadorLocatarios.PessoaFisica;
import GerenciadorLocatarios.PessoaJuridica;

public class App {
public static void main(String[] args) throws Exception {

    boolean voltaMenu = true;
    List<PessoaFisica> pessoaCPF = new LinkedList<PessoaFisica>();
    List<PessoaJuridica> pessoaCNPJ = new LinkedList<PessoaJuridica>();
    
    do {
        voltaMenu = menu(pessoaCPF, pessoaCNPJ);
    } while (voltaMenu);    
}

static boolean menu(List<PessoaFisica> pessoaCPF, List<PessoaJuridica> pessoaCNPJ) throws InterruptedException{
    int escolha, confirma;
    String str;
    
    str = "Menu Principal\n\n" +
        "1 - Gerenciar Locatários\n" +
        "2 - Gerenciar Frota\n" +
        "3 - Gerenciar Reservas\n" +
        "4 - Sair do Programa\n\n" +
        "Digite o número que indica a função que deseja"; 

    escolha = Integer.parseInt(JOptionPane.showInputDialog(null, str));
        switch (escolha) {
            case 1:
        
                str ="Menu de Gerencia de Locatários\n\n" +
                    "1 - Cadastrar Locatário\n" +
                    "2 - Buscar Locatário\n" +
                    "3 - Excluir Locatário\n\n" +
                    "Digite o número que indica a função que deseja";
                
                escolha = Integer.parseInt(JOptionPane.showInputDialog(null, str));

                switch (escolha) {
                    case 1:
                    
                        confirma = JOptionPane.showConfirmDialog(null, "O locatário é um CNPJ?", "Cadastro Locatário", JOptionPane.YES_NO_OPTION);
                        
                        if(confirma == JOptionPane.YES_OPTION){                           
                            if(cadastroCNPJ(pessoaCNPJ, pessoaCPF)){

                                JOptionPane.showMessageDialog(null, "Cadastro de CNPJ feito com sucesso");
                            } else {

                                JOptionPane.showMessageDialog(null,"Erro ao cadastrar CNPJ");
                            }
                        } else {
                            
                            confirma = JOptionPane.showConfirmDialog(null, "O CPF está vinculado à um CNPJ?", "Cadastro Locatário", JOptionPane.YES_NO_OPTION);
                            
                            if(confirma == JOptionPane.YES_OPTION){
                                
                                String cnpj = JOptionPane.showInputDialog(null, "Informe o CNPJ ao qual este CPF está vinculado");
                                
                                for(PessoaJuridica t: pessoaCNPJ){
                                    if(t.getCnpj().equalsIgnoreCase(cnpj)){

                                        PessoaJuridica empresa = t;
                                        PessoaFisica funcionario = cadastroCPF(pessoaCPF);
                                        empresa.cadastrarFuncionario(funcionario);
                                    }
                                }
                            } else {
                            
                                cadastroCPF(pessoaCPF);
                            }                        
                        }
                        return true;

                    case 2:
                        //Buscar Locatário
                        return true;

                    case 3:
                        //Excluir Locatário
                        return true;
                
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida, Pressione OK para voltar ao menu"); 
                        return true;
                }
            case 2:
        
                str = "Menu de gerência de frota\n\n" +
                    "1 - Cadastrar Veículo\n" +
                    "2 - Pesquisar Veículo\n" +
                    "3 - Atualizar dados de um Veículo\n" +
                    "4 - Remover Veículo da frota\n\n" +
                    "Digite o número que indica a função que deseja";

                escolha = Integer.parseInt(JOptionPane.showInputDialog(null, str));

                switch (escolha) {
                    case 1:
                
                        str = "Menu de Cadastro de Veículos\n\n" +
                            "1 - Cadastrar Veículo de Passeio\n" +
                            "2 - Cadastrar Veículo Utilitário\n" +
                            "3 - Cadastrar Motocicleta\n\n" +
                            "Digite o número que indica a função que deseja";

                        escolha = Integer.parseInt(JOptionPane.showInputDialog(null, str));
                        
                        switch (escolha) {
                            case 1:
                                //Cadastro Veiculo Passeio
                                return true;

                            case 2:
                                //Cadastro Veiculo utilitario
                                return true;

                            case 3:
                                //Cadastro Motocicleta
                                return true;
                        
                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida, Pressione OK para voltar ao menu"); 
                                return true;
                        }
                    case 2:
                
                        str = "Menu de Pesquisa de Veículos\n\n" +
                            "1 - Pesquisar Veículo pelo Renavan\n" +
                            "2 - Pesquisar por Marca ou Modelo\n\n" +
                            "Digite o número que indica a função que deseja";

                        escolha = Integer.parseInt(JOptionPane.showInputDialog(null, str));
                        
                            switch (escolha) {
                            case 1:
                                //Pesquisar Veiculo RENAVAM
                                return true;

                            case 2:
                                //Pesquisar Veiculo Marca Modelo
                                return true;
                        
                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida, Pressione OK para voltar ao menu"); 
                                return true;
                        }
                    case 3:
                        //Atualizar dados veiculo
                        return true;

                    case 4:
                        //Remover Veiculo frota
                        return true;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida, Pressione OK para voltar ao menu"); 
                        return true;
                }
                
            case 3:
        
                str = "Gerenciador de Reservas\n\n"+
                    "1 - Realizar reserva\n" +
                    "2 - Relatorio da reserva\n" +
                    "3 - Relatorio consolidado de reservas\n\n" +
                    "Digite o número que indica a função que deseja";

                escolha = Integer.parseInt(JOptionPane.showInputDialog(null, str));

                switch (escolha) {
                    case 1:
                        //Realizar reserva
                        return true;

                    case 2:
                        //Relatorio Reserva
                        return true;
                    
                    case 3: 
                        //Relatorio Consolidado Reserva
                        return true;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida, Pressione OK para voltar ao menu"); 
                        return true;
                }

            case 4:
                JOptionPane.showMessageDialog(null, "Saindo do Programa..."); 
                return false;
        
            default:
                JOptionPane.showMessageDialog(null, "Opção Inválida, Pressione OK para voltar ao menu"); 
                return true;
        }
    }

    static PessoaFisica cadastroCPF(List<PessoaFisica> pessoaCPF){
        String nome = JOptionPane.showInputDialog(null, "Informe o nome");
        String cpf = JOptionPane.showInputDialog(null, "Informe o CPF");
        String estadoCivil = JOptionPane.showInputDialog(null, "Informe o estado civil");
        String end = JOptionPane.showInputDialog(null, "Informe o endereço");
        String bai = JOptionPane.showInputDialog(null, "Informe o bairro");
        String cid = JOptionPane.showInputDialog(null, "Informe a cidade");
        String est = JOptionPane.showInputDialog(null, "Informe o estado");
        String cep = JOptionPane.showInputDialog(null, "Informe o cep");
        String eml = JOptionPane.showInputDialog(null, "Informe o email");
        int ddd = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ddd"));
        int tel = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número de telefone"));

        PessoaFisica nvCPF = new PessoaFisica(end, bai, cid, est, cep, eml, ddd, tel, nome, cpf, estadoCivil);
        if(pessoaCPF.add(nvCPF)){
            JOptionPane.showMessageDialog(null, "Cadastro CPF feito com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar CPF");
        }
        return nvCPF;
    }

    static boolean cadastroCNPJ(List<PessoaJuridica> pessoaCNPJ, List<PessoaFisica> pessoaCPF){
        String nomeSocial = JOptionPane.showInputDialog(null, "Informe o Nome Social");
        String cnpj = JOptionPane.showInputDialog(null, "Informe o CNPJ");
        String end = JOptionPane.showInputDialog(null, "Informe o endereço");
        String bai = JOptionPane.showInputDialog(null, "Informe o bairro");
        String cid = JOptionPane.showInputDialog(null, "Informe a cidade");
        String est = JOptionPane.showInputDialog(null, "Informe o estado");
        String cep = JOptionPane.showInputDialog(null, "Informe o cep");
        String eml = JOptionPane.showInputDialog(null, "Informe o email");
        int ddd = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ddd"));
        int tel = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número de telefone"));

        PessoaJuridica nvCNPJ = new PessoaJuridica(end, bai, cid, est, cep, eml, ddd, tel, nomeSocial, cnpj);
        PessoaFisica func = cadastroCPF(pessoaCPF);
        nvCNPJ.cadastrarFuncionario(func);

        return pessoaCNPJ.add(nvCNPJ);
    }

}