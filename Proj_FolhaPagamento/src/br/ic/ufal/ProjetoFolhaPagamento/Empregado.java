package br.ic.ufal.ProjetoFolhaPagamento;


public class Empregado {

	private int id = Fluxo.geraIdEmpregado();
	private String nome;
	public Endereco endereco = new Endereco();
	private int tipo;
	private int sindicato;
	private int idSindicato = Fluxo.geraIdSindicato();
	private double taxaSindical;
	private int formaPagamento;
	private double valorHora;
	private double comissao;
	private double percentualComissao;
	private double salario;
	private String entrada;
	private String saida;
	private double taxaServico = 0;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	public double getComissao() {
		return comissao;
	}
	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getId() {
		return id;
	}
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public String getSaida() {
		return saida;
	}
	public void setSaida(String saida) {
		this.saida = saida;
	}
	public double getTaxaServico() {
		return taxaServico;
	}
	public void setTaxaServico(double taxaServico) {
		this.taxaServico = taxaServico;
	}
	public int getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(int formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public int getSindicato() {
		return sindicato;
	}
	public void setSindicato(int sindicato) {
		this.sindicato = sindicato;
	}
	public double getTaxaSindical() {
		return taxaSindical;
	}
	public void setTaxaSindical(double taxaSindical) {
		this.taxaSindical = taxaSindical;
	}
	public int getIdSindicato() {
		return idSindicato;
	}
	public double getPercentualComissao() {
		return percentualComissao;
	}
	public void setPercentualComissao(double percentualComissao) {
		this.percentualComissao = percentualComissao;
	}
}
