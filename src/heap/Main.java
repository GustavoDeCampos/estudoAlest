package heap;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HeapClean meuHeap = new HeapClean();

        for(int i = 0; i < 10; i++){
            meuHeap.inserir((int) Math.floor(Math.random() * 100));
        }

        System.out.println("\nHeap resultante:");
        meuHeap.mostrarHeap();

        ArrayList<Integer> heapOrdenado = meuHeap.heapSort();
        System.out.println("\nHeap ordenado:");
        System.out.println(heapOrdenado);

        System.out.println("\nValor máximo removido: " + meuHeap.removerMax());

        System.out.println("\nHeap após a remoção do valor máximo:");
        meuHeap.mostrarHeap();

        ArrayList<Integer> heapOrdenadoSemMax = meuHeap.heapSort();
        System.out.println("\nHeap ordenado sem o valor máximo:");
        System.out.println(heapOrdenadoSemMax);

        System.out.println("\nValor máximo removido: " + meuHeap.removerMax());

        System.out.println("\nHeap após a remoção do valor máximo:");
        meuHeap.mostrarHeap();

        ArrayList<Integer> heapOrdenadoSemMax1 = meuHeap.heapSort();
        System.out.println("\nHeap ordenado sem o valor máximo:");
        System.out.println(heapOrdenadoSemMax1);
    }
}
