package GerenciadorFrota;

public class CampoEmBrancoException extends RuntimeException {

    public CampoEmBrancoException(String mensagem){
       super(mensagem);
    }
}
