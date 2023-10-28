import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SalvarServlet")

public class SalvarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        
        String nome=request.getParameter("nome");  
        String senha=request.getParameter("senha");  
        String email=request.getParameter("email");  
        String pais=request.getParameter("pais");  
        
        Empregado e = new Empregado();  
        e.setNome(nome);  
        e.setSenha(senha);  
        e.setEmail(email);  
        e.setPais(pais);  
        
        int status=EmpregadoDao.save(e);  
        
        if(status>0){  
            out.print("<p>Registro salvo com sucesso!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Desculpe! Seu registro não pode ser salvo");  
        }  
          
        out.close();  
    }  
	}
