package hash;

import java.util.ArrayList;

public class LinkedList {
    private Node head;

    public void add (User user)throws Exception{
        Node newNode = new Node(user);

        Node aux = head;
        Node aux2 = null;

        while ((aux != null) && (aux.user.getId() < newNode.user.getId())){
            aux2 = aux;
            aux = aux.next;
        }

        if (head == null){
            head = newNode;
        }else if (aux == head){
            newNode.next = head;
            head = newNode;
        }else {
            newNode.next = aux;
            aux2.next = newNode;
        }
    }

    public boolean remove(int id) {
        Node aux = head;
        Node aux2 = null;

        while (aux != null && aux.user.getId() != id) {
            aux2 = aux;
            aux = aux.next;
        }

        if (aux == null) {
            return false; // Usuário não encontrado
        }

        if (aux == head) {
            head = head.next;
        } else {
            aux2.next = aux.next;
        }

        return true; // Usuário removido com sucesso
    }

    public User retrieve(int id) {
        Node aux = head;

        while (aux != null){
            if(aux.user.getId() == id){
                return aux.user;
            } else {
                aux = aux.next;
            }
        }
        return null;
    }

    public ArrayList<User> retrievUsers(){
        ArrayList<User> users = new ArrayList<User>();

        Node aux = head;

        while (aux != null){
            users.add(aux.user);
            aux = aux.next;
        }
        return users;
    }

    public boolean isEmpty(){
        if (head == null){
            return true;
        } else {
            return false;
        }
    }

    public void print(){
        System.out.print("inicio -> ");

        Node aux = head;

        while (aux != null) {
            System.out.print(aux.user.getName() + " (id: " + aux.user.getId() + ") -> ");
            aux = aux.next;
        }
        System.out.print("null\n");
    }

    public int size(){
        Node aux = head;
        int count = 0;

        while (aux != null){
            count++;
            aux = aux.next;
        }
        return count;
    }
}
