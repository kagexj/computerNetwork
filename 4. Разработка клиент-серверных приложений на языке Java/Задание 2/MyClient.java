import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;
import java.util.Scanner;

public class MyClient {
   public static final String HOST = "127.0.0.1";
   public static final int PORT = 2020;
   
   static ArrayList<Integer> answer = new ArrayList<>();
	
	static void calc(int start, int end) {
		int x = 11 * 13 * 17 * 19;
		for (int j = start; j < end; j++) {
			if (j % x == 0) answer.add(j);
		}
	}

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      try {
         System.out.println("Устанавливаем соединение с "+ HOST +" по порту " + PORT);
         Socket socket = new Socket(HOST, PORT);
         System.out.println("Соединение установлено");
         DataInputStream input = new DataInputStream(socket.getInputStream());
         DataOutputStream output = new DataOutputStream(socket.getOutputStream());
          
         
         System.out.println("Читаем интервал с сервера");
         int s = input.readInt();
         int e = input.readInt();
         System.out.println("Прочитано начало: " + s + " Конец: " + e);
         //output.flush();
         
         calc(s, e);
         int count = answer.size();
         System.out.println("Записываем в поток серверу p");
         output.writeInt(count);
         
         for (Integer i : answer) output.writeInt(i);

         
         System.out.println("Закрываем сокет");
         socket.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
      in.close();
   }
}
