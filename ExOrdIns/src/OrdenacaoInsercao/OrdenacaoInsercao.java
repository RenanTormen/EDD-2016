package OrdenacaoInsercao;

public class OrdenacaoInsercao {

    public static int vet[] = {30, 20, 10, 40};

    public OrdenacaoInsercao() {

    }

    public static void ordenaMenor() {

        // int vet2[] = new int[4];
        int chave = 0;
        int j = 0;
        System.out.println("tamanho do vetor: " + vet.length);

        for (int i = 1; i < vet.length; i++) {

            chave = vet[i];
      

            for ( j = i-1; j >= 0 && vet[j] > chave; j--) {
      
                vet[j+1] = vet[j];
            }

            vet[j+1] = chave;

        }

        int t = 0;
        while (t != vet.length) {
            System.out.println(vet[t]);
            t++;
        }
    }

    public static void ordenaMaior() {

        // int vet2[] = new int[4];
        int chave = 0;
        int j = 0;
        System.out.println("tamanho do vetor: " + vet.length);

        for (int i = 1; i < vet.length; i++) {

            chave = vet[i];

            for ( j = i-1; j >= 0 && vet[j] < chave; j--) {
                vet[j+1] = vet[j];
            }
            vet[j+1] = chave;
       

        }

        int t = 0;
        while (t != vet.length) {
            System.out.println(vet[t]);
            t++;
        }
    }
    
    public static void main(String[] args) {
        ordenaMenor();
        ordenaMaior();
    }
}
