package comparação;

public class Resultado {
    private int[] vetor;
    private int trocas;

    public int[] getVetor() {
        return vetor;
    }

    public int getTrocas() {
        return trocas;
    }

    public Resultado(int[] vetor, int trocas){
        this.vetor = vetor;
        this.trocas = trocas;

    }
}
