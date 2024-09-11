package hash;

public interface HashTable {
    /**
     * calcula o hash da chave inteira id, utilizando o metodo estipulado
     * @param id chave identificadora do objeto
     * @return o indice mapeado para a chave id
     */
    public int hash(int id);

    /**
     * metodo para averiguar se há espaços vazios na tabela (a tabela pode conter um atributo para contar a quantidade de elementos)
     * @return verdadeiro se não houver espaços vazios onde possam ser inseridos novos elementos, falso caso contrário
     */
    public boolean isFull();

    /**
     * adiciona o objeto passado por parametro na tabela hash
     * @param user objeto a ser adicionado na tabela
     * @throws Exception lança uma exceção caso a tabela esteja cheia e nao houver espaços disponiveis
     */
    public void add(User user) throws Exception;

    /**
     * remove o usuario com o id passado por parametro da tabela hash
     * @param id id do usuario a ser removido
     * @throws Exception lança uma exceção caso o usuario com o id passado por parametro não exista na tabela
     */
    public void remove(int id) throws Exception;

    /**
     * o metodo retorna o usuario com o id igual ao recebido como parametro de entrada
     * @param id id do usuario que se deseja recuperar
     * @return retorna o objeto usuario com o id igual ao recebido como parametro
     * @throws Exception lança uma exceção caso o usuario com o id recebido como parametro não exista na tabela
     */
    public User retrieve(int id) throws Exception;

    /**
     * esse metodo deve imprimir os indices da tabela hash
     * ex.
     * [0] - vazio
     * [1] - joão (id: 1) (para tabelas com endereçamento aberto)
     * [2] - inicio -> ana (id: 2) -> maria (id: 4) (para tabelas com endereçamento fechado)
     * [3] - raiz -> josé (id: 3), jonathas (id: 6) (percurso préordem para arvores)   
     */
    public void print();

    /**
     * função que dobra o tamanho da tabela hash e realoca todos os elementos existentes em seus novos indices
     */
    public void resize();

    /**
     * @return retorna a quantidade de elementos na tabela
     */
    public int size();
}
