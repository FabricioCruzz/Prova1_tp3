package br.edu.univas.main;

import java.util.Random;
import java.util.Scanner;

import br.edu.univas.vo.Carro;
import br.edu.univas.vo.Competidor;
import br.edu.univas.vo.Moto;

public class StartApp {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		Competidor[] competidores = new Competidor[5];
		
		for (int i = 0; i < competidores.length; i++) {
			
			Competidor c = new Competidor();
			
			competidores[i] = c;
		}
		
		Random random = new Random();
		
		int opcao;

		int min = 5;
		int max = 20;
		
		String nome;
		
		
		for (int i = 0; i < 5; i++) {
			
			System.out.println("COMPETIDOR " +  (i+1) + ":\nESCOLHA SEU VEÍCULO:::");
			System.out.println("1 - Carro");
			System.out.println("2 - Moto");
			opcao = readInteger();
			
			System.out.println("Por favor, digite seu nome:");
			nome = sc.nextLine();
			competidores[i].setApelido(nome);
			
			if(opcao == 1) {
				Carro carro = new Carro();
				
				competidores[i].setVeiculo(carro);
			}
			else if(opcao == 2) {
				Moto moto = new Moto();
				
				competidores[i].setVeiculo(moto);
			}			
		}
		
		for (int i = 0; i < 10; i++) {			
			for (int j = 0; j < 5; j++) {

				int aceleracao = random.nextInt((max - min) + 1) + min;

				competidores[j].getVeiculo().acelerar(aceleracao);				
			}
		}
	
		int idx = 0;
		
		for (int i = 0; i < 5; i++) {
			
			for (int j = 0; j < competidores.length; j++) {
				
				if(competidores[i].getVeiculo().getVelocidadeAtual() > competidores[j].getVeiculo().getVelocidadeAtual()) {
					idx = i;
				}
			}
		}

		print(competidores[idx]);
		
		
		sc.close();
	}

	public static int readInteger() {
		int valor = sc.nextInt();
		sc.nextLine();
		
		return valor;
	}
	
public static void print(Competidor comp) {
		
		System.out.println("\n::::Competidor Vencedor:::");
		System.out.println("Nome: " + comp.getApelido());
		System.out.println("Velocidade Atual: " + comp.getVeiculo().getVelocidadeAtual());
		System.out.println();
	}
	
}
