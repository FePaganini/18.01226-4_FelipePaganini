// Felipe dos Santos Paganini   18.01226-4

public class Conta {
	private int id;
	private double saldo;
	private static int numeroDeContas;
	private Usuario user;
	
	public Conta(Usuario user,double saldo){
		this.user = user;
		this.saldo = saldo;
		Conta.numeroDeContas = Conta.numeroDeContas + 1;
		this.id = numeroDeContas;
	}
	
	public Usuario getUsuario() {
		return user;
	}
	
	public String getId(){
		return Integer.toString(this.id);
	}

	public double getsaldo(){
		return saldo;
	}
	
	public boolean sacar(double valor) {
		if(valor > this.saldo) {
			return false;
		}
		else {
			this.saldo = this.saldo - valor;
			return true;
		}
	}
	public void depositar(double valor) {
		this.saldo = this.saldo+valor;
	}
	
}
