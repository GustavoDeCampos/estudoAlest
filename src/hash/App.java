package hash;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        HashTable table = new Table(5);
        Scanner keyboard = new Scanner(System.in);
        int option;

        do{
            System.out.println("1 - adicionar usuario");
            System.out.println("2 - recuperar usuario");
            System.out.println("3 - consultar quantidade");
            System.out.println("4 - imprimir a tabela");
            System.out.println("5 - remover usuario");
            System.out.println("0 - sair");
            System.out.print("opção: ");
            option = keyboard.nextInt();
            keyboard.nextLine(); // Consumir a nova linha
            System.out.println();

            switch (option) {
                case 1:
                    System.out.print("Digite o nome do usuario: ");
                    String name = keyboard.nextLine();
                    System.out.print("Digite o id do usuario: ");
                    int id = keyboard.nextInt();
                    keyboard.nextLine(); // Consumir a nova linha
                    System.out.println();
                    User user = new User(id, name);
                    try {
                        table.add(user);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Digite o id do usuario que deseja recuperar: ");
                    int idRetrieve = keyboard.nextInt();
                    keyboard.nextLine(); // Consumir a nova linha
                    try {
                        User userRetrieve = table.retrieve(idRetrieve);
                        System.out.println(userRetrieve);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Quantidade de elementos na tabela: " + table.size());
                    System.out.println();
                    break;
                case 4:
                    table.print();
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Digite o id do usuario que deseja remover: ");
                    int idRemove = keyboard.nextInt();
                    keyboard.nextLine(); // Consumir a nova linha
                    try {
                        User userRemove = table.retrieve(idRemove);
                        table.remove(idRemove);
                        System.out.println("Usuário removido: " + userRemove);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.out.println();
                    break;    
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (option != 0);

        keyboard.close();
    }
}
