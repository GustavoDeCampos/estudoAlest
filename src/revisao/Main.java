package revisao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        ArrayList<Character>lista = new ArrayList<>();
        Queue<Character>fila = new LinkedList<Character>();

        fila.add('A');
        fila.add('a');
        fila.add('B');
        fila.add('b');
        fila.add('C');
        fila.add('c');
        fila.add('D');
        fila.add('d');
        fila.add('E');
        fila.add('e');

        for (Character letra:fila) {
            if (letra.equals('A') ||
                letra.equals('a') ||
                letra.equals('E') ||
                letra.equals('e') ||
                letra.equals('I') ||
                letra.equals('i') ||
                letra.equals('O') ||
                letra.equals('o') ||
                letra.equals('U') ||
                letra.equals('u')){
                lista.add(letra);
            }
        }
        System.out.println(lista);
    }
}
