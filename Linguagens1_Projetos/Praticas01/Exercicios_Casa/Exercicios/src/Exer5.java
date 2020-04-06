import java.util.Scanner;

public class Exer5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n;
		System.out.print("Indique o termo que você quer de Fibonacci: ");
		n = in.nextInt();
		int[] Fibo = new int[n];

		if(n == 1) {
			Fibo[0] = 0;
			System.out.println("O termo que você quer é: " + Fibo[n-1]);
		}
		else if(n == 2) {
			Fibo[1] = 1;
			System.out.println("O termo que você quer é: " + Fibo[n-1]);
		}
		else{
			for(int i = 2; i <= n-1; i++) {
				Fibo[0]= 0;
				Fibo[1] = 1;
				Fibo[i] = Fibo[i-2] + Fibo[i-1];
							
		}
			System.out.println("O termo que você quer é: " + Fibo[n-1]);
		}
		
	}

}
