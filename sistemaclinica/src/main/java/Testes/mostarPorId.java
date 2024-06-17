package Testes;

import modelo.Paciente;
import modelo.PacienteDao;

public class mostarPorId {

	public static void main(String[] args) {
		
		PacienteDao pacienteDao = new PacienteDao();
		Paciente paciente = pacienteDao.mostrarPorId(1);
		
		if(paciente != null) {
			System.out.println("PACIENTE");
			System.out.println("IdPaciente: " + paciente.getIdPaciente());
			System.out.println("CPF do Paciente: " + paciente.getCpf());
			System.out.println("Nome do Paciente: " + paciente.getNomePaciente());
			System.out.println("Motivo da Consulta: " + paciente.getMotivoConsulta());
			System.out.println("Nome da Clinica: "+ paciente.getNomeClinica());
			System.out.println("Nome do Medico: " + paciente.getNomeMedico());
			System.out.println("Diagnostico: " + paciente.getDiagnostico());
			System.out.println("Data Consulta: "+ paciente.getDataConsulta());
			System.out.println("Valor Consulta: " + paciente.getValorConsulta());
			
		} else {
			System.out.println("Paciente não encontrado!!");
		}
		

	}

}
