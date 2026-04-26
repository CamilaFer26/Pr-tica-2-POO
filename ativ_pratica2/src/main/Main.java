package main;

import service.Estoque;
import ui.MenuConsole;

public class Main {

	public static void main(String[] args) {
		// instaciação de estoque, menu, chamada da função de interação com usuario
		Estoque estoque = new Estoque();
		MenuConsole menu = new MenuConsole(estoque);
		
		menu.iniciar();
	}

}
