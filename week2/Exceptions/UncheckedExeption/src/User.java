public class User {

    private String name;
    private int age;

    public User(String name, int age) throws DatabaseCorruptedException {
        this.name = name;
        this.age = age;
        if (name.equals("")) {
            throw new DatabaseCorruptedException();
        }
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }

}
