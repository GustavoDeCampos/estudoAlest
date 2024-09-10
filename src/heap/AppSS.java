package heap; // Declara o pacote onde a classe AppSS está localizada

import java.util.ArrayList; // Importa a classe ArrayList da biblioteca Java

public class AppSS { // Declara a classe pública AppSS

    private ArrayList<Integer> heap; // Declara uma variável de instância do tipo ArrayList para armazenar o heap

    public AppSS(){ // Construtor da classe AppSS
        heap = new ArrayList<>(); // Inicializa a variável heap como uma nova instância de ArrayList
    }

    public void inserir(int valor){ // Método para inserir um valor no heap
        heap.add(valor); // Adiciona o valor ao final do heap
        swim(heap.size() - 1); // Chama o método swim para ajustar o heap após a inserção
        // O método swim é chamado aqui para garantir que a propriedade do heap seja mantida.
        // heap.size() - 1 é passado como argumento porque o novo valor foi adicionado no final do heap,
        // então precisamos ajustar a posição desse novo valor.
        System.out.println("Inserido " + valor + ": " + heap); // Imprime o valor inserido e o estado atual do heap
    }

    public int removerMax(){ // Método para remover o valor máximo do heap
        if (heap.isEmpty()) { // Verifica se o heap está vazio
            throw new IllegalStateException("Heap vazio"); // Lança uma exceção se o heap estiver vazio
        }

        int maximo = heap.get(0); // Armazena o valor máximo (raiz do heap) em uma variável
        // O maior valor em um max-heap está sempre na raiz, que é a posição 0 do ArrayList.

        int ultimo = heap.remove(heap.size() - 1); // Remove o último elemento do heap e o armazena em uma variável
        // Remove o último elemento do heap (posição heap.size() - 1) para substituir a raiz.
        // Isso é feito para manter a estrutura do heap após a remoção do maior valor.

        if (!heap.isEmpty()) { // Verifica se o heap não está vazio após a remoção
            heap.set(0, ultimo); // Substitui a raiz do heap pelo último elemento
            // Coloca o último elemento na posição da raiz (índice 0) para manter a estrutura do heap.
            sink(heap, 0, heap.size()); // Chama o método sink para ajustar o heap após a remoção
            // O método sink é chamado para ajustar o heap a partir da raiz (índice 0) até o tamanho atual do heap.
            // 1. O método sink é chamado com três argumentos: o heap, o índice inicial (0) e o tamanho atual do heap.
            // 2. O índice inicial (0) indica que o ajuste deve começar a partir da raiz do heap.
            // 3. O método sink ajusta o heap para garantir que a propriedade do max-heap seja mantida.
            // 4. Ele compara o valor na raiz com seus filhos e troca de posição se necessário.
            // 5. O processo continua recursivamente até que o heap esteja ajustado corretamente.
        }

        return maximo; // Retorna o valor máximo removido
    }

    public ArrayList<Integer> heapSort(){ // Método para ordenar o heap
        ArrayList<Integer> copiaHeap = new ArrayList<>(heap); // Cria uma cópia do heap original
        int tamanhoHeap = copiaHeap.size(); // Armazena o tamanho do heap

        // Constrói o heap (max-heap)
        for (int i = tamanhoHeap / 2 - 1; i >= 0; i--){ // Percorre os nós não-folha do heap de baixo para cima
            sink(copiaHeap, i, tamanhoHeap); // Chama o método sink para ajustar o heap
        }

        // Ordena o vetor
        for(int i = tamanhoHeap - 1; i > 0; i--){ // Percorre o heap de trás para frente
            // Troca o maior elemento (na raiz) com o último elemento não ordenado
            troca(copiaHeap, 0, i); // Chama o método troca para trocar os elementos

            // Ajusta o heap com o tamanho reduzido
            sink(copiaHeap, 0, i); // Chama o método sink para ajustar o heap
        }

        return copiaHeap; // Retorna o heap ordenado
    }

    private void sink(ArrayList<Integer> heap, int pai, int tamanho) { // Método para ajustar o heap após a remoção de um elemento
        // Calcula o índice do filho esquerdo do nó pai
        int esquerda = (2 * pai) + 1;
        // Calcula o índice do filho direito do nó pai
        int direita = (2 * pai) + 2;
    
        // Verifica se o filho esquerdo está dentro dos limites do heap
        if (esquerda < tamanho) {
            // Assume inicialmente que o filho esquerdo é o maior
            int maiorFilho = esquerda;
    
            // Verifica se o filho direito está dentro dos limites do heap e se é maior que o filho esquerdo
            if (direita < tamanho && heap.get(direita) > heap.get(esquerda)) {
                // Atualiza o maior filho para o filho direito, pois ele é maior que o filho esquerdo
                maiorFilho = direita;
            }
    
            // Verifica se o valor do nó pai é menor que o valor do maior filho
            if (heap.get(pai) < heap.get(maiorFilho)) {
                // Troca os valores do nó pai e do maior filho para manter a propriedade do max-heap
                troca(heap, pai, maiorFilho);
                // Chama recursivamente o método sink para ajustar o heap a partir da nova posição do maior filho
                sink(heap, maiorFilho, tamanho);
            }
        }
    }

    /*
    Exemplo de Heap Inicial
    Vamos considerar um heap inicial representado pelo array [25, 15, 20, 17, 8, 10]. Suponha que removemos o elemento 25 (a raiz) e substituímos pelo último elemento 10. O array após a remoção seria [10, 15, 20, 17, 8].

    Teste de Mesa
    Vamos acompanhar passo a passo o método sink ajustando a posição do novo elemento 10.

    Passo 1: Inicialização
    Heap: [10, 15, 20, 17, 8]
    Índice do Pai: 0 (novo elemento 10)
    Tamanho: 5
    Passo 2: Primeira Iteração
    Cálculo dos Filhos:
    esquerda = (2 * 0) + 1 = 1
    direita = (2 * 0) + 2 = 2
    Comparação dos Filhos:
    heap.get(2) > heap.get(1) (20 > 15) é verdadeiro.
    Maior Filho: 2
    Comparação com o Pai:
    heap.get(0) < heap.get(2) (10 < 20) é verdadeiro.
    Troca: Troca 10 com 20.
    Heap Após Troca: [20, 15, 10, 17, 8]
    Atualização do Pai: pai = 2
    Passo 3: Segunda Iteração
    Cálculo dos Filhos:
    esquerda = (2 * 2) + 1 = 5
    direita = (2 * 2) + 2 = 6
    Verificação dos Limites:
    esquerda < tamanho (5 < 5) é falso.
    Fim do Método: O heap está ajustado.
    Resultado Final
    Heap Final: [20, 15, 10, 17, 8]
     */

    private void swim(int filho) { // Método para ajustar o heap após a inserção de um novo elemento
        // O método `swim` é usado para ajustar a posição de um novo elemento no heap para cima (subir) até que a propriedade do max-heap seja restaurada.
        // Ele é chamado após a inserção de um novo elemento no heap.
        // O objetivo é garantir que cada nó pai seja maior ou igual aos seus filhos, mantendo a estrutura do max-heap.
        // Parâmetros:
        // - filho: o índice do novo elemento que foi inserido no heap.
    
        // Verifica se o índice do filho é maior que 0, ou seja, se o filho não é a raiz do heap.
        if (filho > 0) {
            // Calcula o índice do nó pai do elemento atual (filho).
            // O índice do pai é calculado usando a fórmula (filho - 1) / 2.
            int pai = (filho - 1) / 2;
    
            // Compara o valor do elemento no índice do filho com o valor do elemento no índice do pai.
            // Se o valor do filho for maior que o valor do pai, a propriedade do max-heap está violada.
            if (heap.get(filho) > heap.get(pai)) {
                // Troca os valores do filho e do pai para restaurar a propriedade do max-heap.
                troca(heap, filho, pai);
    
                // Chama recursivamente o método swim para continuar ajustando a posição do novo elemento para cima no heap.
                swim(pai);
            }
        }
    }

    /*
    Exemplo de Heap Inicial
    Vamos considerar um heap inicial representado pelo array [20, 15, 10, 17, 8]. 
    Suponha que inserimos um novo elemento com valor 25 no heap. O array após a inserção seria [20, 15, 10, 17, 8, 25].

    Teste de Mesa
    Vamos acompanhar passo a passo o método swim ajustando a posição do novo elemento 25.

    Passo 1: Inicialização
    Heap: [20, 15, 10, 17, 8, 25]
    Índice do Filho: 5 (novo elemento 25)
    Passo 2: Primeira Iteração
    Verificação: filho > 0 (5 > 0) é verdadeiro.
    Cálculo do Pai: pai = (5 - 1) / 2 = 2
    Comparação: heap.get(5) > heap.get(2) (25 > 10) é verdadeiro.
    Troca: Troca 25 com 10.
    Heap Após Troca: [20, 15, 25, 17, 8, 10]
    Atualização do Filho: filho = 2
    Passo 3: Segunda Iteração
    Verificação: filho > 0 (2 > 0) é verdadeiro.
    Cálculo do Pai: pai = (2 - 1) / 2 = 0
    Comparação: heap.get(2) > heap.get(0) (25 > 20) é verdadeiro.
    Troca: Troca 25 com 20.
    Heap Após Troca: [25, 15, 20, 17, 8, 10]
    Atualização do Filho: filho = 0
    Passo 4: Terminação
    Verificação: filho > 0 (0 > 0) é falso.
    Fim do Método: O heap está ajustado.
    Resultado Final
    Heap Final: [25, 15, 20, 17, 8, 10]
     */

    private void troca(ArrayList<Integer> heap, int a, int b){ // Método para trocar dois elementos no heap
        // O método `troca` é usado para trocar os valores de dois elementos no heap.
        // Parâmetros:
        // - heap: o ArrayList que representa o heap.
        // - a: o índice do primeiro elemento a ser trocado.
        // - b: o índice do segundo elemento a ser trocado.
        
        int auxiliar = heap.get(a); // Armazena o valor do elemento a em uma variável auxiliar
        // Passo 1: Armazena o valor do elemento no índice `a` em uma variável auxiliar.
        // Isso é feito para não perder o valor original do elemento `a` durante a troca.
    
        heap.set(a, heap.get(b)); // Substitui o elemento a pelo elemento b
        // Passo 2: Substitui o valor do elemento no índice `a` pelo valor do elemento no índice `b`.
        // Agora, o índice `a` contém o valor que estava originalmente no índice `b`.
    
        heap.set(b, auxiliar); // Substitui o elemento b pelo valor armazenado na variável auxiliar
        // Passo 3: Substitui o valor do elemento no índice `b` pelo valor armazenado na variável auxiliar.
        // Agora, o índice `b` contém o valor que estava originalmente no índice `a`.
    
        // Resultado: Os valores dos elementos nos índices `a` e `b` foram trocados.
    }

    public void mostrarHeap(){ // Método para imprimir o estado atual do heap
        System.out.println(heap); // Imprime o heap
    }

    public static void main(String[] args) { // Método principal, ponto de entrada do programa
        AppSS meuHeap = new AppSS(); // Cria uma nova instância da classe AppSS

        // Insere elementos aleatorios de 0 a 100 no heap até atingir 20 elementos
        for(int i = 0; i < 10; i++){
            meuHeap.inserir((int) Math.floor(Math.random() * 100));
        }

        System.out.println("\nHeap resultante:"); // Imprime uma mensagem indicando que o heap resultante será mostrado
        meuHeap.mostrarHeap(); // Chama o método mostrarHeap para imprimir o estado atual do heap

        ArrayList<Integer> heapOrdenado = meuHeap.heapSort(); // Chama o método heapSort para ordenar o heap e armazena o resultado em heapOrdenado
        System.out.println("\nHeap ordenado:"); // Imprime uma mensagem indicando que o heap ordenado será mostrado
        System.out.println(heapOrdenado); // Imprime o heap ordenado

        System.out.println("\nValor máximo removido: " + meuHeap.removerMax()); // Remove o valor máximo do heap e imprime o valor removido

        System.out.println("\nHeap após a remoção do valor máximo:"); // Imprime uma mensagem indicando que o heap após a remoção do valor máximo será mostrado
        meuHeap.mostrarHeap(); // Chama o método mostrarHeap para imprimir o estado atual do heap

        ArrayList<Integer> heapOrdenadoSemMax = meuHeap.heapSort(); // Chama o método heapSort novamente para ordenar o heap sem o valor máximo
        System.out.println("\nHeap ordenado sem o valor máximo:"); // Imprime uma mensagem indicando que o heap ordenado sem o valor máximo será mostrado
        System.out.println(heapOrdenadoSemMax); // Imprime o heap ordenado sem o valor máximo

        System.out.println("\nValor máximo removido: " + meuHeap.removerMax()); // Remove o valor máximo do heap e imprime o valor removido

        System.out.println("\nHeap após a remoção do valor máximo:"); // Imprime uma mensagem indicando que o heap após a remoção do valor máximo será mostrado
        meuHeap.mostrarHeap(); // Chama o método mostrarHeap para imprimir o estado atual do heap

        ArrayList<Integer> heapOrdenadoSemMax1 = meuHeap.heapSort(); // Chama o método heapSort novamente para ordenar o heap sem o valor máximo
        System.out.println("\nHeap ordenado sem o valor máximo:"); // Imprime uma mensagem indicando que o heap ordenado sem o valor máximo será mostrado
        System.out.println(heapOrdenadoSemMax1); // Imprime o heap ordenado sem o valor máximo
    }
}