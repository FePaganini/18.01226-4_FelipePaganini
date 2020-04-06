import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String nome, genero, descricao;
		System.out.println("Informe nome, gênero e descrição:");
		nome = scan.nextLine();
		genero = scan.nextLine();
		descricao = scan.nextLine();
		Jogo j1 = new Jogo(nome,genero,descricao);
		System.out.println("J1: " + j1.getInfo());
		
		System.out.println("Informe nick: ");
		String nick = scan.nextLine();
		Usuario usuario = new Usuario(nick,"123","");
		Conta conta = new Conta(usuario);
		System.out.println("Dados da Conta: " + conta.getInfo());
		conta.addCreditos(50);
		for(int i = 0; i < 5; i++)
			conta.addJogo(j1);
		
		System.out.println("Dados da Conta: " + conta.getInfo());
	}

}
