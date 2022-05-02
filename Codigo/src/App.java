import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import GerenciadorLocatarios.Locatario;
import GerenciadorLocatarios.PessoaFisica;
import GerenciadorLocatarios.PessoaJuridica;
import GerenciadorFrota.Motocicleta;
import GerenciadorFrota.VeiculoPasseio;
import GerenciadorFrota.VeiculoUtilitarioCarga;
import GerenciadorFrota.VeiculoUtilitarioPassageiro;

public class App {
public static void main(String[] args) throws Exception {

    boolean voltaMenu = true;
    List<Motocicleta> motos = new LinkedList<Motocicleta>();
    List<VeiculoPasseio> veicPasseio = new LinkedList<VeiculoPasseio>();
    List<VeiculoUtilitarioCarga> veicCarga = new LinkedList<VeiculoUtilitarioCarga>();
    List<VeiculoUtilitarioPassageiro> veicPassageiro = new LinkedList<VeiculoUtilitarioPassageiro>();
    List<PessoaFisica> pessoaCPF = new LinkedList<PessoaFisica>();
    List<PessoaJuridica> pessoaCNPJ = new LinkedList<PessoaJuridica>();
    
    do {
        voltaMenu = menu(pessoaCPF, pessoaCNPJ, motos, veicPasseio, veicCarga, veicPassageiro);
    } while (voltaMenu);    
}

static boolean menu(List<PessoaFisica> pessoaCPF, List<PessoaJuridica> pessoaCNPJ,  List<Motocicleta> motos,  List<VeiculoPasseio> veicPasseio,  List<VeiculoUtilitarioCarga> veicCarga,  List<VeiculoUtilitarioPassageiro> veicPassageiro) throws InterruptedException{
    int escolha, confirma, tipoBusca;
    String str, resultado;
    Locatario buscado;
    
    str = "Menu Principal\n\n" +
        "1 - Gerenciar Locatários\n" +
        "2 - Gerenciar Frota\n" +
        "3 - Gerenciar Reservas\n" +
        "4 - Sair do Programa\n\n" +
        "Digite o número que indica a função que deseja"; 

    escolha = Integer.parseInt(JOptionPane.showInputDialog(null, str));
        switch (escolha) {
            case 1:
        
                str = "Menu de Gerencia de Locatários\n\n" +
                    "1 - Cadastrar Locatário\n" +
                    "2 - Buscar Locatário\n" +
                    "3 - Excluir Locatário\n\n" +
                    "Digite o número que indica a função que deseja";
                
                escolha = Integer.parseInt(JOptionPane.showInputDialog(null, str));

                switch (escolha) {
                    case 1:
                        //Cadastrar Locatário
                        confirma = JOptionPane.showConfirmDialog(null, "O locatário é um CNPJ?", "Cadastro Locatário", JOptionPane.YES_NO_OPTION);
                        
                        if(confirma == JOptionPane.YES_OPTION){                           
                            if(cadastroCNPJ(pessoaCNPJ, pessoaCPF)){

                                JOptionPane.showMessageDialog(null, "Cadastro de CNPJ feito com sucesso");
                            } else {

                                JOptionPane.showMessageDialog(null,"Erro ao cadastrar CNPJ");
                            }
                        } else {
                            
                            confirma = JOptionPane.showConfirmDialog(null, "O CPF está vinculado a um CNPJ?", "Cadastro Locatário", JOptionPane.YES_NO_OPTION);
                            
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
                        tipoBusca = JOptionPane.showConfirmDialog(null, "Deseja buscar CPF?", "Busca Locatário", JOptionPane.YES_NO_OPTION);
                        buscado = buscaLocatario(pessoaCPF, pessoaCNPJ, tipoBusca);

                        if(tipoBusca == JOptionPane.YES_OPTION){
                            PessoaFisica buscadoCPF = (PessoaFisica) buscado;
                            resultado = "Resultado:\n" + buscadoCPF.getNome() + "\n" + buscadoCPF.getEmail() + "\n" + buscadoCPF.getCpf() + "\n" + buscadoCPF.getEstadoCivil() +
                                        "\n" + buscadoCPF.getCidade() + " " + buscadoCPF.getEstado() + "\n" + buscadoCPF.getEndereco() + " " +
                                        buscadoCPF.getBairro() + "\n" + buscadoCPF.getCep() + "\n(" + buscadoCPF.getDddCelular() + ")" + buscadoCPF.getNumeroCelular() +
                                        "\n\nDeseja atualizar os dados cadastrais? (em inputs vazios, serão considerados o dado atual)";
                            
                            int atualizar = JOptionPane.showConfirmDialog(null, resultado, "", JOptionPane.YES_NO_OPTION);
                            if(atualizar == JOptionPane.YES_OPTION){
                                atualizarCPF(buscadoCPF);
                            }

                        } else {
                            PessoaJuridica buscadoCNPJ = (PessoaJuridica) buscado;
                            resultado = "Resultado:\n" + buscadoCNPJ.getNomeSocial() + "\n" + buscadoCNPJ.getEmail() + "\n" + buscadoCNPJ.getCnpj() + "\n" +
                                        "\n" + buscadoCNPJ.getCidade() + " " + buscadoCNPJ.getEstado() + "\n" + buscadoCNPJ.getEndereco() + " " +
                                        buscadoCNPJ.getBairro() + "\n" + buscadoCNPJ.getCep() + "\n(" + buscadoCNPJ.getDddCelular() + ")" + buscadoCNPJ.getNumeroCelular() +
                                        "\n\nDeseja atualizar os dados cadastrais? (em inputs vazios, serão considerados o dado atual)";
                            
                            int atualizar = JOptionPane.showConfirmDialog(null, resultado, "", JOptionPane.YES_NO_OPTION);
                            if(atualizar == JOptionPane.YES_OPTION){
                                atualizarCNPJ(buscadoCNPJ);
                            }
                        }
                        return true;

                    case 3:
                        //Excluir Locatário
                        tipoBusca = JOptionPane.showConfirmDialog(null, "Deseja buscar CPF?", "Busca Locatário", JOptionPane.YES_NO_OPTION);
                        buscado = buscaLocatario(pessoaCPF, pessoaCNPJ, tipoBusca);

                        if(tipoBusca == JOptionPane.YES_OPTION){
                            PessoaFisica buscadoCPF = (PessoaFisica) buscado;
                            resultado = "Resultado:\n" + buscadoCPF.getNome() + "\n" + buscadoCPF.getEmail() + "\n" + buscadoCPF.getCpf() + "\n" + buscadoCPF.getEstadoCivil() +
                                        "\n" + buscadoCPF.getCidade() + " " + buscadoCPF.getEstado() + "\n" + buscadoCPF.getEndereco() + " " +
                                        buscadoCPF.getBairro() + "\n" + buscadoCPF.getCep() + "\n(" + buscadoCPF.getDddCelular() + ")" + buscadoCPF.getNumeroCelular() +
                                        "\n\nDeseja apagar o cadastro?";
                            
                            int excluir = JOptionPane.showConfirmDialog(null, resultado, "", JOptionPane.YES_NO_OPTION);
                            if(excluir == JOptionPane.YES_OPTION){
                                    if(pessoaCPF.contains(buscadoCPF)){
                                        if(pessoaCPF.remove(buscadoCPF)){
                                            JOptionPane.showMessageDialog(null, "CPF removido com sucesso");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Ocorreu um erro");
                                        }
                                    }
                            }

                        } else {
                            PessoaJuridica buscadoCNPJ = (PessoaJuridica) buscado;
                            resultado = "Resultado:\n" + buscadoCNPJ.getNomeSocial() + "\n" + buscadoCNPJ.getEmail() + "\n" + buscadoCNPJ.getCnpj() + "\n" +
                                        "\n" + buscadoCNPJ.getCidade() + " " + buscadoCNPJ.getEstado() + "\n" + buscadoCNPJ.getEndereco() + " " +
                                        buscadoCNPJ.getBairro() + "\n" + buscadoCNPJ.getCep() + "\n(" + buscadoCNPJ.getDddCelular() + ")" + buscadoCNPJ.getNumeroCelular() +
                                        "\n\nDeseja apagar o cadastro?";
                            
                            int excluir = JOptionPane.showConfirmDialog(null, resultado, "", JOptionPane.YES_NO_OPTION);
                            if(excluir == JOptionPane.YES_OPTION){
                                if(pessoaCNPJ.contains(buscadoCNPJ)){
                                    if(pessoaCNPJ.remove(buscadoCNPJ)){
                                        JOptionPane.showMessageDialog(null, "CNPJ removido com sucesso");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Ocorreu um erro");
                                    }
                                }                                
                            }
                        }
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
                                   String marca = JOptionPane.showInputDialog(null, "Qual a marca do veiculo");
                                   String modelo = JOptionPane.showInputDialog(null, "Qual o modelo do veiculo");
                                   String renavam = JOptionPane.showInputDialog(null, "Qual o renavam do veiculo");
                                   String categoria = JOptionPane.showInputDialog(null, "Qual a categoria do veiculo");
                                   
                                   confirma = JOptionPane.showConfirmDialog(null, "Possui ar-condicionado", "Ar-Condicionado", JOptionPane.YES_NO_OPTION);
                                   Boolean arCondicionado;
                                   if(confirma == JOptionPane.YES_OPTION){
                                        arCondicionado = true;
                                   }else{
                                        arCondicionado = false;
                                   }
                                  
                                   confirma = JOptionPane.showConfirmDialog(null, "Possui direção hidraulica", "Direção hidraulica", JOptionPane.YES_NO_OPTION);
                                   Boolean direcaoHidraulica;
                                   if(confirma==JOptionPane.YES_OPTION){
                                       direcaoHidraulica = true;
                                   }else{
                                       direcaoHidraulica = false;
                                   }
                                
                                   confirma = JOptionPane.showConfirmDialog(null, "Possui cambio automatico", "Cambio Automatico", JOptionPane.YES_NO_OPTION);
                                   Boolean cambioAutomatico;
                                   if(confirma==JOptionPane.YES_OPTION){
                                       cambioAutomatico=true;
                                   }else{
                                       cambioAutomatico=false;
                                   }
                                
                                VeiculoPasseio novoVeicPasseio = new VeiculoPasseio(marca, modelo, renavam, categoria, arCondicionado, direcaoHidraulica, cambioAutomatico);
                                veicPasseio.add(novoVeicPasseio);
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
        String ddd = JOptionPane.showInputDialog(null, "Informe o ddd");
        String tel = JOptionPane.showInputDialog(null, "Informe o número de telefone");

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
        String ddd = JOptionPane.showInputDialog(null, "Informe o ddd");
        String tel = JOptionPane.showInputDialog(null, "Informe o número de telefone");

        PessoaJuridica nvCNPJ = new PessoaJuridica(end, bai, cid, est, cep, eml, ddd, tel, nomeSocial, cnpj);
        JOptionPane.showMessageDialog(null, "É necessário cadastrar um funcionário para efetuar o aluguel");
        PessoaFisica func = cadastroCPF(pessoaCPF);
        nvCNPJ.cadastrarFuncionario(func);

        return pessoaCNPJ.add(nvCNPJ);
    }

    static Locatario buscaLocatario(List<PessoaFisica> pessoaCPF, List<PessoaJuridica> pessoaCNPJ, int tipoBusca){

        String busca;
        String resultado = "Locatários encontrados:\n";
        int escolha;

        PessoaFisica listaDeBuscaCPF[];
        PessoaJuridica listaDeBuscaCNPJ[];
        listaDeBuscaCPF = new PessoaFisica[50];
        listaDeBuscaCNPJ = new PessoaJuridica[50];
        int i = 0;
        
        if(tipoBusca == JOptionPane.YES_OPTION){
            busca = JOptionPane.showInputDialog(null, "Digite o nome, email ou cpf do locatário a ser buscado");
            for (PessoaFisica t: pessoaCPF){
                if(t.getNome().toLowerCase().contains(busca.toLowerCase()) || t.getEmail().toLowerCase().contains(busca.toLowerCase()) || t.getCpf().toLowerCase().contains(busca.toLowerCase())){
                    listaDeBuscaCPF[i] = t;
                    i++;
                    resultado += i + " - " + t.getNome() + "\n";
                }
            }
            resultado += "\nIndique o número do locatário que deseja visualizar";
            escolha = Integer.parseInt(JOptionPane.showInputDialog(null, resultado));

            return listaDeBuscaCPF[escolha -1];
                        
        } else {
            busca = JOptionPane.showInputDialog(null, "Digite o nome social, email ou cnpj do locatário a ser buscado");
            for (PessoaJuridica t: pessoaCNPJ){
                if(t.getNomeSocial().toLowerCase().contains(busca.toLowerCase()) || t.getEmail().toLowerCase().contains(busca.toLowerCase()) || t.getCnpj().toLowerCase().contains(busca.toLowerCase())){
                    listaDeBuscaCNPJ[i] = t;
                    i++;
                    resultado += i + " - " + t.getNomeSocial() + "\n";
                }
            }
            resultado += "\nIndique o número do locatário que deseja visualizar";
            escolha = Integer.parseInt(JOptionPane.showInputDialog(null, resultado));

            return listaDeBuscaCNPJ[escolha -1];
        }

    }

    static boolean atualizarCPF(PessoaFisica cpf){
        String a, b;

        a = "Altere o nome\n" + cpf.getNome();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cpf.getNome();
        }
        cpf.setNome(b);
        a = "Altere o CPF\n" + cpf.getCpf();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cpf.getCpf();
        }
        cpf.setCpf(b);
        a = "Altere o Estado Civil\n" + cpf.getEstadoCivil();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cpf.getEstadoCivil();
        }
        cpf.setEstadoCivil(b);
        a = "Altere o Endereço\n" + cpf.getEndereco();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cpf.getEndereco();
        }
        cpf.setEndereco(b);
        a = "Altere o Bairro\n" + cpf.getBairro();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cpf.getBairro();
        }
        cpf.setBairro(b);
        a = "Altere o Cidade\n" + cpf.getCidade();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cpf.getCidade();
        }
        cpf.setCidade(b);
        a = "Altere o Estado\n" + cpf.getEstado();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cpf.getEstado();
        }
        cpf.setEstado(b);
        a = "Altere o CEP\n" + cpf.getCep();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cpf.getCep();
        }
        cpf.setCep(b);
        a = "Altere o Email\n" + cpf.getEmail();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cpf.getEmail();
        }
        cpf.setEmail(b);
        a = "Altere o DDD\n" + cpf.getDddCelular();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cpf.getDddCelular();
        }
        cpf.setDddCelular(b);
        a = "Altere o Número telefone\n" + cpf.getNumeroCelular();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cpf.getNumeroCelular();
        }
        cpf.setNumeroCelular(b);

        JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
        return true;
    }

    static boolean atualizarCNPJ(PessoaJuridica cnpj){
        String a, b;

        a = "Altere o nome\n" + cnpj.getNomeSocial();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cnpj.getNomeSocial();
        }
        cnpj.setNomeSocial(b);
        a = "Altere o cnpj\n" + cnpj.getCnpj();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cnpj.getCnpj();
        }
        cnpj.setCnpj(b);
        a = "Altere o Endereço\n" + cnpj.getEndereco();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cnpj.getEndereco();
        }
        cnpj.setEndereco(b);
        a = "Altere o Bairro\n" + cnpj.getBairro();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cnpj.getBairro();
        }
        cnpj.setBairro(b);
        a = "Altere o Cidade\n" + cnpj.getCidade();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cnpj.getCidade();
        }
        cnpj.setCidade(b);
        a = "Altere o Estado\n" + cnpj.getEstado();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cnpj.getEstado();
        }
        cnpj.setEstado(b);
        a = "Altere o CEP\n" + cnpj.getCep();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cnpj.getCep();
        }
        cnpj.setCep(b);
        a = "Altere o Email\n" + cnpj.getEmail();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cnpj.getEmail();
        }
        cnpj.setEmail(b);
        a = "Altere o DDD\n" + cnpj.getDddCelular();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cnpj.getDddCelular();
        }
        cnpj.setDddCelular(b);
        a = "Altere o Número telefone\n" + cnpj.getNumeroCelular();
        b = JOptionPane.showInputDialog(null, a);
        if(b.isEmpty()){
            b = cnpj.getNumeroCelular();
        }
        cnpj.setNumeroCelular(b);

        JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
        return true;
    }


}