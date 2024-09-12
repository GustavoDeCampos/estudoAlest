package hash;

import java.util.ArrayList;

public class LinkedList {
    private Node head; // Referência para o primeiro nó da lista

    // Método para adicionar um usuário na lista
    public void add(User user) throws Exception {
        Node newNode = new Node(user); // Cria um novo nó com o usuário fornecido

        Node aux = head; // Nó auxiliar para percorrer a lista, começando pelo head, o inicio da lista
        Node aux2 = null; // Nó auxiliar que sempre percorre a lista uma posição atras de aux, guardando assim o elemento anterior
        //isso serve para que a lista ligada fique ordenada, pois supondo que o novo elemento cheque a posição 1 e ele seja maior
        //então o aux vai para a posição 2 e o aux2 fica na posição 1, entao se o novo elemento for maior que o aux2 e menor que o aux
        //o aux2 vai receber o novo elemento como seu proximo, e o novo elemento vai receber o aux como seu proximo, posicionando assim
        //o novo elemento na frente de um elemento menor e atras de um elemento maior, mantendo a lista ordenada

        // Percorre a lista até encontrar a posição correta para inserir o novo nó
        while ((aux != null) && (aux.user.getId() < newNode.user.getId())) {
            aux2 = aux; // Atualiza aux2 para o nó atual
            aux = aux.next; // Move para o próximo nó
            //o que está acontecendo aqui é: supondo que o primeiro elemento da lista seja menor que o novo elemento
            // o aux2 vai receber o primeiro elemento e o aux vai pular para o segundo elemento, esse loop vai continuar até que
            // o novo elemento seja menor que o aux, ou seja, o aux vai ser o elemento que o novo elemento vai ficar atras
        }

        // Se a lista estiver vazia, insere o novo nó como head
        if (head == null) {
            head = newNode;
            //se a lista estiver vazia, o novo elemento vai ser o head
        } else if (aux == head) { // Se o novo nó deve ser inserido antes do head atual
            newNode.next = head; // O próximo do novo nó será o head atual
            head = newNode; // Atualiza o head para o novo nó
            //supondo que o primeiro elemento da lista é 2 por exemplo e o novo elemento é 1, então o novo elemento
            //deve ser o novo primeiro elemento, então ele recebe o head atual como seu proximo e entao se torna o novo head
        } else { // Insere o novo nó entre aux2 e aux
            newNode.next = aux; // O próximo do novo nó será aux
            aux2.next = newNode; // O próximo de aux2 será o novo nó
            //caso o novo elemento não seja menor do que o head, o while vai pocisionar ele na posição correta
            // e o aux2 que é menor que ele vai receber ele como seu proximo e ele vai receber o aux como seu proximo
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
        aux = null; // Remove a referência para o nó a ser removido

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