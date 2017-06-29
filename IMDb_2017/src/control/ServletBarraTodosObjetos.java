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
import dao.ListaTodosObjetosTipoDAO;
import model.AtoresFilme;
import model.DiretoresFilme;
import model.Filme;

@WebServlet("/barra-todos")
public class ServletBarraTodosObjetos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletBarraTodosObjetos() {
        super();
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String consultaTodos = request.getParameter("consultaTodos");
		
		Connection conexao = Conexao.getConexao();
		
	if (consultaTodos.equals("Todos os Filmes")) {
			
		ListaTodosObjetosTipoDAO rtod = new ListaTodosObjetosTipoDAO(conexao);
	
		ArrayList<Filme> todosFilmes = rtod.getListaTodosFilmes();
		
		request.setAttribute("filme", todosFilmes);
	
		RequestDispatcher rd = request.getRequestDispatcher("/lista-filmes.jsp");
		rd.forward(request, response);
		
	} else if (consultaTodos.equals("Todos os Diretores")) {
		
	   	ListaTodosObjetosTipoDAO rtod = new ListaTodosObjetosTipoDAO(conexao);

	   	ArrayList<DiretoresFilme> todosDiretores = rtod.getListaTodosDiretores();
		
	   	request.setAttribute("diretores", todosDiretores);

	   	RequestDispatcher rd = request.getRequestDispatcher("/lista-diretores.jsp");
	   	rd.forward(request, response);
	   			
	} else if (consultaTodos.equals("Todos os Atores")) {
				
	   	ListaTodosObjetosTipoDAO rtod = new ListaTodosObjetosTipoDAO(conexao);

	   	ArrayList<AtoresFilme> todosAtores = rtod.getListaTodosAtores();
		
	   	request.setAttribute("atores", todosAtores);

	   	RequestDispatcher rd = request.getRequestDispatcher("/lista-atores.jsp");
	   	rd.forward(request, response);
    }
  }
}