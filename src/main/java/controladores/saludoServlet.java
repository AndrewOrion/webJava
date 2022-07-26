package controladores;

import java.io.IOException;
import java.io.PrintWriter;
//ctrl + shift + o
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class saludoServlet
 */
@WebServlet("/bienvenida")
public class saludoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public saludoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		utilidadesServlet.imprimirCabecera("saludo",out);//clase utilidades servlet
		
		String nombre = request.getParameter("nombre"); //recojo el nombre del formulario
		if (nombre ==null || nombre.isBlank() ) {
			out.println("<h1>Hola, desconocido </h1>");
		} else {
			out.println("<h1>Hola, "+ nombre + "</h1>");
		}
		utilidadesServlet.imprimirPie(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
