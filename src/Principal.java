import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Principal {
	
	public static void main(String[] args) throws Exception {
		
		String[] valores;
		Paciente pacienteAux;
		ListaDePrioridade<Paciente> listaPacientes = new ListaDePrioridade<Paciente>(1);
		BufferedReader br = null;
		br = new BufferedReader(new FileReader("sequenciaOcorrencias.txt"));
		
		PrintStream ps = new PrintStream("saida.txt");
		
		String linha = br.readLine();
		String linhaEscrever = "";
		while(linha != null){
			
			//SÓ PARA TESTAR
			listaPacientes.exibirLista("Lista de Pacientes: ");
			
			valores = linha.split("\t");
			
			if(valores[0].equals("ENTRADA")){
				Operacoes.criarPaciente(listaPacientes, valores);
				
				linhaEscrever = linha;
			}	
			
			else if(valores[0].equals("ATENDIMENTO")){
				pacienteAux = listaPacientes.getLista(0);
				if(pacienteAux != null)
					linhaEscrever = "ATENDIMENTO\t" + pacienteAux.getCpf() + "\t" + pacienteAux.getNome() + "\t" + pacienteAux.getGrauR();
				Operacoes.serAtendido(listaPacientes);
				

				
			}	
			
			else if(valores[0].equals("RECLASS")){
				Operacoes.alterarRisco(listaPacientes, valores);
				
				linhaEscrever = Operacoes.alterarRisco(listaPacientes, valores);
			}	
			
			ps.println(linhaEscrever);
			
			linha = br.readLine();

		}
		
		if(listaPacientes.getLista(0) != null){
			ps.println("NÃO FORAM ATENDIDOS:");
			for(int num = 0; listaPacientes.getLista(num) != null; num++){
				pacienteAux = listaPacientes.getLista(num);
				linhaEscrever = pacienteAux.getCpf() + "\t" + pacienteAux.getNome() + "\t" + pacienteAux.getGrauR();
				ps.println(linhaEscrever);
			}
			
		}
		else
			ps.println("TODOS FORAM ATENDIDOS");
		
		//SÓ PARA TESTAR MESMO
		listaPacientes.exibirLista("Lista de Pacientes: ");
	}
}
