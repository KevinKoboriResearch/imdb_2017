package control;

//OBS: EU UTILIZO CADA UM DESSES TIPOS DE COMENTARIOS AQUI PARA DIFERENCIAR O QUE REALMENTE IMPORTA E O QUE EH APENAS COMPLEMENTO NOS MEUS PROGRAMAS JAVA!      

//= PROGRAMACAO OBRIGATORIA PARA FUNCIONAR A PROVA1!
/*  = NECESSARIO CASO QUEIRA RETORNAR OS DADOS DE MANEIRA MAIS ORGANIZADA. BOM LEMBRAR QUE OS QUE ESTIVEREM COMENTADOS DESSA MANEIRA, NECESSITAM ESTAR ATIVOS PARA QUE ESSE PROGRAMA RODE */
/** = DESNECESSARIO = IMPLEMENTACAO OPCIONAL, APENAS POR ORGANIZACAO */
//_________________________________________________________________________________________________________________________________________________________________*/

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

@WebServlet("/detalha-filme")
public class ServletDetalhaObjetosFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDetalhaObjetosFilme() {
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/detalha-filme.jsp");
		rd.forward(request, response);
    }
}

