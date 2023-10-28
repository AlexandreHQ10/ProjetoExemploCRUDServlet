import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditarServlet")

public class EditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Editar Empregado</h1>"); 
        
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Empregado e = EmpregadoDao.getEmpregadoById(id);  
        
        out.print("<form action = 'EditarServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+ e.getId() + "'/></td></tr>");  
        out.print("<tr><td>Nome:</td><td><input type='text' name='nome' value = '" +e.getNome()+"'/></td></tr>");  
        out.print("<tr><td>Senha:</td><td><input type='password' name='senha' value=' "+e.getSenha()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>"); 
        out.print("<tr><td>País:</td><td>");  
        out.print("<select name='pais' style='width:150px'>");  
        out.print("<option>Brasil</option>");  
        out.print("<option>Argentina</option>");  
        out.print("<option>Bolívia</option>");  
        out.print("<option>Paraguai</option>");
        out.print("<option>Venezuela</option>");
        out.print("<option>Outros</option>");
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Salvar Edição'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>"); 
        
        out.close();
	}

}
