package projeto_rpg;

import java.util.Random;
import java.util.Scanner;

public class Projeto_RPG {

    public static int opcao; //variável global da opção do menu
    static int[] vetor_desafios = new int[8]; // variável global da criação do vetor para armazenar os desafios já utilizados
    static int pos = 0; //variável utilizada para armazenar o posicionamento do desafio dentro da função de validação do vetor
    static boolean valida_vetor; //variável que retorna True ou False do número gerado pela função random_desafios
    //static boolean valida_vida;
    static int vida = 3; // variável com a quantidade de vida do usuário
    static int certo = 0; //variável que armazena quantas questões foram acertadas
    static int errado = 0; //variável que armazena quantas questões foram erradas
    static int laco = 0; //variável para controlar o número de vezes que vai chamar os desafios
    static String nome_player = null; //variável para setar o nome do jogador

    static Scanner leitor = new Scanner(System.in);

    //método do menu do jogo
    public static void menu_jogo() {

        //menu contendo as 4 opções do jogo
        System.out.println("|----------------------------------------------------|");
        System.out.println("|-------------------- 1 - Jogar ---------------------|");
        System.out.println("|-------------------- 2 - Instruções ----------------|");
        System.out.println("|-------------------- 3 - Créditos ------------------|");
        System.out.println("|-------------------- 4 - Saída ---------------------|");
        System.out.println("|----------------------------------------------------|");

        opcao = leitor.nextInt();

        //caso seja inserido algum número diferente destes, retorna opção inválida, e pede para selecionar novamente fazendo a chamada do método novamente
        if (opcao > 4 || opcao < 1) {

            while (opcao != 1 || opcao != 2 || opcao != 3 || opcao != 4) {

                System.out.println("Opção Inválida!\nEscolha uma opção válida!");
                menu_jogo();
                opcao = leitor.nextInt();
            }
        }

        switch (opcao) {

            //método para "limpar" a tela, e chamar o início do jogo
            case 1:
                limpar_tela();
                inicio_jogo();
                break;
            //método para "limpar" a tela, e chamar as instruções do jogo
            case 2:
                limpar_tela();
                instruções_jogo();
                break;
            //método para "limpar" a tela, e chamar o crédito do jogo
            case 3:
                limpar_tela();
                creditos_jogo();
                break;
            //se for igual a 4, apenas sai do jogo
            default:
                if (opcao == 4) {
                    limpar_tela();
                    saida_jogo();

                }
                break;
        }
    }

    //médoto do início, onde insereo o nome do jogador e passa para a função de desafios
    public static void inicio_jogo() {
        System.out.println("Insira o nome do jogador(a): ");
        nome_player = leitor.next();
        System.out.println("");
        System.out.println("Um aluno da universidade (Senac), especificamente do curso de Tecnologia em Analise e Desenvolvimento - TADS de Sistemas encontra-se com dificuldade na matéria de Algoritmos.\n"
                + "Sendo assim, conversando com seu professor a respeito dessa dificuldade, o professor lhe propõe um exame contendo 8 desafios, onde se o aluno obtiver sucesso em 5 ou mais, será aprovado.");
        System.out.println("Professor:\n"
                + "- Tenho uma ideia para que você possa se sair bem em minha matéria.\n"
                + nome_player + ":\n"
                + "- Qual seria sua solução, professor?\n"
                + "Professor:\n"
                + "- Irei aplicar um trabalho a você envolvendo 8 exercícios. Faremos da seguinte maneira:\n"
                + "Você terá 3 vidas extras, como se fossem vidas em um jogo, se você acertar pelo menos 5 questões será aprovado em minha matéria.\n"
                + nome_player + ":\n"
                + "- Muito bem professor, irei aceitar seus desafios.\n"
                + "Professor:\n"
                + "- Pois bem, então vamos lá.");
        System.out.println("");
        funcao_desafios();
    }

    //função responsável para fazer a geração randômica dos desafios que devem ser mostrados ao jogador
    public static int random_desafios() {

        int desafio;

        Random aleatorio = new Random();
        desafio = aleatorio.nextInt(8) + 1;

        return desafio;
    }

    //função para conferir se o desafio já foi usado ou não. Quando utilizado, popula um vetor.
    public static Boolean validacao_vetor(int entrada) {

        //faz a leitura de todas as posições do vetor, e todas sendo verdadeiro, ele seta o número do desafio no vetor, e retorna verdadeiro
        if (entrada != vetor_desafios[0] && entrada != vetor_desafios[1] && entrada != vetor_desafios[2]
                && entrada != vetor_desafios[3] && entrada != vetor_desafios[4] && entrada != vetor_desafios[5]
                && entrada != vetor_desafios[6] && entrada != vetor_desafios[7]) {
            vetor_desafios[pos] = entrada;
            pos++;
            return true;

        } else {
            //senão retorna falso, e depois adiante, ele retorna para a função randômica para gerar número
            return false;
        }

    }

    //função que verifica quantas questões foram acertadas ou erradas. Também verifica se o jogador tem vida suficiente para prosseguir.
    public static Boolean status(String entrada) {

        //caso tenha acertado, ele incrementa a variável "certo" que servirá para dar uma estatística final
        if (entrada.equalsIgnoreCase("certa")) {

            certo += 1;

        } else {
            //o mesmo aplica-se para a variável "errado".
            errado += 1;
        }

        //enquanto retornar true, o jogador poderá continuar jogando. A partir do momento ele tiver apenas 0 vida, então não poderá mais falhar.
        if (entrada.equalsIgnoreCase("errada") && vida >= 1) {

            vida -= 1;
            return true;

        } else if (entrada.equalsIgnoreCase("certa") && vida >= 0) {

            return true;

        } else {

            return false;
        }
    }

    //método de exibição de GAME OVER, significando que o jogador não tem mais vidas. 
    public static void game_over() {

        limpar_tela();
        System.out.println("GAME OVER");
        System.out.println("Parabéns, você não conseguiu superar os Desafios do professor X, "
                + "portanto, terá que cursar a disciplina novamente.");
        laco = 9; //Acrescenta o valor 9 na variável laço, pois ela quem faz o controle dentro do método dos Desafios
    }

    public static void funcao_desafios() {

        //enquanto o laço for menor que 8, continuará sendo executado até que todos os Desafios sejam mostrados
        do {
            boolean validacao_vida;
            String resposta;

            //chamada da função random_desafios que vai gerar um número aleatório entre 1 e 8
            int desafio = random_desafios();
            //depois esse número é validado na função de validação_vetor
            valida_vetor = validacao_vetor(desafio);

            //caso o número do desafio já tenha sido utilizado, então ele retorna para a função de random_desafios
            if (valida_vetor == false) {

                random_desafios();

            } else {

                //atribui-se o número para outra variável que será utilizado no Switch Case
                int numero_desafio = desafio;

                switch (numero_desafio) {

                    case 1:
                        //chama a função do primeiro desafio
                        resposta = desafio_01();
                        //confere se a resposta está certo ou errado
                        validacao_vida = status(resposta);

                        //em caso de retorno False, quer dizer que já foram utilizadas as 3 vidas extras do jogador e chama o método de GAME OVER.
                        if (validacao_vida == false) {

                            game_over();

                        } else {

                            limpar_tela();
                            System.out.println("");
                            System.out.println("|-------------------------------------|");
                            //senão indica que a resposta foi certa, e quantidade atual de vidas, além do incremento do laço
                            if(resposta.equalsIgnoreCase("certa")){
                                System.out.println("|Sua resposta foi " + resposta + " --------------|");
                            }else{
                                System.out.println("|Sua resposta foi " + resposta + " -------------|");
                            }                            
                            System.out.println("|Quantidade de vidas extras: " + vida + " -------|");
                            System.out.println("|-------------------------------------|");
                            System.out.println("");
                            laco++;
                        }

                        break;

                    case 2:
                        //chama a função do segundo desafio
                        resposta = desafio_02();
                        //confere se a resposta está certo ou errado
                        validacao_vida = status(resposta);

                        //em caso de retorno False, quer dizer que já foram utilizadas as 3 vidas extras do jogador e chama o método de GAME OVER.
                        if (validacao_vida == false) {

                            game_over();

                        } else {

                            limpar_tela();
                            System.out.println("");
                            System.out.println("|-------------------------------------|");
                            //senão indica que a resposta foi certa, e quantidade atual de vidas, além do incremento do laço
                            if(resposta.equalsIgnoreCase("certa")){
                                System.out.println("|Sua resposta foi " + resposta + " --------------|");
                            }else{
                                System.out.println("|Sua resposta foi " + resposta + " -------------|");
                            }                            
                            System.out.println("|Quantidade de vidas extras: " + vida + " -------|");
                            System.out.println("|-------------------------------------|");
                            System.out.println("");
                            laco++;
                        }

                        break;

                    case 3:
                        //chama a função do terceiro desafio
                        resposta = desafio_03();
                        //confere se a resposta está certo ou errado
                        validacao_vida = status(resposta);

                        //em caso de retorno False, quer dizer que já foram utilizadas as 3 vidas extras do jogador e chama o método de GAME OVER.
                        if (validacao_vida == false) {

                            game_over();

                        } else {

                            limpar_tela();
                            System.out.println("");
                            System.out.println("|-------------------------------------|");
                            //senão indica que a resposta foi certa, e quantidade atual de vidas, além do incremento do laço
                            if(resposta.equalsIgnoreCase("certa")){
                                System.out.println("|Sua resposta foi " + resposta + " --------------|");
                            }else{
                                System.out.println("|Sua resposta foi " + resposta + " -------------|");
                            }                            
                            System.out.println("|Quantidade de vidas extras: " + vida + " -------|");
                            System.out.println("|-------------------------------------|");
                            System.out.println("");
                            laco++;
                        }

                        break;

                    case 4:
                        //chama a função do quarto desafio
                        resposta = desafio_04();
                        //confere se a resposta está certo ou errado
                        validacao_vida = status(resposta);

                        //em caso de retorno False, quer dizer que já foram utilizadas as 3 vidas extras do jogador e chama o método de GAME OVER.
                        if (validacao_vida == false) {

                            game_over();

                        } else {

                            limpar_tela();
                            System.out.println("");
                            System.out.println("|-------------------------------------|");
                            //senão indica que a resposta foi certa, e quantidade atual de vidas, além do incremento do laço
                            if(resposta.equalsIgnoreCase("certa")){
                                System.out.println("|Sua resposta foi " + resposta + " --------------|");
                            }else{
                                System.out.println("|Sua resposta foi " + resposta + " -------------|");
                            }                            
                            System.out.println("|Quantidade de vidas extras: " + vida + " -------|");
                            System.out.println("|-------------------------------------|");
                            System.out.println("");
                            laco++;
                        }

                        break;

                    case 5:
                        //chama a função do quinto desafio
                        resposta = desafio_05();
                        //confere se a resposta está certo ou errado
                        validacao_vida = status(resposta);

                        //em caso de retorno False, quer dizer que já foram utilizadas as 3 vidas extras do jogador e chama o método de GAME OVER.
                        if (validacao_vida == false) {

                            game_over();

                        } else {

                            limpar_tela();
                            System.out.println("");
                            System.out.println("|-------------------------------------|");
                            //senão indica que a resposta foi certa, e quantidade atual de vidas, além do incremento do laço
                            if(resposta.equalsIgnoreCase("certa")){
                                System.out.println("|Sua resposta foi " + resposta + " --------------|");
                            }else{
                                System.out.println("|Sua resposta foi " + resposta + " -------------|");
                            }                            
                            System.out.println("|Quantidade de vidas extras: " + vida + " -------|");
                            System.out.println("|-------------------------------------|");
                            System.out.println("");
                            laco++;
                        }

                        break;

                    case 6:
                        //chama a função do sexto desafio
                        resposta = desafio_06();
                        //confere se a resposta está certo ou errado
                        validacao_vida = status(resposta);

                        //em caso de retorno False, quer dizer que já foram utilizadas as 3 vidas extras do jogador e chama o método de GAME OVER.
                        if (validacao_vida == false) {

                            game_over();

                        } else {

                            limpar_tela();
                            System.out.println("");
                            System.out.println("|-------------------------------------|");
                            //senão indica que a resposta foi certa, e quantidade atual de vidas, além do incremento do laço
                            if(resposta.equalsIgnoreCase("certa")){
                                System.out.println("|Sua resposta foi " + resposta + " --------------|");
                            }else{
                                System.out.println("|Sua resposta foi " + resposta + " -------------|");
                            }                            
                            System.out.println("|Quantidade de vidas extras: " + vida + " -------|");
                            System.out.println("|-------------------------------------|");
                            System.out.println("");
                            laco++;
                        }

                        break;

                    case 7:
                        //chama a função do sétimo desafio
                        resposta = desafio_07();
                        //confere se a resposta está certo ou errado
                        validacao_vida = status(resposta);

                        //em caso de retorno False, quer dizer que já foram utilizadas as 3 vidas extras do jogador e chama o método de GAME OVER.
                        if (validacao_vida == false) {

                            game_over();

                        } else {

                            limpar_tela();
                            System.out.println("");
                            System.out.println("|-------------------------------------|");
                            //senão indica que a resposta foi certa, e quantidade atual de vidas, além do incremento do laço
                            if(resposta.equalsIgnoreCase("certa")){
                                System.out.println("|Sua resposta foi " + resposta + " --------------|");
                            }else{
                                System.out.println("|Sua resposta foi " + resposta + " -------------|");
                            }                            
                            System.out.println("|Quantidade de vidas extras: " + vida + " -------|");
                            System.out.println("|-------------------------------------|");
                            System.out.println("");
                            laco++;
                        }

                        break;

                    case 8:
                        //chama a função do oitavo desafio
                        resposta = desafio_08();
                        //confere se a resposta está certo ou errado
                        validacao_vida = status(resposta);

                        //em caso de retorno False, quer dizer que já foram utilizadas as 3 vidas extras do jogador e chama o método de GAME OVER.
                        if (validacao_vida == false) {

                            game_over();

                        } else {

                            limpar_tela();
                            System.out.println("");
                            System.out.println("|-------------------------------------|");
                            //senão indica que a resposta foi certa, e quantidade atual de vidas, além do incremento do laço
                            if(resposta.equalsIgnoreCase("certa")){
                                System.out.println("|Sua resposta foi " + resposta + " --------------|");
                            }else{
                                System.out.println("|Sua resposta foi " + resposta + " -------------|");
                            }                            
                            System.out.println("|Quantidade de vidas extras: " + vida + " -------|");
                            System.out.println("|-------------------------------------|");
                            System.out.println("");
                            laco++;
                        }

                        break;
                }
            }
        } while (laco < 8);//condição de repetição. Enquanto for menor que 8 continuará sendo chamado
    }

    //Função do 1º desafio
    public static String desafio_01() {

        int opcao_desafio; //variável que será utilizada para o jogador escolher a opção
        String opcao_resposta; // variável que retornará se o jogador acertou ou errou o Desafio

        //trechos de diálogos da história
        System.out.println("Professor:\n"
                + "- Neste desafio aplicarei algumas condicionais e uso de função. Mostre-me o que aprendeu.\n"
                + "Em seu teste deverá analisar esse código e identificar o erro. Este código envolve Estruturas Condicionais sendo contemplando IF Else dentro de função. \n"
                + nome_player + ":\n"
                + "- Ok, professor.\n"
                + "Professor:\n"
                + "- Boa Sorte.");
        System.out.println("");
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
                + "        if (a > b && a > c) {\n"
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

        //possíveis opções
        switch (opcao_desafio) {

            case 1:
                opcao_resposta = "errada";
                break;
            case 2:
                opcao_resposta = "certa";
                break;
            case 3:
                opcao_resposta = "errada";
                break;
            case 4:
                opcao_resposta = "errada";
                break;
            default:
                //caso seja inserido qualquer outra opção, será considerado errado
                System.out.println("Resposta inválida, portanto, considerado errado.");
                opcao_resposta = "errada";
                break;

        }

        return opcao_resposta; //retorno da opção certa ou errado
    }

    //Função do 2º desafio
    public static String desafio_02() {

        int opcao_desafio; //variável que será utilizada para o jogador escolher a opção
        String opcao_resposta; // variável que retornará se o jogador acertou ou errou o Desafio

        //trechos de diálogos da história
        System.out.println("Professor:\n"
                + "- Muito bem, vou aplicar esse trecho de código.\n"
                + "Neste desafio será testado seus conhecimentos em Estruturas Condicionais envolvendo Switch Case onde o código será apresentado e deverá ser analisado.\n"
                + "Veremos como irá se sair nessa.\n"
                + nome_player + ":\n"
                + "- Mostre-me como está o código!");
        System.out.println("");
        System.out.println("-----CÓDIGO-----");
        System.out.println("1.	package desafio_2;\n"
                + "2.	\n"
                + "3.	import java.Scanner;"
                + "4.	\n"
                + "5.	public class Teste_02 {\n"
                + "6.	\n"
                + "7.	    public static void main(String[] args) {\n"
                + "8.	        Scanner scr = new Scanner(System.in);\n"
                + "9.	        System.out.println(\"Digite o dia da Semana: \");\n"
                + "10.	        int semana = scr.nextInt();\n"
                + "11.	        switch (semana) {\n"
                + "12.	            case 1:\n"
                + "13.	                System.out.println(\"Hojé é Domingo\");\n"
                + "14.	                break;\n"
                + "15.	            case 2:\n"
                + "16.	                System.out.println(\"Hojé é Segunda\");\n"
                + "17.	                break;\n"
                + "18.	            case 3:\n"
                + "19.	                System.out.println(\"Hojé é Terça\");\n"
                + "20.	                break;\n"
                + "21.	            case 4:\n"
                + "22.	                System.out.println(\"Hojé é Quarta\");\n"
                + "23.	                break;\n"
                + "24.	            case 5:\n"
                + "25.	                System.out.println(\"Hojé é Quinta\");\n"
                + "26.	                break;\n"
                + "27.	            case 6:\n"
                + "28.	                System.out.println(\"Hojé é Sexta\");\n"
                + "29.	                break;\n"
                + "30.	            case 7:\n"
                + "31.	                System.out.println(\"Hojé é Sabado\");\n"
                + "32.	                break;\n"
                + "33.	        }\n"
                + "34.	    }\n"
                + "35.	\n"
                + "36.	}");
        System.out.println("Ao contrário do If, o Switch é usado para opções de respostas pré determinada.");
        System.out.println("Quais das seguintes informações são verdadeiras? \n"
                + "I - Está Faltando um Default para informar quando nenhuma das minhas opções no Switch for digitada. \n"
                + "II - Não Foi efetuado a Chamada da Biblioteca JAVA.UTIL no código imposibilitando a leitura de dados. \n"
                + "III - O código está sem nenhum ponto e virgula no final dos comandos.");
        System.out.println("1) Opções I,II - Corretas \n"
                + "2) Opções I,III - Corretas \n"
                + "3) Opções I,II,III Corretas \n"
                + "4) Apenas Opção III");
        opcao_desafio = leitor.nextInt();

        //possíveis opções
        switch (opcao_desafio) {
            case 1:
                opcao_resposta = "certa";
                break;
            case 2:
                opcao_resposta = "errada";
                break;
            case 3:
                opcao_resposta = "errada";
                break;
            case 4:
                opcao_resposta = "errada";
                break;
            default:
                //caso seja inserido qualquer outra opção, será considerado errado
                System.out.println("Resposta inválida, portanto, considerado errado.");
                opcao_resposta = "errada";
                break;
        }

        //retorno da opção certa ou errado
        return (opcao_resposta);

    }

    //Função do 3º desafio
    public static String desafio_03() {

        int opcao_desafio; //variável que será utilizada para o jogador escolher a opção
        String opcao_resposta; // variável que retornará se o jogador acertou ou errou o Desafio

        //trechos de diálogos da história
        System.out.println("Professor:\n"
                + "- Esse desafio será um pouco difícil.\n"
                + "Irei testá-lo neste código para que ache a falha pontual que impede o programa de ser executado.\n"
                + "Informe qual das opções é verdadeira, lembre-se que se errar será descontado de suas vidas.\n"
                + nome_player + ":\n"
                + "- Irei me sair bem nesse desafio, observe.");
        System.out.println("");
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
                + "III - Não foram inicializadas os valores das variáveis corretamente;\n"
                + "IV - Ausência de pontução.\n");
        System.out.println("1) Opções I,II - Corretas \n"
                + "2) Opções I,IV - Corretas \n"
                + "3) Opções I,III,IV - Corretas \n"
                + "4) Apenas Opção III");

        opcao_desafio = leitor.nextInt();

        //possíveis opções
        switch (opcao_desafio) {
            case 1:
                opcao_resposta = "errada";
                break;
            case 2:
                opcao_resposta = "errada";
                break;
            case 3:
                opcao_resposta = "errada";
                break;
            case 4:
                opcao_resposta = "certa";
                break;
            default:
                //caso seja inserido qualquer outra opção, será considerado errado
                System.out.println("Resposta inválida, portanto, considerado errado.");
                opcao_resposta = "errada";
                break;
        }

        //retorno da opção certa ou errado
        return opcao_resposta;
    }

    //Função do 4º desafio
    public static String desafio_04() {

        int opcao_desafio; //variável que será utilizada para o jogador escolher a opção
        String opcao_resposta; // variável que retornará se o jogador acertou ou errou o Desafio

        //trechos de diálogos da história
        System.out.println("Professor:\n"
                + "- Não irei facilitar para você, se quer ser aprovado em minha matéria, dê o seu melhor.\n"
                + "Neste desafio irei testa-lo com matrizes onde será analisado seus conhecimentos sobre essas Arrays.\n"
                + "Mostre-me aonde está o erro.\n"
                + nome_player + ":\n"
                + "- Mostrarei ao senhor e ainda irei melhorar esse código, observe.\n"
                + "Professor:\n"
                + "- Muito bem então, quero ver como se sairá em Arrays.");
        System.out.println("");
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

        //possíveis opções
        switch (opcao_desafio) {
            case 1:
                opcao_resposta = "errada";
                break;
            case 2:
                opcao_resposta = "errada";
                break;
            case 3:
                opcao_resposta = "errada";
                break;
            case 4:
                opcao_resposta = "certa";
                break;
            default:
                //caso seja inserido qualquer outra opção, será considerado errado
                System.out.println("Resposta inválida, portanto, considerado errado.");
                opcao_resposta = "errada";
                break;
        }
        //retorno da opção certa ou errado
        return opcao_resposta;

    }

    //Função do 5º desafio
    public static String desafio_05() {

        int opcao_desafio; //variável que será utilizada para o jogador escolher a opção
        String opcao_resposta; // variável que retornará se o jogador acertou ou errou o Desafio

        //trechos de diálogos da história
        System.out.println("Professor:\n"
                + "- Nesse desafio vou lhe apresentar um erro que envolve um problema em Array.\n"
                + "Neste teste colocamos a estrutura de repetição do-while, e também vetor.\n"
                + "Nele será relatado o erro:  Exception in thread \\\"main\\\" java.lang.ArrayIndexOutOfBounds\n"
                + nome_player + ":\n"
                + "- Esse erro é complicado, mas não impossível.\n"
                + "Professor:\n"
                + "- Muito bem. É assim que gosto de ver meus alunos, se esforçando ao máximo.\n"
                + "Mostre-me aonde está o erro e como resolve-lo.");
        System.out.println("");
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

        //possíveis opções
        switch (opcao_desafio) {
            case 1:
                opcao_resposta = "errada";
                break;
            case 2:
                opcao_resposta = "errada";
                break;
            case 3:
                opcao_resposta = "certa";
                break;
            case 4:
                opcao_resposta = "errada";
                break;
            default:
                //caso seja inserido qualquer outra opção, será considerado errado
                System.out.println("Resposta inválida, portanto, considerado errado.");
                opcao_resposta = "errada";
                break;
        }

        //retorno da opção certa ou errado
        return opcao_resposta;
    }

    //Função do 6º desafio
    public static String desafio_06() {

        int opcao_desafio; //variável que será utilizada para o jogador escolher a opção
        String opcao_resposta; // variável que retornará se o jogador acertou ou errou o Desafio

        //trechos de diálogos da história
        System.out.println("Professor:\n"
                + "- Resolva este erro. \n"
                + "Este código é feito para a conversão de dólar, onde é pedido o valor e quantidade de dólar desejado.\n"
                + "Nele é relatado o erro:  Exception in thread \\\"main\\\" java.lang.RuntimeException: Uncompilable source code\n"
                + "Mostre-me como resolver esse erro para que possamos mais tarde fazer o cálculo dos dólares.\n"
                + nome_player + ":\n"
                + "- Deixa comigo, professor.\n"
                + "Professor:\n"
                + "- Lembre-se, se errar, pode perder uma vida.");
        System.out.println("");
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

        //possíveis opções
        switch (opcao_desafio) {
            case 1:
                opcao_resposta = "errada";
                break;
            case 2:
                opcao_resposta = "certa";
                break;
            case 3:
                opcao_resposta = "errada";
                break;
            case 4:
                opcao_resposta = "errada";
                break;
            default:
                //caso seja inserido qualquer outra opção, será considerado errado
                System.out.println("Resposta inválida, portanto, considerado errado.");
                opcao_resposta = "Errado";
                break;
        }

        //retorno da opção certa ou errado
        return opcao_resposta;
    }

    //Função do 7º desafio
    public static String desafio_07() {

        int opcao_desafio; //variável que será utilizada para o jogador escolher a opção
        String opcao_resposta; // variável que retornará se o jogador acertou ou errou o Desafio

        //trechos de diálogos da história
        System.out.println("Professor:\n"
                + "- Esse código é bastante complexo por envolver um certo cálculo\n"
                + "No código temos que entrar com a base e altura de um triangulo para que o algoritmo possa retornar a área, perímetro e diagonal.\n"
                + "Verifique esse código e mostre-me o que consta errado.\n"
                + nome_player + ":\n"
                + "- Observe, irei achar o erro e serei aprovado em sua matéria.");
        System.out.println("");
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
                + "III - Não foi especificado nenhuma variável que recebe o retorno das funções;\n"
                + "IV - Função matemática aplicada erroneamente.\n");
        System.out.println("1) Opções I,III - Corretas \n"
                + "2) Opções II,III - Corretas \n"
                + "3) Apenas Opção I \n"
                + "4) Apenas Opção IV");

        opcao_desafio = leitor.nextInt();

        //possíveis opções
        switch (opcao_desafio) {
            case 1:
                opcao_resposta = "errada";
                break;
            case 2:
                opcao_resposta = "errada";
                break;
            case 3:
                opcao_resposta = "certa";
                break;
            case 4:
                opcao_resposta = "errada";
                break;
            default:
                //caso seja inserido qualquer outra opção, será considerado errado
                System.out.println("Resposta inválida, portanto, considerado errado.");
                opcao_resposta = "errada";
                break;
        }

        //retorno da opção certa ou errado
        return opcao_resposta;
    }

    //Função do 8º desafio
    public static String desafio_08() {

        int opcao_desafio; //variável que será utilizada para o jogador escolher a opção
        String opcao_resposta; // variável que retornará se o jogador acertou ou errou o Desafio

        //trechos de diálogos da história
        System.out.println("Professor:\n"
                + "- Este é algoritmo para um cardápio de restaurante.\n"
                + "Desenvolvi esse código onde é apresentado um cardápio. Ao digitar o prato desejado será apresentado as refeições que vem em cada um.\n"
                + "Coloquei estruturas condicionais como Switch e envolvi também laço de repetição como Do-While.\n"
                + "Quero testar seus conhecimentos nesse desafio para ver como irá se sair.\n"
                + nome_player + ":\n"
                + "- Muito bem professor, irei resolver esses problemas e ao final irei fazer um lanche.\n"
                + "Professor:\n"
                + "- Muito bem, vamos ver se será capaz como diz.");
        System.out.println("");
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

        //possíveis opções
        switch (opcao_desafio) {
            case 1:
                opcao_resposta = "errada";
                break;
            case 2:
                opcao_resposta = "errada";
                break;
            case 3:
                opcao_resposta = "errada";
                break;
            case 4:
                opcao_resposta = "certa";
                break;
            default:
                //caso seja inserido qualquer outra opção, será considerado errado
                System.out.println("Resposta inválida, portanto, considerado errado.");
                opcao_resposta = "errada";
                break;
        }

        //retorno da opção certa ou errado
        return opcao_resposta;
    }

    //Método que mostra as instruções do jogo
    public static void instruções_jogo() {

        String tecla;

        //as instruções que serão exibidas para o jogador
        System.out.println("O jogador escolherá o nome.\n"
                + "Começara com 3 vidas extras, e ao longo do jogo, será concedido oito desafios (o aluno precisa efetivamente acertar 5 deles para obter a aprovação).\n"
                + "Ao passar por um desafio, será informado se acertou ou não. Caso tenha errado, perderá uma vida. Ao zerar todas as vidas, "
                + "será exibido tela de REPROVADO. \n"
                + "Passando por 5 desafios, ao final do jogo, exibirá tela de APROVADO. \n"
                + "Os desafios serão de múltipla escolha, contendo quatro alternativas.\n\n"
                + "Para voltar, digite a tecla 'X' para voltar ao menu.\n");
        tecla = leitor.next();

        //condicional utilizada para que o usuário volte para o menu do jogo
        if (tecla.equalsIgnoreCase("X")) {
            System.out.println("\n");
            limpar_tela();
            menu_jogo();

            //caso digite qualquer outra opção, repete o método de instruções
        } else {
            limpar_tela();
            System.out.println("Opção inválida!\n");
            instruções_jogo();
            System.out.println("\n");
        }
    }

    //Método que mostra os créditos do jogo
    public static void creditos_jogo() {

        String tecla;

        //os crédito de quem desenvolveu o jogo
        System.out.println("Equipe de Produção: \n"
                + "Bruno Pontes\n"
                + "Diego Mansoldo\n"
                + "Gabriel Vital\n"
                + "\n"
                + "História desenvolvida por: \n"
                + "Bruno Pontes\n"
                + "Diego Mansoldo\n"
                + "Gabriel Vital\n"
                + "\n"
                + "Apresentação: \n"
                + "Bruno Pontes\n"
                + "Diego Mansoldo\n"
                + "Gabriel Vital\n"
                + "\n"
                + "Para voltar, digite a tecla 'X' para voltar ao menu.\n");
        tecla = leitor.next();

        //condicional utilizada para que o usuário volte para o menu do jogo
        if (tecla.equalsIgnoreCase("X")) {
            System.out.println("\n");
            limpar_tela();
            menu_jogo();

            //caso digite qualquer outra opção, repete o método de instruções
        } else {            
            
            limpar_tela();
            System.out.println("Opção inválida!\n");
            creditos_jogo();
            System.out.println("\n");
        }
    }

    //Método que efetua a saída do jogo
    public static void saida_jogo() {
        System.out.println("Você saiu do jogo!");
    }

    //método para inserir diversos quebras de linha para simular uma limpeza de tela    
    public static void limpar_tela() {

        for (int i = 0; i < 150; i++) {
            System.out.println("\n");
        }

    }

    public static void main(String[] args) {

        menu_jogo();//Método que encaminha para todos os outros métodos do jogo

        //validação que indica que o jogador conseguiu ser aprovado pelos Desafios.
        if (certo >= 5) {

            System.out.println("Parabéns, você conseguiu superar os Desafios do professor X");
        }

        System.out.println("");
        System.out.println("Você acertou " + certo + " de 8 Desafios."); //indica quantos desafios foram acertados pelo jogador.
        System.out.println("Você errou " + errado + " de 8 Desafios."); //indica quantos desafios o jogador errou.
        System.out.println("FIM");

        leitor.close();

    }
}
