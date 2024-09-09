package Recursao;

public class Mensagem {
    public static void main(String[] args) {

        int n = 10;
        System.out.println("mensagens:");
        mensagem(n);
    }

    public static void mensagem(int n) {
        if(n>=1) {
            System.out.println("oi");
            mensagem(n-1);
        }
    }
}
