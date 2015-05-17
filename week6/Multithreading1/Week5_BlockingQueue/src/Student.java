public class Student extends Thread {
    private SharedQueue repository;
    public Student(SharedQueue repo) {
        this.repository = repo;
    }

    public void run() {
        int i = 0;
        while (true)
            try {
                String homework = getName() + "'s homework " + ++i + "";
                repository.addHomework(homework);
                System.out.println(getName() + " write homework " + i);
                sleep((long) (Math.random() * 4000));
            } catch (InterruptedException e) {
            }
    }
}
