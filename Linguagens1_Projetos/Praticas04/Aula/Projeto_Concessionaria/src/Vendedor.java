
public class Vendedor {
//Isso não cheira bem e não parece correto
		private double salarioBase;
		private double comissao;
		private Gerente gerente;
		
		//Construtor
		public Vendedor(double salarioBase, Gerente gerente) {
			this.salarioBase = salarioBase;
			this.comissao = 0.05;
			this.gerente = gerente;
		}
		
		public double getsalarioBase() {
			return salarioBase;
			
		}
		public boolean setSalarioBase(double novoSalarioBase, Gerente gerente) {
			if(this.gerente.equals(gerente)) {
				this.salarioBase = novoSalarioBase;
				return true;
			}else
				return false;
		}
		
		public double getcomissao() {
			return comissao;
		}
		
	public double getSalarioFinal(double totalVendasMes) {
		return salarioBase + comissao*totalVendasMes;
			
		}
	public final Gerente getGerente() {
		return gerente;
	}
}

