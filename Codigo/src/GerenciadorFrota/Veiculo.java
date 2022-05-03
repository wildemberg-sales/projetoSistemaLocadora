package GerenciadorFrota;

public class Veiculo {

    protected String marca, modelo;

	protected String cor;

	protected String renavam;

    protected int anoFabricacao;

    protected int anoModelo;

    protected int capacidadeTanque;

    protected float valorDiariaCPF;

	protected float valorDiariaCNPJ;

    public Veiculo(String marca, String modelo, String renavam, String cor, int anoFabricacao, int anoModelo, int capacidadeTanque, float valorDiariaCPF, float valorDiariaCNPJ) throws CampoEmBrancoException{
        
        if(marca.isEmpty() || modelo.isEmpty() || renavam.isEmpty()){
            throw new CampoEmBrancoException("Marca, modelo e renavam precisam estar preenchidos para o cadastro ser realizado!\nClique em OK para voltar ao Menu");
        }else{
            this.marca = marca;
            this.modelo = modelo;
            this.renavam = renavam;
            this.anoFabricacao=anoFabricacao;
            this.anoModelo=anoModelo;
            this.capacidadeTanque=capacidadeTanque;
            this.valorDiariaCNPJ=valorDiariaCNPJ;
            this.valorDiariaCPF=valorDiariaCPF;
            this.cor=cor;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public int getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(int capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public float getValorDiariaCPF() {
        return valorDiariaCPF;
    }

    public void setValorDiariaCPF(float valorDiariaCPF) {
        this.valorDiariaCPF = valorDiariaCPF;
    }

    public float getValorDiariaCNPJ() {
        return valorDiariaCNPJ;
    }

    public void setValorDiariaCNPJ(float valorDiariaCNPJ){
        this.valorDiariaCNPJ = valorDiariaCNPJ;
    }
}
