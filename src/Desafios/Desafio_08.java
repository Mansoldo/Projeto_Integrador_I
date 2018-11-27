package Desafios;
// @author Mansoldo

import java.util.Scanner;

public class Desafio_08 {

    static Scanner leitor = new Scanner(System.in);

    public static String desafio_08(int entrada) {

        int opcao_desafio;
        String opcao_resposta;

        System.out.println("-----CÓDIGO-----");
        System.out.println("package Desafios;\n"
                + "\n"
                + "import java.util.Scanner;\n"
                + "\n"
                + "// @author Mansoldo\n"
                + "public class Teste {\n"
                + "\n"
                + "    static Scanner leitor = new Scanner(System.in);\n"
                + "\n"
                + "    public static void main(String[] args) {\n"
                + "\n"
                + "        System.out.println(\"Verifique o cardápio, e escolha uma das opções: \\n\");\n"
                + "\n"
                + "        int menu_opcao = 0;\n"
                + "\n"
                + "        do {\n"
                + "            System.out.println(\"Cardápio\\n\"\n"
                + "                    + \"1 - Prato executivo do dia\\n\"\n"
                + "                    + \"2 - Prato econômico do dia\\n\"\n"
                + "                    + \"3 - Lanches\\n\"\n"
                + "                    + \"4 - Bebidas\\n\"\n"
                + "                    + \"5 - Não quero nada!\");\n"
                + "            menu_opcao = leitor.nextInt();\n"
                + "\n"
                + "            switch (menu_opcao) {\n"
                + "\n"
                + "                case 1:                    \n"
                + "                    System.out.println(\"Arroz, Batata Frita e filé de frango.\\n\");\n"
                + "                    menu_opcao = 5;\n"
                + "                    break;\n"
                + "                    \n"
                + "                case 2:\n"
                + "                    System.out.println(\"Ovo frito com salsicha.\\n\");\n"
                + "                    menu_opcao = 5;\n"
                + "                    break;\n"
                + "                    \n"
                + "                case 3:\n"
                + "                    System.out.println(\"X-burguer simples.\\n\");\n"
                + "                    menu_opcao = 5;\n"
                + "                    break;\n"
                + "                    \n"
                + "                case 4:\n"
                + "                    System.out.println(\"Suco de laranja.\\n\");\n"
                + "                    menu_opcao = 5;\n"
                + "                    break;\n"
                + "                default:\n"
                + "\n"
                + "                        System.out.println(\"Opção inválida\");\n"
                + "            }\n"
                + "\n"
                + "        } while (menu_opcao != 5);\n"
                + "\n"
                + "        System.out.println(\"Você largou o cardápio!\");\n"
                + "\n"
                + "        leitor.close();\n"
                + "    }\n"
                + "\n"
                + "}\n"
                + "");
        
        System.out.println("Verificando o trecho de código acima, identifique a opção verdadeira e aponte-a em umas das opções abaixo: \n\n"
                + "1) A criação da variável menu_opcao tem que ser obrigatoriamente criada dentro do laço do/while.\n"
                + "2) Atribuição do valor 5 na variável menu_opcao dentro dos cases, faz com que o laço não finalize.\n"
                + "3) Ausência do break na opção Default ocasiona falha de compilação.\n"
                + "4) Não foi realizado tratamento na opção Default, fazendo que sempre seja impresso Opção Inválida mesmo digitando um número válido.");
        
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

        String validacao_resposta = desafio_08(resposta);
        System.out.println(validacao_resposta);

    }

}
