package Desafios;

import java.util.Scanner;

// @author Mansoldo
public class Desafio_07 {

    static Scanner leitor = new Scanner(System.in);

    public static String desafio_07(int entrada) {

        int opcao_desafio;
        String opcao_resposta;

        System.out.println("-----CÓDIGO-----");
        System.out.println("\n"
                + "package java_course_1;\n"
                + "import java.util.Locale;\n"
                + "import java.util.Scanner;\n"
                + "\n"
                + " //@author Mansoldo\n"
                + " \n"
                + "public class Program {\n"
                + "\n"
                + "    public static void main(String[] args) {\n"
                + "\n"
                + "        Scanner leitor = new Scanner(System.in);\n"
                + "        Locale.setDefault(Locale.US);\n"
                + "\n"
                + "        System.out.println(\"Entre com a altura e base de um triângulo\");\n"
                + "        double altura = leitor.nextDouble();\n"
                + "        double base = leitor.nextDouble();\n"
                + "\n"
                + "        double retangulo = area_funcao(altura, base);\n"
                + "        double perimetro = perimetro_funcao(altura, base);\n"
                + "        double diagonal = diagonal_funcao(altura, base);\n"
                + "\n"
                + "        System.out.println(\"AREA = %.2f%n\", retangulo);\n"
                + "        System.out.println(\"PERIMETER = %.2f%n\", perimetro);\n"
                + "        System.out.println(\"DIAGONAL = %.2f%n\", diagonal);\n"
                + "\n"
                + "        leitor.close();\n"
                + "\n"
                + "    }\n"
                + "\n"
                + "    static public double area_funcao(double a, double b) {\n"
                + "        return a * b;\n"
                + "    }\n"
                + "\n"
                + "    static public double perimetro_funcao(double a, double b) {\n"
                + "        return 2 * (a + b);\n"
                + "    }\n"
                + "\n"
                + "    static public double diagonal_funcao(double a, double b) {\n"
                + "        return Math.sqrt(a * a + b * b);\n"
                + "    }\n"
                + "\n"
                + "}");
        System.out.println("Análise o trecho de código acima, e verifique dentre as opções abaixo qual a verdadeira: ");
        System.out.println("\n"
                + "I - Será gerado erro na saída, pois não foi especificado a impressão de formatação do print;\n"
                + "II - Ausência de pontuação;\n"
                + "III - Não foi especificado nenhuma variável para que haja retorno das funções;\n"
                + "IV - Função matemática aplicada erroneamente.\n");
        System.out.println("1) Opções I,III - Corretas \n"
                + "2) Opções II,III - Corretas \n"
                + "3) Apenas Opção I \n"
                + "4) Apenas Opção IV");

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

        String validacao_resposta = desafio_07(resposta);
        System.out.println(validacao_resposta);

    }

}
