package Testes;

import modelo.PacienteDao;

public class registrarDiag {

	public static void main(String[] args) {
		
		PacienteDao pacienteDao = new PacienteDao();
		int idPaciente = 2;
		String diagnostico = "lesão na c4";
		pacienteDao.registarDiagnostico(idPaciente, diagnostico);
		
	}

}
