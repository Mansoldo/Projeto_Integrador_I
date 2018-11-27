package Desafios;

import java.util.Scanner;
// @author Mansoldo

public class Desafio_04 {

    static Scanner leitor = new Scanner(System.in);

    public static String desafio_04(int entrada) {

        int opcao_desafio;
        String opcao_resposta;

        System.out.println("-----CÓDIGO-----");
        System.out.println("package exercicios_matrizes;\n"
                + "\n"
                + "import java.util.Scanner;\n"
                + "/*\n"
                + "1 - Faça um programa para somar duas matrizes.\n"
                + " */\n"
                + "public class Exercicio_1 {\n"
                + "\n"
                + "    public static void main(String[] args) {\n"
                + "\n"
                + "        Scanner leitor = new Scanner(System.in);\n"
                + "\n"
                + "        int[][] matriz_1 = new int[2][4];\n"
                + "        int[][] matriz_2 = new int[2][4];\n"
                + "\n"
                + "        for (int controle = 0; controle < 2; controle++) {\n"
                + "\n"
                + "            System.out.println(\"Informe os valores da linha \" + (controle + 1) + \" da Matriz 1: \");\n"
                + "\n"
                + "            for (int controle1 = 0; controle1 < 4; controle1++) {\n"
                + "                System.out.println(\"Coluna \" + (controle1 + 1) + \": \");\n"
                + "                matriz_1[controle][controle1] = leitor.nextInt();\n"
                + "            }\n"
                + "        }\n"
                + "\n"
                + "        for (int controle = 0; controle < 2; controle++) {\n"
                + "\n"
                + "            System.out.println(\"Informe os valores da linha \" + (controle + 1) + \" da Matriz 2: \");\n"
                + "\n"
                + "            for (int controle1 = 0; controle1 < 4; controle1++) {\n"
                + "                System.out.println(\"Coluna \" + (controle1 + 1) + \": \");\n"
                + "                matriz_2[controle][controle1] = leitor.nextInt();\n"
                + "            }\n"
                + "        }\n"
                + "\n"
                + "        System.out.println(\"\");\n"
                + "\n"
                + "        for (int controle = 0; controle < 2; controle++) {\n"
                + "\n"
                + "            System.out.println(\"Linha \" + (controle + 1) + \": \");\n"
                + "\n"
                + "            for (int controle1 = 0; controle1 < 4; controle1++) {\n"
                + "\n"
                + "                matriz_resultado[controle][controle1] = matriz_1[controle][controle1] + matriz_2[controle][controle1];\n"
                + "\n"
                + "                System.out.print(matriz_resultado[controle][controle1] + \" \");\n"
                + "            }\n"
                + "            System.out.println(\"\");\n"
                + "        }\n"
                + "\n"
                + "    }\n"
                + "\n"
                + "}");
        System.out.println("Dado o trecho de código acima, identifique a falha pontual que está impedindo o programa de ser executado.");
        System.out.println("Qual das opções são verdadeiras? \n\n"
                + "I - As variáveis utilizadas para varrer as posições estão sendo utilizadas erroneamente;\n"
                + "II - Os laços utilizados para efetuar a leitura, e posteriormente guardar os valores estão incorretos;\n"
                + "III - Não foi criado a matriz para receber a soma de ambos as matrizes;\n"
                + "IV - Ausência de pontução.\n");
        System.out.println("1) Opções I,II - Corretas \n"
                + "2) Opções II,III - Corretas \n"
                + "3) Opções I,III,IV - Corretas \n"
                + "4) Apenas Opção III");

        opcao_desafio = leitor.nextInt();

        switch (opcao_desafio) {
            case 1:
                opcao_resposta = "Errado";
                break;
            case 2:
                opcao_resposta = "Errado";
                break;
            case 3:
                opcao_resposta = "Errado";
                break;
            case 4:
                opcao_resposta = "Certo";
                break;
            default:
                System.out.println("Resposta inválida, portanto, considerado errado.");
                opcao_resposta = "Errado";
                break;
        }
        return opcao_resposta;

    }

    public static void main(String[] args) {

        System.out.println("Verificação de Desafio: ");
        int resposta = leitor.nextInt();

        String validacao_resposta = desafio_04(resposta);
        System.out.println(validacao_resposta);

    }

}
