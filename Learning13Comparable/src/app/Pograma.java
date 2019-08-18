package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import entities.Empregado;

public class Pograma {
	
	public static int metodoMaior(int a, int b, int c) {
		if (a > b && a > c) {
			System.out.println(a);
		}
		if (a < b && b > c) {
			System.out.println(b);;
		}
		if (c > b && c > a) {
			System.out.println(c);;
		}

		try {
			if (a == b && a == c) {
				throw new Exception();
			}

		} catch (Exception e) {
			System.out.println("Error: São todos iguais!");
		}
		return 0;
		}

	public static void main(String[] args) {
		metodoMaior(7, 7, 7);
		
	}

}
