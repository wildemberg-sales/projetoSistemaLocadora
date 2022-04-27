package GerenciadorReserva;

public class Reserva{

    private String dataInicio, dataFim;
    private int numeroReserva, horaInicio, minutoInicio, horaFim, minutoFim, diarias;
    private float valorTotal, seguroObrigatorio, imposto;
    private boolean seguroVeiculo;
   
    public Reserva(String dataInicio, String dataFim, int numeroReserva, int horaInicio, int minutoInicio, int horaFim,
            int minutoFim, int diarias, float valorTotal, float seguroObrigatorio, float imposto,
            boolean seguroVeiculo) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.numeroReserva = numeroReserva;
        this.horaInicio = horaInicio;
        this.minutoInicio = minutoInicio;
        this.horaFim = horaFim;
        this.minutoFim = minutoFim;
        this.diarias = diarias;
        this.valorTotal = valorTotal;
        this.seguroObrigatorio = seguroObrigatorio;
        this.imposto = imposto;
        this.seguroVeiculo = seguroVeiculo;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getMinutoInicio() {
        return minutoInicio;
    }

    public void setMinutoInicio(int minutoInicio) {
        this.minutoInicio = minutoInicio;
    }

    public int getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(int horaFim) {
        this.horaFim = horaFim;
    }

    public int getMinutoFim() {
        return minutoFim;
    }

    public void setMinutoFim(int minutoFim) {
        this.minutoFim = minutoFim;
    }

    public int getDiarias() {
        return diarias;
    }

    public void setDiarias(int diarias) {
        this.diarias = diarias;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getSeguroObrigatorio() {
        return seguroObrigatorio;
    }

    public void setSeguroObrigatorio(float seguroObrigatorio) {
        this.seguroObrigatorio = seguroObrigatorio;
    }

    public float getImposto() {
        return imposto;
    }

    public void setImposto(float imposto) {
        this.imposto = imposto;
    }

    public boolean getSeguroVeiculo() {
        return seguroVeiculo;
    }

    public void setSeguroVeiculo(boolean seguroVeiculo) {
        this.seguroVeiculo = seguroVeiculo;
    }

    

}