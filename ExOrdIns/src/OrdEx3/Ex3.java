package OrdEx3;

import javax.swing.JOptionPane;

public class Ex3 {

    public static void main(String[] args) {
        Vetor v = new Vetor();
        String c = "";
        c = JOptionPane.showInputDialog("Selecione a opção desejada: \n 1 - Ordenação do > p/ < \n 2 - Ordenação do < p/ >");
        switch (c) {
            case "1":
                v.ordenaMaior(4);
                v.mostraVetor();
                main(args);
            case "2" :
                v.ordenaMenor(4);
                v.mostraVetor();
                main(args);
        }

    }
}
