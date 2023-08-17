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
		String query = "";

		return null;
	}

	public boolean inserir(Animal a) {

		Conexao c = Conexao.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO animal " + "(marca,especie) " + "VALUES (?, ?)";

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

}
