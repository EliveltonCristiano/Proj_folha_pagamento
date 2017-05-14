package br.ic.ufal.ProjetoFolhaPagamento;

import java.util.Scanner;

public class Capture {
	Scanner input = new Scanner(System.in);

	public int opcaoMenu() {
		try {

			return input.nextInt();
		} catch (Exception e) {

			System.out.println("   --> Entrada invalida <--");
			input.nextLine();
			return -1;
		}
	}

	public int tipo() {
		System.out.println("1. Horista\n2. Assalariado\n3. Comissionado\n>> ");
		return opcaoMenu();
	}
	
	public String nome() {
		System.out.print("nome: ");
		input.nextLine();
		return input.nextLine();
	}

	public double valorHora() {
		System.out.print("valor por hora: ");
		return input.nextDouble();
	}

	public double percentualComissao() {
		System.out.print("valor da percentual da comissao: ");
		try {
			return input.nextDouble();
		}catch (Exception InputMismatchException){
			System.out.println("entrada de valor invalida, use virgula");
			return 0;
		}
	}

	public String rua() {
		System.out.print("Rua: ");
		input.nextLine();
		return input.nextLine();
	}

	public int num() {
		System.out.print("Numero: ");
		int x;
		do {
			x = opcaoMenu(); 
			
		} while(x == -1);
		
		return x;
	}

	public String bairro() {
		System.out.print("Bairro: ");
		input.nextLine();
		return input.nextLine();
	}

	public String cidade() {
		System.out.print("Cidade: ");
		return input.nextLine();
	}

	public String estado() {
		System.out.print("Estado: ");
		return input.nextLine();
	}

	public double taxa() {
		System.out.print("valor da taxa: ");
		try {
			return input.nextDouble();
		}catch (Exception InputMismatchException){
			System.out.println("entrada de valor invalida, use virgula");
			return 0;
		}
	}

	public int formaPagamento() {
		System.out.print("1. chequeCorreios\n2. ChequeMaos\n3. depositoConta\n   >>");
		int x = input.nextInt();
		while(x < 1 || x > 3) {
			System.out.print("1. chequeCorreios\n2. ChequeMaos\n3. depositoConta\n   >>");
			x = input.nextInt();
		}
		return x;
	}

	public int sindicato() {
		System.out.print("participar do sindicato?(0 para nao, 1 para sim) ");
		int x = input.nextInt();
		while(x != 0 && x != 1) {
			System.out.print("participar do sindicato?(0 para nao, 1 para sim) ");
			x = input.nextInt();
		}
		return x;
	}

	public double taxaSindical() {
		System.out.print("Valor da taxa sindical: ");
		try {
			return input.nextDouble();
		}catch (Exception InputMismatchException){
			System.out.println("entrada de valor invalida, use virgula");
			return 0;
		}
	}

	public String recebeDataVenda() {
		System.out.println("data da venda: ");
		input.nextLine();
		String data = input.nextLine();
		if(Datas.validarData(data)){
			return data;
		}
		return null;
	}

	public double valorVenda() {
		System.out.print("valor da venda: ");
		try {
			return input.nextDouble();
		}catch (Exception InputMismatchException){
			System.out.println("entrada de valor invalida, use virgula");
			return 0;
		}
	}

	public boolean alterar() {
		System.out.print("alterar?(1 sim, 0 nao)\n  >>> ");
		switch (opcaoMenu()) {
		case 1:
			return true;
		}
		return false;
	}
}
