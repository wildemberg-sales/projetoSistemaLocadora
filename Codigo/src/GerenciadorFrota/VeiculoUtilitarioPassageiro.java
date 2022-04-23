package GerenciadorFrota;

public class VeiculoUtilitarioPassageiro extends Veiculo{

    protected int capacidadeCarga;

    protected boolean arCondicionado, direcaoHidraulica, tv;

    public VeiculoUtilitarioPassageiro(String marca, String modelo, int renavam,
     int capacidadeCarga, boolean arCondicionado, boolean direcaoHidraulica, boolean tv){
        super(marca, modelo, renavam);
        this. capacidadeCarga = capacidadeCarga;
        this.arCondicionado = arCondicionado;
        this.direcaoHidraulica = direcaoHidraulica;
        this.tv = tv;
    }
    
    public VeiculoUtilitarioPassageiro(){

    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public boolean getArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public boolean getDirecaoHidraulica() {
        return direcaoHidraulica;
    }

    public void setDirecaoHidraulica(boolean direcaoHidraulica) {
        this.direcaoHidraulica = direcaoHidraulica;
    }

    public boolean getTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }
    
}
