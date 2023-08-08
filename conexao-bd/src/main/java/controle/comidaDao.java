package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.comida;

public class comidaDao {
	
	/**
	 * Metodo que recebe uma comida
	 * @param c
	 * @return
	 */
	
	public boolean inserir(comida c) {
		// Intaciar a classe
		Conexao C = Conexao.getInstacia();
		
		// Abrir a conexão com o banco de dados
		Connection con = C.conectar();
		
		String query = "INSERT INTO comida (idcomida, Marca) VALUES ('Macarrao,seara')";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			// seta o parametros
			ps.setInt(1, c.getComida());
			ps.setString(2,c.getMarca());
			
			//consolidar a execucao do comando no banco
			ps.executeUpdate();
			
			//Fecha a conexao
			C.fecharConexao();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
		return true;
	}
}
