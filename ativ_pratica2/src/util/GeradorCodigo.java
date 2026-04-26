package util;

public class GeradorCodigo {
	private static int sequencial = 1;
	
	public static String gerarCodigo(String prefixo) {
		String codigo = String.format("%-3s-%03d", prefixo, sequencial);
		sequencial++;
		return codigo;
	}
}
