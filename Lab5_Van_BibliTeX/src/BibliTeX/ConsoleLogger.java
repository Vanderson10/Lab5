package BibliTeX;

/**
 * representa um Logger, parecido com um consoleS
 * @author vanderson
 *
 */
public class ConsoleLogger implements Logger{
	
	/**
	 * construtor
	 */
	public ConsoleLogger(){
		
	}
	
	/**
	 * metodo do imprimir Logger
	 */
	@Override
	public String imprimeLogger(String transformacao, long momento, String metodo) { 
		if (metodo.equals("transforma")) {
			return "[transforma] "+transformacao+"\n";
		}
		else if (metodo.equals("contaTransformacao")) {
			return "[contaTransformacao] "+"\n";
		}
		else if (metodo.equals("historico")) {
			return "[historico] "+transformacao+"\n";
		}
		return null;
	}

}
