package hash;

import java.util.ArrayList;

public class LinkedList {
    private Node head; // Referência para o primeiro nó da lista

    // Método para adicionar um usuário na lista
    public void add(User user) throws Exception {
        Node newNode = new Node(user); // Cria um novo nó com o usuário fornecido

        Node aux = head; // Nó auxiliar para percorrer a lista, começando pelo head
        Node aux2 = null; // Nó auxiliar para manter a referência do nó anterior

        // Percorre a lista até encontrar a posição correta para inserir o novo nó
        while ((aux != null) && (aux.user.getId() < newNode.user.getId())) {
            aux2 = aux; // Atualiza aux2 para o nó atual
            aux = aux.next; // Move para o próximo nó
        }

        // Se a lista estiver vazia, insere o novo nó como head
        if (head == null) {
            head = newNode;
        } else if (aux == head) { // Se o novo nó deve ser inserido antes do head atual
            newNode.next = head; // O próximo do novo nó será o head atual
            head = newNode; // Atualiza o head para o novo nó
        } else { // Insere o novo nó entre aux2 e aux
            newNode.next = aux; // O próximo do novo nó será aux
            aux2.next = newNode; // O próximo de aux2 será o novo nó
        }
    }

    // Método para remover um usuário da lista pelo ID
    public boolean remove(int id) {
        Node aux = head; // Nó auxiliar para percorrer a lista, começando pelo head
        Node aux2 = null; // Nó auxiliar para manter a referência do nó anterior

        // Percorre a lista até encontrar o nó com o ID fornecido
        while (aux != null && aux.user.getId() != id) {
            aux2 = aux; // Atualiza aux2 para o nó atual
            aux = aux.next; // Move para o próximo nó
        }

        // Se o nó não for encontrado, retorna false
        if (aux == null) {
            return false; // Usuário não encontrado
        }

        // Se o nó a ser removido for o head
        if (aux == head) {
            head = head.next; // Atualiza o head para o próximo nó
        } else { // Remove o nó entre aux2 e aux
            aux2.next = aux.next; // O próximo de aux2 será o próximo de aux
        }

        return true; // Usuário removido com sucesso
    }

    // Método para recuperar um usuário da lista pelo ID
    public User retrieve(int id) {
        Node aux = head; // Nó auxiliar para percorrer a lista, começando pelo head

        // Percorre a lista até encontrar o nó com o ID fornecido
        while (aux != null) {
            if (aux.user.getId() == id) { // Se encontrar o nó com o ID fornecido
                return aux.user; // Retorna o usuário encontrado
            } else {
                aux = aux.next; // Move para o próximo nó
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }

    // Método para recuperar todos os usuários da lista
    public ArrayList<User> retrievUsers() {
        ArrayList<User> users = new ArrayList<User>(); // Cria uma lista para armazenar os usuários

        Node aux = head; // Nó auxiliar para percorrer a lista, começando pelo head

        // Percorre a lista e adiciona cada usuário na lista de usuários
        while (aux != null) {
            users.add(aux.user); // Adiciona o usuário atual na lista
            aux = aux.next; // Move para o próximo nó
        }
        return users; // Retorna a lista de usuários
    }

    // Método para verificar se a lista está vazia
    public boolean isEmpty() {
        return head == null; // Retorna true se o head for null, indicando que a lista está vazia
    }

    // Método para imprimir os usuários da lista
    public void print() {
        System.out.print("inicio -> "); // Imprime o início da lista

        Node aux = head; // Nó auxiliar para percorrer a lista, começando pelo head

        // Percorre a lista e imprime cada usuário
        while (aux != null) {
            System.out.print(aux.user.getName() + " (id: " + aux.user.getId() + ") -> "); // Imprime o nome e ID do usuário
            aux = aux.next; // Move para o próximo nó
        }
        System.out.print("null\n"); // Imprime null indicando o final da lista
    }

    // Método para contar o número de nós na lista
    public int size() {
        Node aux = head; // Nó auxiliar para percorrer a lista, começando pelo head
        int count = 0; // Contador de nós

        // Percorre a lista e incrementa o contador para cada nó
        while (aux != null) {
            count++; // Incrementa o contador
            aux = aux.next; // Move para o próximo nó
        }
        return count; // Retorna o número de nós na lista
    }
}