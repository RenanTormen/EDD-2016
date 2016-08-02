package ExOrdSelec;

public class ExOrdSelecao {

    public static int[] vet = {30, 20, 10, 40};

    public int[] ordenaMaior() {
        int pos = 0;

        for (int i = 0; i != vet.length - 1; i++) {
            pos = i;
            for (int j = i + 1; j < vet.length -1 ; j++) {
                if (vet[j] < vet[pos]) {
                    pos = j;

                }
                if (pos != i) {
                    int aux = vet[i];
                    vet[i] = vet[pos];
                    vet[pos] = aux;
                    
                }
            }
        }
        int u = 0;

        while (u < vet.length) {
            System.out.print("["+vet[u]+"]");
            u++;
        }
        
        return vet;

    }

   
}
