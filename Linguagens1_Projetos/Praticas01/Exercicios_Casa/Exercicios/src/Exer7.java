import java.util.Scanner;
public class Exer7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Informe um valor");
		char[] algarismos = null;
		Scanner in = new Scanner(System.in);
		String numero = in.nextLine();
		int soma = 0;
		algarismos = numero.toCharArray();
		for(int i=0;i< numero.length(); i++) {
			int a = Character.getNumericValue(algarismos[i]);
			soma = soma+ a;
			
		}
		System.out.println("Esta é a soma de seus algarismos: " + soma);
	}

}
