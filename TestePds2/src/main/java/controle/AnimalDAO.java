package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Animal;

public class AnimalDAO {

	public ArrayList<Animal> listar() {
		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();
		ArrayList<Animal> animais = new ArrayList();
		String query = "SELECT * FROM animais ORDER BY id ASC;";

		return null;
	}

	public boolean inserir(Animal a) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO animal " + "(idAnimal,marca,especie) " + "VALUES (?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,  a.getMarca());
			ps.setString(2,  a.getEspecie());

			ps.executeUpdate();

			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean excluir(Animal a) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		String query = "DELETE FROM animal\r\n  WHERE idAnimal = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, a.getId());
			ps.executeUpdate();
			
			c.fecharConexao();
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean atualizar(Animal a) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		
		String query = "UPDATE animal\r\n   SET" 
				+ "marca = ?\r\n" + "especie = ?,  WHERE idAnimal = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, a.getMarca());
			ps.setString(2, a.getEspecie());
			ps.setInt(3, a.getId());
			
			
			ps.executeUpdate();
			
			c.fecharConexao();
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

}
