package br.maua.implemetacoes.arquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TesteEscrita {
    public static void main(String[] args) {
        //Cria um arquivo
        File file = new File("nome.txt");
        try{
            //Cria uma conexão para escrever no arquivo
            FileWriter fileWriter = new FileWriter(file);
            //Cria um buffer de writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //Escrever algo no arquivo
            bufferedWriter.write("Olá Mundo Arquivos\n");
            bufferedWriter.write("2+2 = "+ (2+2) +"\n");
            bufferedWriter.write("Vegeta é o cara\n");
            //Força escrita na hora : bufferedWriter.flush()

            //Fecha o buufer e escreve no arquivo
            bufferedWriter.close();
        }
        catch(Exception e){
            System.out.println("Deu ruim");
            e.printStackTrace();
        }

    }
}
