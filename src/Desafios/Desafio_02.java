/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Desafios;

import java.util.Scanner;

/**
 *
 * @author gabriel.rvital
 */
public class Desafio_02 {

    static Scanner leitor = new Scanner(System.in);
    
    public static String desafio_02 (int entrada) {     
        
        int opcao_desafio;
        String opcao_resposta;
        
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
        
        switch (opcao_desafio) {
            case 1:
                opcao_resposta = "Certo";
                break;
            case 2:
                opcao_resposta = "Errado";
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
        return (opcao_resposta);

    }

    public static void main(String[] args) {
        
        System.out.println("Verificação de Desafio: ");
        int resposta = leitor.nextInt();
        
        String validacao_resposta = desafio_02(resposta);
        System.out.println(validacao_resposta);
    }
}
