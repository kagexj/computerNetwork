/*
 * Обработка POST запроса и получение параметров
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String L = request.getParameter("left");
		String R = request.getParameter("right");
		
		if ( L != null && R != null)
		{
			try 
			{
				// Пробуем преобразовать его в целое число и сохраняем для JSP страницы как аттрибут  
				int lValue = Integer.valueOf(L);
				int rValue = Integer.valueOf(R);
				
				request.setAttribute("l", lValue);
				request.setAttribute("r", rValue);
				
				// Заводим массив простых чисел и заполняем его 
				ArrayList<Integer> primes = new ArrayList<>();
				for( int i = lValue ; i < rValue ; i++) {
					if (i % 11 == 0 && i % 13 == 0 && i % 17 == 0) {
						primes.add(i);
					}
				}
				System.out.println(primes);
				// Сохраняем его как аттрибут primes
				request.setAttribute("primes", primes);
				// Направляем на последующую обработку файлу primeOutput.jsp
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
			catch (InputMismatchException e)
			{
				// Если преобразовать не получилось, то ничего не делаем
			}
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Получаем параметр N
		doGet(request, response);
		// Направляем на страницу index.jsp
		
	}
}
