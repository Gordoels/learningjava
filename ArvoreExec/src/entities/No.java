package entities;

public class No {
	  
	private No esquerda;
	private No direita;
	private No pai;
	private int chave;
	private int balanca;

	public No(int chave) {
		setEsquerda(setDireita(setPai(null)));
		setBalanca(0);
		setChave(chave);
	}

	public String toString() {
		return Integer.toString(getChave());
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public int getBalanca() {
		return balanca;
	}

	public void setBalanca(int balanca) {
		this.balanca = balanca;
	}

	public No getPai() {
		return pai;
	}

	public No setPai(No pai) {
		this.pai = pai;
		return pai;
	}

	public No getDireita() {
		return direita;
	}

	public No setDireita(No direita) {
		this.direita = direita;
		return direita;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}
}
