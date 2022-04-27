import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        
        String op;
        
        

    }

    //Menu principal
    public static String Menu(){
        String op;
        op = JOptionPane.showInputDialog("=====Menu Principal=====\nA) Gerenciar Locatarios\nB)Gerenciar Frota\nC)Gerenciar Reservas\nD)Sair do Programa").toUpperCase();
        return op;
    }


}
