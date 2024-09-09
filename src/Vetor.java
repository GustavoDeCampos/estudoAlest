import java.util.Scanner;

public class Vetor {
    public static void main(String[] args) {


        Scanner homelander = new Scanner(System.in);
        String[] v = new String[10];

        v[0] = "Rs";
        v[1] = "Sc";
        v[2] = "Sp";
        v[3] = "Rj";
        v[4] = "Mg";
        v[5] = "Ba";
        v[6] = "Am";
        v[7] = "Mt";
        v[8] = "Pr";
        v[9] = "Ce";

        for (int i = 0; i < v.length; i++){
            System.out.println("Estado " + i + ": " +  v[i]);
        }

        System.out.println("Qual estado você esta procurando? escreva apenas sua sigla: ");
        String siglaBusca = homelander.nextLine();

        System.out.println(siglaBusca);

        boolean encontrou = false;
        for (int i = 0; i < v.length; i++){
            String elemento = v[i];
            if (elemento.equalsIgnoreCase(siglaBusca)){
                encontrou = true;
                break;
            }
        }
        if (encontrou == true){
            System.out.println("encontrou");
        }else {
            System.out.println("não encontrou");
        }
        }
}