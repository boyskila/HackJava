public class BoundedQueueTest {

    public static void main(String[] args) {
        BoundedQueue<Integer> boundedQueue = new BoundedQueue<Integer>(4);

        boundedQueue.offer(1);
        boundedQueue.offer(2);
        boundedQueue.offer(3);
        boundedQueue.offer(4);
        boundedQueue.offer(5);

        System.out.print(boundedQueue.toString());

    }

}
