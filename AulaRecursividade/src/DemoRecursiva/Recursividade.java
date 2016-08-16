
package DemoRecursiva;

public class Recursividade {

    int contagem = 10;
    
    public static void contagemRegressiva(int n){
        
        if(n == 0){
        
            System.out.println("EXPLOSIOOOOOOOOOON");
            
        } else {
        
            System.out.println(n);
            contagemRegressiva(n-1);
        }
    
    
    }
    
    public static void main(String[] args) {
        contagemRegressiva(5);
    }
    
}
