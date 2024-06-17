package modelo;

import java.util.Date;
import java.sql.SQLData;

public class Paciente {
	public Paciente(int cpf , String nomePaciente, String motivoConsulta) {
		this.cpf = cpf;
		this.nomePaciente = nomePaciente;
		this.motivoConsulta = motivoConsulta;
		
	}
	
	public Paciente(int idPaciente, int cpf, String nomePaciente, String nomeMedico, Date dataConsulta) {
		this.idPaciente = idPaciente;
		this.cpf = cpf;
		this.nomePaciente = nomePaciente;
		this.nomeMedico = nomeMedico;
		this.dataConsulta = dataConsulta;	
	}
	
	public Paciente() {}
	
	//paciente
	private int idPaciente;
	private int cpf;
	private String nomePaciente;
	private String motivoConsulta;
	
	
	//clinica
	private String nomeClinica;
	private String nomeMedico;
	private String diagnostico;
	private Date dataConsulta;
	private double valorConsulta;
	

	//getts e setts
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public String getNomeClinica() {
		return nomeClinica;
	}
	public void setNomeClinica(String nomeClinica) {
		this.nomeClinica = nomeClinica;
	}
	public String getNomeMedico() {
		return nomeMedico;
	}
	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Date getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public double getValorConsulta() {
		return valorConsulta;
	}
	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
	
}
