package app;

import entities.Metodos;

public class Pograminha {

	public static void main(String[] args) {
		Metodos novo = new Metodos();
		
		
		System.out.println("----- Criando o arquivo -------");
		novo.postInserir("c:\\temp\\arquivo.txt", "Eu amo java!"); 
		
		novo.getRecupera("c:\\temp\\arquivo.txt");
		
		System.out.println();
		
		System.out.println("----- Atualizando o arquivo -------");
		novo.putAtualiza("c:\\temp\\arquivo.txt", " E quero MUITO trabalhar na Stefanini!!!");
		
		novo.getRecupera("c:\\temp\\arquivo.txt");
		
		System.out.println();
		
		System.out.println("----- Deletando o arquivo -------");
		
		novo.deleteArquivo("c:\\temp\\arquivo.txt");
	}

}
