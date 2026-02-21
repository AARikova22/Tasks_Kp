import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Simulation{
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Order> order = new LinkedBlockingQueue<>();
        BlockingQueue<Order> ready = new LinkedBlockingQueue<>();

        Order order1 = new Order("Pizza", 2);
        Order order2 = new Order("Burger", 3);
        order.add(order1);
        order.add(order2);
        Kitchen kitchen = new Kitchen(order, ready);

        Waiter waiter = new Waiter(1, order, ready);
        Waiter waiter1 = new Waiter(2, order, ready);
        Thread kitchenThread = new Thread(kitchen);
        Thread waiterThread1 = new Thread(waiter);

        Thread waiterThread2 = new Thread(waiter1);

        waiterThread1.start();
        kitchenThread.start();


    }
}