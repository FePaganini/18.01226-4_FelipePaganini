// Felipe dos Santos Paganini   18.01226-4
import java.util.Random;

public class Transacao {
	
	public static String geraQR(Conta conta,double valor){
		return (conta.getId()+";"+conta.getUsuario().getNome()+";"+ valor +";"+Transacao.getRandomNumberInRange(1000, 9999));
		
	}
	public static void novaTransferencia(Conta pagador,Conta receptor, String qr){
		String s = qr;
		String[] dados = s.split(";");
		if((receptor.getId().equals(dados[0]))&& (receptor.getUsuario().getNome().equals(dados[1]))){
			double valor = Double.parseDouble(dados[2]);
			pagador.sacar(valor);
			receptor.depositar(valor);
		}
	}
	private static int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max-min)+1) + min;
	}
	
}
