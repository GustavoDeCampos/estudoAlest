package comparação;

public class Main {
    public static void main(String[] args) {
        int[] vetor = new int[100000];

        for (int i = 0; i < vetor.length; i++){
            vetor[i] = (int) (Math.random() * vetor.length);
        }

        long inicio, fim;
        Resultado resultado;

        System.out.println("\n\nBubble sorts");
        inicio = System.currentTimeMillis();
        resultado = BubbleSort.Sort(vetor.clone());
        fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim-inicio) + "ms");
        System.out.println("Trocas: " + resultado.getTrocas());

        System.out.println("\n\nHeap sorts");
        inicio = System.currentTimeMillis();
        resultado = HeapSort.Sort(vetor.clone());
        fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim-inicio) + "ms");
        System.out.println("Trocas: " + resultado.getTrocas());

        System.out.println("\n\nInsertion sorts");
        inicio = System.currentTimeMillis();
        resultado = InsertionSort.Sort(vetor.clone());
        fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim-inicio) + "ms");
        System.out.println("Trocas: " + resultado.getTrocas());

        System.out.println("\n\nSelection sorts");
        inicio = System.currentTimeMillis();
        resultado = SelectionSort.Sort(vetor.clone());
        fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim-inicio) + "ms");
        System.out.println("Trocas: " + resultado.getTrocas());

        System.out.println("\n\nQuick sorts");
        inicio = System.currentTimeMillis();
        resultado = QuickSort.Sort(vetor.clone(), 0, vetor.length);
        fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim-inicio) + "ms");
        System.out.println("Trocas: " + resultado.getTrocas());
    }
}
