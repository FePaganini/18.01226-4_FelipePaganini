package model;

import dao.AnimeDAO;
import dao.MangaDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Sistema {

    private int opcao = 1;
    Scanner scanner = new Scanner(System.in);
    private String nome;
    private AnimeList animeList = new AnimeList();
    private MangaList mangaList = new MangaList();
    private AnimeDAO animeDAO = new AnimeDAO();
    private MangaDAO mangaDAO = new MangaDAO();

    public void menu(){
        System.out.println("--- MENU ---");
        System.out.println("1- Procurar Anime\n2- Procurar Manga\n3- Visualizar Lista de Animes" +
                "\n4- Visualizar Lista de Mangas\n0- Fechar o Sistema");
        System.out.print("Insira sua opção: ");
    }

    public void rodar() {
        while (opcao != 0) {
            menu();
            while (true) {
                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                    while (opcao > 4 || opcao < 0) {
                        System.out.print("Insira uma opção válida: ");
                        opcao = Integer.parseInt(scanner.nextLine());
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Insira uma opção válida: ");
                }
            }
            switch (opcao) {
                case 1:
                    System.out.print("Insira o nome do Anime: ");
                    nome = scanner.nextLine();
                    break;
                case 2:
                    break;
                case 3:
                    animeList.animeList = animeDAO.getAll();
                    if(animeList.animeList.isEmpty()){
                        System.out.println("Lista de Animes está vazia!\n");
                    }
                    else{
                        System.out.println("Lista de Animes:");
                        animeList.animeList.forEach(anime -> System.out.println(anime));
                        System.out.println("");
                    }
                    break;
                case 4:
                    mangaList.mangaList = mangaDAO.getAll();
                    if(mangaList.mangaList.isEmpty()){
                        System.out.println("Lista de Mangas está vazia!\n");
                    }
                    else{
                        System.out.println("Lista de Mangas:");
                        mangaList.mangaList.forEach(manga -> System.out.println(manga));
                        System.out.println("");
                    }
                    break;
            }
        }
        System.exit(0);
    }

    private static String leituraAnime(String nome) throws Exception{
        URL url = new URL("https://api.jikan.moe/v3/search/anime?q=" + nome);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String result;
        StringBuffer content = new StringBuffer();
        while((result=in.readLine()) != null){
            content.append(result);
        }
        in.close();
        return content.toString();
    }
}
