package dao;

//OBS: EU UTILIZO CADA UM DESSES TIPOS DE COMENTARIOS AQUI PARA DIFERENCIAR O QUE REALMENTE IMPORTA E O QUE EH APENAS COMPLEMENTO NOS MEUS PROGRAMAS JAVA!      

//= PROGRAMACAO OBRIGATORIA PARA FUNCIONAR A PROVA1!
/*  = NECESSARIO CASO QUEIRA RETORNAR OS DADOS DE MANEIRA MAIS ORGANIZADA */
/** = DESNECESSARIO = IMPLEMENTACAO OPCIONAL, APENAS POR ORGANIZACAO */
//_________________________________________________________________________________________________________________________________________________________________*/

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static Connection conexao = null;

	public static Connection getConexao(){

		if (conexao == null) {
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				String url = "jdbc:mysql://localhost/imdb_2017";
				String username = "root";
				String password = "";
				
				conexao = DriverManager.getConnection(url, username, password);
			}
			catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		return conexao;
	}

}
