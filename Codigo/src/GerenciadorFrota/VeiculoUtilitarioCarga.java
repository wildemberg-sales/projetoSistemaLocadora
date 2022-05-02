package GerenciadorFrota;

public class VeiculoUtilitarioCarga extends Veiculo {
    
    protected int capacidadeCarga, taraVeiculo, tamanhoCompartimento;

    protected String tipoCompartimento;

    public VeiculoUtilitarioCarga(String marca, String modelo, String renavam,
     int capacidadeCarga, int taraVeiculo, int tamanhoCompartimento, String tipoCompartimento){
        super(marca, modelo, renavam);
        this.capacidadeCarga = capacidadeCarga;
        this.taraVeiculo = taraVeiculo;
        this.tamanhoCompartimento = tamanhoCompartimento;
        this.tipoCompartimento = tipoCompartimento;
    }
    
    public VeiculoUtilitarioCarga(){

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
