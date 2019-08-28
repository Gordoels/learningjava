package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Metodos {

	// metodo insert/post
	public void postInserir(String caminho, String msg) { // Cria um novo arquivo

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) { // se for usado o mesmo caminho de um
																				// arquivo anterior, ele o destruirá
			bw.write(msg);
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
	}
	

	// metodo get
	public void getRecupera(String caminho) { // Lê o que está escrito no arquivo

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			System.out.println(br.readLine());
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
	}
	

	// metodo put/update
	public void putAtualiza(String caminho, String msg) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) { // Este não destruirá o arquivo
																						// anterior mas se mesclará
			bw.write(msg);
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
	}
	

	// metodo delete
	public void deleteArquivo(String caminho) { //procura se o arquivo existe

		File file = new File (caminho);
		if(file.delete()) { //se existe, deleta
			System.out.println("Foi deletado com sucesso!");
		}
		else {
			System.out.println("Não existe esse arquivo!");
		}
	}
	
}
