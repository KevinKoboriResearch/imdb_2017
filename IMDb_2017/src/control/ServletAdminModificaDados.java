package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminModificaObjetosDAO;
import dao.Conexao;


@WebServlet("/admin-modifica-dados")
public class ServletAdminModificaDados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ServletAdminModificaDados() {
        super();
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String tipo = request.getParameter("tipo");
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/		
	if (tipo.equals("incluidiretor")) {
    	
			String idfilme = request.getParameter("idfilme");
			String diretor = request.getParameter("diretor");
			String descricao = request.getParameter("descricao");
		
			Connection conexao = Conexao.getConexao();
		
			AdminModificaObjetosDAO idd = new AdminModificaObjetosDAO(conexao);
		
			boolean resultado = idd.incluiDiretor(idfilme, diretor, descricao);
				
				if (resultado == true) {
					RequestDispatcher rd = request.getRequestDispatcher("/inclui-sucesso.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/inclui-falha.jsp");
					rd.forward(request, response);
				}
				
	//-------------------------------------------------------------------------------------------------------------------------------------------/				
	} else if (tipo.equals("incluiator")) {
			
			String idFilme = request.getParameter("idfilme");
			String diretor = request.getParameter("ator-nome");
			String papel = request.getParameter("papel");
			String descricao = request.getParameter("descricao");
			
			Connection conexao = Conexao.getConexao();
			
			AdminModificaObjetosDAO idd = new AdminModificaObjetosDAO(conexao);
			
			boolean resultado = idd.incluiAtor(idFilme, diretor, papel, descricao);
					
				if (resultado == true) {
					RequestDispatcher rd = request.getRequestDispatcher("/inclui-sucesso.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/inclui-falha.jsp");
					rd.forward(request, response);
				}

	//-------------------------------------------------------------------------------------------------------------------------------------------/		
    } else if (tipo.equals("incluifilme")) {
    	
			String titulo = request.getParameter("titulo");
			String tituloIngles = request.getParameter("tituloingles");
			String ano = request.getParameter("ano");
			String categoria = request.getParameter("categoria");
			String pontuacao = request.getParameter("pontuacao");

			Connection conexao = Conexao.getConexao();

			AdminModificaObjetosDAO ipd = new AdminModificaObjetosDAO(conexao);

			boolean resultado = ipd.incluiFilme(titulo, tituloIngles, ano, categoria, pontuacao);

				if (resultado == true) {
					RequestDispatcher rd = request.getRequestDispatcher("/inclui-sucesso.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/inclui-falha.jsp");
					rd.forward(request, response);
				}
    
	//-------------------------------------------------------------------------------------------------------------------------------------------/	
    } else if (tipo.equals("excluidiretor")) {

    		String idDiretor = request.getParameter("iddiretor");
    		
    		Connection conexao = Conexao.getConexao();
    		
    		AdminModificaObjetosDAO amdd = new AdminModificaObjetosDAO(conexao);
    		
    		boolean resultado = amdd.excluiDiretor(idDiretor);
    		
    			if (resultado) {
    				RequestDispatcher rd = request.getRequestDispatcher("/exclui-sucesso.jsp");
    				rd.forward(request, response);
    			} else {
    				RequestDispatcher rd = request.getRequestDispatcher("/exclui-falha.jsp");
    				rd.forward(request, response);
    			}
    			
    //-------------------------------------------------------------------------------------------------------------------------------------------/	
    } else if (tipo.equals("excluiator")) {
    	
    		String idAtor = request.getParameter("idator");
		
    		Connection conexao = Conexao.getConexao();
		
    		AdminModificaObjetosDAO amdd = new AdminModificaObjetosDAO(conexao);
		
    		boolean resultado = amdd.excluiAtor(idAtor);
		
				if (resultado) {
					RequestDispatcher rd = request.getRequestDispatcher("/exclui-sucesso.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/exclui-falha.jsp");
					rd.forward(request, response);
				}
    	
    //-------------------------------------------------------------------------------------------------------------------------------------------/	
    } else if (tipo.equals("excluifilme")) {
    	
    		String idFilme = request.getParameter("idfilme");
		
    		Connection conexao = Conexao.getConexao();
		
    		AdminModificaObjetosDAO amdd = new AdminModificaObjetosDAO(conexao);
		
    		boolean resultado = amdd.excluiFilme(idFilme);
		
				if (resultado) {
					RequestDispatcher rd = request.getRequestDispatcher("/exclui-sucesso.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/exclui-falha.jsp");
					rd.forward(request, response);
				}
    }
  }
}
