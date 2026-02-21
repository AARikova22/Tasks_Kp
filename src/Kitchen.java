import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Kitchen implements Runnable {
    private final BlockingQueue<Order> orderBlockingQueue;
    private final BlockingQueue<Order> readyBlockingQueue;

    public Kitchen(BlockingQueue<Order> orderBlockingQueue, BlockingQueue<Order> readyBlockingQueue) {
        this.orderBlockingQueue = orderBlockingQueue;
        this.readyBlockingQueue = readyBlockingQueue;
    }

    @Override
    public void run() {
        while(true){
            try{
                Order order = orderBlockingQueue.poll(3, TimeUnit.SECONDS);
                System.out.println("Приготвя поръчка: " + order);
                Thread.sleep(100 * order.getNum());
                System.out.println("Кухня е завършила: " + order);
                readyBlockingQueue.put(order);}
            catch (InterruptedException e){
                System.out.println();
            }
        }}
}
