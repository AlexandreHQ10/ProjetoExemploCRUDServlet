import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VisualizarServlet")

public class VisualizarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<a href='index.html'>Adicionar Novo Empregado</a>");  
	        out.println("<h1>Listar todos os Empregados</h1>");  
	          
	        List<Empregado> list=EmpregadoDao.getAllEmployees();  
	          
	        out.print("<table border='1' width='100%'");  
	        out.print("<tr><th>Id</th><th>Nome</th><th>Senha</th><th>Email</th><th>País</th><th>Editar</th><th>Excluir</th></tr>");  
	        for(Empregado e:list){out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNome()+"</td><td>"+e.getSenha()+"</td> <td>"+e.getEmail()+"</td><td>"+e.getPais()+"</td><td><a href='EditarServlet?id="+e.getId()+"'>Editar</a></td>  <td><a href='ExcluirServlet?id="+e.getId()+"'>Excluir</a></td></tr>");  
	        }  
	        out.print("</table>");  
	          
	        out.close();  
	}

}
