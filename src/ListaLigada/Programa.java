package ListaLigada;

// linkedList
public class Programa {
    public static void main(String[] args) {

        ListaLigada1<String> lista = new ListaLigada1<String>();

        System.out.println(lista.getTamanho());
        lista.adicionar("Rj");
        lista.adicionar("Ba");
        lista.adicionar("Rs");
        lista.adicionar("Ce");

        System.out.println("Tamanho: " + lista.getTamanho());
        System.out.println("Primeiro: " + lista.getPrimeiro().getValor());
        System.out.println("Ultimo: " + lista.getUltimo().getValor());

        for (int i = 0; i < lista.getTamanho(); i++){
            System.out.println(lista.get(i).getValor());
        }

        //remover estado
        lista.remover("Rs");
        System.out.println("Removeu estado Rs");

        System.out.println("Tamanho: " + lista.getTamanho());
        for (int i = 0; i < lista.getTamanho(); i++){
            System.out.println(lista.get(i).getValor());
        }
    }
}


