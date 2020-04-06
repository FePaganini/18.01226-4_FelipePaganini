import java.util.Scanner;
public class Exer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String user, senha, userback, senhaback;
		System.out.print("Informe o usuário: ");
		user = in.nextLine();
		System.out.print("Informe a senha: ");
		senha = in.nextLine();
		userback = "";
		senhaback = "";
		while(!(userback.equals(user)) || !(senhaback.equals(senha))) {
			System.out.print("Informe o usuário: ");
			userback = in.nextLine();
			System.out.print("Informe a senha: ");
			senhaback = in.nextLine();
		}
				
		
	}

}
