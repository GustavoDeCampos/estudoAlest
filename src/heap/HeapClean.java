package heap;

import java.util.ArrayList;

public class HeapClean {

    private ArrayList<Integer> heap;

    public HeapClean(){
        heap = new ArrayList<>();
    }

    public void inserir(int valor){
        heap.add(valor);
        swim(heap.size() - 1);
        System.out.println("Inserido " + valor + ": " + heap);
    }

    private void swim(int filho) {
        if (filho > 0) {
            int pai = (filho - 1) / 2;

            if (heap.get(filho) > heap.get(pai)) {
                troca(heap, filho, pai);
                swim(pai);
            }
        }
    }

    public int removerMax(){
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap vazio");
        }

        int maximo = heap.get(0);
        int ultimo = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, ultimo);
            sink(heap, 0, heap.size());
        }

        return maximo;
    }

    private void sink(ArrayList<Integer> heap, int pai, int tamanho) {
        int esquerda = (2 * pai) + 1;
        int direita = (2 * pai) + 2;

        if (esquerda < tamanho) {
            int maiorFilho = esquerda;

            if (direita < tamanho && heap.get(direita) > heap.get(esquerda)) {
                maiorFilho = direita;
            }

            if (heap.get(pai) < heap.get(maiorFilho)) {
                troca(heap, pai, maiorFilho);
                sink(heap, maiorFilho, tamanho);
            }
        }
    }

    public ArrayList<Integer> heapSort(){
        ArrayList<Integer> copiaHeap = new ArrayList<>(heap);
        int tamanhoHeap = copiaHeap.size();

        for (int i = tamanhoHeap / 2 - 1; i >= 0; i--){
            sink(copiaHeap, i, tamanhoHeap);
        }

        for(int i = tamanhoHeap - 1; i > 0; i--){
            troca(copiaHeap, 0, i);
            sink(copiaHeap, 0, i);
        }

        return copiaHeap;
    }

    private void troca(ArrayList<Integer> heap, int a, int b){
        int auxiliar = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, auxiliar);
    }

    public void mostrarHeap(){
        System.out.println(heap);
    }
}