package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Veiculo;
import util.JpaUtil;

public class VeiculoDAOImpl implements VeiculoDAO {

	public void inserir(Veiculo veiculo) {

		String sql = "insert into VEICULO (modelo, marca,ano) values (?, ?, ?)";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, veiculo.getModelo());
			ps.setString(2, veiculo.getMarca());
			ps.setInt(3, veiculo.getAno());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(Veiculo veiculo) {

		String sql = "UPDATE VEICULO SET marca = ?, ano = ? where modelo = ?";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, veiculo.getModelo());
			ps.setString(2, veiculo.getMarca());
			ps.setInt(3, veiculo.getAno());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(Veiculo veiculo) {

		String sql = "DELETE FROM VEICULO WHERE modelo = ?";

		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, veiculo.getModelo());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Veiculo pesquisar(String modelo) {

		String sql = "select U.MODELO, U.MARCA, U.ANO from VEICULO U where modelo = ?";
		
		Veiculo veiculo = null;
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, modelo);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				veiculo = new Veiculo();
				veiculo.setModelo(res.getString("MODELO"));
				veiculo.setMarca(res.getString("MARCA"));
				veiculo.setAno(res.getInt("ANO"));
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return veiculo;
	}

	public List<Veiculo> listarTodos() {

		String sql = "select U.MODELO, U.MARCA, U.ANO from VEICULO U";
		
		List<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
		
		Connection conexao;
		try {
			conexao = JpaUtil.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
				Veiculo veiculo = new Veiculo();
				veiculo.setModelo(res.getString("MODELO"));
				veiculo.setMarca(res.getString("MARCA"));
				veiculo.setAno(res.getInt("ANO"));
				
				listaVeiculo.add(veiculo);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaVeiculo;

	}

}
