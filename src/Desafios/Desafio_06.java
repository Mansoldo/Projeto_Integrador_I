package Desafios;

import java.util.Scanner;
// @author Mansoldo

public class Desafio_06 {

    static Scanner leitor = new Scanner(System.in);

    public static String desafio_06(int entrada) {

        int opcao_desafio;
        String opcao_resposta;

        System.out.println("-----CÓDIGO-----");
        System.out.println("package Entities;\n"
                + "// @author Mansoldo\n"
                + "public class CurrencyConverter {\n"
                + "\n"
                + "    public static final double IOF = 0.06;\n"
                + "\n"
                + "    public static double dollarReal(double preco, double qtd_dollar) {\n"
                + "\n"
                + "        return preco * qtd_dollar * (1 + IOF);\n"
                + "    }\n"
                + "\n"
                + "}");
        System.out.println("package java_course;\n"
                + "\n"
                + "import java.util.Locale;\n"
                + "import java.util.Scanner;\n"                
                + "\n"
                + "// @author Mansoldo\n"
                + "public class Conversao_dolar {\n"
                + "\n"
                + "    public static void main(String[] args) {\n"
                + "\n"
                + "        Scanner leitor = new Scanner(System.in);\n"
                + "        Locale.setDefault(Locale.US);\n"
                + "        \n"
                + "        System.out.println(\"Qual o valor do dólar\");\n"
                + "        double dolar_price = leitor.nextDouble();\n"
                + "        \n"
                + "        System.out.println(\"Quantos dólares serão comprados? \");\n"
                + "        double qtd_dollar = leitor.nextDouble();\n"
                + "        \n"
                + "        double resultado = CurrencyConverter.dollarReal(dolar_price, qtd_dollar);\n"
                + "        \n"
                + "        System.out.printf(\"Quantidade a ser pago em reais: %.2f%n\", resultado);\n"
                + "\n"
                + "        leitor.close();\n"
                + "    }\n"
                + "\n"
                + "}");
        System.out.println("Ao executar o techo de código acima, verificou-se o erro Exception in thread \"main\" java.lang.RuntimeException: Uncompilable source code\n"
                + "Dentre as opções abaixo, aponte qual o motivo do erro: ");
        System.out.println("\n"
                + "1) A função dollarReal retornou um valor incompatível com o tipo da variável que vai receber o retorno do método.\n"
                + "2) Não foi realizado a importação do pacote da classe CurrencyConverter.\n"
                + "3) O cálculo realizado dentro da função está incorreto.\n"
                + "4) Ocorreu o erro devido a definição de configuração de formatação para US.");

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

        String validacao_resposta = desafio_06(resposta);
        System.out.println(validacao_resposta);

    }

}
