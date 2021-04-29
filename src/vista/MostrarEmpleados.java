package vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Consultar;
import modelo.Empleado;

/**
 * Servlet implementation class EclipseServlet
 * 
 * Este servlet se ha generado a partir de la plantilla predefinida de Eclipse
 * IDE
 * 
 * El servlet esta mapeado con anotaciones
 */
@WebServlet("/MostrarEmpleados")
public class MostrarEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	Consultar consultar;

	public MostrarEmpleados() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		consultar = new Consultar();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Map<String, String[]> parameterMap = request.getParameterMap();
		printResponse(out, parameterMap);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public PrintWriter printResponse(PrintWriter out, Map<String, String[]> parameterMap) {

		PrintWriter pw = out;
		List<Empleado> empleados = consultar.listarEmpleados();

		pw.println("<html>");
		pw.println("<title>Empleados</title>");
		pw.println("<body>");
		pw.println("<h1>Empleados</h1>");
		pw.println("<table border=\"1\">");
		pw.println("<tr>");
		pw.println("<th>Código</th>");
		pw.println("<th>Nombre</th>");
		pw.println("<th>Primer apellido</th>");
		pw.println("<th>Segundo apellido</th>");
		pw.println("<th>Lugar de nacimiento</th>");
		pw.println("<th>Fecha de nacimiento</th>");
		pw.println("<th>Dirección</th>");
		pw.println("<th>Teléfono</th>");
		pw.println("<th>Puesto</th>");
		pw.println("<th>Código de departamento</th>");
		pw.println("</tr>");
		for (int i = 0; i < empleados.size(); i++) {
			pw.println("<tr>");
			pw.println("<td>");
			pw.print(empleados.get(i).getCodigo());
			pw.println("</td>");
			pw.println("<td>");
			pw.print(empleados.get(i).getNombre());
			pw.println("</td>");
			pw.println("<td>");
			pw.print(empleados.get(i).getApellido1());
			pw.println("</td>");
			pw.println("<td>");
			pw.print(empleados.get(i).getApellido2());
			pw.println("</td>");
			pw.println("<td>");
			pw.print(empleados.get(i).getLugarNacimiento());
			pw.println("</td>");
			pw.println("<td>");
			pw.print(empleados.get(i).getFechaNacimiento());
			pw.println("</td>");
			pw.println("<td>");
			pw.print(empleados.get(i).getDireccion());
			pw.println("</td>");
			pw.println("<td>");
			pw.print(empleados.get(i).getTelefono());
			pw.println("</td>");
			pw.println("<td>");
			pw.print(empleados.get(i).getPuesto());
			pw.println("</td>");
			pw.println("<td>");
			pw.print(empleados.get(i).getCodDepartamento());
			pw.println("</td>");
			pw.println("</tr>");
		}
		pw.println("</table");
		pw.println("</body>");
		pw.println("</html>");

		return pw;
	}
}