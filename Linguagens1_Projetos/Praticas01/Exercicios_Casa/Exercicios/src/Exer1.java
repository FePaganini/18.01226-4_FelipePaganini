import java.util.Scanner;

public class Exer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int  idade;
		String RA, Nome, email, telefone;
		System.out.print("Informe seu R.A: ");
		RA = in.nextLine();
		System.out.print("Informe seu Nome Completo: ");
		Nome = in.nextLine();
		System.out.print("Informe seu Telefone: ");
		telefone = in.nextLine();
		System.out.print("Informe seu Email: ");
		email = in.nextLine();
		System.out.print("Informe sua Idade: ");
		idade = in.nextInt();
		
		
		System.out.println("RA: " + RA);
		System.out.println("Nome: " + Nome);
		System.out.println("Telefone: " + telefone);
		System.out.println("Email: " + email);
		System.out.println("Idade: " + idade);
	}

}
