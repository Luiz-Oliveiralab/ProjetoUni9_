package Testes;

import modelo.Paciente;
import modelo.PacienteDao;
import java.sql.Date;
public class alterarPorid {

	public static void main(String[] args) {
		
		Paciente paciente = new Paciente(1,123, "joao","marcio", null);
										//id,//cpf,nome,medico,data	
		
		PacienteDao pacienteDao = new PacienteDao();
		pacienteDao.alterarPorId(paciente);
		

	}

}
