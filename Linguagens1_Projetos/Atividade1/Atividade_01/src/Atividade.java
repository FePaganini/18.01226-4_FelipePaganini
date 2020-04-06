// Felipe dos Santos Paganini   18.01226-4
public class Atividade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conta c1,c2,c3;
		Usuario u1,u2,u3;
		String qr1,qr2;
		u1 = new Usuario("Felipe", "endeavor", "fmail");
		u2 = new Usuario("Bruna", "arquitetura", "bmail");
		u3 = new Usuario("Thor", "amobruna", "tmail");
		c1 = new Conta(u1,1000);
		c2 = new Conta(u2,250);
		c3 = new Conta(u3,3000);
		System.out.println("Estado Inicial \nUser 1: "+c1.getUsuario().getNome() +" - Saldo: " + c1.getsaldo());
		System.out.println("User 2: "+c2.getUsuario().getNome() +" - Saldo: " + c2.getsaldo());
		System.out.println("User 3: "+c3.getUsuario().getNome() +" - Saldo: " + c3.getsaldo());
		qr1 = Transacao.geraQR(c1, 250);
		
		Transacao.novaTransferencia(c2, c1, qr1);
		Transacao.novaTransferencia(c3, c1, qr1);
		
		qr2 = Transacao.geraQR(c2, 1000);
		Transacao.novaTransferencia(c3, c2, qr2);
		System.out.println("Estado Final \nUser 1: "+c1.getUsuario().getNome() +" - Saldo: " + c1.getsaldo());
		System.out.println("User 2: "+c2.getUsuario().getNome() +" - Saldo: " + c2.getsaldo());
		System.out.println("User 3: "+c3.getUsuario().getNome() +" - Saldo: " + c3.getsaldo());
		
	}
	
}
