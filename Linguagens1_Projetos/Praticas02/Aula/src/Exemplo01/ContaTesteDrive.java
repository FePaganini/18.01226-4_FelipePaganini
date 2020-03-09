package Exemplo01;

public class ContaTesteDrive {
	public static void main(String[] args){
		// Declara c1, ainda sem nada dentro
		Conta c1;
		// Instancia conta - colaca a referência de um objeto
		c1 = new Conta();
		// Acesso o titular da conta
		c1.cliente.nome = "Odair";
		System.out.println("Titular C1: " + c1.cliente.nome);
		
		Conta c2 = new Conta();
		c2.cliente.nome = "Goku";
		System.out.println("Titular C2: " + c2.cliente.nome);
		c1.saldo = 20000;
		c1.visualizarSaldo();
		c2.visualizarSaldo();
		c1.sacar(300);
		c1.visualizarSaldo();
		c1.sacar(20000);
		c1.visualizarSaldo();
		c1.transferirDinheiro(c2, 2000);
		c1.visualizarSaldo();
		c2.visualizarSaldo();
	}
	
}
