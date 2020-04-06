
public class Funcionario {
	private double salarioBase;
	private double comissao;
	private Gerente gerente;
	
	//Construtor
	public Funcionario(double salarioBase, Gerente gerente) {
		this.salarioBase = salarioBase;
		this.gerente = gerente;
		this.comissao = 0.05;
	}
	
	public double getsalarioBase() {
		return salarioBase;
		
	}
	
	public double getcomissao() {
		return comissao;
	}
	
public double getSalarioFinal(double totalVendasMes) {
	return salarioBase + comissao*totalVendasMes;
		
	}
	
}
