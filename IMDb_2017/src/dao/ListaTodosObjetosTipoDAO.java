package dao;

//OBS: EU UTILIZO CADA UM DESSES TIPOS DE COMENTARIOS AQUI PARA DIFERENCIAR O QUE REALMENTE IMPORTA E O QUE EH APENAS COMPLEMENTO NOS MEUS PROGRAMAS JAVA!      

//= PROGRAMACAO OBRIGATORIA PARA FUNCIONAR A PROVA1!
/*  = NECESSARIO CASO QUEIRA RETORNAR OS DADOS DE MANEIRA MAIS ORGANIZADA. BOM LEMBRAR QUE OS QUE ESTIVEREM COMENTADOS DESSA MANEIRA, NECESSITAM ESTAR ATIVOS PARA QUE ESSE PROGRAMA RODE */
/** = DESNECESSARIO = IMPLEMENTACAO OPCIONAL, APENAS POR ORGANIZACAO */
//_________________________________________________________________________________________________________________________________________________________________*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.AtoresFilme;
import model.DiretoresFilme;
import model.Filme;

public class ListaTodosObjetosTipoDAO {
	private Connection conexao;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/

	public ListaTodosObjetosTipoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	
	public ArrayList<Filme> getListaTodosFilmes() {
		ArrayList<Filme> filme = new ArrayList<Filme>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, categoria, pontuacao FROM filme ORDER BY titulo");
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Filme f = new Filme();
				f.setIdFilme(rs.getInt("idfilme"));
				f.setTitulo(rs.getString("titulo"));
				f.setTituloIngles(rs.getString("titulo_ingles"));
				f.setAno(rs.getInt("ano"));
				f.setCategoria(rs.getString("categoria"));
				f.setPontuacao(rs.getDouble("pontuacao"));
				
				filme.add(f);
			}

			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filme;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	
	public ArrayList<DiretoresFilme> getListaTodosDiretores() {
		ArrayList<DiretoresFilme> diretores = new ArrayList<DiretoresFilme>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement("SELECT iddiretor, idfilme, diretor_nome, descricao FROM diretoresfilme ORDER BY iddiretor");
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				DiretoresFilme df = new DiretoresFilme();
				df.setIdDiretor(rs.getInt("iddiretor"));
				df.setIdFilme(rs.getInt("idfilme"));
				df.setDiretorNome(rs.getString("diretor_nome"));
				df.setDescricao(rs.getString("descricao"));
				
				diretores.add(df);
			}

			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return diretores;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	
	public ArrayList<AtoresFilme> getListaTodosAtores() {
		ArrayList<AtoresFilme> atores = new ArrayList<AtoresFilme>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement("SELECT idator, idfilme, ator, papel, descricao FROM atoresfilme ORDER BY idator");
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				AtoresFilme af = new AtoresFilme();
				af.setIdAtor(rs.getInt("idator"));
				af.setIdFilme(rs.getInt("idfilme"));
				af.setAtorNome(rs.getString("ator_nome"));
				af.setPapel(rs.getString("papel"));
				af.setDescricao(rs.getString("descricao"));
				
				atores.add(af);
			}

			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return atores;
	}
}
