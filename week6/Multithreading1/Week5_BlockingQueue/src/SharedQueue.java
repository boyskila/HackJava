import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue {
    private final int QueSize = 10;
    private Queue<String> homeworksRepository = new LinkedList<>();

    public synchronized void addHomework(String homework) throws InterruptedException {
        while (homeworksRepository.size() == QueSize) {

            wait();
        }
        this.homeworksRepository.add(homework);
        notifyAll();
    }

    public synchronized String readHomework() throws InterruptedException {
        String homework = "";
        while (homeworksRepository.size() == 0) {

            wait();
        }
        homework = homeworksRepository.poll();
        notifyAll();
        return homework;
    }

    public Queue<String> getHomeworksRepository() {
        return homeworksRepository;
    }
}
