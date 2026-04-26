package ui;

import service.Estoque;
import java.util.List;
import java.util.Scanner;
import util.*;
import model.*;
public class MenuConsole {
	private Scanner scanner = new Scanner(System.in);
	private Estoque estoque;
	
	public MenuConsole(Estoque estoque) {
		this.estoque = estoque;
	}
	
	public void iniciar() {
		exibirMenu();
	}
	
	private void exibirMenu() {
		int opcao;
		
			 System.out.println("\n********** MENU **********");
			 System.out.println("[1] Cadastrar produto no estoque");
			 System.out.println("[2] Registrar entrada no estoque");
			 System.out.println("[3] Registrar saída do estoque");
			 System.out.println("[4] Buscar produto no estoque");
			 System.out.println("[5] Listar produtos");
			 System.out.println("[6] Exibir relatório");
		do { 
			 System.out.print("-> Insira a opcao desejada: ");
			 opcao = this.scanner.nextInt();
			 this.scanner.nextLine();	
			 
			 switch(opcao) {
			 case 1:
				 this.cadastrarProduto();
				 break;
			 case 2:
				 this.registrarEntrada();
				 break;
			 case 3:
				 this.registrarSaida();
				 break;
			 case 4:
				 this.buscarProduto();
				 break;
			 case 5:
				 this.listarProdutos();
				 break;
			 case 6: 
				 this.exibirRelatorio();
				 break;
			 default:
			     System.out.println("Opção inválida");
			 }			
		}while(opcao != 0);
	}
	
	private void cadastrarProduto() {
		System.out.println("\n***** Cadastro de produto *****");
		System.out.println("[1] Alimentício");
		System.out.println("[2] Eletrônico");
		System.out.println("[3] Vestuário");
		System.out.println("[0] SAIR");

		int op;

		do {
		    System.out.print("-> Insira o tipo de produto: ");
		    op = this.scanner.nextInt();
		    this.scanner.nextLine();

		    switch(op) {
		    case 1:
		        System.out.print("-> Insira o nome: ");
		        String nomeA = this.scanner.nextLine();

		        System.out.print("-> Insira o prefixo do código: ");
		        String prefixoA = this.scanner.nextLine();
		        String codigoA = GeradorCodigo.gerarCodigo(prefixoA);

		        System.out.print("-> Insira a quantidade inicial: ");
		        int qtdA = this.scanner.nextInt();

		        System.out.print("-> Insira o preço: ");
		        double precoA = this.scanner.nextDouble();
		        this.scanner.nextLine();

		        System.out.print("-> Insira a data de validade (dd/mm/aaaa): ");
		        String data = this.scanner.nextLine();

		        Produto pA = new ProdutoAlimenticio(codigoA, nomeA, qtdA, precoA, data);
		        this.estoque.cadastrarProduto(pA);
		        System.out.println("** Produto cadastrado com sucesso! código " + pA.getCodigo());
		        break;

		    case 2:
		        System.out.print("-> Insira o nome: ");
		        String nomeE = this.scanner.nextLine();

		        System.out.print("-> Insira o prefixo do código: ");
		        String prefixoE = this.scanner.nextLine();
		        String codigoE = GeradorCodigo.gerarCodigo(prefixoE);

		        System.out.print("-> Insira a quantidade inicial: ");
		        int qtdE = this.scanner.nextInt();

		        System.out.print("-> Insira o preço: ");
		        double precoE = this.scanner.nextDouble();
		        this.scanner.nextLine();

		        System.out.print("-> Insira a garantia (meses): ");
		        int garantia = this.scanner.nextInt();
		        this.scanner.nextLine();

		        System.out.print("-> Insira a voltagem: ");
		        String voltagem = this.scanner.nextLine();

		        Produto pE = new ProdutoEletronico(codigoE, nomeE, qtdE, precoE, garantia, voltagem);
		        this.estoque.cadastrarProduto(pE);
		        System.out.println("** Produto cadastrado com sucesso! código " + pE.getCodigo());
		        break;

		    case 3:
		        System.out.print("-> Insira o nome: ");
		        String nomeV = this.scanner.nextLine();

		        System.out.print("-> Insira o prefixo do código: ");
		        String prefixoV = this.scanner.nextLine();
		        String codigoV = GeradorCodigo.gerarCodigo(prefixoV);
		        
		        System.out.print("-> Insira a quantidade inicial: ");
		        int qtdV = this.scanner.nextInt();
		        
		        System.out.print("-> Insira o preço: ");
		        double precoV = this.scanner.nextDouble();
		        this.scanner.nextLine();
		        
		        System.out.print("-> Insira o tamanho: ");
		        String tamanho = this.scanner.nextLine();
		        
		        System.out.print("-> Insira o material: ");
		        String material = this.scanner.nextLine();

		        Produto pV = new ProdutoVestuario(codigoV, nomeV, qtdV, precoV, tamanho, material);
		        this.estoque.cadastrarProduto(pV);
		        System.out.println("** Produto cadastrado com sucesso! código " + pV.getCodigo());
		        break;
		    case 0:
		        System.out.println("Saindo...");
		        break;
		    default:
		        System.out.println("Opção inválida");
		    }
		} while(op != 0);
		
		this.exibirMenu();
	}
	
	private void listarProdutos() {
		List<Produto> lista = this.estoque.listarProdutos();
		for(Produto p : lista)
			p.exibirDetalhes();
		this.exibirMenu();
	}
	
	private void buscarProduto() {
		System.out.println("***** Buscar produto *****");
		System.out.print("-> Insira o código do produto: ");
		String cod = this.scanner.nextLine();
		
		Produto p = this.estoque.buscarProdutoPorCodigo(cod);
		if(p != null) {
			System.out.println("** Produto encontrado!");
			p.exibirDetalhes();
		}
		else {
			System.out.println("** Produto não foi encontrado");		
		}
		
		this.exibirMenu();
	}
	
	private void registrarEntrada() {
		 System.out.println("\n***** Entrada de estoque ******");
		 System.out.print("-> Insira o código do produto: ");
		 String cod = this.scanner.nextLine();
		 
		 System.out.print("-> Insira a quantidade: ");
		 int qtd = this.scanner.nextInt();
		 this.scanner.nextLine();
		 
		 boolean verifica = this.estoque.registrarEntrada(cod, qtd);
		 if(verifica) {
			 System.out.println("* Entrada de estoque registrada!");
		 }
		 else {
			 System.out.println("* Não foi possível realizar a operação");
		 }
		 
		 this.exibirMenu();
	}
	
	private void registrarSaida() {
		 System.out.println("\n***** Saída de estoque ******");
		 System.out.print("-> Insira o código do produto: ");
		 String cod = this.scanner.nextLine();
		 
		 System.out.print("-> Insira a quantidade: ");
		 int qtd = this.scanner.nextInt();
		 this.scanner.nextLine();
		 
		 boolean verifica = this.estoque.registrarSaida(cod, qtd);
		 if(verifica) {
			 System.out.println("* Saída de estoque realizada com sucesso!");
		 }
		 else {
			 System.out.println("* Não foi possível realizar a operação");
		 }
		 
		 this.exibirMenu();
	}
	
	private void exibirRelatorio() {
		 System.out.println(FormatadorRelatorio.formatarRelatorioEstoque(this.estoque.listarProdutos()));
	
		 this.exibirMenu();
	}
}
