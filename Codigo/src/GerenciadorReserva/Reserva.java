package GerenciadorReserva;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;

import GerenciadorFrota.Veiculo;
import GerenciadorLocatarios.Locatario;
import GerenciadorLocatarios.PessoaFisica;
import GerenciadorLocatarios.PessoaJuridica;

public class Reserva{

    private String dataInicio, dataFim;
    private int numeroReserva, horaInicio, minutoInicio, horaFim, minutoFim, diarias, tipoLocatario;
    private float valorTotal, seguroObrigatorio, imposto, valorSeguroVeiculo;
    private boolean seguroVeiculo;

    private Locatario locatario;
    private PessoaFisica responsavelLoc;
    private Veiculo veiculo;
   
    public Reserva(String dataInicio, String dataFim, int numeroReserva,int horaInicio, int minutoInicio, 
                   int horaFim,int minutoFim, boolean seguroVeiculo,int tipoLocatario,
                    Locatario locatario, Veiculo veiculo, PessoaFisica responsavelLoc) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.numeroReserva = numeroReserva;
        this.horaInicio = horaInicio;
        this.minutoInicio = minutoInicio;
        this.horaFim = horaFim;
        this.minutoFim = minutoFim;        
        this.seguroVeiculo = seguroVeiculo;
        this.locatario = locatario;
        this.veiculo = veiculo;
        this.tipoLocatario = tipoLocatario;
        if(tipoLocatario == JOptionPane.YES_OPTION){
            this.responsavelLoc = responsavelLoc;
        } else {
            PessoaFisica self = (PessoaFisica) locatario;
            this.responsavelLoc = self;
        }

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

    public float calcularValor(){
        LocalDate inicio = LocalDate.parse(dataInicio); //aaaa-mm-dd
        LocalDate fim = LocalDate.parse(dataFim);
        LocalTime horaI = LocalTime.of(horaInicio, minutoInicio);
        LocalTime horaF = LocalTime.of(horaFim, minutoFim);

        LocalDateTime dataInicial = LocalDateTime.of(inicio, horaI);
        LocalDateTime dataFinal = LocalDateTime.of(fim, horaF);
        int diarias = (int) ChronoUnit.DAYS.between(dataInicial, dataFinal);
        this.diarias = diarias;
        
        float valorFinal;
        if(this.tipoLocatario == JOptionPane.YES_OPTION){
            valorFinal = veiculo.getValorDiariaCNPJ() * diarias;
        } else {
            valorFinal = veiculo.getValorDiariaCPF() * diarias;
        }
        double a = valorFinal * 0.12;
        double b = valorFinal * 0.05;
        double c = valorFinal * 0.08;

        this.seguroObrigatorio = (float) a;
        this.imposto = (float) b;
        this.valorSeguroVeiculo = (float) c;
        
        if(seguroVeiculo){
            valorFinal += c;
        }
        valorFinal += a;
        valorFinal += b;

        valorTotal = valorFinal;
        return valorTotal;
    }

    public void relatorioReserva(){
        String resposta;
        float valorFinal;
        if(this.tipoLocatario == JOptionPane.YES_OPTION){
            PessoaJuridica a = (PessoaJuridica) locatario;
            valorFinal = veiculo.getValorDiariaCNPJ(); 
            resposta = "Reserva: " + numeroReserva + "\nLocatário: " + a.getNomeSocial() +
                       "\nResponsável pela Locação: " + responsavelLoc.getNome();
        } else{
            PessoaFisica a = (PessoaFisica) locatario;
            valorFinal = veiculo.getValorDiariaCPF();
            resposta = "Reserva: " + numeroReserva + "\nLocatário: " + a.getNome() + 
                       "\nResponsável pela Locação: " + responsavelLoc.getNome();
        }

        resposta += "\n\n                   Dados da Locação                   " +
                    "\nInício: " + dataInicio + " - " + horaInicio + ":" + minutoInicio +
                    "\nFim:    " + dataFim + " - " + horaFim + ":" + minutoFim +
                    "\nNúmero de diárias: " + diarias + 
                    "\n\nVeiculo: " + veiculo.getMarca() + " - " + veiculo.getModelo() +
                    "\nAno de Febricação / Modelo: " + veiculo.getAnoFabricacao() + " / " + veiculo.getAnoModelo() +
                    "\nRenavam: " + veiculo.getRenavam() +
                    "\n\nValor Diaria: " + valorFinal +
                    "\nValor do seguro de terceiros: " + seguroObrigatorio +
                    "\nValor do seguro próprio: " + valorSeguroVeiculo + 
                    "\nValor dos impostos: " + imposto +
                    "\nValor total: " + valorTotal;

        JOptionPane.showMessageDialog(null, resposta);
    }

}