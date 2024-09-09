package duplaEncadeada;

public class App {
    public static void main(String[] args) {
       duplaEncadeada lista = new duplaEncadeada();
       

       lista.adicionar("junior");
       lista.adicionar("gabriel");
       lista.adicionar("santos");
       System.out.println(lista);

       
    }
}

/*ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        System.out.println(lista);
        lista.adicionar("cecilia");
        System.out.println(lista);
        lista.adicionar("vitor");
        System.out.println(lista);
        lista.adicionar("salete");
        System.out.println(lista);

        System.out.println(lista.contem("joao"));
        System.out.println(lista.contem("cecilia"));
        lista.adicionar(2, "joao");
        System.out.println(lista); */