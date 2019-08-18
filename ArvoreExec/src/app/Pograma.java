package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.*;

public class Pograma {

	public static void main(String[] args) {
		
		AVL arvre = new AVL();
        
        Scanner in = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();
       
        
        System.out.print("Digite a quantidade:");
        Integer qtd = in.nextInt();
        
        for(int i = 1; i <= qtd; i++){
        	Integer temp;
        	temp = (int) (Math.random() * 1000);
        	if(!lista.contains(temp)){
        		lista.add(temp);
        		arvre.inserir(temp);
        	}else{
        		i--;
        	}
        }
        
        arvre.printarAVL();
        
        
        in.close();
	}

}