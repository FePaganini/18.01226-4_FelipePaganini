import java.util.Scanner;
public class Exer4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String frase;
		System.out.println("Escreva uma frase: ");
		frase = in.nextLine();
		StringBuffer palin = new StringBuffer();
		for(int i = frase.length()-1; i>= 0; i--) {
			 palin.append(frase.charAt(i));
		}
		if(frase.equals(palin.toString())) {
			System.out.println("String � palindromo");
		}
		else {
			System.out.println("String n�o � palindromo");
		}
		System.out.print("Frase: "+ frase +"\n Frase invertida: "+palin);
		
	}

}
