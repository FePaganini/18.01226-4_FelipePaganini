
public class Gerente {
	private double salarioBase;
	private final double comissao = 0.1;
	
	//Construtor
	public Gerente(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	public double getsalarioBase() {
		return salarioBase;
		
	}
	
	public double getcomissao() {
		return comissao;
	}
	
	public double getSalarioFinal(double totalVendasMes) {
	return salarioBase + comissao*totalVendasMes+ 0.5*salarioBase;
		
	}
	public boolean darAumento(Vendedor vendedor, double aumento) {
			double novoSalarioBase = vendedor.getsalarioBase()*(1.0+ aumento);
			return vendedor.setSalarioBase(novoSalarioBase, this);
	}
}
