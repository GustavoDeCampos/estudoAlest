package hash;

public class User {
    private int Id;
    private String name;
    
    public User(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [Id=" + Id + ", name=" + name + "]";
    }
}
