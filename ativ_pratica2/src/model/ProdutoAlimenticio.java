package model;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ProdutoAlimenticio extends Produto {
    private Date dataValidade;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ProdutoAlimenticio(String codigo, String nome, int qtd, double preco, String dataValidade) {
        super(codigo, nome, qtd, preco);

        try {
            if (dataValidade != null && !dataValidade.strip().isEmpty()) {
                this.dataValidade = dateFormat.parse(dataValidade);
            }
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use: (dd/mm/aaaa)");
        }
    }

    // Sobrescrita
    @Override
    public void exibirDetalhes() {
        System.out.printf("*** Detalhes ***\n* Nome: %s\n", this.getNome());
        System.out.printf("* Código: %s\n* Preço: %.2f\n", this.getCodigo(), this.getPreco());
        String dataFormatada = (dataValidade != null) ? dateFormat.format(dataValidade) : "N/A";
        System.out.printf("* Data de validade: %s\n* Qtd. no estoque: %d\n", dataFormatada, this.getQtd());
        System.out.printf("* Valor total do estoque: %.2f\n", this.getPreco() * this.getQtd());
    }

    public boolean estaVencido() {
        if (this.dataValidade == null)
        	return false;
        Date hoje = new Date();
        return dataValidade.before(hoje);
    }

    @Override
    public boolean saidaEstoque(int qtd) {
        if (this.qtd >= qtd && !estaVencido()) {
            this.qtd -= qtd;
            return true;
        } else {
            System.out.println("Falha na operação");
            return false;
        }
    }

    @Override
    public boolean saidaEstoque(int qtd, boolean zerar) {
        if (zerar && this.qtd >= qtd && !estaVencido()) {
            this.qtd -= qtd;
            return true;
        } else return saidaEstoque(qtd);
    }

    public String getDataValidade() {
        return (dataValidade != null) ? dateFormat.format(dataValidade) : "";
    }

    public void setDataValidade(String dataValidade) {
        try {
            this.dataValidade = dateFormat.parse(dataValidade);
        } catch (ParseException e) {
        	System.out.println("Formato de data inválido. Use: (dd/mm/aaaa)");
        }
    }
}