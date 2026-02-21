import java.util.concurrent.BlockingQueue;

public class Waiter implements Runnable {
    private int waiterNum;
    private final BlockingQueue<Order> orderBlockingQueue;
    private final   BlockingQueue<Order> readyBlockingQueue;

    public Waiter(int waiterNum, BlockingQueue<Order> orderBlockingQueue, BlockingQueue<Order> readyBlockingQueue) {
        this.waiterNum = waiterNum;
        this.orderBlockingQueue = orderBlockingQueue;
        this.readyBlockingQueue = readyBlockingQueue;
    }

    @Override
    public void run(){
        while(true){
            try{
                Order order = readyBlockingQueue.take();
                System.out.println(waiterNum + "Сервитьор обслужва поръчка " +  order);
                Thread.sleep(50*order.getNum());
            }catch (InterruptedException e){
                System.out.println();
            }
        }
    }

}
