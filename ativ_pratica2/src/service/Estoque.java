package service;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import model.Produto;

public class Estoque {
	private HashMap<String, Produto> produtosMap;	// localizar produtos
	private List<Produto> produtosList;	// percorrimento para relatórios e afins
	
	public Estoque() {
		this.produtosMap = new HashMap<>();
		this.produtosList = new ArrayList<>();
	}
	
	public void cadastrarProduto(Produto produto) {
		if(!this.produtosMap.containsValue(produto)) {
			this.produtosList.add(produto);
			this.produtosMap.put(produto.getCodigo(), produto);			
		}
	}
	
	public Produto buscarProdutoPorCodigo(String codigo) {
		Produto p = this.produtosMap.get(codigo);
		return p;
	}
	
	public boolean removerProduto(String codigo) {
		if(this.produtosMap.containsKey(codigo)) {
			Produto produto = this.produtosMap.get(codigo);
			this.produtosMap.remove(codigo);
			this.produtosList.remove(produto);
			return true;
		}
		return false;
	}
	
	public boolean registrarEntrada(String codigo, int quantidade) {
		if(this.produtosMap.containsKey(codigo)) {
			Produto produto = this.produtosMap.get(codigo);
			return produto.entradaEstoque(quantidade);
		}
		return false;
	}
	
	public boolean registrarSaida(String codigo, int quantidade) {
		if(this.produtosMap.containsKey(codigo)) {
			Produto produto = this.produtosMap.get(codigo);
			return produto.saidaEstoque(quantidade);
		}
		return false; 
	 }

	public List<Produto> listarProdutos(){
		return this.produtosList;
	}

	public void gerarRelatorioGeral(){
		System.out.println("Quantidade de produtos cadastrados no estoque: " + this.produtosList.size());
	}
	
	public List<Produto> listarProdutosComEstoqueBaixo(int limite){
		List<Produto> lista = new ArrayList<>();
		for(Produto p : this.produtosList) {
			if(p.getQtd() <= limite) {
				lista.add(p);
			}
		}
		
		return lista;
	}
}
