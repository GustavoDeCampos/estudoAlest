package Selection;

public class Main {
    public static void main(String[] args) {
        int[] vetor = new int[40];

        System.out.println("Vetor:");
        for (int i = 0; i < vetor.length; i++){
            vetor[i] = (int) (Math.random() * 100);
            System.out.println(vetor[i]);
        }

        int menor;
        int aux;
        //Selection sort O(n^2)
        for (int i = 0; i < vetor.length; i++){ //O(n)
            menor = i;
            for (int j = i + 1; j < vetor.length; j++){ //O(n)
                if (vetor[j] < vetor[menor]){
                    menor = j;
                }
            }
            aux = vetor[menor];
            vetor[menor] = vetor[i];
            vetor[i] = aux;

        }


        System.out.println("\nOrdenado:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}
