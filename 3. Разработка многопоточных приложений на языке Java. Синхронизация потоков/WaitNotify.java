public class WaitNotify {
  
    public static void main(String[] args) {
          
    	Threads queue = new Threads();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();/*запускаем потоки производителя и потребителя*/
        new Thread(consumer).start();
    }
}

class Threads{
   private int numb = 0; /*объявление переменных, начальные значения*/
   private int printed = 0;
   
   public synchronized int get() {

		while (numb < 1) {
	        try {
	           wait(); /*блокирует выполнение метода run, пока не будет вызван метод notify() */
	        }
	        catch (InterruptedException e) { 
	        } 
	     }
		
		 numb--; /*уменьшаем число*/
	     notify(); /*сигнал методу put() продолжить работу*/
		 return printed;
		
	  }

   public synchronized void put(int queue) {
       while (numb >= 1) {
         try {
            wait(); /*блокирует выполнение метода get, пока не будет вызван метод notify() */
         }
         catch (InterruptedException e) { 
         } 
      }
       numb++; /*увеличиваем число*/
       printed = queue; 
       notify(); /*сигнал методу get() продолжить работу*/
   }
   
}

/*класс Производитель*/
class Producer implements Runnable{
  
	private Threads queue;
    public Producer(Threads queue){ /*присваивает значение параметру*/
       this.queue = queue; 
    }
    public void run(){
    	for (int i = 1; i < 11; i++) {
			queue.put(i * i); /*Вставляет указанный элемент в очередь*/
		}
    	queue.put(-100);
    }
}

/*Класс Потребитель*/
class Consumer implements Runnable{
      
	private Threads queue;
    public Consumer(Threads queue){ /*присваивает значение параметру*/
       this.queue = queue; 
    }
    public void run(){
    		int qu;
    		while(true) {
				qu = queue.get(); /*Извлекает элементы из этой очереди*/
				if(qu == -100)
					break;
				System.out.println(qu);
    		}	
    }
}
