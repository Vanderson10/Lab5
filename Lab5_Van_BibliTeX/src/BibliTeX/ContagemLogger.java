package BibliTeX;

public class ContagemLogger implements Logger{
	/**
	 * atributos para armazenar a quantidade de vezes que cada metodo desses é invocado
	 */
	private int transforma;
	private int contaTransformacao;
	private int historico;
	
	/**
	 * construtor
	 */
	public ContagemLogger(){
		
	}
	
	/**
	 * metodo que faz a contagem de quantas vezes cada metodo é chamado
	 */
	@Override
	public String imprimeLogger(String transformacao, long momento, String metodo) {
		if (metodo.equals("transforma")) {
			this.transforma+=1;
		}
		else if (metodo.equals("contaTransformacao")) {
			this.contaTransformacao+=1;
		}
		else if (metodo.equals("historico")) {
			this.historico+=1;
		}
		return "";
	}
	
	/**
	 * metodo que retorna os valores em string de quantas vezes cada metodo foi invocado
	 */
	public String toString() {
		String transformas = Integer.toString(transforma);
		String contaTransformacaos = Integer.toString(contaTransformacao);
		String historicos = Integer.toString(historico);
		String saida = "transforma - "+transformas+"\n"
				+ "contaTransformacao - "+contaTransformacaos+"\n"
				+ "historico - "+historicos;
		
		return saida;
	}
	

}
