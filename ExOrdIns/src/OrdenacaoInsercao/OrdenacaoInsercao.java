package OrdenacaoInsercao;

public class OrdenacaoInsercao {

    public static int vet[] = {30, 20, 10, 40};

    public OrdenacaoInsercao() {

    }

    public static void main(String[] args) {

        // int vet2[] = new int[4];
        int chave = 0;
        System.out.println("tamanho do vetor: " + vet.length);

        for (int i = 0; i  < vet.length  ; i++) {
            
           chave = vet[i];
           
           for(int j = i - 1; j >= 0 && vet[j] > chave; j-- ){
               vet[j] = vet[j+1];
           }
                
        }

        int t = 0;
        while (t != vet.length) {
            System.out.println(vet[t]);
            t++;
        }
    }

}
