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

//		Algunos de los datos que podemos obtener de la cabecera de la peticion:

//		request.getHeader(String x): De vuelve el valor de la cabecera indicada, null si no hay una cabecera con ese nombre
//		request.getHeaders(String x): Algunas cabeceras (como Accept-Language) pueden tener una lista de valores
//		request.getHeaderNames(): Devuelve el nombre de todas las cabeceras presentes
//		request.getMethod(): Indica el método HTTP: GET, POST
//		request.getQueryString(): Devuelve la query string que hay en el URL, o null si no hay
//		request.getParameter(): Devuelve el parámetro especificado

//		Parametros de la peticion:		
//		String parameter = request.getParameter("parameterName");
//		Map<String, String[]> parameterMap = request.getParameterMap();

//		Atributos de la aplicacion:
//		request.setAttribute("attributeName", attribute);
//		Permite pasar cualquier objeto entre los diferentes servlets de nuestra aplicacion diferentes cuando redirigimos

//		Para modificar o añadir valores a la cabecera de la respuesta:

//		Sustituir headers:
//		response.setHeader()
//		response.setDateHeader()
//		response.setIntHeader()
//		
//		Añadir headers:
//		response.addHeader()
//		response.addDateHeader()
//		response.addIntHeader()
//		setContentType() se utiliza para especificar el tipo MIME
//		setContentLenght()
//		...

//		response.setStatus(int code): codigo de respuesta (normalmente se utilizan constantes, tales como SC_OK, SC_NOT_FOUND)
//		response.sendError(int code, String mensaje): codigo y mensaje de error
//		response.sendRedirect(String url): redireccion a otra pagina (sin codigo, porque el cod. asociado 302)		

//		Redirecciones:
// 		- indirecta (manda una respuesta), utiliza siempre GET:
//		response.sendRedirect("URL");
// 		- directa (reenvia la peticion), solo dentro de la aplicacion, GET o POST segun sea la peticion original, permite añadir parametros
//		request.setAttribute("otro", "parametro insertado desde MainController");
//		request.getRequestDispatcher("/servlet").forward(request, response);

		// response.getWriter().append("Served at: ").append(request.getContextPath());
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

	private PrintWriter printResponse(PrintWriter out, Map<String, String[]> parameterMap) {

		PrintWriter pw = out;
		List<Departamento> departamentos = consultar.listarDepartamentos();

		pw.println("<html>");
		pw.println("<title>Departamentos</title>");
		pw.println("<body>");
		pw.println("<h1>Departamentos</h1>");
		pw.println("<table border=\"1\">");
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

		return pw;
	}

}