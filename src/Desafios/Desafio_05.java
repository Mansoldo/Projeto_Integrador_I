package Desafios;

import java.util.Scanner;

// @author Mansoldo
//Verificação de números pares em um intervalo dado pelo usuário e guarda numa matriz
public class Desafio_05 {

    static Scanner leitor = new Scanner(System.in);

    public static String desafio_05(int entrada) {

        int opcao_desafio;
        String opcao_resposta;

        System.out.println("-----CÓDIGO-----");
        System.out.println("package aula_8_arrays;\n"
                + "\n"
                + "import java.util.Scanner;\n"
                + "\n"
                + "// @author Mansoldo\n"
                + "public class Exercicio_04 {\n"
                + "\n"
                + "    static Scanner leitor = new Scanner(System.in);\n"
                + "    static int tamanho_vetor = 5;\n"
                + "\n"
                + "    public static void main(String[] args) {\n"
                + "\n"
                + "        int num = 0, num1 = 0;\n"
                + "\n"
                + "        do {\n"
                + "            System.out.println(\"Digite o número inicial: \");\n"
                + "            num = leitor.nextInt();\n"
                + "\n"
                + "            System.out.println(\"Digite o número final: \");\n"
                + "            num1 = leitor.nextInt();\n"
                + "\n"
                + "        } while (num > num1);\n"
                + "\n"
                + "        int[] vetor_resposta = funcao_par_armazenado(num, num1);\n"
                + "\n"
                + "        for (int controle = 0; controle < vetor_resposta.length; controle++) {\n"
                + "            System.out.print(\"\");\n"
                + "            if (vetor_resposta[controle] != 0) {\n"
                + "                System.out.print(vetor_resposta[controle] + \" \");\n"
                + "            } else {\n"
                + "                System.out.print(\"\");\n"
                + "            }\n"
                + "\n"
                + "        }\n"
                + "\n"
                + "        leitor.close();\n"
                + "    }\n"
                + "\n"
                + "    public static int[] funcao_par_armazenado(int num_inicial, int num_final) {\n"
                + "\n"
                + "        int[] vetor_par;\n"
                + "        vetor_par = new int[tamanho_vetor];\n"
                + "        int i = 0;\n"
                + "\n"
                + "        for (int controle = num_inicial; controle <= num_final; controle++) {\n"
                + "\n"
                + "            if (controle % 2 == 0) {\n"
                + "\n"
                + "                vetor_par[i] = controle;\n"
                + "                i++;\n"
                + "            }\n"
                + "        }\n"
                + "        return vetor_par;\n"
                + "    }\n"
                + "\n"
                + "}");
        System.out.println("Ao executar o techo de código acima, verificou-se o erro Exception in thread \"main\" java.lang.ArrayIndexOutOfBoundsException.\n"
                + "Dentre as opções abaixo, aponte qual o motivo do erro: ");
        System.out.println("\n"
                + "1) O tamanho da array foi especificado incorretamente.\n"
                + "2) Ao imprimir os valores pares, houve falha na concatenação.\n"
                + "3) O intervalo digitado pelo usuário estourou o tamanho máximo da array ao conferir os números pares.\n"
                + "4) O retorno da função devolveu valores incorretos.");

        opcao_desafio = leitor.nextInt();

        switch (opcao_desafio) {
            case 1:
                opcao_resposta = "Errado";
                break;
            case 2:
                opcao_resposta = "Errado";
                break;
            case 3:
                opcao_resposta = "Certo";
                break;
            case 4:
                opcao_resposta = "Errado";
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

        String validacao_resposta = desafio_05(resposta);
        System.out.println(validacao_resposta);
    }

}
