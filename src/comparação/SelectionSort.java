package comparação;

public class SelectionSort {
        public static Resultado Sort(int[] vetor) {
            int trocas = 0;
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
                trocas++;
            }
            return new Resultado(vetor, trocas);
        }
    }
