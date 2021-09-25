package BibliTeX;

/**
 * representa um logger
 * @author vanderson
 *
 */
public class BreakpointLogger implements Logger{

	/**
	 * armazena o metodo que deseja aparecer mensagem quando invocado
	 */
	private String metodoConstrutor;
	
	/**
	 * construtor
	 * @param metodo
	 */
	public BreakpointLogger(String metodo) {
		this.metodoConstrutor = metodo;
	}
	
	/**
	 * imprime de acordo com o metodo escolhido para ser invocado uma mensagem
	 */
	@Override
	public String imprimeLogger(String transformacao, long momento, String metodo) {
		if (metodo.equals("transforma") && metodo.equals(metodoConstrutor)) {
			return "[INVOCADO - transforma]\n";
		}
		else if (metodo.equals("contaTransformacao") && metodo.equals(metodoConstrutor)) {
			return "[INVOCADO - contaTransformacao]\n";
		}
		else if (metodo.equals("historico") && metodo.equals(metodoConstrutor)) {
			return "[INVOCADO - historico]\n";
		}
		return "";
	}
	

}
