package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class contactoServlet
 */
@WebServlet("/datosContacto")
public class contactoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public contactoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		utilidadesServlet.imprimirCabecera("Datos de Contacto",out);//clase utilidades servlet
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String provincia = request.getParameter("provincia");
		String[] conocimientos = request.getParameterValues("conocimientos"); //convierto a entero con parseInt
		String fecha_nac = request.getParameter("fecha_nac");
		Integer experiencia = Integer.parseInt(request.getParameter("experiencia")); //convierto a entero con parseInt

				
		out.println("<h2>Datos introducidos: </h2>");
		out.println("<ul>");
		out.println("<li> Nombre: " + nombre + "</li>");
		out.println("<li> Apellidos: " + apellidos + "</li>");
		out.println("<li> Provincia: " + provincia + "</li>");
		out.println("<li>Conocimientos:</li>");
		out.println("<ul>");
		if (conocimientos == null || conocimientos.length==0) {
			out.print("No se han registrado conocimientos</li>");
		} else {
			for (String dato : conocimientos) {
				out.println("<li>" + dato + "</li>");
			}
		}
		out.println("</ul>");
		out.println("<li> Fecha de nacimiento: " + fecha_nac + "</li>");
		out.println("<li> Experiencia: " + experiencia + "</li>");
		out.println("</ul>");
		
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
