
public class Paciente implements Comparable<Paciente>, MetodosGenericos<Paciente>{

	private String cpf;
	private String nome;
	private Paciente paciente; 
	private int grauRisco;
	
	
	public Paciente(String cpf, String nome, int grauRisco){
		this.cpf = cpf;
		this.nome = nome;
		this.grauRisco = grauRisco;
	}
	
	public String getCpf() {
		return cpf;
	}
		
	public String getNome() {
		return nome;
	}
	

	public int getGrauR() {
		return grauRisco;
	}
	
	public void setGrauR(int grauRisco) {
		this.grauRisco = grauRisco;
	}
	
	public Paciente getPaciente(){
		return this.paciente;
	}

	@Override
	public int compareTo(Paciente paciente) {
		if(this.paciente.grauRisco > paciente.getGrauR())
			return 1;
		else 
			return 0;
	}

	@Override
	public void setar(Paciente pacienteSetado) {
		paciente = pacienteSetado;
		
	}
	
	@Override
	public String toString(){
		return "Grau de risco: " + this.grauRisco + " Nome: " + this.nome;
	}


	
	
	
}
