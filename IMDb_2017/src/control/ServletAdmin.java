package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.ListaTodosObjetosTipoDAO;
import model.Filme;

@WebServlet("/admin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAdmin() {
        super();
    }
    
    //-------------------------------------------------------------------------------------------------------------------------------------------/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		ListaTodosObjetosTipoDAO rtod = new ListaTodosObjetosTipoDAO(conexao);
		
		ArrayList<Filme> todosFilmes = rtod.getListaTodosFilmes();
		
		request.setAttribute("filme", todosFilmes);
	
		RequestDispatcher rd = request.getRequestDispatcher("/lista-edita-filmes.jsp");
		rd.forward(request, response);
	}

}
