import java.util.Scanner;

public class Exer6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int i,f,intervalo;
		System.out.println("Informe o valor inicial da sequência: ");
		i = in.nextInt();
		System.out.println("Informe o valor final da sequência: ");
		f = in.nextInt();
		intervalo = f - i;
		int[] var = new int[intervalo+1];
		int[] soma = new int[intervalo+1];
		int[] prod = new int[intervalo+1];
		for(int a = 1; a<= intervalo; a++) {
			var[0] = i;
			prod[0] = i;
			soma[0] = i;
			var[a] = var[a-1]+1;
			soma[a] = var[a] + soma[a-1] ;
			prod[a] = prod[a-1]*var[a];
 		}
		System.out.println("A somatória é " + soma[intervalo] + " e o produto é "+ prod[intervalo]);
		
	}

}
