package Testes;

import modelo.Paciente;
import modelo.PacienteDao;

public class testeCadastro {

	public static void main(String[] args) {
		
		Paciente paciente = new Paciente(456, "Maria", "dor nas costas");
		PacienteDao pacienteDao = new PacienteDao();
		pacienteDao.cadastro(paciente);
	}

}
