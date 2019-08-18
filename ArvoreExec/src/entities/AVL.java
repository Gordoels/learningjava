package entities;

import java.util.ArrayList;

public class AVL {

	protected No raiz;

	public void inserir(int numero) {
		No n = new No(numero);
		inserirAVL(this.raiz, n);
	}

	public void inserirAVL(No node, No novo) {

		if (node == null) {
			this.raiz = novo;

		} 
		else {

			if (novo.getChave() < node.getChave()) {

				if (node.getEsquerda() == null) {
					node.setEsquerda(novo);
					novo.setPai(node);
					verificarBalanceamento(node);
				} 
				else {
					inserirAVL(node.getEsquerda(), novo);
				}
			} 
			else if (novo.getChave() > node.getChave()) {

				if (node.getDireita() == null) {
					node.setDireita(novo);
					novo.setPai(node);
					verificarBalanceamento(node);
				} 
				else {
					inserirAVL(node.getDireita(), novo);
				}

			} 
		}
	}

	public void verificarBalanceamento(No atual) {
		balancear(atual);
		int balanceamento = atual.getBalanca();

		if (balanceamento == -2) {

			if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
				atual = rotacionaDireita(atual);
			} 
			else {
				atual = duplaRotacaoEsquerdaDireita(atual);
			}
		} 
		else if (balanceamento == 2) {

			if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
				atual = rotacionaEsquerda(atual);
			} 
			else {
				atual = duplaRotacaoDireitaEsquerda(atual);
			}
		}

		if (atual.getPai() != null) {
			verificarBalanceamento(atual.getPai());
		} 
		else {
			this.raiz = atual;
		}
	}
	
	public No rotacionaEsquerda(No inicial) {

		No direita = inicial.getDireita();
		direita.setPai(inicial.getPai());

		inicial.setDireita(direita.getEsquerda());

		if (inicial.getDireita() != null) {
			inicial.getDireita().setPai(inicial);
		}

		direita.setEsquerda(inicial);
		inicial.setPai(direita);

		if (direita.getPai() != null) {

			if (direita.getPai().getDireita() == inicial) {
				direita.getPai().setDireita(direita);
			} 
			else if (direita.getPai().getEsquerda() == inicial) {
				direita.getPai().setEsquerda(direita);
			}
		}

		balancear(inicial);
		balancear(direita);

		return direita;
	}

	public No rotacionaDireita(No inicial) {

		No esquerda = inicial.getEsquerda();
		esquerda.setPai(inicial.getPai());

		inicial.setEsquerda(esquerda.getDireita());

		if (inicial.getEsquerda() != null) {
			inicial.getEsquerda().setPai(inicial);
		}

		esquerda.setDireita(inicial);
		inicial.setPai(esquerda);

		if (esquerda.getPai() != null) {

			if (esquerda.getPai().getDireita() == inicial) {
				esquerda.getPai().setDireita(esquerda);
			
			} else if (esquerda.getPai().getEsquerda() == inicial) {
				esquerda.getPai().setEsquerda(esquerda);
			}
		}

		balancear(inicial);
		balancear(esquerda);

		return esquerda;
	}

	public No duplaRotacaoEsquerdaDireita(No inicial) {
		inicial.setEsquerda(rotacionaEsquerda(inicial.getEsquerda()));
		return rotacionaDireita(inicial);
	}

	public No duplaRotacaoDireitaEsquerda(No inicial) {
		inicial.setDireita(rotacionaDireita(inicial.getDireita()));
		return rotacionaEsquerda(inicial);
	}

	public int altura(No atual) {
		if (atual == null) {
			return -1;
		}

		if (atual.getEsquerda() == null && atual.getDireita() == null) {
			return 0;
		}
		
		else if (atual.getEsquerda() == null) {
			return 1 + altura(atual.getDireita());
		}
		
		else if (atual.getDireita() == null) {
			return 1 + altura(atual.getEsquerda());
		}
		else {
			return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
		}
	}

	private void balancear(No no) {
		no.setBalanca(altura(no.getDireita()) - altura(no.getEsquerda()));
	}

	protected ArrayList<No> inorder() {
		ArrayList<No> ret = new ArrayList<>();
		inorder(raiz, ret);
		return ret;
	}

	protected void inorder(No no, ArrayList<No> lista) {
		if (no == null) {
			return;
		}
		inorder(no.getEsquerda(), lista);
		lista.add(no);
		inorder(no.getDireita(), lista);
	}
	
	public void printarAVL() {
		System.out.print("{");
		for (No no : inorder()) {
			System.out.print("[" + no + "]" + "(" + no.getBalanca() + ")");
		}
		System.out.print("}");
	}
}

