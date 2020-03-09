package Exemplo01;

public class Conta {
	// Atributos da classe
	public int numero;
	public Cliente cliente = new Cliente();
	public double saldo;
	
	//M�todos da classe
	boolean sacar(double valor){
		if(valor > this.saldo){
			System.out.println("N�o tem o saldo suficiente");
			return false;
		}
		else{
			this.saldo = this.saldo - valor; //this.saldo -= valor;
			return true;
		}
		}
	void depositar(double valor){
		this.saldo += valor;
	}
	void visualizarSaldo(){
		System.out.println("Saldo: " + this.saldo);
	}
	boolean transferirDinheiro(Conta Destino,  double valor){
		if(sacar(valor)){
			Destino.depositar(valor);
			return true;
		}
		else
			return false;
	}
}