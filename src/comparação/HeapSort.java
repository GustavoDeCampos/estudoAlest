package comparação;

public class HeapSort {
    static int trocas = 0;
        public static Resultado Sort(int[] vetor) {
            //Heap sort
            int n = vetor.length;
            for (int i = n / 2 - 1; i >= 0; i--) {
                aplicarHeap(vetor, n, i);
            }

            for (int i = n - 1; i > 0; i--) {
                int aux = vetor[0];
                vetor[0] = vetor[i];
                vetor[i] = aux;
                trocas++;
                aplicarHeap(vetor, i, 0);
            }
            return new Resultado(vetor, trocas);
        }
        private static void aplicarHeap(int[] vetor, int n, int i){
            int raiz = i;
            int esquerda = 2*i + 1;
            int direita = 2*i + 2;

            if (esquerda < n && vetor[esquerda] > vetor[raiz]){
                raiz = esquerda;
            }
            if (direita < n && vetor[direita] > vetor[raiz]){
                raiz = direita;
            }
            if (raiz != i){
                int aux = vetor[i];
                vetor[i] = vetor[raiz];
                vetor[raiz] = aux;
                trocas++;

                aplicarHeap(vetor, n, raiz);
            }
        }
    }

