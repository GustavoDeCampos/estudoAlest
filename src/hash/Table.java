package hash;

import java.util.ArrayList;

public class Table implements HashTable {

    private LinkedList[] table;
    private int count;
    private static final double LOAD_FACTOR = 0.75;

    public Table(int size){
        this.table = new LinkedList[size];
        initialize(table, size);
    }

    public void initialize(LinkedList[] table, int size){
        for (int i = 0; i < size; i++){
            this.table[i] = new LinkedList();
        }
    }

    @Override
    public void add(User user) throws Exception {
        if (count >= table.length * LOAD_FACTOR){
            resize();
        }
        int hash = hash(user.getId());
        table[hash].add(user);
        count++;
    }

    @Override
    public void remove(int id) throws Exception {
        int hash = hash(id);
        if (table[hash].remove(id)) {
            count--;
        } else {
            throw new Exception("Usuario não encontrado");
        }
    }

    @Override
    public int hash(int id) {
        return id % table.length;
    }

    @Override
    public boolean isFull() {
        //não há necessidade de implementar, pois a tabela não possui limite de elementos, então nunca estará cheia
        return false;
    }

    @Override
    public void print() {
        for(int i = 0; i < table.length; i++){
            System.out.print("[" + i + "] - ");
            table[i].print();
        }
        
    }

    @Override
    public void resize() {
        int size = table.length;

        LinkedList[] aux = table;

        ArrayList<User> users = new ArrayList<User>();

        //salva todos os usuarios da tabela hash dentro do arraylist
        for(int i = 0; i < aux.length; i++){
            for(int j = 0; j < aux[i].retrievUsers().size(); j++){
                users.add(aux[i].retrievUsers().get(j));
            }
        }

        this.table = new LinkedList[size * 2];
        initialize(this.table, this.table.length);

        //pega todos os usuarios salvos no arrayList e distribuir na nova tabela hash
        for(int i = 0; i <users.size(); i++){
            try {
                add(users.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User retrieve(int id) throws Exception {
        int hash = hash(id);

        if(table[hash].retrieve(id) != null){
            return table[hash].retrieve(id);
        } else {
            throw new Exception("Usuario não encontrado");
        }
    }

    @Override
    public int size() {
        int count = 0;

        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].size(); j++){
                count++;
            }
        }

        return count;
    }
    
}
