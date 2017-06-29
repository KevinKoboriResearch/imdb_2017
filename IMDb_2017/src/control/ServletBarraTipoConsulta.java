package control;

//  = PROGRAMACAO OBRIGATORIA!

/*  = NECESSARIO CASO QUEIRA RETORNAR OS DADOS DE MANEIRA MAIS ORGANIZADA.*/

/** = DESNECESSARIO = IMPLEMENTACAO OPCIONAL, APENAS POR ORGANIZACAO.*/

//><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><| = PUXANDO VALORES DA PAGINA ANTERIOR.

//========================================================================| = FAZENDO A PARTE LÓGICA.

//////////////////////////////////////////////////////////////////////////| = ARMAZENANDO VALORES PARA PUXA-LOS NOVAMENTE NO JSP.

//-------------------------------------------------------------------------------------------------------------------------------------------/ = SEPARA OS MÉTODOS

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
import dao.ListaBarraTipoConsultaDAO;
import model.AtoresFilme;
import model.Filme;

@WebServlet("/barra-tipo-consulta")
public class ServletBarraTipoConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletBarraTipoConsulta() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/* ALOCANDO TODOS OS JSPS EM UM JSP SÓ DE "lista-objetos.jsp" usando o metodo Boolean
		boolean objetoFilmes = false;
		boolean objetoAtores = false;
		boolean objetoDiretores = false;
		boolean objetoGeneros = false;*/
		
		//><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><|
		String barraConsulta = request.getParameter("barraConsulta");
		
		String tipoConsulta = request.getParameter("tipoConsulta");
		
		String dados = request.getParameter("dados");
		
	if (barraConsulta.equals("Barra de Filmes")) {	
		
		//========================================================================|
		Connection conexao = Conexao.getConexao();
				
		ListaBarraTipoConsultaDAO lftcd = new ListaBarraTipoConsultaDAO(conexao);
				
		ArrayList<Filme> listaFilmesPorTipoConsulta = lftcd.getListaFilmesPorTipoConsulta(tipoConsulta, dados);
		
//>>>>	objetoFilmes = true;
				
		//////////////////////////////////////////////////////////////////////////|
//>>>>	request.setAttribute("objeto_filmes", objetoFilmes);
//>>>>	request.setAttribute("objeto_Diretores", objetoDiretores);
//>>>>	request.setAttribute("objeto_Atores", objetoAtores);
//>>>>	request.setAttribute("objeto_Generos", objetoGeneros);
		
		request.setAttribute("filme", listaFilmesPorTipoConsulta);
				
		RequestDispatcher rd = request.getRequestDispatcher("/lista-filmes.jsp");
		rd.forward(request, response);
		
/*	} else if (barraConsulta.equals("Barra de Diretores")) {
		
		//========================================================================|
		Connection conexao = Conexao.getConexao();
			
		ListaFilmesBarraTipoConsultaDAO lftcd = new ListaFilmesBarraTipoConsultaDAO(conexao);
		
		ArrayList<Filme> listaDiretoresPorTipoConsulta = lftcd.getListaDiretoresPorTipoConsulta(tipoConsulta, dados);
			
//>>>>	objetoDiretores = true;
		
		//////////////////////////////////////////////////////////////////////////|
//>>>>	request.setAttribute("objeto_filmes", objetoFilmes);
//>>>>	request.setAttribute("objeto_Diretores", objetoDiretores);
//>>>>	request.setAttribute("objeto_Atores", objetoAtores);
//>>>>	request.setAttribute("objeto_Generos", objetoGeneros);
		
		request.setAttribute("atores", listaDiretoresPorTipoConsulta);
			
		RequestDispatcher rd = request.getRequestDispatcher("/lista-diretores.jsp");
		rd.forward(request, response);	*/
		
	} else if (barraConsulta.equals("Barra de Atores")) {
			
		//========================================================================|
		Connection conexao = Conexao.getConexao();
			
		ListaBarraTipoConsultaDAO lftcd = new ListaBarraTipoConsultaDAO(conexao);
		
		ArrayList<AtoresFilme> listaAtoresPorTipoConsulta = lftcd.getListaAtoresPorTipoConsulta(tipoConsulta, dados);
			
//>>>>	objetoAtores = true;
		
		//////////////////////////////////////////////////////////////////////////|
//>>>>	request.setAttribute("objeto_filmes", objetoFilmes);
//>>>>	request.setAttribute("objeto_Diretores", objetoDiretores);
//>>>>	request.setAttribute("objeto_Atores", objetoAtores);
//>>>>	request.setAttribute("objeto_Generos", objetoGeneros);
		
		request.setAttribute("atores", listaAtoresPorTipoConsulta);
			
		RequestDispatcher rd = request.getRequestDispatcher("/lista-atores.jsp");
		rd.forward(request, response);
		
/*	} else if (barraConsulta.equals("Barra de Generos")) {
		
		//========================================================================|
		Connection conexao = Conexao.getConexao();
			
		ListaFilmesBarraTipoConsultaDAO lftcd = new ListaFilmesBarraTipoConsultaDAO(conexao);
		
		ArrayList<Filme> listaFilmesPorTituloConsulta = lftcd.getListaFilmesPorTipoConsulta(tipoConsulta, dados);
			
//>>>>	objetoGeneros = true;
				
		//////////////////////////////////////////////////////////////////////////|
//>>>>	request.setAttribute("objeto_filmes", objetoFilmes);
//>>>>	request.setAttribute("objeto_Diretores", objetoDiretores);
//>>>>	request.setAttribute("objeto_Atores", objetoAtores);
//>>>>	request.setAttribute("objeto_Generos", objetoGeneros);
			
		RequestDispatcher rd = request.getRequestDispatcher("/lista-generos.jsp");
		rd.forward(request, response);*/
		
	} else { 
		
		throw new IllegalArgumentException();
	
    	   }
    }   
}
