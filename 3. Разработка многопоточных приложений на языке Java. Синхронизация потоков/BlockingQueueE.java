import java.util.concurrent.*;
 
public class BlockingQueueE
{
    public static void main(String[] args) {
        /*SynchronousQueue операция добавления одного потока находится в ожидании соответствующей операции удаления в другом потоке*/
    	BlockingQueue queue = new SynchronousQueue(); /*создаем очередь*/ 
    	Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start(); /*запускаем потоки производителя и потребителя*/
        new Thread(consumer).start();
    }
}

 /*класс Производитель*/
class Producer implements Runnable 
{
	private BlockingQueue queue;
	private int n = 11;
	
	public Producer(BlockingQueue queue) { /*присваивает значение параметру*/
		this.queue = queue;
	}
	
	public void run() {
		try {
			for (int i = 1; i < n; i++) 
				queue.put(i * i); /*Вставляет указанный элемент в очередь*/
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }
 /*Класс Потребитель*/
class Consumer implements Runnable
{
	private BlockingQueue queue;
	private int n = 11;
	
	public Consumer(BlockingQueue queue) { /*присваивает значение параметру*/
		this.queue = queue;
	}
	
	public void run() {
		try {
			for (int i = 1; i < n; i++) {
				System.out.println(queue.take()); /*Извлекает элементы из этой очереди*/
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
