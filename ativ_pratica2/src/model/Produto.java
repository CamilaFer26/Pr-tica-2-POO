package model;

public abstract class Produto {
	private final String codigo;
	private String nome;
	protected int qtd;
	private double preco;
	private static int totalProdutos = 0;
	
	public Produto(String codigo, String nome, int qtd, double preco) {
		this.codigo = codigo;
		if(!nome.strip().isEmpty()) {
			this.nome = nome;
		}
		if(qtd >= 0) {
			this.qtd = qtd;
		}
		if(preco > 0) {
			this.preco = preco;
		}
		totalProdutos++;
	}
	// Sobrecarga do método saidaEstoque
	public boolean saidaEstoque(int qtd) {
		if(this.qtd > qtd) {
			this.qtd -= qtd;
			return true;
		}
		else {
			System.out.println("Falha na operação");
			return false;
		}
	}
	
	public boolean saidaEstoque(int qtd, boolean zerar) {
		if(zerar && this.qtd >= qtd) {
			this.qtd -= qtd;
			return true;
		}
		else return saidaEstoque(qtd);
	}
	// Método final que define a regra de aumentar estoque apenas com valores positivos
	public final boolean entradaEstoque(int qtd) {
		if(qtd > 0) {
			this.qtd += qtd;
			return true;
		}
		else {
			System.out.println("Falha na operação");
			return false;
		}
	}
	// Método abstrato
	public abstract void exibirDetalhes();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtd() {
		return qtd;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	// Método estático que retorna o número total de produtos
	public static int getTotalProdutos() {
		return totalProdutos;
	}
}
