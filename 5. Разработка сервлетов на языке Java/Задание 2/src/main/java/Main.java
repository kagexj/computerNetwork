/*
 * Пример получения списка задач с сервера
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String L = request.getParameter("left");
		String R = request.getParameter("right");
		String S = request.getParameter("step");
		
		if ( L != null && R != null && S != null)
		{
			try(Socket socket= new Socket("127.0.0.1", 1243);
				Scanner socketIn = new Scanner(socket.getInputStream());
				PrintWriter out = new PrintWriter(socket.getOutputStream());) {
				out.println("Add task " + L + " " + R + " " + S );
				out.flush();
				ArrayList<String> tasks = new ArrayList<>();
				while(socketIn.hasNext()) {
					String s = socketIn.nextLine();
					tasks.add(s);
				}
				request.setAttribute("tasks", tasks);
				
				
			}
			catch(IOException e) {
			}
			
			try(Socket socket= new Socket("127.0.0.1", 1243);
					Scanner socketIn = new Scanner(socket.getInputStream());
					PrintWriter out = new PrintWriter(socket.getOutputStream());) {
					out.println("Get tasks");
					out.flush();
					ArrayList<String> tasks = new ArrayList<>();
					while(socketIn.hasNext()) {
						String s = socketIn.nextLine();
						tasks.add(s);
					}
					request.setAttribute("tasks", tasks);	
				}
				catch(IOException e) {
				}
			
		
			
	        }
	        
		getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}