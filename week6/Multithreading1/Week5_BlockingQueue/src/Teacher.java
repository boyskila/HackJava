public class Teacher extends Thread {
    private SharedQueue repository;
    public Teacher(SharedQueue homework) {
        this.repository = homework;
    }

    public void run() {
        while (true) {
            try {
                String homework = this.repository.readHomework();
                System.out.println(getName() + " check " + homework);
                sleep((long) (Math.random() * 5000));
            } catch (InterruptedException e) {
            }
        }
    }
}
