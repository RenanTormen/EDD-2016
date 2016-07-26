package OrdenacaoInsercao;

public class OrdenacaoInsercao {

    public static int vet[] = {30, 20, 10, 40};

    public OrdenacaoInsercao() {

    }

    public static void main(String[] args) {

        // int vet2[] = new int[4];
        int chave = 0;
        System.out.println("tamanho do vetor: " + vet.length);

        for (int i = 0; i <= vet.length - 1; i++) {

            chave = vet[i];

            for (int j = 0; j <= vet.length - 2; j++) {

                if (chave >= 0 && vet[j + 1] > chave) {
                    chave = vet[j + 1];

                } else {
                    vet[j] = vet[j + 1];
                    vet[j + 1] = chave;

                }
            }
        }

        int t = 0;
        while (t != vet.length) {
            System.out.println(vet[t]);
            t++;
        }
    }

}
