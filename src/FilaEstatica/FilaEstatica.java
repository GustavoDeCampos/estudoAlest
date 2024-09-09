
public class FilaEstatica {
    private final int CAPACIDADE_INICIAL = 5;
    private int capacidade;
    private String[] itens;
    private int tamanho;
    private int inicio;
    private int fim;

    public FilaEstatica() {
        capacidade = CAPACIDADE_INICIAL;
        itens = new String[capacidade];
        tamanho = 0;
        inicio = 0;
        fim = -1;
    }

    public void enfileirar(String item){
        itens[fim + 1] = item;
        fim++;
        tamanho++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Lista: ");
        for(int i = inicio; i <= fim; i++){
            sb.append(itens[i]);
            sb.append(" ");
            return sb.toString();
        }
        return null;
    }
}