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

import model.Filme;
import model.AtoresFilme;
import model.DiretoresFilme;

public class DetalhaObjetosFilmeDAO {
	private Connection conexao;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	
	public DetalhaObjetosFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/

	public Filme getFilme(String idFilme) {
		Filme f = new Filme();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, categoria, pontuacao FROM filme WHERE idfilme=?");
			ps.setString(1, idFilme);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				f.setIdFilme(rs.getInt("idfilme"));
				f.setTitulo(rs.getString("titulo"));
				f.setTituloIngles(rs.getString("titulo_ingles"));
				f.setAno(rs.getInt("ano"));
				f.setCategoria(rs.getString("categoria"));
				f.setPontuacao(rs.getDouble("pontuacao"));
			}
			
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/

	public ArrayList<AtoresFilme> getAtoresFilme(String idFilme){
		ArrayList<AtoresFilme> atoresFilme = new ArrayList<AtoresFilme>();
		PreparedStatement ps = null;
		ResultSet rs = null;		

			try {
				ps = conexao.prepareStatement("SELECT idator, idfilme, ator_nome, papel, descricao FROM atores_filme WHERE idfilme=?");				
				ps.setString(1, idFilme);
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					atoresFilme.add(new AtoresFilme(
					rs.getInt("idator"),
					rs.getInt("idfilme"),
					rs.getString("ator_nome"),
					rs.getString("papel"),
					rs.getString("descricao")));
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return atoresFilme;
		}

//-------------------------------------------------------------------------------------------------------------------------------------------/

	public ArrayList<DiretoresFilme> getDiretoresFilme(String idFilme){
		ArrayList<DiretoresFilme> diretoresFilme = new ArrayList<DiretoresFilme>();
		PreparedStatement ps = null;
		ResultSet rs = null;		

			try {
				ps = conexao.prepareStatement("SELECT iddiretor, idfilme, diretor_nome, descricao FROM diretores_filme WHERE idfilme=?");				
				ps.setString(1, idFilme);
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					diretoresFilme.add(new DiretoresFilme(
					rs.getInt("iddiretor"),
					rs.getInt("idfilme"),
					rs.getString("diretor_nome"),
					rs.getString("descricao")));
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return diretoresFilme;
		}
}
