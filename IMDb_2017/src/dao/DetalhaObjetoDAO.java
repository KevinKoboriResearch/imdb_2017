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

public class DetalhaObjetoDAO {
	private Connection conexao;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/

	public DetalhaObjetoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	
	public Filme getObjetoFilme(String consultaFilme) {
		Filme filme = new Filme();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, categoria, pontuacao FROM filme WHERE titulo = ?");
			ps.setString(1, consultaFilme);
			
			rs = ps.executeQuery();
			
				filme.setIdFilme(rs.getInt("idfilme"));
				filme.setTitulo(rs.getString("titulo"));
				filme.setTituloIngles(rs.getString("titulo_ingles"));
				filme.setAno(rs.getInt("ano"));
				filme.setCategoria(rs.getString("categoria"));
				filme.setPontuacao(rs.getDouble("pontuacao"));
			
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return filme;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	
		public ArrayList<DiretoresFilme> getBarraDiretor(String consultaFilme) {
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
		
		public ArrayList<AtoresFilme> getBarraAtor(String consultaFilme) {
			ArrayList<AtoresFilme> atores = new ArrayList<AtoresFilme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT idator, idfilme, ator_nome, papel, descricao FROM atoresfilme ORDER BY idator");
				
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
