import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.HashMap;

public class MyServerClass {
   public static final int PORT = 2020;

   public static void main(String[] args) {
      try {
         System.out.println("Готовимся начать прослушивать порт " + PORT);
         ServerSocket server = new ServerSocket(PORT);
         System.out.println("Сервер запущен, прослушиваем порт.");
         
         HashMap<String, String> ap = new HashMap<String, String>();
         
         while(true) {
	         Socket socket = server.accept();
	         System.out.println("Соединение установлено");
	         Scanner input = new Scanner(socket.getInputStream());
	         PrintWriter output = new PrintWriter(socket.getOutputStream());
	         
	         System.out.println("Введите put или get");
	         String p = input.next();
	         System.out.println("Получено = " + p);
         
	         if(p.equals("put")) {
	             System.out.println("Введите ключ и значение");
	             String key = input.next();
	             String val = input.next();
	             System.out.println("Прочитан ключ = " + key +" значение = " + val);
	             ap.put(key, val);
	             output.flush();
	         }
	         
	         if(p.equals("get")) {
	             System.out.println("Введите ключ");
	             String key = input.next();
	             System.out.println("Прочитан ключ = " + key);
	             String res = ap.get(key);
	             System.out.println("Значение = " + ap.get(key));
	             output.println(res);
	             output.flush();
	         }

	         System.out.println("Закрываем сокет и прекращаем слушать порт");
	         socket.close();
         }
         /*server.close(); telnet 127.0.0.1 2020*/
      } catch (IOException e) {
         e.printStackTrace();
        }
   }

}
