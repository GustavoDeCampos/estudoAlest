package comparação;

public class InsertionSort {
        public static Resultado Sort(int[] vetor) {
            int j;
            int aux;
            int trocas = 0;
            for (int i = 1; i < vetor.length; i++){
                aux = vetor[i];
                j = i - 1;
                while (j >= 0 && vetor[j] > aux){
                    vetor[j+1] = vetor[j];
                    j--;
                    trocas++;
                }
                vetor[j+1] = aux;
                trocas++;
            }
            return new Resultado(vetor, trocas);
        }
    }
