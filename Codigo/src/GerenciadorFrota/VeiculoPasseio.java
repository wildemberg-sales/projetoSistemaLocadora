package GerenciadorFrota;

public class VeiculoPasseio extends Veiculo{

    protected String categoria;

    protected boolean arCondicionado, direcaoHidraulica, cambioAutomatico;

    public VeiculoPasseio(String marca, String modelo, int renavam,
     String categoria, boolean arCondicionado, boolean direcaoHidraulica, boolean cambioAutomatico){
        super(marca, modelo, renavam);
        this. categoria = categoria;
        this.arCondicionado = arCondicionado;
        this.direcaoHidraulica = direcaoHidraulica;
        this.cambioAutomatico = cambioAutomatico;
    }
    
    public VeiculoPasseio(){

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public boolean getCambioAutomatico() {
        return cambioAutomatico;
    }

    public void setCambioAutomatico(boolean cambioAutomatico) {
        this.cambioAutomatico = cambioAutomatico;
    }

}

