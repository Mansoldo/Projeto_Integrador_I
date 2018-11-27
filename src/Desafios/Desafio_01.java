package Desafios;

import java.util.Scanner;

// @author Mansoldo
public class Desafio_01 {
    
    static Scanner leitor = new Scanner(System.in);

    public static String desafio_01(int entrada) {        

        int opcao_desafio;
        String opcao_resposta;

        System.out.println("-----CÓDIGO-----");
        System.out.println("public class Teste_01 {\n"
                + "\n"
                + "    public static void main(String[] args) {\n"
                + "\n"
                + "        Scanner leitor = new Scanner(System.in);\n"
                + "\n"
                + "        System.out.println(\"Digite um número: \");\n"
                + "        int num1 = leitor.nextInt();\n"
                + "\n"
                + "        System.out.println(\"Digite outro número: \");\n"
                + "        int num2 = leitor.nextInt();\n"
                + "\n"
                + "        System.out.println(\"Digite outro número: \");\n"
                + "        int num3 = leitor.nextInt();\n"
                + "\n"
                + "        int resultado = maximo(num1, num2, num3);\n"
                + "\n"
                + "        System.out.println(\"O maior número é: \" + resultado);\n"
                + "\n"
                + "        leitor.close();\n"
                + "\n"
                + "    }\n"
                + "\n"
                + "    public static double maximo(int a, int b, int c) {\n"
                + "        int auxiliar;\n"
                + "        if (a > b && a > b) {\n"
                + "            auxiliar = a;\n"
                + "\n"
                + "        } else if (b > c) {\n"
                + "            auxiliar = b;\n"
                + "        } else {\n"
                + "            auxiliar = c;\n"
                + "\n"
                + "        }\n"
                + "        return auxiliar;\n"
                + "\n"
                + "    }\n"
                + "\n"
                + "}");

        System.out.println("Verificando o trecho de código acima, identifique a falha e aponte-a em umas das opções abaixo: \n"
                + "1) A chamada de variáveis dentro da função.\n"
                + "2) Incompatibilidade de tipos de variáveis ao atribuir valor a variável resultado.\n"
                + "3) Sintaxe incorreta de impressão de dados\n"
                + "4) Ausência de pontuação");

        opcao_desafio = leitor.nextInt();

        switch (opcao_desafio) {

            case 1:
                opcao_resposta = "Errado";
                break;
            case 2:
                opcao_resposta = "Certo";
                break;
            case 3:
                opcao_resposta = "Errado";
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
        
        String validacao_resposta = desafio_01(resposta);
        System.out.println(validacao_resposta);
        
        
    }

}
