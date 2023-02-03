public class Solution {
	public static void main(String[] args) {
		
		
		int thr = 17; /*количество потоков*/
		int start = 100000000; /*обозначаем интервал*/
		int end = 400000000;
		int step = (end - start + thr - 1) / thr; /*вычисляем шаг*/
		
        long startTime1 = System.nanoTime();
        int total = 0;
        for (int i = start; i < end; i++) { 
        	if (i % 11 == 0 && i % 13 == 0 && i % 17 == 0 && i % 19 == 0) 
        		total++;
        	}
        long endTime1 = System.nanoTime();
        double time1 = endTime1 - startTime1; //*вычисляем время одного потока*//
        double stime1 = time1 / 1000000000;
      
        
        long startTime = System.nanoTime(); /*вызываем метод замера времени работы программы*/
		/*создаем потоки*/
		System.out.println("Creating threads");
		Threads array[] = new Threads[thr]; /*объявляем массив*/
		for (int i = 0; i < thr - 1; i++) {
			array[i] = new Threads(start + i * step, start + (i + 1) * step);
		}
		
		array[thr - 1] = new Threads(start + (thr - 1) * step, end);

		
		System.out.println("Starting threads");
		for (int i = 0; i < thr; i++) {
			array[i].start(); /*Заставляет этот поток начать выполнение*/ 
		}
		
        for (int i = 0; i < thr; i++) {
            try {
            	array[i].join(); /*все потоки завершаются*/
                System.out.println("Joined with thread " + i);
            } catch (InterruptedException e) { 
            	e.printStackTrace();
            	}
        }
        
        System.out.println("Summing worker totals");
        int cnt = 0;
        for (int i = 0; i < thr; i++) { /*подсчитывает колличество найденных чисел*/
        	cnt += array[i].getCount();
        }

		long endTime = System.nanoTime();
        double time = endTime - startTime; //*вычисляем время потоков*//
        
		double stime = time / 1000000000; /*перевод в секунды*/
		double diffTime = stime1 - stime; /*вычисление разницы*/
        
        System.out.println("Threads: " + thr);
		System.out.println("Answer: " + cnt);

        System.out.println("Work time in one thread: " + stime1 + " s");
        System.out.println("Work time in threads: " + stime + " s");
        System.out.println("Time difference: " + diffTime + " s");
}


	private static class Threads extends Thread {
		private int start, end;
		private int cnt = 0;
	
	    public Threads (int start, int end) { /*присваивает значение параметрам*/
	        this.start = start;
	        this.end = end;
	        System.out.println("Начало: " + start +  " Конец: " + end);
	    }
	    
	    public void run() {
	    	
			for (int i = start; i < end; i++) { /*поиск всех чисел, удовл. условию*/
				if (i % 11 == 0 && i % 13 == 0 && i % 17 == 0 && i % 19 == 0) {
					cnt++;
				}
			}
		}

	    public long getCount() { 
	    	return cnt; 
	    }
	}
}
