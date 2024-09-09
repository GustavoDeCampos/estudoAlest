package ListaLigada;

public class ProgramaInt{
    public static void main(String[] args) {
        ListaLigada1<Integer> numerosInt = new ListaLigada1<Integer>();
        numerosInt.adicionar(3);
        numerosInt.adicionar(4);
        numerosInt.adicionar(5);

        System.out.println("Tamanho: " + numerosInt.getTamanho());
        for (int i = 0; i < numerosInt.getTamanho(); i++){
            System.out.println(numerosInt.get(i).getValor());
        }
    }
}
