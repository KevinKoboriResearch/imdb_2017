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
import dao.DetalhaObjetosFilmeDAO;
import model.AtoresFilme;
import model.DiretoresFilme;
import model.Filme;

@WebServlet("/detalha-filme-admin")
public class ServletDetalhaObjetosFilmeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDetalhaObjetosFilmeAdmin() {
        super();
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idFilme = request.getParameter("idfilme");
		
		Connection conexao = Conexao.getConexao();
		
		DetalhaObjetosFilmeDAO dfda = new DetalhaObjetosFilmeDAO(conexao);
		
		Filme filme = dfda.getFilme(idFilme);
		
		ArrayList<DiretoresFilme> diretoresFilme = dfda.getDiretoresFilme(idFilme);
		
		ArrayList<AtoresFilme> atoresFilme = dfda.getAtoresFilme(idFilme);
		
		request.setAttribute("filme", filme);
		
		request.setAttribute("diretoresFilme", diretoresFilme);
		
		request.setAttribute("atoresFilme", atoresFilme);
		
		RequestDispatcher rd = request.getRequestDispatcher("/edita-detalha-filme.jsp");
		rd.forward(request, response);
    }
}
