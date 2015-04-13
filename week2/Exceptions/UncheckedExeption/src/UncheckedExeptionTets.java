public class UncheckedExeptionTets {

    public static void main(String[] args) throws DatabaseCorruptedException {
        try {
            User user1 = new User("Boyko", 31);
            User user2 = new User("Gosho", 29);
            User user3 = new User("", 29);
            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
        } catch (Exception e) {
            throw new DatabaseCorruptedException(new DatabaseCorruptedException(
                    "Its discouraged to create User without name!Please enter a "
                            + "meaningful name.For example Boyko,Gosho,Pesho"));
        }

    }
}
