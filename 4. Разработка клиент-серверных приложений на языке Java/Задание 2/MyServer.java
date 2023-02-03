import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
   public static final int PORT = 2020;

   public static void main(String[] args) {
      try {
         System.out.println("Готовимся начать прослушивать порт " + PORT);
         ServerSocket server = new ServerSocket(PORT);
         System.out.println("Сервер запущен, прослушиваем порт.");
         
         System.out.println("Подключаем трёх клиентов...");
         int counter = 0;
         for (int i = 0; i < 3; i++){
    	        counter++;
    	        Socket serverClient=server.accept();  // сервер принимает запрос на подключение клиента
    	        System.out.println(" >> " + "Клиент No:" + counter + " подключен!");
    		    int start = 100000000, end = 400000000;
    		    int step = 100000000;
    		    int s = start + i * step;
    		    int e = start + (i + 1) * step;
    		    System.out.println("Для Клиента-" + counter + " интервал начало: " + s + " конец: " + e);
    		    System.out.println("Отправляем Клиенту интервал...");
    		    System.out.println("Ждем результат...");
    		    DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
    		    DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
    		    outStream.writeInt(s);
    		    outStream.writeInt(e);
    		    ServerClientThread sct = new ServerClientThread(serverClient, counter, inStream, outStream); // отправляем запрос в отдельный поток
    	        sct.start();
    		    }
    		    
          
//		принять один интервал 1-2 посчитать числа в клиенте, отправить решение 2 потоку;
//      принять 2 интерв 2-3 посчит числа в клиенте, отправить решение 3 потоку;
//      принять 3 интерв 3-4 посчит числа в клиенте, отправить решение 1 потоку;
//		напечатать output решение 1 потока
         
        
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

}
class ServerClientThread extends Thread {
	  Socket serverClient;
	  int clientNo;
	  DataInputStream inStream;
	  DataOutputStream outStream;

	  ServerClientThread(Socket inSocket, int counter, DataInputStream inStream, DataOutputStream outStream){
	    serverClient = inSocket;
	    clientNo = counter;
	    this.inStream = inStream;
	    this.outStream = outStream;
	    
	    
	  }
	  public void run(){
	    try{
	      //DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
	      //DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
	      
	      for (int i = 0; i < clientNo; i++) {
	    		
	        	 int count = inStream.readInt();
	        	 System.out.println("От Клиента-" + clientNo + " колличество чисел: "+ count);
	        	 for (int j = 0; j < count; j++) {
	        		 int p = inStream.readInt();
	        		 System.out.println(p);
	        	 }
	      }

	      System.out.println();
	      inStream.close();
	      outStream.close();
	      serverClient.close();
	    }catch(Exception ex){
	      System.out.println(ex);
	    }finally{
	      System.out.println("Client -" + clientNo + " exit!! ");
	    }
	  }
	}
