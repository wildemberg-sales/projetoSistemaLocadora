package GerenciadorFrota;

public class Motocicleta extends Veiculo {
    
    protected boolean controleTracao, freiosABS, pilotoAutomatico;

    protected String modoPilotagem;

    public Motocicleta(String marca, String modelo, String renavam,  String cor, int anoFabricacao, int anoModelo, int capacidadeTanque, float valorDiariaCPF, float valorDiariaCNPJ,
     boolean controleTracao, boolean freiosABS, boolean pilotoAutomatico, String modoPilotagem){
        super(marca, modelo, renavam, cor, anoFabricacao, anoModelo, capacidadeTanque, valorDiariaCPF, valorDiariaCNPJ);
        this.controleTracao = controleTracao;
        this.freiosABS = freiosABS;
        this.pilotoAutomatico = pilotoAutomatico;
        this. modoPilotagem = modoPilotagem;
    }

    public boolean getControleTracao() {
        return controleTracao;
    }

    public void setControleTracao(boolean controleTracao) {
        this.controleTracao = controleTracao;
    }

    public boolean getFreiosABS() {
        return freiosABS;
    }

    public void setFreiosABS(boolean freiosABS) {
        this.freiosABS = freiosABS;
    }

    public boolean getPilotoAutomatico() {
        return pilotoAutomatico;
    }

    public void setPilotoAutomatico(boolean pilotoAutomatico) {
        this.pilotoAutomatico = pilotoAutomatico;
    }

    public String getModoPilotagem() {
        return modoPilotagem;
    }

    public void setModoPilotagem(String modoPilotagem) {
        this.modoPilotagem = modoPilotagem;
    }
}