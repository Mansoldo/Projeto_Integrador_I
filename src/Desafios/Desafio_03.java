package Desafios;

import java.util.Scanner;

// @author Mansoldo
public class Desafio_03 {

    static Scanner leitor = new Scanner(System.in);

    public static String desafio_03(int entrada) {

        int opcao_desafio;
        String opcao_resposta;

        System.out.println("-----CÓDIGO-----");
        System.out.println("public class Teste_03 {\n"
                + "\n"
                + "    public static void main(String[] args) {\n"
                + "\n"
                + "        Scanner leitor = new Scanner(System.in);\n"
                + "\n"
                + "        int num, resultado, pos_anterior = 1, pos_atual;\n"
                + "\n"
                + "        do {\n"
                + "\n"
                + "            System.out.println(\"Digite um número inteiro entre 0 e 46: \");\n"
                + "            num = leitor.nextInt();\n"
                + "\n"
                + "        } while (num < 0 || num > 46);\n"
                + "\n"
                + "        for (int controle = 1; controle <= num; controle++) {\n"
                + "\n"
                + "            resultado = pos_anterior + pos_atual; \n"
                + "            pos_anterior = pos_atual; \n"
                + "            pos_atual = resultado; \n"
                + "            \n"
                + "            System.out.print(resultado + \" \");\n"
                + "\n"
                + "        }\n"
                + "\n"
                + "        leitor.close();\n"
                + "\n"
                + "    }\n"
                + "}");
        System.out.println("Dado o trecho de código acima, identifique a falha pontual que está impedindo o programa de ser executado.");
        System.out.println("Qual das opções são verdadeiras? \n\n"
                + "I - Ao digitar um valor fora do estabelecido no laço DO/WHILE, ele entra em loop infinito;\n"
                + "II - As variáveis utilizadas para imprimir a sequência Fibonacci estão fora de ordem;\n"
                + "III - Não foram inicializadas as variáveis corretamente;\n"
                + "IV - Ausência de pontução.\n");
        System.out.println("1) Opções I,II - Corretas \n"
                + "2) Opções I,IV - Corretas \n"
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

        String validacao_resposta = desafio_03(resposta);
        System.out.println(validacao_resposta);

    }

}
