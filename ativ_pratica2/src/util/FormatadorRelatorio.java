package util;

import model.Produto;
import java.util.List;

public class FormatadorRelatorio {
	public static String formatarProduto(Produto p) {
		return String.format("|* Produto\nNome: %s\n|Código: %s\n|Preço: %.2f Qtd: %d\n", p.getNome(), p.getCodigo(), p.getPreco()
				, p.getQtd());
	}
	
	public static String formatarListaProdutos(List<Produto> produtos) {
		 String lista = "|* Listagem de produtos\n";
		 
		 for(Produto p: produtos) {
			 lista = lista.concat(String.format("|* %s\n|Código: %s\n|Preço: %.2f Qtd: %d\n", p.getNome(), p.getCodigo(), p.getPreco()
						, p.getQtd()));
		 }
		 
		 return lista;
	}
	
	public static String formatarRelatorioEstoque(List<Produto> produtos) {
		 String relatorio = "|* Relatorio de estoque\n";
		 int total = 0;
		 double totalValor = 0;
		 
		 for(Produto p: produtos) {
			 relatorio = relatorio.concat(String.format("|* %s\n|Código: %s\n|Preço: %.2f Qtd: %d\n", p.getNome(), p.getCodigo(), p.getPreco()
						, p.getQtd()));
			 total += p.getQtd();
			 totalValor += p.getPreco() * p.getQtd();
		 }
		 
		 relatorio = relatorio.concat(String.format("|* TOTAL de produtos no estoque: %d\n|* VALOR total do estoque: %.2f\n", total, totalValor));
		 return relatorio;		
	}
}
