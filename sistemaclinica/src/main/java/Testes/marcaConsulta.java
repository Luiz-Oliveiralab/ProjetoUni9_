package Testes;

import modelo.PacienteDao;

public class marcaConsulta {

	public static void main(String[] args) {
		
		int idPaciente = 2;
		String nomeClinica = "clinica1";
		String nomeMedico = "bastiao";
		String dataConsulta = "2024-07-09";
		double valorConsulta = 80;
		
		
		
		PacienteDao pacienteDao = new PacienteDao();
		pacienteDao.marcarConsulta(idPaciente, nomeClinica,nomeMedico,dataConsulta,valorConsulta);		
	}

}
