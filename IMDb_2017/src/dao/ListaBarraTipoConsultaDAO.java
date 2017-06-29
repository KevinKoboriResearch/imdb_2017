package dao;

//= PROGRAMACAO OBRIGATORIA!

/*  = NECESSARIO CASO QUEIRA RETORNAR OS DADOS DE MANEIRA MAIS ORGANIZADA.*/

/** = DESNECESSARIO = IMPLEMENTACAO OPCIONAL, APENAS POR ORGANIZACAO.*/

//-------------------------------------------------------------------------------------------------------------------------------------------/ = SEPARA OS MÉTODOS

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.AtoresFilme;
import model.Filme;

public class ListaBarraTipoConsultaDAO {
	private Connection conexao;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/

	public ListaBarraTipoConsultaDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	
	public ArrayList<Filme> getListaFilmesPorTipoConsulta(String tipoConsulta, String dados) {
		if (dados == null || dados.trim().equals("") && tipoConsulta.trim().equals("FILMES") || dados == null || dados.trim().equals("") && !tipoConsulta.trim().equals("Todos os Filmes")) {
			ArrayList<Filme> filme = new ArrayList<Filme>();
			Filme f = new Filme();
			f.setIdFilme(0);
			filme.add(f);
			return filme;
			
		} else if (dados != null && tipoConsulta.trim().equals("FILMES")) {			
			ArrayList<Filme> filme = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT filme.idfilme, filme.titulo, filme.titulo_ingles, filme.ano, filme.pontuacao " +
											 "FROM filme WHERE filme.titulo LIKE ? OR filme.titulo_ingles LIKE ? OR filme.ano LIKE ? OR filme.pontuacao LIKE ? ORDER BY filme.titulo;");
				ps.setString(1, "%" + dados +  "%");
				ps.setString(2, "%" + dados +  "%");
				ps.setString(3, "%" + dados +  "%");
				ps.setString(4, "%" + dados +  "%");

				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					filme.add(f);
				}

				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return filme;	
			
		} else if (tipoConsulta.equals("Todos os Filmes")) {
			ArrayList<Filme> filme = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme ORDER BY titulo");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					filme.add(f);
				}

				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return filme;
			
		} else if (tipoConsulta.equals("Titulo em Portugues")) {
			ArrayList<Filme> listaFilmesPorTitulo = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme WHERE titulo LIKE ?");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					listaFilmesPorTitulo.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorTitulo;
			
		} else if (tipoConsulta.equals("Titulo em Ingles")) {
			ArrayList<Filme> listaFilmesPorTitulo = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme WHERE titulo_ingles LIKE ?");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					listaFilmesPorTitulo.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorTitulo;
			
		} else if (tipoConsulta.equals("Ano")) {
			ArrayList<Filme> listaFilmesPorAno = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme WHERE ano LIKE ?");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					listaFilmesPorAno.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorAno;
			
		} else if (tipoConsulta.equals("Pontuacao")) {
			ArrayList<Filme> listaFilmesPorPontuacao = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme WHERE pontuacao LIKE ?");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					listaFilmesPorPontuacao.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorPontuacao;
			
		} else if (tipoConsulta.equals("Diretores")) {
			ArrayList<Filme> listaFilmesPorDiretores = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT filme.idfilme, filme.titulo, filme.titulo_ingles, filme.ano, filme.pontuacao" +
											//", diretores_filme.iddiretor, diretores_filme.idfilme, diretores_filme.diretor_nome, diretores_filme.descricao " + //ESTA FUNCIONANDO
											  " FROM filme, diretores_filme WHERE filme.idfilme = diretores_filme.idfilme AND diretores_filme.diretor_nome LIKE ? ORDER BY filme.idfilme");
				ps.setString(1, "%" + dados +  "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("filme.idfilme"));
					f.setTitulo(rs.getString("filme.titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("filme.ano"));
					f.setPontuacao(rs.getDouble("filme.pontuacao"));
					
					listaFilmesPorDiretores.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorDiretores;
			
		} else if (tipoConsulta.equals("Atores")) {
			ArrayList<Filme> listaFilmesPorAtores = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT filme.idfilme, filme.titulo, filme.titulo_ingles, filme.ano, filme.pontuacao" +
											//", diretores_filme.iddiretor, diretores_filme.idfilme, diretores_filme.diretor_nome, diretores_filme.descricao " + //ESTA FUNCIONANDO
											  " FROM filme, atores_filme WHERE filme.idfilme = atores_filme.idfilme AND atores_filme.ator_nome LIKE ? ORDER BY filme.idfilme");
				ps.setString(1, "%" + dados +  "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("filme.idfilme"));
					f.setTitulo(rs.getString("filme.titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("filme.ano"));
					f.setPontuacao(rs.getDouble("filme.pontuacao"));
					
					listaFilmesPorAtores.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorAtores;
			
/*		} else if (tipoConsulta.equals("Genero")) {
					ArrayList<Filme> listaFilmesPorCategoria = new ArrayList<Filme>();
					PreparedStatement ps = null;
					ResultSet rs = null;

					try {
						ps = conexao.prepareStatement("SELECT filme.idfilme, filme.titulo, filme.titulo_ingles, filme.ano, filme.pontuacao" +
													//", atores_filme.idator, atores_filme.idfilme, atores_filme.ator_nome, atores_filme.papel, atores_filme.descricao " + //ESTA FUNCIONANDO
								  					  "FROM filme, atores_filme WHERE filme.idfilme = atores_filme.idfilme AND atores_filme.ator_nome LIKE ? ORDER BY filme.idfilme;");
						ps.setString(1, "%" + dados +  "%");
						rs = ps.executeQuery();
						
						while (rs.next()) {
							Filme f = new Filme();
							f.setIdFilme(rs.getInt("idfilme"));
							f.setTitulo(rs.getString("titulo"));
							f.setTituloIngles(rs.getString("titulo_ingles"));
							f.setAno(rs.getInt("ano"));
							f.setPontuacao(rs.getDouble("pontuacao"));
							
							listaFilmesPorCategoria.add(f);
						}
						
						rs.close();
						ps.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					}

					return listaFilmesPorCategoria;
			*/
		} else { throw new IllegalArgumentException();
		
			   }
		}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	//-------------------------------------------------------------------------------------------------------------------------------------------/
		
/*	public ArrayList<DiretoresFilme> getListaDiretoresPorTipoConsulta(String tipoConsulta, String dados) {
		if (dados == null || dados.trim().equals("") && tipoConsulta.trim().equals("ATORES") || dados == null || dados.trim().equals("") && !tipoConsulta.trim().equals("Todos os Atores")) {
//			ArrayList<Filme> filme = new ArrayList<Filme>();
//			Filme f = new Filme();
//			f.setIdFilme(0);
//			filme.add(f);
//			return filme;
			
/*		} else if (dados != null && tipoConsulta.trim().equals("FILMES")) {			
			ArrayList<Filme> filme = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT filme.idfilme, filme.titulo, filme.titulo_ingles, filme.ano, filme.pontuacao " +
											 "FROM filme WHERE filme.titulo LIKE ? OR filme.titulo_ingles LIKE ? OR filme.ano LIKE ? OR filme.pontuacao LIKE ? ORDER BY filme.titulo;");
				ps.setString(1, "%" + dados +  "%");
				ps.setString(2, "%" + dados +  "%");
				ps.setString(3, "%" + dados +  "%");
				ps.setString(4, "%" + dados +  "%");

				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					filme.add(f);
				}

				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return filme;	
			
		} else if (tipoConsulta.equals("Todos os Filmes")) {
			ArrayList<Filme> filme = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme ORDER BY titulo");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					filme.add(f);
				}

				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return filme;
			
		} else if (tipoConsulta.equals("Titulo em Portugues")) {
			ArrayList<Filme> listaFilmesPorTitulo = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme WHERE titulo LIKE ?");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					listaFilmesPorTitulo.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorTitulo;
			
		} else if (tipoConsulta.equals("Titulo em Ingles")) {
			ArrayList<Filme> listaFilmesPorTitulo = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme WHERE titulo_ingles LIKE ?");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					listaFilmesPorTitulo.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorTitulo;
			
		} else if (tipoConsulta.equals("Ano")) {
			ArrayList<Filme> listaFilmesPorAno = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme WHERE ano LIKE ?");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					listaFilmesPorAno.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorAno;
			
		} else if (tipoConsulta.equals("Pontuacao")) {
			ArrayList<Filme> listaFilmesPorPontuacao = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme WHERE pontuacao LIKE ?");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					listaFilmesPorPontuacao.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorPontuacao;
			
		} else if (tipoConsulta.equals("Diretores")) {
			ArrayList<Filme> listaFilmesPorDiretores = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT filme.idfilme, filme.titulo, filme.titulo_ingles, filme.ano, filme.pontuacao" +
											//", diretores_filme.iddiretor, diretores_filme.idfilme, diretores_filme.diretor_nome, diretores_filme.descricao " + //ESTA FUNCIONANDO
											  " FROM filme, diretores_filme WHERE filme.idfilme = diretores_filme.idfilme AND diretores_filme.diretor_nome LIKE ? ORDER BY filme.idfilme");
				ps.setString(1, "%" + dados +  "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("filme.idfilme"));
					f.setTitulo(rs.getString("filme.titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("filme.ano"));
					f.setPontuacao(rs.getDouble("filme.pontuacao"));
					
					listaFilmesPorDiretores.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorDiretores;
			
		} else if (tipoConsulta.equals("Atores")) {
			ArrayList<Filme> listaFilmesPorAtores = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT filme.idfilme, filme.titulo, filme.titulo_ingles, filme.ano, filme.pontuacao" +
											//", diretores_filme.iddiretor, diretores_filme.idfilme, diretores_filme.diretor_nome, diretores_filme.descricao " + //ESTA FUNCIONANDO
											  " FROM filme, atores_filme WHERE filme.idfilme = atores_filme.idfilme AND atores_filme.ator_nome LIKE ? ORDER BY filme.idfilme");
				ps.setString(1, "%" + dados +  "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("filme.idfilme"));
					f.setTitulo(rs.getString("filme.titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("filme.ano"));
					f.setPontuacao(rs.getDouble("filme.pontuacao"));
					
					listaFilmesPorAtores.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorAtores;
			
		} else if (tipoConsulta.equals("Genero")) {
					ArrayList<Filme> listaFilmesPorCategoria = new ArrayList<Filme>();
					PreparedStatement ps = null;
					ResultSet rs = null;

					try {
						ps = conexao.prepareStatement("SELECT filme.idfilme, filme.titulo, filme.titulo_ingles, filme.ano, filme.pontuacao" +
													//", atores_filme.idator, atores_filme.idfilme, atores_filme.ator_nome, atores_filme.papel, atores_filme.descricao " + //ESTA FUNCIONANDO
								  					  "FROM filme, atores_filme WHERE filme.idfilme = atores_filme.idfilme AND atores_filme.ator_nome LIKE ? ORDER BY filme.idfilme;");
						ps.setString(1, "%" + dados +  "%");
						rs = ps.executeQuery();
						
						while (rs.next()) {
							Filme f = new Filme();
							f.setIdFilme(rs.getInt("idfilme"));
							f.setTitulo(rs.getString("titulo"));
							f.setTituloIngles(rs.getString("titulo_ingles"));
							f.setAno(rs.getInt("ano"));
							f.setPontuacao(rs.getDouble("pontuacao"));
							
							listaFilmesPorCategoria.add(f);
						}
						
						rs.close();
						ps.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					}

					return listaFilmesPorCategoria;
			
		} else { throw new IllegalArgumentException();
			   }
		}*/
		
		//-------------------------------------------------------------------------------------------------------------------------------------------/
		//-------------------------------------------------------------------------------------------------------------------------------------------/
		//-------------------------------------------------------------------------------------------------------------------------------------------/ 
		
	public ArrayList<AtoresFilme> getListaAtoresPorTipoConsulta(String tipoConsulta, String dados) {
		if (dados == null || dados.trim().equals("") && tipoConsulta.trim().equals("ATORES") || dados == null || dados.trim().equals("") && !tipoConsulta.trim().equals("Todos os Atores")) {
			ArrayList<AtoresFilme> ator = new ArrayList<AtoresFilme>();
			AtoresFilme a = new AtoresFilme();
			a.setIdAtor(0);
			ator.add(a);
			return ator;
			
		} else if (dados != null && tipoConsulta.trim().equals("ATORES")) {			
			ArrayList<AtoresFilme> atores = new ArrayList<AtoresFilme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT atores_filme.idfilme, atores_filme.idator, atores_filme.ator_nome, atores_filme.papel, atores_filme.descricao " +
											  "FROM atores_filme WHERE atores_filme.ator_nome LIKE ? OR atores_filme.papel LIKE ? ORDER BY atores_filme.ator_nome");
				ps.setString(1, "%" + dados +  "%");
				ps.setString(2, "%" + dados +  "%");
				ps.setString(3, "%" + dados +  "%");
				ps.setString(4, "%" + dados +  "%");

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
			
		} else if (tipoConsulta.equals("Todos os Atores")) {
			ArrayList<AtoresFilme> todosAtores = new ArrayList<AtoresFilme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT idator, idfilme, ator_nome, papel, descricao FROM atores_filme ORDER BY ator_nome");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					AtoresFilme af = new AtoresFilme();
					af.setIdAtor(rs.getInt("idator"));
					af.setIdFilme(rs.getInt("idfilme"));
					af.setAtorNome(rs.getString("ator_nome"));
					af.setPapel(rs.getString("papel"));
					af.setDescricao(rs.getString("descricao"));
					
					todosAtores.add(af);
				}

				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return todosAtores;
			
		} else if (tipoConsulta.equals("Ator Nome")) {
			ArrayList<AtoresFilme> atoresPorNome = new ArrayList<AtoresFilme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idator, idfilme, ator_nome, papel, descricao FROM atores_filme WHERE ator_nome LIKE ? ORDER BY ator_nome");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					AtoresFilme af = new AtoresFilme();
					af.setIdAtor(rs.getInt("idator"));
					af.setIdFilme(rs.getInt("idfilme"));
					af.setAtorNome(rs.getString("ator_nome"));
					af.setPapel(rs.getString("papel"));
					af.setDescricao(rs.getString("descricao"));
					
					atoresPorNome.add(af);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return atoresPorNome;
			
		} else if (tipoConsulta.equals("Ator Papel")) {
			ArrayList<AtoresFilme> atoresPorPapel = new ArrayList<AtoresFilme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idator, idfilme, ator_nome, papel, descricao FROM atores_filme WHERE papel LIKE ? ORDER BY ator_nome");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					AtoresFilme af = new AtoresFilme();
					af.setIdAtor(rs.getInt("idator"));
					af.setIdFilme(rs.getInt("idfilme"));
					af.setAtorNome(rs.getString("ator_nome"));
					af.setPapel(rs.getString("papel"));
					af.setDescricao(rs.getString("descricao"));
					
					atoresPorPapel.add(af);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return atoresPorPapel;
			
		} else if (tipoConsulta.equals("Ator Descrição")) {
			ArrayList<AtoresFilme> atoresPorDescricao = new ArrayList<AtoresFilme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idator, idfilme, ator_nome, papel, descricao FROM atores_filme WHERE descricao LIKE ? ORDER BY ator_nome");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					AtoresFilme af = new AtoresFilme();
					af.setIdAtor(rs.getInt("idator"));
					af.setIdFilme(rs.getInt("idfilme"));
					af.setAtorNome(rs.getString("ator_nome"));
					af.setPapel(rs.getString("papel"));
					af.setDescricao(rs.getString("descricao"));
					
					atoresPorDescricao.add(af);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return atoresPorDescricao;
			
		} else { throw new IllegalArgumentException();
		
			   }
		}		
	
		//-------------------------------------------------------------------------------------------------------------------------------------------/
		//-------------------------------------------------------------------------------------------------------------------------------------------/
		//-------------------------------------------------------------------------------------------------------------------------------------------/
		
/*	public ArrayList<DiretoresFilme> getListaDiretoresPorTipoConsulta(String tipoConsulta, String dados) {
		if (dados == null || dados.trim().equals("") && tipoConsulta.trim().equals("ATORES") || dados == null || dados.trim().equals("") && !tipoConsulta.trim().equals("Todos os Atores")) {
/*			ArrayList<Filme> filme = new ArrayList<Filme>();
			Filme f = new Filme();
			f.setIdFilme(0);
			filme.add(f);
			return filme;*/
			
/*		} else if (dados != null && tipoConsulta.trim().equals("FILMES")) {			
			ArrayList<Filme> filme = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT filme.idfilme, filme.titulo, filme.titulo_ingles, filme.ano, filme.pontuacao " +
											 "FROM filme WHERE filme.titulo LIKE ? OR filme.titulo_ingles LIKE ? OR filme.ano LIKE ? OR filme.pontuacao LIKE ? ORDER BY filme.titulo;");
				ps.setString(1, "%" + dados +  "%");
				ps.setString(2, "%" + dados +  "%");
				ps.setString(3, "%" + dados +  "%");
				ps.setString(4, "%" + dados +  "%");

				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					filme.add(f);
				}

				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return filme;	
			
		} else if (tipoConsulta.equals("Todos os Filmes")) {
			ArrayList<Filme> filme = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme ORDER BY titulo");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					filme.add(f);
				}

				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return filme;
			
		} else if (tipoConsulta.equals("Titulo em Portugues")) {
			ArrayList<Filme> listaFilmesPorTitulo = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme WHERE titulo LIKE ?");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					listaFilmesPorTitulo.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorTitulo;
			
		} else if (tipoConsulta.equals("Titulo em Ingles")) {
			ArrayList<Filme> listaFilmesPorTitulo = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme WHERE titulo_ingles LIKE ?");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					listaFilmesPorTitulo.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorTitulo;
			
		} else if (tipoConsulta.equals("Ano")) {
			ArrayList<Filme> listaFilmesPorAno = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme WHERE ano LIKE ?");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					listaFilmesPorAno.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorAno;
			
		} else if (tipoConsulta.equals("Pontuacao")) {
			ArrayList<Filme> listaFilmesPorPontuacao = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme WHERE pontuacao LIKE ?");
				ps.setString(1, "%" + dados + "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					listaFilmesPorPontuacao.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorPontuacao;
			
		} else if (tipoConsulta.equals("Diretores")) {
			ArrayList<Filme> listaFilmesPorDiretores = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = conexao.prepareStatement("SELECT filme.idfilme, filme.titulo, filme.titulo_ingles, filme.ano, filme.pontuacao" +
											//", diretores_filme.iddiretor, diretores_filme.idfilme, diretores_filme.diretor_nome, diretores_filme.descricao " + //ESTA FUNCIONANDO
											  " FROM filme, diretores_filme WHERE filme.idfilme = diretores_filme.idfilme AND diretores_filme.diretor_nome LIKE ? ORDER BY filme.idfilme");
				ps.setString(1, "%" + dados +  "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("filme.idfilme"));
					f.setTitulo(rs.getString("filme.titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("filme.ano"));
					f.setPontuacao(rs.getDouble("filme.pontuacao"));
					
					listaFilmesPorDiretores.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorDiretores;
			
		} else if (tipoConsulta.equals("Atores")) {
			ArrayList<Filme> listaFilmesPorAtores = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT filme.idfilme, filme.titulo, filme.titulo_ingles, filme.ano, filme.pontuacao" +
											//", diretores_filme.iddiretor, diretores_filme.idfilme, diretores_filme.diretor_nome, diretores_filme.descricao " + //ESTA FUNCIONANDO
											  " FROM filme, atores_filme WHERE filme.idfilme = atores_filme.idfilme AND atores_filme.ator_nome LIKE ? ORDER BY filme.idfilme");
				ps.setString(1, "%" + dados +  "%");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("filme.idfilme"));
					f.setTitulo(rs.getString("filme.titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("filme.ano"));
					f.setPontuacao(rs.getDouble("filme.pontuacao"));
					
					listaFilmesPorAtores.add(f);
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return listaFilmesPorAtores;
			
		} else if (tipoConsulta.equals("Genero")) {
					ArrayList<Filme> listaFilmesPorCategoria = new ArrayList<Filme>();
					PreparedStatement ps = null;
					ResultSet rs = null;

					try {
						ps = conexao.prepareStatement("SELECT filme.idfilme, filme.titulo, filme.titulo_ingles, filme.ano, filme.pontuacao" +
													//", atores_filme.idator, atores_filme.idfilme, atores_filme.ator_nome, atores_filme.papel, atores_filme.descricao " + //ESTA FUNCIONANDO
								  					  "FROM filme, atores_filme WHERE filme.idfilme = atores_filme.idfilme AND atores_filme.ator_nome LIKE ? ORDER BY filme.idfilme;");
						ps.setString(1, "%" + dados +  "%");
						rs = ps.executeQuery();
						
						while (rs.next()) {
							Filme f = new Filme();
							f.setIdFilme(rs.getInt("idfilme"));
							f.setTitulo(rs.getString("titulo"));
							f.setTituloIngles(rs.getString("titulo_ingles"));
							f.setAno(rs.getInt("ano"));
							f.setPontuacao(rs.getDouble("pontuacao"));
							
							listaFilmesPorCategoria.add(f);
						}
						
						rs.close();
						ps.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					}

					return listaFilmesPorCategoria;
			
		} else { throw new IllegalArgumentException();
 			   }
		}*/		
}
