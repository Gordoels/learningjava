package entities;

public class Empregado implements Comparable<Empregado>{
	private String name;
	private double salario;
	
	public Empregado(String name, double salario) {
		this.name = name;
		this.salario = salario;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public int compareTo(Empregado outro) {
		return name.compareTo(outro.getName());
	}
}
