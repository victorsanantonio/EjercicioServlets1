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

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import controlador.Borrar;
import controlador.Consultar;
import modelo.Departamento;

/**
 * Servlet implementation class EclipseServlet
 * 
 * Este servlet se ha generado a partir de la plantilla predefinida de Eclipse
 * IDE
 * 
 * El servlet esta mapeado con anotaciones
 */
@WebServlet("/MostrarDepartamentos")
public class MostrarDepartamentos extends HttpServlet {
	private static Logger logger = LogManager.getLogger(MostrarDepartamentos.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	Consultar consultar;

	public MostrarDepartamentos() {
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
		logger.info("Método GET ejecutado");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		logger.info("Método POST ejecutado");
	}

	public PrintWriter printResponse(PrintWriter out, Map<String, String[]> parameterMap) {

		PrintWriter pw = out;
		List<Departamento> departamentos = consultar.listarDepartamentos();

		pw.println("<html>");
		pw.println("<title>Departamentos</title>");
		pw.println("<body>");
		pw.println("<h1>Departamentos</h1>");
		pw.println("<table border=\"1\">");
		pw.println("<tr>");
		pw.println("<th>Código</th>");
		pw.println("<th>Nombre</th>");
		pw.println("<th>Código de responsable</th>");
		pw.println("</tr>");
		for (int i = 0; i < departamentos.size(); i++) {
			pw.println("<tr>");
			pw.println("<td>");
			pw.print(departamentos.get(i).getCodigo());
			pw.println("</td>");
			pw.println("<td>");
			pw.print(departamentos.get(i).getNombre());
			pw.println("</td>");
			pw.println("<td>");
			pw.print(departamentos.get(i).getCodResponsable());
			pw.println("</td>");
			pw.println("</tr>");
		}
		pw.println("</table");
		pw.println("</body>");
		pw.println("</html>");
		logger.info("Tabla de departamentos generada");
		return pw;
	}
}