package br.ic.ufal.ProjetoFolhaPagamento;

public class Main {

	public static void main(String[] args) {
		Opcoes screen = new Opcoes();
		Capture capture = new Capture();
		boolean loop = true;
		Fluxo.setStart();
		
		do {
			
			screen.menuPrincipal();
			switch (capture.opcaoMenu()) {
			case 9:
				Fluxo.printEmp();
				break;
			case 10:
				loop = false;
				break;
				
			case 1:
				Fluxo.addEmpregado();
				break;
			case 2:
				Fluxo.removeEmpregado();
				break;
			case 3:
				Fluxo.editarDados();
				break;
				
			case 4:
				screen.ponto();
				switch(capture.opcaoMenu())	{
				case 1:
					Fluxo.entrada();
				break;	
					
				case 2:
					Fluxo.saida();
				break;
		
				}
				break;
			case 5:
				Fluxo.adcTaxa();
				
				break;
			case 6:
				Fluxo.sindicato();
				break;
			case 7:
				Fluxo.resultadoDeVenda();
				break;
			case 8:
				Fluxo.rodarFolhaDePagamento();
				break;
			default:
				break;
			}
			
		}while(loop);	
	}

}
