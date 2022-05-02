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
    
    do { //Função loop do Menu
        voltaMenu = menu(pessoaCPF, pessoaCNPJ, motos, veicPasseio, veicCarga, veicPassageiro);
    } while (voltaMenu);    
}

static boolean menu(List<PessoaFisica> pessoaCPF, List<PessoaJuridica> pessoaCNPJ,  List<Motocicleta> motos,  List<VeiculoPasseio> veicPasseio,  List<VeiculoUtilitarioCarga> veicCarga,  List<VeiculoUtilitarioPassageiro> veicPassageiro) throws InterruptedException{
    //Variaveis para as funções relacionadas ao menu
    int escolha;
    String str;
    //Variaveis para as funções relacionadas a busca
    int confirma, tipoBusca;
    String resultado;
    Locatario buscadoLoc;
    
    //Menu Principal
    str = "Menu Principal\n\n" +
        "1 - Gerenciar Locatários\n" +
        "2 - Gerenciar Frota\n" +
        "3 - Gerenciar Reservas\n" +
        "4 - Sair do Programa\n\n" +
        "Digite o número que indica a função que deseja"; 

    escolha = Integer.parseInt(JOptionPane.showInputDialog(null, str));
        switch (escolha) {
            case 1:
                //Primeiro menu,gerencia de locatarios
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
                        
                        if(confirma == JOptionPane.YES_OPTION){ //Cadastro de CNPJ com funcionario                     
                            if(cadastroCNPJ(pessoaCNPJ, pessoaCPF)){
                                JOptionPane.showMessageDialog(null, "Cadastro de CNPJ feito com sucesso");
                            } else {
                                JOptionPane.showMessageDialog(null,"Erro ao cadastrar CNPJ");
                            }
                        } else { //Cadastro de CPF
                            confirma = JOptionPane.showConfirmDialog(null, "O CPF está vinculado a um CNPJ?", "Cadastro Locatário", JOptionPane.YES_NO_OPTION);
                        
                            if(confirma == JOptionPane.YES_OPTION){ //CPF está vinculado a um CNPJ
                                String cnpj = JOptionPane.showInputDialog(null, "Informe o CNPJ ao qual este CPF está vinculado");
                                
                                for(PessoaJuridica t: pessoaCNPJ){ //Procura o CNPJ informado e cadastra o CPF como funcionario
                                    if(t.getCnpj().equalsIgnoreCase(cnpj)){ 
                                        PessoaJuridica empresa = t;
                                        PessoaFisica funcionario = cadastroCPF(pessoaCPF);
                                        empresa.cadastrarFuncionario(funcionario);
                                    }
                                }
                            } else { //Cadastro de CPF particular
                                cadastroCPF(pessoaCPF);
                            }                        
                        }
                        return true;

                    case 2:
                    //Buscar Locatário
                    //Tipo de busca que será feita, CPF ou CNPJ
                        tipoBusca = JOptionPane.showConfirmDialog(null, "Deseja buscar CPF?", "Busca Locatário", JOptionPane.YES_NO_OPTION);
                    //buscadoLoc é do tipo locatario para reaproveitar a função buscaLocatario em CPF e CNPJ
                        buscadoLoc = buscaLocatario(pessoaCPF, pessoaCNPJ, tipoBusca);

                        if(tipoBusca == JOptionPane.YES_OPTION){ //Buscou um CPF
                            PessoaFisica buscadoLocCPF = (PessoaFisica) buscadoLoc; //TypeCast de Locatario para CPF
                        //Resultado da busca
                        //Apresenta todos os dados relacionados ao objeto da busca
                            resultado = "Resultado:\n" + buscadoLocCPF.getNome() + "\n" + buscadoLocCPF.getEmail() + "\n" + buscadoLocCPF.getCpf() + "\n" + buscadoLocCPF.getEstadoCivil() +
                                        "\n" + buscadoLocCPF.getCidade() + " " + buscadoLocCPF.getEstado() + "\n" + buscadoLocCPF.getEndereco() + " " +
                                        buscadoLocCPF.getBairro() + "\n" + buscadoLocCPF.getCep() + "\n(" + buscadoLocCPF.getDddCelular() + ")" + buscadoLocCPF.getNumeroCelular() +
                                        "\n\nDeseja atualizar os dados cadastrais? (em inputs vazios, serão considerados o dado atual)";
                            
                            int atualizar = JOptionPane.showConfirmDialog(null, resultado, "", JOptionPane.YES_NO_OPTION);
                            if(atualizar == JOptionPane.YES_OPTION){ //Caso queira atualizar os dados
                                atualizarCPF(buscadoLocCPF);
                            }

                        } else { //Buscou um CNPJ
                            PessoaJuridica buscadoLocCNPJ = (PessoaJuridica) buscadoLoc; //TypeCast de Locatario para CNPJ
                        //Resultado da busca
                        //Apresenta todos os dados relacionados ao objeto da busca
                            resultado = "Resultado:\n" + buscadoLocCNPJ.getNomeSocial() + "\n" + buscadoLocCNPJ.getEmail() + "\n" + buscadoLocCNPJ.getCnpj() + "\n" +
                                        "\n" + buscadoLocCNPJ.getCidade() + " " + buscadoLocCNPJ.getEstado() + "\n" + buscadoLocCNPJ.getEndereco() + " " +
                                        buscadoLocCNPJ.getBairro() + "\n" + buscadoLocCNPJ.getCep() + "\n(" + buscadoLocCNPJ.getDddCelular() + ")" + buscadoLocCNPJ.getNumeroCelular() +
                                        "\n\nDeseja atualizar os dados cadastrais? (em inputs vazios, serão considerados o dado atual)";
                            
                            int atualizar = JOptionPane.showConfirmDialog(null, resultado, "", JOptionPane.YES_NO_OPTION);
                            if(atualizar == JOptionPane.YES_OPTION){ //Caso queira atualizar os dados
                                atualizarCNPJ(buscadoLocCNPJ);
                            }
                        }
                        return true;

                    case 3:
                    //Excluir Locatário
                    //Tipo de busca que será feita a exclusão, CPF ou CNPJ, essa parte é praticamente a mesma que em busca
                        tipoBusca = JOptionPane.showConfirmDialog(null, "Deseja buscar CPF?", "Busca Locatário", JOptionPane.YES_NO_OPTION);
                        buscadoLoc = buscaLocatario(pessoaCPF, pessoaCNPJ, tipoBusca);

                        if(tipoBusca == JOptionPane.YES_OPTION){ //Buscou um CPF
                            PessoaFisica buscadoLocCPF = (PessoaFisica) buscadoLoc;
                        //Resultado da busca
                        //Apresenta todos os dados relacionados ao objeto da busca
                            resultado = "Resultado:\n" + buscadoLocCPF.getNome() + "\n" + buscadoLocCPF.getEmail() + "\n" + buscadoLocCPF.getCpf() + "\n" + buscadoLocCPF.getEstadoCivil() +
                                        "\n" + buscadoLocCPF.getCidade() + " " + buscadoLocCPF.getEstado() + "\n" + buscadoLocCPF.getEndereco() + " " +
                                        buscadoLocCPF.getBairro() + "\n" + buscadoLocCPF.getCep() + "\n(" + buscadoLocCPF.getDddCelular() + ")" + buscadoLocCPF.getNumeroCelular() +
                                        "\n\nDeseja apagar o cadastro?";
                            
                            int excluir = JOptionPane.showConfirmDialog(null, resultado, "", JOptionPane.YES_NO_OPTION);
                            if(excluir == JOptionPane.YES_OPTION){
                                    if(pessoaCPF.contains(buscadoLocCPF)){
                                        if(pessoaCPF.remove(buscadoLocCPF)){ //Apagou um CPF
                                            JOptionPane.showMessageDialog(null, "CPF removido com sucesso");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Ocorreu um erro");
                                        }
                                    }
                            }

                        } else { //Buscou um CNPJ
                            PessoaJuridica buscadoLocCNPJ = (PessoaJuridica) buscadoLoc;
                        //Resultado da busca
                        //Apresenta todos os dados relacionados ao objeto da busca
                            resultado = "Resultado:\n" + buscadoLocCNPJ.getNomeSocial() + "\n" + buscadoLocCNPJ.getEmail() + "\n" + buscadoLocCNPJ.getCnpj() + "\n" +
                                        "\n" + buscadoLocCNPJ.getCidade() + " " + buscadoLocCNPJ.getEstado() + "\n" + buscadoLocCNPJ.getEndereco() + " " +
                                        buscadoLocCNPJ.getBairro() + "\n" + buscadoLocCNPJ.getCep() + "\n(" + buscadoLocCNPJ.getDddCelular() + ")" + buscadoLocCNPJ.getNumeroCelular() +
                                        "\n\nDeseja apagar o cadastro?";
                            
                            int excluir = JOptionPane.showConfirmDialog(null, resultado, "", JOptionPane.YES_NO_OPTION);
                            if(excluir == JOptionPane.YES_OPTION){
                                if(pessoaCNPJ.contains(buscadoLocCNPJ)){
                                    if(pessoaCNPJ.remove(buscadoLocCNPJ)){ //Apagou um CNPJ
                                        JOptionPane.showMessageDialog(null, "CNPJ removido com sucesso");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Ocorreu um erro");
                                    }
                                }                                
                            }
                        }
                        return true;
                
                    default: //Opção Inválida
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
                                   String cor = JOptionPane.showInputDialog(null, "Qual a cor do veiculo");
                                    int anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o ano de fabricação"));
                                    int anoModelo = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o ano do modelo"));
                                    int capacidadeTanque = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a capacidade do tanque"));
                                    float valorDiariaCNPJ = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o valor da diaria para CNPJ"));
                                    float valorDiariaCPF = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o valor da diaria para CPF"));

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
                                
                                VeiculoPasseio novoVeicPasseio = new VeiculoPasseio(marca, modelo, renavam, cor, anoFabricacao, anoModelo, capacidadeTanque, valorDiariaCPF, valorDiariaCNPJ, categoria, arCondicionado, direcaoHidraulica, cambioAutomatico);
                                veicPasseio.add(novoVeicPasseio);

                                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
                                return true;

                            case 2:
                                //Cadastro Veiculo utilitario
                                str= "Cadastro de veiculo ultilitario\n\n"+
                                    "1 - Cadastrar veiculo de Carga\n"+
                                    "2 - Cadastrar veiculo de passageiros\n\n"+
                                    "Digite o número que indica a função que deseja";
                                escolha = Integer.parseInt(JOptionPane.showInputDialog(null, str));

                                switch(escolha){
                                    case 1:
                                    marca = JOptionPane.showInputDialog(null, "Qual a marca do veiculo");
                                    modelo = JOptionPane.showInputDialog(null, "Qual o modelo do veiculo");
                                    renavam = JOptionPane.showInputDialog(null, "Qual o renavam do veiculo");
                                    cor = JOptionPane.showInputDialog(null, "Qual a cor do veiculo");
                                    int capacidadeCarga = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a capacidade de carga"));
                                    int taraVeiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a tara do veiculo"));
                                    int tamanhoCompartimento = Integer.parseInt(JOptionPane.showInputDialog(null, "qual o tamanho do compartimento em metros"));
                                    String tipoCompartimento = JOptionPane.showInputDialog(null, "Qual o tipo de compartimento");
                                    anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o ano de fabricação"));
                                    anoModelo = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o ano do modelo"));
                                    capacidadeTanque = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a capacidade do tanque"));
                                    valorDiariaCNPJ = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o valor da diaria para CNPJ"));
                                     valorDiariaCPF = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o valor da diaria para CPF"));

                                    VeiculoUtilitarioCarga newVeicCarga = new VeiculoUtilitarioCarga(marca, modelo, renavam, cor, anoFabricacao, anoModelo, capacidadeTanque, valorDiariaCPF, valorDiariaCNPJ, capacidadeCarga, taraVeiculo, tamanhoCompartimento, tipoCompartimento);
                                    veicCarga.add(newVeicCarga);

                                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
                                    return true;

                                    case 2:
                                    marca = JOptionPane.showInputDialog(null, "Qual a marca do veiculo");
                                    modelo = JOptionPane.showInputDialog(null, "Qual o modelo do veiculo");
                                    renavam = JOptionPane.showInputDialog(null, "Qual o renavam do veiculo");
                                    cor = JOptionPane.showInputDialog(null, "Qual a cor do veiculo");
                                    capacidadeCarga = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a capacidade de carga"));
                                    anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o ano de fabricação"));
                                    anoModelo = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o ano do modelo"));
                                     capacidadeTanque = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a capacidade do tanque"));
                                    valorDiariaCNPJ = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o valor da diaria para CNPJ"));
                                   valorDiariaCPF = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o valor da diaria para CPF"));

                                    confirma = JOptionPane.showConfirmDialog(null, "Possui ar-condicionado", "Ar-Condicionado", JOptionPane.YES_NO_OPTION);
                                    if(confirma == JOptionPane.YES_OPTION){
                                        arCondicionado = true;
                                   }else{
                                        arCondicionado = false;
                                   }
                                  
                                   confirma = JOptionPane.showConfirmDialog(null, "Possui direção hidraulica", "Direção hidraulica", JOptionPane.YES_NO_OPTION);
                                   if(confirma==JOptionPane.YES_OPTION){
                                       direcaoHidraulica = true;
                                   }else{
                                       direcaoHidraulica = false;
                                   }
                                
                                   confirma = JOptionPane.showConfirmDialog(null, "Possui TV", "TV", JOptionPane.YES_NO_OPTION);
                                   Boolean tv;
                                   if(confirma==JOptionPane.YES_OPTION){
                                       tv=true;
                                   }else{
                                       tv=false;
                                   }
                                    VeiculoUtilitarioPassageiro newVeicPassageiro = new VeiculoUtilitarioPassageiro(marca, modelo, renavam, cor, anoFabricacao, anoModelo, capacidadeTanque, valorDiariaCPF, valorDiariaCNPJ, capacidadeCarga, arCondicionado, direcaoHidraulica, tv);
                                    veicPassageiro.add(newVeicPassageiro);

                                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
                                    return true;

                                    default:
                                    JOptionPane.showMessageDialog(null, "Opção Inválida, Pressione OK para voltar ao menu"); 
                                    return true;
                                }

                            case 3:
                                //Cadastro Motocicleta
                                marca = JOptionPane.showInputDialog(null, "Qual a marca do veiculo");
                                modelo = JOptionPane.showInputDialog(null, "Qual o modelo do veiculo");
                                renavam = JOptionPane.showInputDialog(null, "Qual o renavam do veiculo");
                                cor = JOptionPane.showInputDialog(null, "Qual a cor do veiculo");
                                anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o ano de fabricação"));
                                 anoModelo = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o ano do modelo"));
                                 capacidadeTanque = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a capacidade do tanque"));
                                valorDiariaCNPJ = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o valor da diaria para CNPJ"));
                                valorDiariaCPF = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o valor da diaria para CPF"));

                                confirma = JOptionPane.showConfirmDialog(null, "Possui controle de tração", "Controle de Tração", JOptionPane.YES_NO_OPTION);
                                    Boolean controleTracao;
                                if(confirma == JOptionPane.YES_OPTION){
                                        controleTracao = true;
                                   }else{
                                        controleTracao = false;
                                   }
                                  
                                   confirma = JOptionPane.showConfirmDialog(null, "Possui Freio ABS", "Freio", JOptionPane.YES_NO_OPTION);
                                   Boolean freiosABS;
                                   if(confirma==JOptionPane.YES_OPTION){
                                       freiosABS = true;
                                   }else{
                                       freiosABS = false;
                                   }
                                
                                   confirma = JOptionPane.showConfirmDialog(null, "Possui piloto automatico", "Piloto automatico", JOptionPane.YES_NO_OPTION);
                                   Boolean pilotoAutomatico;
                                   if(confirma==JOptionPane.YES_OPTION){
                                       pilotoAutomatico=true;
                                   }else{
                                       pilotoAutomatico=false;
                                   }

                                   String modoPilotagem = JOptionPane.showInputDialog(null, "Qual o modo de pilotagem");

                                Motocicleta newMoto = new Motocicleta(marca, modelo, renavam, cor, anoFabricacao, anoModelo, capacidadeTanque, valorDiariaCPF, valorDiariaCNPJ, controleTracao, freiosABS, pilotoAutomatico, modoPilotagem);
                                motos.add(newMoto);

                                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
                                return true;
                        
                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida, Pressione OK para voltar ao menu"); 
                                return true;
                        }
                    case 2:
                
                        //Pesquisar Veiculo RENAVAM
                        String busca = JOptionPane.showInputDialog(null, "Qual o renavam do veiculo");
                        String resultadoBusca= " ";

                        for(VeiculoPasseio a: veicPasseio){
                            if(a.getRenavam().toLowerCase().contains(busca.toLowerCase())){
                                resultadoBusca = "Renavam: "+ a.getRenavam() + 
                                                "\nMarca: " + a.getMarca()+
                                                "\nModelo: "+ a.getModelo()+
                                                "\nCor: "+a.getCor()+
                                                "\nCategoria: "+a.getCategoria()+
                                                "\nAno de fabricação: "+a.getAnoFabricacao()+
                                                "\nAno Modelo: "+a.getAnoModelo()+
                                                "\nCapacidade do tanque: "+a.getCapacidadeTanque()+
                                                "\nAr condicionado: "+a.getArCondicionado()+
                                                "\nDireção Hidraulica: "+a.getDirecaoHidraulica()+
                                                "\nCambio automatico: "+a.getCambioAutomatico()+
                                                "\nValor Diaria p/ CNPJ: "+ a.getValorDiariaCNPJ()+
                                                "\nValor diaria p/ CPF: "+a.getValorDiariaCPF();
                            }else{

                            }
                        }
                        for(VeiculoUtilitarioCarga a: veicCarga){
                            if(a.getRenavam().toLowerCase().contains(busca.toLowerCase())){
                                resultadoBusca = "Renavam: "+ a.getRenavam() + 
                                                "\nMarca: " + a.getMarca()+
                                                "\nModelo: "+ a.getModelo()+
                                                "\nCor: "+a.getCor()+
                                                "\nAno de fabricação: "+a.getAnoFabricacao()+
                                                "\nAno Modelo: "+a.getAnoModelo()+
                                                "\nCapacidade do tanque: "+a.getCapacidadeTanque()+
                                                "\nCapacidade de carga: "+a.getCapacidadeCarga()+
                                                "\nTara do veiculo: "+a.getTaraVeiculo()+
                                                "\nTipo de compartimento: "+a.getTipoCompartimento()+
                                                "\nTamanho do compartimento: "+a.getTamanhoCompartimento()+
                                                "\nValor Diaria p/ CNPJ: "+ a.getValorDiariaCNPJ()+
                                                "\nValor diaria p/ CPF: "+a.getValorDiariaCPF();
                            }else{

                            }
                        }
                        for(VeiculoUtilitarioPassageiro a: veicPassageiro){
                            if(a.getRenavam().toLowerCase().contains(busca.toLowerCase())){
                                resultadoBusca = "Renavam: "+ a.getRenavam() + 
                                                "\nMarca: " + a.getMarca()+
                                                "\nModelo: "+ a.getModelo()+
                                                "\nCor: "+a.getCor()+
                                                "\nAno de fabricação: "+a.getAnoFabricacao()+
                                                "\nAno Modelo: "+a.getAnoModelo()+
                                                "\nCapacidade do tanque: "+a.getCapacidadeTanque()+
                                                "\nCapacidade de carga: "+a.getCapacidadeCarga()+
                                                "\nAr condicionado: "+a.getArCondicionado()+
                                                "\nDireção Hidraulica: "+a.getDirecaoHidraulica()+
                                                "\nTV: "+a.getTv()+
                                                "\nValor Diaria p/ CNPJ: "+ a.getValorDiariaCNPJ()+
                                                "\nValor diaria p/ CPF: "+a.getValorDiariaCPF();
                            }else{

                            }
                        }
                        for(Motocicleta a: motos){
                            if(a.getRenavam().toLowerCase().contains(busca.toLowerCase())){
                                resultadoBusca = "Renavam: "+ a.getRenavam() + 
                                                "\nMarca: " + a.getMarca()+
                                                "\nModelo: "+ a.getModelo()+
                                                "\nCor: "+a.getCor()+
                                                "\nAno de fabricação: "+a.getAnoFabricacao()+
                                                "\nAno Modelo: "+a.getAnoModelo()+
                                                "\nControle de tração: "+a.getControleTracao()+
                                                "\nFeio ABS: "+a.getFreiosABS()+
                                                "\nPiloto automatico: "+a.getPilotoAutomatico()+
                                                "\nModo de pilotagem: "+a.getModoPilotagem()+
                                                "\nValor Diaria p/ CNPJ: "+ a.getValorDiariaCNPJ()+
                                                "\nValor diaria p/ CPF: "+a.getValorDiariaCPF();
                                                
                            }
                        }

                        if(resultadoBusca==" "){
                            JOptionPane.showMessageDialog(null, "Veiculo não encontrado");
                        }else{
                            JOptionPane.showMessageDialog(null, resultadoBusca);
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
    //Atribuindo os valores informados à variáveis, a partir daqui que se faz o Exception
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

    //Criando um objeto do tipo CPF com todos as variaveis recebidas
        PessoaFisica nvCPF = new PessoaFisica(end, bai, cid, est, cep, eml, ddd, tel, nome, cpf, estadoCivil);
        if(pessoaCPF.add(nvCPF)){ //Caso o CPF foi adicionado a lista
            JOptionPane.showMessageDialog(null, "Cadastro CPF feito com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar CPF");
        }
        return nvCPF; //Retorna uma referencia ao objeto recem criado
    }

    static boolean cadastroCNPJ(List<PessoaJuridica> pessoaCNPJ, List<PessoaFisica> pessoaCPF){
    //Atribuindo os valores informados à variáveis, a partir daqui que se faz o Exception 
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

    //Criando um objeto do tipo CNPJ com todos as variaveis recebidas
        PessoaJuridica nvCNPJ = new PessoaJuridica(end, bai, cid, est, cep, eml, ddd, tel, nomeSocial, cnpj);
    //Informando a necessidade de criar um funcionario vinculado ao CNPJ
        JOptionPane.showMessageDialog(null, "É necessário cadastrar um funcionário para efetuar o aluguel");
    //Chama a função cadastroCPF e o vincula ao CNPJ como funcionario
        PessoaFisica func = cadastroCPF(pessoaCPF);
        nvCNPJ.cadastrarFuncionario(func);

        return pessoaCNPJ.add(nvCNPJ); //Retorna um boolean para caso o CNPJ tenha sido add
    }

    static Locatario buscaLocatario(List<PessoaFisica> pessoaCPF, List<PessoaJuridica> pessoaCNPJ, int tipoBusca){
    //Função de busca, utiliza as listas de objetos e que tipo de busca será feita, CPF ou CNPJ
        String busca; //String com o conteudo da busca
        String resultado = "Locatários encontrados:\n"; //String com a lista de resultados
        int escolha; //Armazena qual objeto foi selecionado

    //Lista de resultados
        PessoaFisica listaDeBuscaCPF[]; 
        PessoaJuridica listaDeBuscaCNPJ[];
        listaDeBuscaCPF = new PessoaFisica[50];
        listaDeBuscaCNPJ = new PessoaJuridica[50];
        int i = 0; //índice
        
        if(tipoBusca == JOptionPane.YES_OPTION){ //Caso a busca seja um CPF
            busca = JOptionPane.showInputDialog(null, "Digite o nome, email ou cpf do locatário a ser buscado");
    //Percorre a lista e verifica se quais objetos possui Nome, Email ou CPF correspondente a 'busca' 
            for (PessoaFisica t: pessoaCPF){
                if(t.getNome().toLowerCase().contains(busca.toLowerCase()) || t.getEmail().toLowerCase().contains(busca.toLowerCase()) || t.getCpf().toLowerCase().contains(busca.toLowerCase())){
                    listaDeBuscaCPF[i] = t;
                    i++;
                    resultado += i + " - " + t.getNome() + "\n"; //Acrescenta nomes à lista de resultado
                }
            }
        //Pergunta qual CPF deseja ser apresentado
            resultado += "\nIndique o número do locatário que deseja visualizar";
            escolha = Integer.parseInt(JOptionPane.showInputDialog(null, resultado));

            return listaDeBuscaCPF[escolha -1]; //retorna o CPF escolhido
                        
        } else { //Caso a busca seja um CNPJ
            busca = JOptionPane.showInputDialog(null, "Digite o nome social, email ou cnpj do locatário a ser buscado");
    //Percorre a lista e verifica se quais objetos possui Nome Social, Email ou CNPJ correspondente a 'busca'
            for (PessoaJuridica t: pessoaCNPJ){
                if(t.getNomeSocial().toLowerCase().contains(busca.toLowerCase()) || t.getEmail().toLowerCase().contains(busca.toLowerCase()) || t.getCnpj().toLowerCase().contains(busca.toLowerCase())){
                    listaDeBuscaCNPJ[i] = t;
                    i++;
                    resultado += i + " - " + t.getNomeSocial() + "\n"; //Acrescenta nomes à lista de resultado
                }
            }
        //Pergunta qual CNPJ deseja ser apresentado
            resultado += "\nIndique o número do locatário que deseja visualizar";
            escolha = Integer.parseInt(JOptionPane.showInputDialog(null, resultado));

            return listaDeBuscaCNPJ[escolha -1]; //retorna o CNPJ escolhido
        }

    }

    /*
    A função de atualizar CPF e CNPJ funcionam da mesma maneira e para todos os atributos
    para facilitar será explicado apenas o 'alterar nome' em CPF
    basicamente para cada atributo será apresentado uma box para informar o novo dado,
    se o input for vazio, será mantido o dado
    */

    static boolean atualizarCPF(PessoaFisica cpf){
    //Strings 'a' para informar na caixa de texto e 'b' para a verificação e alteração do dado
        String a, b; 

        a = "Altere o nome\n" + cpf.getNome(); //String informa qual dado será alterado e qual o valor original
        b = JOptionPane.showInputDialog(null, a); //Input para o novo valor
        if(b.isEmpty()){ //Verifica se a String do input continua vazia
            b = cpf.getNome(); //String pega o valor original
        }
        cpf.setNome(b); //Método set para o valor 'b' 
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