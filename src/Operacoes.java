
public class Operacoes {
	public static void criarPaciente(ListaDePrioridade<Paciente> listaPacientes, String[] valores){
		String cpf = valores[1];
		
		String nome = valores[2];
		
		int grauRisco = Integer.parseInt(valores[3]);
		
		Paciente novoPaciente = new Paciente(cpf, nome, grauRisco);
		
		listaPacientes.insere(novoPaciente);
	}
	
	public static String alterarRisco(ListaDePrioridade<Paciente> listaPacientes, String[] valores){
		
		String cpf = valores[1];
		int NovoGrauRisco = Integer.parseInt(valores[2]);
		
		for(int i = 0; i < listaPacientes.getNum(); i++){
			
			Paciente pacienteAux = listaPacientes.getLista(i);
			
			if(pacienteAux.getCpf().equals(cpf)){
				pacienteAux.setGrauR(NovoGrauRisco);
				
				if(listaPacientes.pai(i) < pacienteAux.getGrauR())
					listaPacientes.sobe(i);
				else
					listaPacientes.desce(i);
				return "RECLASS\t" + pacienteAux.getCpf() + "\t" + pacienteAux.getNome() + "\t" + pacienteAux.getGrauR();
			}
			
		}
		return "";
		
	}
	
	public static void serAtendido(ListaDePrioridade<Paciente> listaPacientes){
		listaPacientes.remove();
	}
}
