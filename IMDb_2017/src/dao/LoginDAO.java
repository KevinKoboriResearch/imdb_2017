package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	private Connection conexao;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	
	public LoginDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/

	public boolean resultadoLogin(String usuario, String senha) {
		PreparedStatement ps = null;
		boolean resultado = false;
		
		ResultSet rs = null;
		
		try {
			
			ps = conexao.prepareStatement("SELECT idlogin FROM login WHERE usuario = ? AND senha = ?");
			ps.setString(1, usuario);
			ps.setString(2, senha);

			rs = ps.executeQuery();

			if (rs.first()) {
			
			resultado = true;
				
			} else {
			
			resultado = false;
			
			}
			
			rs.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
}