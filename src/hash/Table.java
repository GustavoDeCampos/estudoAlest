package hash;

import java.util.ArrayList;

public class Table implements HashTable {

    private LinkedList[] Ltable; // Array de listas encadeadas para armazenar os usuários
    private int count; // Contador de elementos na tabela
    private static final double LOAD_FACTOR = 0.75; // Fator de carga para redimensionamento

    // Construtor que inicializa a tabela com o tamanho especificado
    public Table(int size) {
        this.Ltable = new LinkedList[size]; // Cria o array de listas encadeadas
        initialize(Ltable, size); // Inicializa cada posição do array com uma nova lista encadeada
    }

    // Método para inicializar cada posição do array com uma nova lista encadeada
    public void initialize(LinkedList[] table, int size) {
        for (int i = 0; i < size; i++) {
            this.Ltable[i] = new LinkedList(); // Inicializa a posição i com uma nova lista encadeada
        }
    }

    // Método para calcular o hash do ID do usuário
    @Override
    public int hash(int id) {
        return id % Ltable.length; // Retorna o índice calculado pelo hash
    }

    // Método para adicionar um usuário na tabela
    @Override
    public void add(User user) throws Exception {
        // Verifica se a tabela precisa ser redimensionada
        if (count >= Ltable.length * LOAD_FACTOR) {
            resize(); // Redimensiona a tabela se necessário
        }
        int hash = hash(user.getId()); // Calcula o hash do ID do usuário
        Ltable[hash].add(user); // Adiciona o usuário na lista encadeada correspondente ao hash
        count++; // Incrementa o contador de elementos
    }

    // Método para redimensionar a tabela
    @Override
    public void resize() {
        int size = Ltable.length; // Armazena o tamanho atual da tabela

        LinkedList[] aux = Ltable; // Cria uma referência auxiliar para a tabela atual

        ArrayList<User> users = new ArrayList<User>(); // Cria uma lista para armazenar todos os usuários

        // Salva todos os usuários da tabela hash dentro do arraylist
        for (int i = 0; i < aux.length; i++) { //Este loop percorre cada índice do array aux, i é o índice atual do array aux, aux.length é o comprimento do array aux, ou seja, o número de "baldes" ou listas na tabela hash.
            for (int j = 0; j < aux[i].retrievUsers().size(); j++) { //em cada indice i, tem uma lista de usuários, então este loop percorre cada usuário na lista de usuários
                users.add(aux[i].retrievUsers().get(j)); // Adiciona cada usuário na lista
            }//uma vez que esse for percorreu toda a lista de usuarios, o for anterior vai para a proxima lista e esse for vai percorrer ela inteira
            //garantindo que o array users receba todos os usuarios de todas as listas ligadas da tabela hash
        }

        this.Ltable = new LinkedList[size * 2]; // Dobra o tamanho da tabela
        initialize(this.Ltable, this.Ltable.length); // Inicializa a nova tabela

        // Pega todos os usuários salvos no arrayList e distribui na nova tabela hash
        for (int i = 0; i < users.size(); i++) {
            try {
                add(users.get(i)); // Adiciona cada usuário na nova tabela
            } catch (Exception e) {
                e.printStackTrace(); // Imprime a pilha de exceção se ocorrer um erro
            }
        }
    }

    // Método para remover um usuário da tabela pelo ID
    @Override
    public void remove(int id) throws Exception {
        int hash = hash(id); // Calcula o hash do ID do usuário
        if (Ltable[hash].remove(id)) { // Remove o usuário da lista encadeada correspondente ao hash
            count--; // Decrementa o contador de elementos
        } else {
            throw new Exception("Usuario não encontrado"); // Lança uma exceção se o usuário não for encontrado
        }
    }

    // Método para verificar se a tabela está cheia
    @Override
    public boolean isFull() {
        //não há necessidade de implementar, pois a tabela não possui limite de elementos, então nunca estará cheia
        return false;
    }

    // Método para imprimir os usuários da tabela
    @Override
    public void print() {
        for (int i = 0; i < Ltable.length; i++) {
            System.out.print("[" + i + "] - "); // Imprime o índice da tabela
            Ltable[i].print(); // Imprime os usuários na lista encadeada correspondente ao índice
        }
    }

    // Método para recuperar um usuário da tabela pelo ID
    @Override
    public User retrieve(int id) throws Exception {
        int hash = hash(id); // Calcula o hash do ID do usuário

        if (Ltable[hash].retrieve(id) != null) { // Verifica se o usuário existe na lista encadeada correspondente ao hash
            return Ltable[hash].retrieve(id); // Retorna o usuário encontrado
        } else {
            throw new Exception("Usuario não encontrado"); // Lança uma exceção se o usuário não for encontrado
        }
    }

    // Método para contar o número de elementos na tabela
    @Override
    public int size() {
        int count = 0; // Inicializa o contador de elementos

        // Percorre cada lista encadeada na tabela
        for (int i = 0; i < Ltable.length; i++) {
            for (int j = 0; j < Ltable[i].size(); j++) {
                count++; // Incrementa o contador para cada elemento encontrado
            }
        }

        return count; // Retorna o número total de elementos na tabela
    }
}