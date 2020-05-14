package br.com.bootcamp.jogo;

import java.util.Random;
import java.util.Scanner;

public class JogoForca {

    private static String [] dica;
    private static int qtdLetras = 0;
    private static int vida = 6;

    public static void main (String[] args){
        String palavraChave = null;
        System.out.println("Qual nivel de dificuldade? D(Dificil); N(Normal); F(Facil) --> ");
        Scanner in = new Scanner (System.in);
        String dificuldade = in.next().toUpperCase();

        switch (dificuldade) {
            case "D":
                palavraChave = listaPalavraDificil();
                break;
            case "N":
                palavraChave = listaPalavraNormal();
                break;
            case "F":
                palavraChave = listaPalavraFacil();
                break;
            default:
                palavraChave = "";
                System.out.print("Nenhuma letra válda!!");
                vida = 0;
                break;
        }


        String ListaEmString = "";
        montaDica(palavraChave.length());

        for(String s : dica){
            ListaEmString = ListaEmString + s;
        }

        System.out.println(ListaEmString);

        while (vida > 0) {
            System.out.println("Qual letra você escolhe? -->");
            String letraDigitada = in.next().toLowerCase();
            String[] listaLetrasCorretas = palavraChave.split("");

            int i = 0;
            int acertouLetra = 0;
            qtdLetras = palavraChave.length();
            while (i < qtdLetras) {
                if (listaLetrasCorretas[i].equals(letraDigitada)) {
                    dica[i] = letraDigitada;
                    //* quero remover o item "__" que esta na posição i atual para colocar "letraDigitada no lugar"
                    acertouLetra++;
                }
                i++;
            }
            if (acertouLetra == 0) {
                vida--;
                System.out.println("Você errou a letra, perdeu um de vida, agora tem " + vida + " de vida");
            }

            String novaDica = "";

            for (String s : dica) {
                novaDica += s;
            }

            System.out.println(novaDica);

            if (palavraChave.equals(novaDica)){
                System.out.println("Voce ganhou!");
                break;
            }

        }

        System.out.println("Fim de jogo!");


    }

    public static String[] montaDica (int qdtLetras){
        dica = new String[qdtLetras];
        for (int i = 0; i < dica.length; i++){
            dica[i] = " __ ";
        }
        return dica;
    }

    public static String listaPalavraDificil(){
        String[] palavras  = {"carambola","jatoba","melancia"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length)];
    }

    public static String listaPalavraNormal(){
        String[] palavras  = {"laranja","melao","maca"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length)];
    }

    public static String listaPalavraFacil(){
        String[] palavras  = {"banana","uva","abacate"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length)];
    }

}
