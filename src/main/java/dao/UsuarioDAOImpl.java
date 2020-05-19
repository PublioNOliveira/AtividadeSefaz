package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Usuario;
import util.JpaUtil;

public class UsuarioDAOImpl implements UsuarioDAO {

	public void inserir(Usuario usuario) {

		String sql = "insert into USUARIO (nome, email, cpf, senha) values (?, ?, ?, ?)";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setDouble(3, usuario.getCpf());
			ps.setString(4, usuario.getSenha());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(Usuario usuario) {

		String sql = "UPDATE USUARIO SET email = ?, cpf = ?, senha = ? where nome = ?";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEmail());
			ps.setDouble(3, usuario.getCpf());
			ps.setString(4, usuario.getSenha());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(Usuario usuario) {

		String sql = "DELETE FROM USUARIO WHERE nome = ?";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Usuario pesquisar(String nome) {

		String sql = "select U.NOME, U.EMAIL, U.CPF, U.SENHA from USUARIO U where nome = ?";
		
		Usuario usuario = null;
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, nome);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				usuario = new Usuario();
				usuario.setNome(res.getString("NOME"));
				usuario.setEmail(res.getString("EMAIL"));
				usuario.setCpf(res.getDouble("CPF"));
				usuario.setSenha(res.getString("SENHA"));
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

	public List<Usuario> listarTodos() {

		String sql = "select  U.NOME, U.EMAIL, U.CPF, U.SENHA from USUARIO U";
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
				Usuario usuario = new Usuario();
				usuario.setNome(res.getString("NOME"));
				usuario.setEmail(res.getString("EMAIL"));
				usuario.setCpf(res.getDouble("CPF"));
				usuario.setSenha(res.getString("SENHA"));
				
				listaUsuarios.add(usuario);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaUsuarios;

	}

	

}
