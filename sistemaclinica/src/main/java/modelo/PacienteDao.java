package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.SQLData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {
	//certo
	public void cadastro(Paciente paciente) {
		Connection con = Conexao.obterConexao();
		String sql = "INSERT INTO pacientes(cpf, nomePaciente, motivoConsulta) VALUES(?, ?,?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			preparador.setInt(1, paciente.getCpf());
			preparador.setString(2, paciente.getNomePaciente());
			preparador.setString(3, paciente.getMotivoConsulta());
			preparador.execute();
			
			
			ResultSet rs = preparador.getGeneratedKeys();
			if (rs.next()) {
				paciente.setIdPaciente(rs.getInt(1));
			}

			preparador.close();
			con.close();
			System.out.println("PACIENTE CADASTRADO COM SUCESSO!!!");
		} catch(SQLException e) {
			e.printStackTrace();
            System.out.println("NÃO FOI POSSÍVEL CADASTRAR O PACIENTE!!!");
			
		}
		
	}
	//certo
	public List<Paciente> mostrarTodos(){
		Connection con = Conexao.obterConexao();
		List<Paciente> pacientes = new ArrayList<>();
		String sql = "SELECT * FROM pacientes";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Paciente paciente = new Paciente();
				paciente.setIdPaciente(resultado.getInt("idPaciente"));
				paciente.setCpf(resultado.getInt("cpf"));
				paciente.setNomePaciente(resultado.getString("nomePaciente"));
				paciente.setMotivoConsulta(resultado.getString("motivoConsulta"));
				paciente.setNomeClinica(resultado.getString("nomeClinica"));
				paciente.setNomeMedico(resultado.getString("nomeMedico"));
				paciente.setDiagnostico(resultado.getString("diagnostico"));
				paciente.setDataConsulta(resultado.getDate("dataConsulta"));
				paciente.setValorConsulta(resultado.getDouble("valorConsulta"));
				
				pacientes.add(paciente);
			}
			
			resultado.close();
			preparador.close();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
            System.out.println("NÃO FOI POSSÍVEL RECUPERAR A LISTA DE PACIENTES!!!");
		}	
		return pacientes;
	} 
	//certo
	public Paciente mostrarPorId(int idPaciente) {

		Connection con = Conexao.obterConexao();
		Paciente paciente = null;
		String sql = "SELECT * FROM pacientes WHERE idPaciente = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, idPaciente);
			ResultSet resultado = preparador.executeQuery();
			
			if (resultado.next()) {
				paciente = new Paciente();
				paciente.setIdPaciente(resultado.getInt("idPaciente"));
				paciente.setCpf(resultado.getInt("cpf"));
				paciente.setNomePaciente(resultado.getString("nomePaciente"));
				paciente.setMotivoConsulta(resultado.getString("motivoConsulta"));
				paciente.setNomeClinica(resultado.getString("nomeClinica"));
				paciente.setNomeMedico(resultado.getString("nomeMedico"));
				paciente.setDiagnostico(resultado.getString("diagnostico"));
				paciente.setDataConsulta(resultado.getDate("dataConsulta"));
				paciente.setValorConsulta(resultado.getDouble("valorConsulta"));
				
			}
			
			resultado.close();
			preparador.close();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
            System.out.println("NÃO FOI POSSÍVEL RECUPERAR O PACIENTE!!!");
			
		}
		
		
		return paciente;
	}
	//certo
	public void excluirPorId(int idPaciente) {
		Connection con = Conexao.obterConexao();
		String sql = "DELETE * FROM pacientes WHERE idPaciente =?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, idPaciente);
            preparador.execute();
            preparador.close();
            con.close();
            System.out.println("PACIENTE EXCLUÍDO COM SUCESSO!!!");
		} catch(SQLException e) {
			e.printStackTrace();
            System.out.println("NÃO FOI POSSÍVEL EXCLUIR O PACIENTE!!!");
		}
		
	}
	
	//certo
	public void alterarPorId(Paciente paciente) {
		Connection con = Conexao.obterConexao();
		String sql = "UPDATE pacientes SET cpf =?, nomePaciente=?, nomeMedico=?, dataConsulta =? WHERE idPaciente =?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, paciente.getCpf());
			preparador.setString(2, paciente.getNomePaciente());
			preparador.setString(3, paciente.getNomeMedico());
			preparador.setDate(4, (Date) paciente.getDataConsulta());
			preparador.setInt(5, paciente.getIdPaciente());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("PACIENTE ATUALIZADO COM SUCESSO!!!");
			
		} catch(SQLException e) {
			e.printStackTrace();
            System.out.println("NÃO FOI POSSÍVEL ATUALIZAR O PACIENTE!!!");
		}
		
		
	}
	//certo
	public void marcarConsulta(int idPaciente, String nomeClinica, String nomeMedico,String dataConsulta , double valorConsulta) {
		
		Connection con = Conexao.obterConexao();
		String sql = "UPDATE pacientes SET  nomeClinica=?, nomeMedico=?, dataConsulta=?, valorConsulta=? WHERE idPaciente=?";
		
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setString(1, nomeClinica);
			 preparador.setString(2, nomeMedico);
			 preparador.setString(3, dataConsulta);
			 preparador.setDouble(4, valorConsulta);
			 preparador.setInt(5, idPaciente);
			 preparador.execute();
			 preparador.close();
			 
			 System.out.println("CONSULTA MARCADA COM SUCESSO!!!");
		}catch(SQLException e) {
			e.printStackTrace();
            System.out.println("NÃO FOI POSSÍVEL MARCAR A CONSULTA!!!");
		}
		
	}
	//certo
	public void registarDiagnostico(int idPaciente, String diagnostico) {
		Connection con = Conexao.obterConexao();
		String sql = "UPDATE pacientes SET diagnostico = ? WHERE idPaciente = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, diagnostico);
            preparador.setInt(2, idPaciente);
            preparador.execute();
            
            preparador.close();
            System.out.println("DIAGNÓSTICO REGISTRADO COM SUCESSO!!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("NÃO FOI POSSÍVEL REGISTRAR O DIAGNÓSTICO!!!");
        }
		
		
		
	}
	
}
