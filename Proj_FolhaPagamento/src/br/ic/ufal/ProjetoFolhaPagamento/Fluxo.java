package br.ic.ufal.ProjetoFolhaPagamento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Fluxo {
	
	static Capture capture = new Capture();
	static List<Empregado> empregados = new ArrayList<Empregado>();
	private static int id = 1000;
	private static int idSindicato = 50;

	public static int geraIdEmpregado() {
		return id++;
	}

	public static int geraIdSindicato() {
		return idSindicato++;
	}

	static void setStart() {
		Empregado empregado = new Empregado();
		Empregado empregado2 = new Empregado();
		Empregado empregado3 = new Empregado();
		Empregado empregado4 = new Empregado();
		
		empregado.setTipo(1);
		empregado.setSindicato(1);
		empregado.setTaxaSindical(24.10);
		empregado.setFormaPagamento(1);
		empregado.setNome("Pessoa Aleatoria");
		empregado.setValorHora(32);
		empregado.setSalario(0);
		empregado.setPercentualComissao(0);
		empregado.endereco.setRua("Grota");
		empregado.endereco.setNum(13);
		empregado.endereco.setBairro("Jacintinho");
		empregado.endereco.setCidade("Maceio");
		empregado.endereco.setEstado("AL");
		
		empregado2.setTipo(2);
		empregado2.setSindicato(1);
		empregado2.setTaxaSindical(29.40);
		empregado2.setFormaPagamento(2);
		empregado2.setNome("Teste dos Santos");
		empregado2.setValorHora(32);
		empregado2.setSalario(1500);
		empregado2.setPercentualComissao(0.20);
		empregado2.endereco.setRua("Rua teste");
		empregado2.endereco.setNum(123);
		empregado2.endereco.setBairro("Teste");
		empregado2.endereco.setCidade("Maceio");
		empregado2.endereco.setEstado("AL");

		empregado3.setTipo(3);
		empregado3.setSindicato(0);
		empregado3.setTaxaSindical(0);
		empregado3.setFormaPagamento(3);
		empregado3.setNome("Teste da Silva");
		empregado3.setValorHora(27);
		empregado3.setSalario(3000);
		empregado3.setPercentualComissao(0.25);
		empregado3.endereco.setRua("Teste");
		empregado3.endereco.setNum(32);
		empregado3.endereco.setBairro("Teste");
		empregado3.endereco.setCidade("Maceio");
		empregado3.endereco.setEstado("AL");
		
		empregado4.setTipo(3);
		empregado4.setSindicato(0);
		empregado4.setTaxaSindical(0);
		empregado4.setFormaPagamento(3);
		empregado4.setNome("Teste da Silva teste");
		empregado4.setValorHora(23);
		empregado4.setSalario(900);
		empregado4.setPercentualComissao(0.21);
		empregado4.endereco.setRua("Teste");
		empregado4.endereco.setNum(32);
		empregado4.endereco.setBairro("Teste");
		empregado4.endereco.setCidade("Maceio");
		empregado4.endereco.setEstado("AL");

		empregados.add(empregado);
		empregados.add(empregado2);
		empregados.add(empregado3);
		empregados.add(empregado4);
		
		
	}
	static void addEmpregado() {
		try {

			Empregado emp = new Empregado();

			emp.setTipo(capture.tipo());
			switch(emp.getTipo()){
			case 1:
				emp.setSalario(0);
				break;
			case 2:
				emp.setSalario(3000);
				break;
			case 3:
				emp.setSalario(1500); 
				break;
			case 4:
				emp.setSalario(9200); 
				break;
			default:
				System.out.println("tipo invalido, retornando");
				return;
			}
			emp.setSindicato(capture.sindicato());
			if(emp.getSindicato() == 1) emp.setTaxaSindical(capture.taxaSindical());
			emp.setFormaPagamento(capture.formaPagamento());
			emp.setNome(capture.nome());
			emp.setValorHora(capture.valorHora());
			emp.setComissao(capture.percentualComissao());
			emp.endereco.setRua(capture.rua());
			emp.endereco.setNum(capture.num());
			emp.endereco.setBairro(capture.bairro());
			emp.endereco.setCidade(capture.cidade());
			emp.endereco.setEstado(capture.estado());

			empregados.add(emp);
		} catch (Exception ex) {
			return;
		}
	}

	static void printEmp() {
		for (int i = 0; i < empregados.size(); i++) {
			System.out.print(empregados.get(i).getId() + " ");
			System.out.println(empregados.get(i).getNome());
			System.out.println("Id Sindicato: " + empregados.get(i).getIdSindicato());
			System.out.println("Salario ate o momento: " + empregados.get(i).getSalario());
			System.out.println("Descontos : " + empregados.get(i).getTaxaServico());
			System.out.println("Entrada: " + empregados.get(i).getEntrada());
			System.out.println("Saida: " + empregados.get(i).getSaida());
			System.out.println();
		}
	}

	public static void removeEmpregado() {
		System.out.print("id do empregado a remover: ");
		int id = capture.opcaoMenu();
		boolean bool = false;
		
		for (int i = 0; i < empregados.size(); i++) {
			if (empregados.get(i).getId() == id) {
				empregados.remove(i);
				bool = true;
			}
		}
		if(bool) {
			System.out.println("Empregado removido com sucesso");
		} else {
			System.out.println("Codigo nao encontrado, nao ha o que remover");
		}
	}

	public static void entrada() {
		System.out.print("codCartao(idEmpregado): ");
		int id = capture.opcaoMenu();
		boolean bool = false;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		for (int i = 0; i < empregados.size(); i++) {
			if (empregados.get(i).getId() == id) {
				if(empregados.get(i).getEntrada() != null && empregados.get(i).getSaida() == null) {
					System.out.println("Voce ja deu entrada, retornando");
					return;
				}
				if(empregados.get(i).getTipo() != 1) {
					System.out.println("Voce nao precisa marcar o ponto");
					return;
				}
				
				empregados.get(i).setEntrada(sdf.format(new Date()));
				empregados.get(i).setSaida(null);
				System.out.println("   Entrada - " + sdf.format(new Date()));
				bool = true;
			}
		}
		
		if(!bool) System.out.println("Codigo nao encontrado");

	}

	public static void saida() {
		System.out.print("codCartao(idEmpregado): ");
		int id = capture.opcaoMenu();
		boolean bool = false;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		for (int i = 0; i < empregados.size(); i++) {
			if (empregados.get(i).getId() == id) {
				if(empregados.get(i).getTipo() != 1) {
					System.out.println("Voce nao precisa marcar o ponto");
					return;
				}
				empregados.get(i).setSaida(sdf2.format(new Date()));
				if (empregados.get(i).getEntrada() != null) {
					
					bool = true;
					System.out.println("   Saida - " + sdf2.format(new Date()));
					try {
						
						Date dataDe = sdf.parse(empregados.get(i). getEntrada());
						Date dataAte = sdf2.parse(empregados.get(i). getSaida());

						long tempoTrabalhado = (dataAte.getTime() - dataDe.getTime()) / (1000 * 60);// minutos
						if (tempoTrabalhado < 0) {
							tempoTrabalhado = ((-1) * tempoTrabalhado) - 240;
						}
						
						double extra = 0, valorExtra = empregados.get(i).getValorHora() * 0.015;
						if(tempoTrabalhado > 8) extra = tempoTrabalhado/60 - 8; 

						System.out.println("Tempo Trabalhado: " + tempoTrabalhado / 60 + ":" + tempoTrabalhado % 60);
						empregados.get(i).setSalario(empregados.get(i).getSalario()
								+ (tempoTrabalhado * (empregados.get(i).getValorHora() / 60)) + extra * valorExtra);// setando valor atual
																							
					} catch (Exception ex) {
						System.out.println("erro ao registrar saida");
					}

				} else {
					System.out.println("Entrada nao identificada");
					return;
				}
			}
		}
		
		if(!bool) System.out.println("Codigo nao encontrado");

	}

	public static void adcTaxa() {
		System.out.print("codCartao(idEmpregado): ");
		int id = capture.opcaoMenu();

		for (int i = 0; i < empregados.size(); i++) {
			if (empregados.get(i).getId() == id) {
				empregados.get(i).setTaxaServico(empregados.get(i).getTaxaServico() + capture.taxa());
			}
		}

	}

	public static void editarDados() {

		System.out.print("codCartao(idEmpregado): ");
		int id = capture.opcaoMenu();

		for (int i = 0; i < empregados.size(); i++) {
			if (empregados.get(i).getId() == id) {
				Empregado emp = empregados.get(i);

				System.out.println("tipo atual: " + emp.getTipo());
				if(capture.alterar()){
					emp.setTipo(capture.tipo());
					switch(emp.getTipo()){
					case 1:
						emp.setSalario(0);
						break;
					case 2:
						emp.setSalario(3000);
						break;
					case 3:
						emp.setSalario(1500);
						break;
					}
				}
				
				System.out.println("participa do Sindicato?(0 nao, 1 sim): " + emp.getSindicato());
				if(capture.alterar()){
					emp.setTipo(capture.sindicato());
					if(emp.getSindicato() == 1){
						emp.setTaxaSindical(capture.taxaSindical());
					}
				}
				
				System.out.println("forma de Pagamento: " + emp.getFormaPagamento());
				if(capture.alterar()){
				emp.setTipo(capture.formaPagamento());
				}
				
				System.out.println("Nome Atual: " + emp.getNome());
				if(capture.alterar()){
				emp.setNome(capture.nome());
				}
				
				if(emp.getTipo() == 1){
					System.out.println("Valor da Hora trabalhada: " + emp.getValorHora());
					if(capture.alterar()){
					emp.setValorHora(capture.valorHora());
					}
				}
				
				if(emp.getTipo() == 3){
					System.out.println("Valor do percentual da Comissao: " + emp.getPercentualComissao());
					if(capture.alterar()){
					emp.setComissao(capture.percentualComissao());
					}
				}
				
				System.out.println("Rua atual: " + emp.endereco.getRua());
				if(capture.alterar()){
				emp.endereco.setRua(capture.rua());
				}
				System.out.println("Numero atual: " + emp.endereco.getNum());
				if(capture.alterar()){
				emp.endereco.setNum(capture.num());
				}
				System.out.println("Bairro atual: " + emp.endereco.getBairro());
				if(capture.alterar()){
				emp.endereco.setBairro(capture.bairro());
				}
				System.out.println("Cidade atual: " + emp.endereco.getCidade());
				if(capture.alterar()){
				emp.endereco.setCidade(capture.cidade());
				}
				System.out.println("Estado atual: " + emp.endereco.getEstado());
				if(capture.alterar()){
				emp.endereco.setEstado(capture.estado());
				}
			}
		}

	}

	public static void sindicato() {
		System.out.print("codCartao(idEmpregado): ");
		int id = capture.opcaoMenu();

		for (int i = 0; i < empregados.size(); i++) {
			if (empregados.get(i).getId() == id) {
				Empregado emp = empregados.get(i);
				if (emp.getSindicato() == 0) {
					System.out.println("Nao pertence ao sindicato.");
					switch (capture.sindicato()) {
					case 1:
						emp.setSindicato(1);
						System.out.println("Adicionado ao sindicato com sucesso");
						break;
					case 0:
						System.out.println("Ok, continua nao pertencendo");
						break;
					}
				} else {
					System.out.println("Voce ja eh afiliado ao sindicato.");
					switch (capture.sindicato()) {
					case 0:
						emp.setSindicato(0);
						System.out.println("Removido do sindicato com sucesso");
						break;
					case 1:
						System.out.println("OK, continua afiliado");
						break;
					}
				}
			}
		}
	}
	

	public static void rodarFolhaDePagamento() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Data: " + sdf.format(new Date()) + " - ");
		
		try {

			Date date = sdf.parse(sdf.format(new Date())); 
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(date);
			
			int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);
			int diaDoMes = gc.get(GregorianCalendar.DAY_OF_MONTH);
			System.out.println( Opcoes.diaPorExt(diaDaSemana));
			
			for (int i = 0; i < empregados.size(); i++) {
				Empregado emp = empregados.get(i);
				
				switch(emp.getTipo()){
				case 1:
					if(diaDaSemana == 6){
						emp.setSalario(0);
						emp.setTaxaServico(0);
						
						switch(emp.getFormaPagamento()){
						case 1:
							System.out.println(emp.getId() + " " + emp.getNome());
							System.out.println("Cheque no valor de " + (emp.getSalario()
							- emp.getTaxaServico() - emp.getTaxaSindical()) + " enviado pelos correios com sucesso");
							break;
						case 2:
							System.out.println(emp.getId() + " " + emp.getNome());
							System.out.println("Cheque no valor de " + (emp.getSalario()
									- emp.getTaxaServico() - emp.getTaxaSindical()) + " impresso com sucesso");
							
							break;
						case 3:
							System.out.println(emp.getId() + " " + emp.getNome());
							System.out.println("Salario no valor de " + (emp.getSalario()
									- emp.getTaxaServico() - emp.getTaxaSindical()) + " Depositado na conta com sucesso");
							break;
						}
					}
					
					break;
				case 2:
					if(Datas.ultimoDiaMes(date)){
						emp.setTaxaServico(0);
						switch(emp.getFormaPagamento()){
						case 1:
							System.out.println(emp.getId() + " " + emp.getNome());
							System.out.println("Cheque no valor de " + (emp.getSalario()
							- emp.getTaxaServico() - emp.getTaxaSindical()) + " enviado pelos correios com sucesso");
							break;
						case 2:
							System.out.println(emp.getId() + " " + emp.getNome());
							System.out.println("Cheque no valor de " + (emp.getSalario()
									- emp.getTaxaServico() - emp.getTaxaSindical()) + " impresso com sucesso");
							
							break;
						case 3:
							System.out.println(emp.getId() + " " + emp.getNome());
							System.out.println("Salario no valor de " + (emp.getSalario()
									- emp.getTaxaServico() - emp.getTaxaSindical()) + " Depositado na conta com sucesso");
							break;
						}
					}
					
					break;
				case 3:
					if(diaDaSemana == 6 && (diaDoMes >= 14 && diaDoMes <= 20)){
						emp.setTaxaServico(0);
						switch(emp.getFormaPagamento()){
						case 1:
							System.out.println(emp.getId() + " " + emp.getNome());
							System.out.println("Cheque no valor de " + (emp.getSalario()
							- emp.getTaxaServico() - emp.getTaxaSindical() + emp.getComissao()) + " enviado pelos correios com sucesso");
							break;
						case 2:
							System.out.println(emp.getId() + " " + emp.getNome());
							System.out.println("Cheque no valor de " + (emp.getSalario()
									- emp.getTaxaServico() - emp.getTaxaSindical() + emp.getComissao()) + " impresso com sucesso");
							
							break;
						case 3:
							System.out.println(emp.getId() + " " + emp.getNome());
							System.out.println("Salario no valor de " + (emp.getSalario()
									- emp.getTaxaServico() - emp.getTaxaSindical() + emp.getComissao()) + " Depositado na conta com sucesso");
							break;
						}
					}
					break;
				}
			}
				
		} catch (Exception ex) {
			System.out.println("erro ao registrar ao rodar a folha de pagamento");
			return;
		}
	}

	public static void resultadoDeVenda() {
		System.out.print("codCartao(idEmpregado): ");
		int id = capture.opcaoMenu();
		boolean bool = false;
		for (int i = 0; i < empregados.size(); i++) {
			if (empregados.get(i).getId() == id && empregados.get(i).getTipo() == 3) {
				
				String data = capture.recebeDataVenda(); 
				if(data == null) Opcoes.dataErrada();
				empregados.get(i).setComissao(empregados.get(i).getComissao() + (capture.valorVenda() * empregados.get(i).getPercentualComissao()));
				
				
				bool = true;
			}
		}
		if(!bool) System.out.println("Codigo nao encontrado/Voce nao recebe comissao");
	}
}
