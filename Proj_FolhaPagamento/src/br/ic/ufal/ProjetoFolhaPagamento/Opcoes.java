package br.ic.ufal.ProjetoFolhaPagamento;

public class Opcoes {
	
	public void menuPrincipal(){
		
		System.out.println(" ---------------------------- ");
		System.out.println(" 1. Adicionar empregado       ");
		System.out.println(" 2. Remover empregado         ");
		System.out.println(" 3. Editar dados do empregado ");
		System.out.println(" 4. Lancar cartao de ponto    ");
		System.out.println(" 5. adicionar taxa a debitar  ");
		System.out.println(" 6. Sindicato                 ");
		System.out.println(" 7. Lancar venda no sistema   ");
		System.out.println(" 8. Rodar folha de pagamento  ");
		System.out.println(" 9. Listar Empregados         ");
		System.out.println(" 10. Exit                     ");
		System.out.println(" ---------------------------- ");
		
		System.out.print(" >>  ");
	}
	
public void ponto(){
		
		System.out.println(" ------------ ");
		System.out.println(" 1. Entrada   ");
		System.out.println(" 2. Saida     ");
		System.out.println(" 0. voltar    ");
		System.out.print(" >>  ");
	}

public static String diaPorExt(int diaDaSemana) {
		switch(diaDaSemana) {
		case 1:
			return "Domingo";
		case 2:
			return "Segunda-Feira";
		case 3:
			return "Terca-Feira";
		case 4:
			return "Quarta-Feira";
		case 5:
			return "Quinta-Feira";
		case 6:
			return "Sexta-Feira";
		case 7:
			return "Sabado";
		}
		return null;
	}

public static void dataErrada() {
	System.out.println("Valor de data invalido!");
	
 }
}
