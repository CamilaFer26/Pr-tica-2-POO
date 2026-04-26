package model;

public class ProdutoVestuario extends Produto{
	private String tamanho;
	private String material;
	
	public ProdutoVestuario(String codigo, String nome, int qtd, double preco, String tamanho, String material) {
		super(codigo, nome, qtd, preco);
		
		if(!tamanho.strip().isEmpty()) {
			this.tamanho = tamanho;
		}
		if(!material.strip().isEmpty()) {
			this.material = material;
		}
	}
	// Sobrescrita
	@Override
	public void exibirDetalhes() {
		System.out.printf("*** Detalhes ***\n* Nome: &s\n", this.getNome());
		System.out.printf("* Código: %s\n* Preço: %.2f\n", this.getCodigo(), this.getPreco());
		System.out.printf("* Tmanho: &s meses\n* Material: %s\n", this.tamanho, this.material);
		System.out.printf("* Qtd. no estoque: %d\n", this.getQtd());
		System.out.printf("* Valor total do estoque: %.2f", this.getPreco() * this.getQtd());
	}
	
	public boolean isTamanhoUnico() {
		if(this.tamanho.equalsIgnoreCase("unico"))
			return true;
		return false;
	}
	
	public double cacularPrecoPromocional(double percentual) {
		return this.getPreco() * percentual;
	}
	
	public String getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(String tamanho) {
		if(!tamanho.strip().isEmpty()) {
			this.tamanho = tamanho;
		}
	}
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		if(!material.strip().isEmpty()) {
			this.material = material;
		}
	}
}
