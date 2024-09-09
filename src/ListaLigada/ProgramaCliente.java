package ListaLigada;

public class ProgramaCliente {
    public static void main(String[] args) {
        ListaLigada1<Cliente> clientes = new ListaLigada1<Cliente>();

        clientes.adicionar(new Cliente("123", "jão"));
        clientes.adicionar(new Cliente("456", "duca"));
        clientes.adicionar(new Cliente("789", "zezin"));

        System.out.println("Tamanho: " + clientes.getTamanho());
        for (int i = 0; i < clientes.getTamanho(); i++){
            System.out.println(clientes.get(i).getValor());
        }
    }
}
