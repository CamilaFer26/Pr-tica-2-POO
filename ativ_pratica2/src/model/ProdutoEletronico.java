package model;

public class ProdutoEletronico extends Produto{
	private int garantiaMeses;
	private String voltagem;
	
	public ProdutoEletronico(String codigo, String nome, int qtd, double preco, int garantiaMeses, String voltagem) {
		super(codigo, nome, qtd, preco);
		
		if(garantiaMeses > 0)
			this.garantiaMeses = garantiaMeses;
		if(!voltagem.strip().isEmpty())
			this.voltagem = voltagem;
	}
	// Sobrescrita
	@Override
	public void exibirDetalhes() {
		System.out.printf("*** Detalhes ***\n* Nome: &s\n", this.getNome());
		System.out.printf("* Código: %s\n* Preço: %.2f\n", this.getCodigo(), this.getPreco());
		System.out.printf("* Garantia: &d meses\n* Voltagem: %d\n", this.garantiaMeses, this.voltagem);
		System.out.printf("* Qtd. no estoque: %d\n", this.getQtd());
		System.out.printf("* Valor total do estoque: %.2f", this.getPreco() * this.getQtd());
	}
	
	public boolean possuiGarantiaEstendida() {
		if(this.garantiaMeses > 3)
			return true;
		return false;
	}
	
	public int getGarantiaMeses() {
		return garantiaMeses;
	}
	
	public void setGarantiaMeses(int garantiaMeses) {
		this.garantiaMeses = garantiaMeses;
	}
	
	public String getVoltagem() {
		return voltagem;
	}
	public void setVoltagem(String voltagem) {
		if(!voltagem.strip().isEmpty())
			this.voltagem = voltagem;
	}
}
