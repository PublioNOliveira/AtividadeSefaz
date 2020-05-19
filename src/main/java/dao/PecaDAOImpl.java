package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Peca;
import util.JpaUtil;

public class PecaDAOImpl implements PecaDAO {

	public void inserir(Peca peca) {

		String sql = "insert into PECA (nome, referencia) values (?, ?)";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, peca.getNome());
			ps.setString(2, peca.getReferencia());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(Peca peca) {

		String sql = "UPDATE PECA SET referencia = ?, where nome = ?";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, peca.getNome());
			ps.setString(2, peca.getReferencia());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(Peca peca) {

		String sql = "DELETE FROM PECA WHERE NOME = ?";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, peca.getNome());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Peca pesquisar(String nome) {

		String sql = "select U.NOME, U.REFERENCIA from PECA U where nome = ?";
		
		Peca peca = null;
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, nome );

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				peca = new Peca();
				peca.setNome(res.getString("NOME"));
				peca.setReferencia(res.getString("REFERENCIA"));
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return peca;
	}

	
	public List<Peca> listarTodos() {

		String sql = "select U.NOME, U.REFERENCIA, from PECA U";
		
		List<Peca> listaPeca = new ArrayList<Peca>();
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
				Peca peca = new Peca();
				peca.setNome(res.getString("NOME"));
				peca.setReferencia(res.getString("REFERENCIA"));
								
				listaPeca.add(peca);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaPeca;

	}

}
