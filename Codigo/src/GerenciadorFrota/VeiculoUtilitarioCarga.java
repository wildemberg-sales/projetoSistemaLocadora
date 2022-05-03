package GerenciadorFrota;

public class VeiculoUtilitarioCarga extends Veiculo {
    
    protected int capacidadeCarga, taraVeiculo, tamanhoCompartimento;

    protected String tipoCompartimento;

    public VeiculoUtilitarioCarga(String marca, String modelo, String renavam,  String cor, int anoFabricacao, int anoModelo, int capacidadeTanque, float valorDiariaCPF, float valorDiariaCNPJ,
     int capacidadeCarga, int taraVeiculo, int tamanhoCompartimento, String tipoCompartimento){
        super(marca, modelo, renavam, cor, anoFabricacao, anoModelo, capacidadeTanque, valorDiariaCPF, valorDiariaCNPJ);
        this.capacidadeCarga = capacidadeCarga;
        this.taraVeiculo = taraVeiculo;
        this.tamanhoCompartimento = tamanhoCompartimento;
        this.tipoCompartimento = tipoCompartimento;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getTaraVeiculo() {
        return taraVeiculo;
    }

    public void setTaraVeiculo(int taraVeiculo) {
        this.taraVeiculo = taraVeiculo;
    }

    public int getTamanhoCompartimento() {
        return tamanhoCompartimento;
    }

    public void setTamanhoCompartimento(int tamanhoCompartimento) {
        this.tamanhoCompartimento = tamanhoCompartimento;
    }

    public String getTipoCompartimento() {
        return tipoCompartimento;
    }

    public void setTipoCompartimento(String tipoCompartimento) {
        this.tipoCompartimento = tipoCompartimento;
    }

}
