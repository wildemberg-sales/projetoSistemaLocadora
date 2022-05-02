package GerenciadorFrota;

public class Veiculo {

    protected String marca, modelo, cor, renavam;

    protected int anoFabricacao, anoModelo, capacidadeTanque;

    protected float valorDiariaCPF, valorDiariaCNPJ;

    public Veiculo(String marca, String modelo, String renavam) {
        this.marca = marca;
        this.modelo = modelo;
        this.renavam = renavam;
        
    }

    public Veiculo(){

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
