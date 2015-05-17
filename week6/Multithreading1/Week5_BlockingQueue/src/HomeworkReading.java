public class HomeworkReading {

    public static void main(String[] args) throws InterruptedException {
        SharedQueue sq = new SharedQueue();
        Student s1 = new Student(sq);
        s1.setName("Pesho");
        s1.start();
       // s1.sleep(2000);
        Student s2 = new Student(sq);
        s2.setName("Gosho");
        s2.start();
       // s2.sleep(3000);
        Student s3 = new Student(sq);
        s3.setName("Boyko");
        s3.start();
       // s3.sleep(1000);

        Teacher t1 = new Teacher(sq);
        t1.setName("Borko");
        t1.start();
        //t1.sleep(1000);
        Teacher t2 = new Teacher(sq);
        t2.setName("Nasko");
        t2.start();
        //t2.sleep(1000);
        Teacher t3 = new Teacher(sq);
        t3.setName("Gasko");
        t3.start();
        //t3.sleep(500);
    }
}
