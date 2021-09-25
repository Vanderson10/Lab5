package BibliTeX;
/**
 * representa um logger
 * @author vanderson
 *
 */
public class TimeConsoleLogger implements Logger{
	
	/**
	 * construtor
	 */
	public TimeConsoleLogger() {
	}
	
	/**
	 * faz o mesmo que console loger só que com tempo
	 */
	@Override
	public String imprimeLogger(String transformacao, long momento, String metodo) {
		if (metodo.equals("transforma")) {
			return "[transforma - "+momento+"ms] "+transformacao+"\n";
		}
		else if (metodo.equals("contaTransformacao")) {
			return "[contaTransformacao - "+momento+"ms]\n";
		}
		else if (metodo.equals("historico")) {
			return "[historico - "+momento+"ms] "+transformacao+"\n";
		}
		return null;
	}
	
	

}
