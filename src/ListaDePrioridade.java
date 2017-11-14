
public class ListaDePrioridade<T>{
	
	private T[] lista;

	private int numero;
	
	
	public T getLista(int indice){
		return this.lista[indice];
	}
	
	public int getNum(){
		return this.numero;
	}
	
	public ListaDePrioridade(int tamanho) {
		lista = (T[]) new Object[tamanho];
		numero = 0;
	}

	
	public ListaDePrioridade() {
		this(10);
	}

	
	public boolean vazia() {
		return numero == 0;
	}

	
	public void insere(T novo) {
		if(numero == lista.length)
			aumentarEspaco();
		lista[numero] = novo;
		numero++;
		sobe(numero - 1);
	}

	
	public T remove(){
		if(numero == 0)
			throw new RuntimeException("FALHA AO REMOVER DE UMA LISTA VAZIA !!!!!");
			
		T topo = lista[0];
		lista[0] = lista[numero - 1];
		lista[numero - 1] = null;
		numero--;
	
		if (!vazia())
			desce(0);
		return topo;
		
	}

	
	public int pai(int i) {
		if (i == 0)
			return 0;
		return (i - 1) / 2;
	}

	
	private int esquerdo(int i) {
		return 2 * i + 1;
	}

	
	private int direito(int i) {
		return 2 * i + 2;
	}


	public void sobe(int i) {
		int p = pai(i);
		((MetodosGenericos<T>) lista[i]).setar(lista[i]);
		
		while (( ((Comparable<T>)lista[i]).compareTo(lista[p]) == 1)) {
			troca(i, p);
			i = p;
			p = pai(i);
			((MetodosGenericos<T>) lista[i]).setar(lista[i]);
		}
		
	}


	public void desce(int i) {
		int iMaior = i;

		int iEsq = esquerdo(i);
		
		if (iEsq < numero && ((Comparable<T>) lista[iEsq]).compareTo(lista[iMaior]) == 1)
			iMaior = iEsq;

		int iDir = direito(i);
		
		if (iDir < numero && ((Comparable<T>) lista[iDir]).compareTo(lista[iMaior]) == 1)
			iMaior = iDir;

		if (iMaior != i) {
			troca(i, iMaior);
			desce(iMaior);
		}
	}

	private void troca(int i, int j) {
		T aux = lista[i];
		lista[i] = lista[j];
		lista[j] = aux;
	}
	
	public void exibirLista(String nomeLista){
		int cont = 0;
		
		System.out.println(nomeLista);
		while(cont < numero && this.lista[cont] != null){
			System.out.println(lista[cont].toString());
			cont++;
		}
		System.out.println();
	}
	
	private void aumentarEspaco(){
		T[] listaAux = (T[]) new Object[lista.length * 2];
		for (int i = 0; i < numero; ++i)
			listaAux[i] = lista[i];
		lista = listaAux;
	}

}
