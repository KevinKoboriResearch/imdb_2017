package control;


import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.LoginDAO;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ServletLogin() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Connection conexao = Conexao.getConexao();
		
		LoginDAO ld = new LoginDAO(conexao);
		
		boolean resultadoLogin = ld.resultadoLogin(usuario, senha);
		
		if (resultadoLogin == true) {
			
			request.setAttribute("usuario", usuario);
			
			RequestDispatcher rd = request.getRequestDispatcher("/login-sucesso.jsp");
			rd.forward(request, response);
			
		} else if (resultadoLogin == false) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/login-falha.jsp");
			rd.forward(request, response);
		}
	}
}
