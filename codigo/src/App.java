import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        boolean voltaMenu = true;
       
        do {
            voltaMenu = menu();
        } while (voltaMenu);    
    }

    static int escolha(){
        int opcao;

        System.out.println("Selecione a opção que deseja");
        Scanner sc = new Scanner(System.in);
        opcao = sc.nextInt();
        return opcao;
    }

    static void clear(){
        for (int i = 0; i < 20; i++) {
            System.out.println("\n");
        }
    }

    static boolean menu() throws InterruptedException{
        
        clear();
        System.out.println(
            "********** Menu Principal **********\n\n" +
            "1 - Gerenciar Locatários\n" +
            "2 - Gerenciar Frota\n" +
            "3 - Gerenciar Reservas\n" +
            "4 - Sair do Programa\n\n"
            );    
    
            switch (escolha()) {
                case 1:
                    clear();
                    System.out.println(
                    "Menu de Gerencia de Locatários\n\n" +
                    "1 - Cadastrar Locatário\n" +
                    "2 - Buscar Locatário\n" +
                    "3 - Pesquisar Locatário\n" +
                    "4 - Excluir Locatário\n\n"
                    );
                    switch (escolha()) {
                        case 1:
                            clear();
                            System.out.println("Cadastrar Locatário");
                            return true;

                        case 2:
                            clear();
                            System.out.println("Buscar Locatário");
                            return true;

                        case 3:
                            clear();
                            System.out.println("Pesquisar Locatário");
                            return true;

                        case 4:
                            clear();
                            System.out.println("Excluir Locatário");
                            return true;
                    
                        default:
                            System.out.println("\n\nOpção inválida, retornando ao menu...");
                            return true;
                    }
                case 2:
                    clear();
                    System.out.println("Menu de gerência de frota\n\n" +
                    "1 - Cadastrar Veículo\n" +
                    "2 - Pesquisar Veículo\n" +
                    "3 - Atualizar dados de um Veículo\n" +
                    "4 - Remover Veículo da frota\n\n"
                    );
    
                    switch (escolha()) {
                        case 1:
                            clear();
                            System.out.println("Menu de Cadastro de Veículos\n\n" +
                            "1 - Cadastrar Veículo de Passeio\n" +
                            "2 - Cadastrar Veículo Utilitário\n" +
                            "3 - Cadastrar Motocicleta\n\n"
                            );

                            switch (escolha()) {
                                case 1:
                                    clear();
                                    System.out.println("Cadastrar Veículo de Passeio");
                                    return true;

                                case 2:
                                    clear();
                                    System.out.println("Cadastrar Veículo Utilitário");
                                    return true;

                                case 3:
                                    clear();
                                    System.out.println("Cadastrar Motocicleta");
                                    return true;
                            
                                default:
                                    System.out.println("\n\nOpção inválida, encerrando programa...");
                                    return true;
                            }
                        case 2:
                            clear();
                            System.out.println("Menu de Pesquisa de Veículos\n\n" +
                            "1 - Pesquisar Veículo pelo Renavan\n" +
                            "2 - Pesquisar por Marca ou Modelo\n\n"
                            );
                            switch (escolha()) {
                                case 1:
                                    clear();
                                    System.out.println("Pesquisar Veículo pelo Renavan");
                                    return true;
    
                                case 2:
                                    clear();
                                    System.out.println("Pesquisar por Marca ou Modelo");
                                    return true;
                            
                                default:
                                    System.out.println("\n\nOpção inválida, encerrando programa...");
                                    return true;
                            }
                        case 3:
                            clear();
                            System.out.println("Atualizar dados de um Veículo");
                            return true;
    
                        case 4:
                            clear();
                            System.out.println("Remover Veículo da frota");
                            return true;
    
                        default:
                            System.out.println("\n\nOpção inválida, encerrando programa...");
                            return true;
                    }
                    
                case 3:
                    clear();
                    System.out.println("Gerenciar Reservas");
                    return true;
    
                case 4:
                    clear();
                    System.out.println("Sair do Programa");
                    Thread.sleep(2500); 
                    return false;
            
                default:
                    System.out.println("\n\nOpção inválida, encerrando programa...");
                    return true;
            }
        }
    }

