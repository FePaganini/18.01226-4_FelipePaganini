import java.util.Scanner;
public class Exer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Nome, Nome2;
		Scanner in = new Scanner(System.in);
		int idade, idade2, dif;
		System.out.print("Informe o primeiro nome: ");
		Nome = in.nextLine();
		System.out.print("Informe o segundo nome: ");
		Nome2 = in.nextLine();
		System.out.println("Informe a primeira idade: ");
		idade = in.nextInt();
		System.out.println("Informe a segunda idade: ");
		idade2 = in.nextInt();
		
		dif = Math.abs(idade - idade2);
		System.out.println("A diferença das idades é igual a " + dif);
	}

}
