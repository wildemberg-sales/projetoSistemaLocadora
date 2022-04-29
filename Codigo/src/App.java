import java.util.ArrayList;

import javax.swing.JOptionPane;



import GerenciadorLocatarios.PessoaJuridica;

public class App {
public static void main(String[] args) throws Exception {

    boolean voltaMenu = true;
    
    do {
        voltaMenu = menu();
    } while (voltaMenu);    
}

static boolean menu() throws InterruptedException{
    int escolha, confirma;
    String str;
    ArrayList<PessoaFisica> pessoaFisica = new ArrayList<>();
   ArrayList<PessoaJuridica> pessoaJuridica = new ArrayList<>();
    
    str = "\n\n********** Menu Principal **********\n\n" +
        "1 - Gerenciar Locatários\n" +
        "2 - Gerenciar Frota\n" +
        "3 - Gerenciar Reservas\n" +
        "4 - Sair do Programa\n\n"; 

    escolha = Integer.parseInt(JOptionPane.showInputDialog(null, str));
        switch (escolha) {
            case 1:
        
                str ="\n\n********** Menu de Gerencia de Locatários **********\n\n" +
                    "1 - Cadastrar Locatário\n" +
                    "2 - Buscar Locatário\n" +
                    "3 - Excluir Locatário\n\n";
                
                escolha = Integer.parseInt(JOptionPane.showInputDialog(null, str));

                switch (escolha) {
                    case 1:
                        confirma = JOptionPane.showConfirmDialog(null, "O locatário é um CNPJ?", "Cadastro Locatário", JOptionPane.YES_NO_OPTION);
                        
                        if(confirma == JOptionPane.YES_OPTION){
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
                            
                           
                            
                        } else {
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

                            PessoaFisica a = new PessoaFisica(end, bai, cid, est, cep, eml, ddd, tel, nome, cpf, estadoCivil);
                            pessoaFisica.add(a);

                        }

                        return true;

                    case 2:
                
                        System.out.println("\nBuscar Locatário");
                        return true;

                    case 3:
                
                        System.out.println("\nExcluir Locatário");
                        return true;
                
                    default:
                        System.out.println("\n\nOpção inválida, retornando ao menu...");
                        Thread.sleep(2500); 
                        return true;
                }
            case 2:
        
                System.out.println("\n\n*****Menu de gerência de frota*****\n\n" +
                "1 - Cadastrar Veículo\n" +
                "2 - Pesquisar Veículo\n" +
                "3 - Atualizar dados de um Veículo\n" +
                "4 - Remover Veículo da frota\n\n"
                );

                switch (escolha) {
                    case 1:
                
                        System.out.println("\nMenu de Cadastro de Veículos\n\n" +
                        "1 - Cadastrar Veículo de Passeio\n" +
                        "2 - Cadastrar Veículo Utilitário\n" +
                        "3 - Cadastrar Motocicleta\n\n"
                        );

                        switch (escolha) {
                            case 1:
                        
                                System.out.println("\nCadastrar Veículo de Passeio");
                                return true;

                            case 2:
                        
                                System.out.println("\nCadastrar Veículo Utilitário");
                                return true;

                            case 3:
                        
                                System.out.println("\nCadastrar Motocicleta");
                                return true;
                        
                            default:
                                System.out.println("\n\nOpção inválida, retornando ao Menu...");
                                Thread.sleep(2500); 
                                return true;
                        }
                    case 2:
                
                        System.out.println("\n*****Menu de Pesquisa de Veículos*****\n\n" +
                        "1 - Pesquisar Veículo pelo Renavan\n" +
                        "2 - Pesquisar por Marca ou Modelo\n\n"
                        );
                        switch (escolha) {
                            case 1:
                        
                                System.out.println("\nPesquisar Veículo pelo Renavan");
                                return true;

                            case 2:
                        
                                System.out.println("\nPesquisar por Marca ou Modelo");
                                return true;
                        
                            default:
                                System.out.println("\n\nOpção inválida, retornando ao Menu...");
                                Thread.sleep(2500); 
                                return true;
                        }
                    case 3:
                
                        System.out.println("\nAtualizar dados de um Veículo");
                        return true;

                    case 4:
                
                        System.out.println("\nRemover Veículo da frota");
                        return true;

                    default:
                        System.out.println("\n\nOpção inválida, retornando ao Menu...");
                        Thread.sleep(2500); 
                        return true;
                }
                
            case 3:
        
                System.out.println("\n\n*******Gerenciador de Reservas*******\n\n"+
                "1 - Realizar reserva\n" +
                "2 - Relatorio da reserva\n" +
                "3 - Relatorio consolidado de reservas\n");

                switch (escolha) {
                    case 1:
                
                        System.out.println("\nRealizar reserva");
                        return true;

                    case 2:
                
                        System.out.println("\nRelatorio de reserva");
                        return true;
                    
                    case 3: 

                        System.out.println("\nRelatorio consolidado de reserva");
                        return true;

                    default:
                        System.out.println("\n\nOpção inválida, retornando ao Menu...");
                        Thread.sleep(2500); 
                        return true;
                }

            case 4:
        
                System.out.println("Saindo do Programa...");
                Thread.sleep(2500); 
                return false;
        
            default:
                System.out.println("\n\nOpção inválida!! Retornando ao Menu...");
                Thread.sleep(2500); 
                return true;
        }
    }

}