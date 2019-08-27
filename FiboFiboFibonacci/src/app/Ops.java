package app;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ops {

	/*public static void main(String[] args) {
		
		for(int i = 0; i<10;i++) {
			System.out.print(fibo(i) + " ");
		}

	}

	public static int fibo(int n) {
		if (n<2) {
			return n;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}

	}
                     ^^  FEITO RECURSIVAMENTE ^^ */
	
	public static void main(String [] args) { 
		// \/ FEITO USANDO STREAM E LAMBDA \/
		Stream<Long> fibo = Stream.iterate(new Long[] {0L, 1L}, i -> new Long[] {i[1], i[0]+i[1]}).map(i-> i[0]);
		
		System.out.println(Arrays.toString(fibo.limit(12).toArray()));
		
	}
	
}
