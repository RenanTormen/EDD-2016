package OrdenacaoInsercao;

public class OrdenacaoInsercao {

    public static int vet[] = {30, 20, 10, 40};

    public OrdenacaoInsercao() {

    }

    public static void main(String[] args) {

       // int vet2[] = new int[4];
        int chave = 0;

        for (int i = 0; i >= vet.length - 1; i++) {
            System.out.println(vet[i]);

            chave = vet[i];
            for (int j = 0; i >= vet.length - 1; i++) {
                if (chave >= 0 && chave > vet[j + 1]) {
                    chave = vet[j + 1];
                } else {
                    vet[j] = vet[j + 1];
                    vet[j + 1] = chave;
                }
            }
        }
    }

}
