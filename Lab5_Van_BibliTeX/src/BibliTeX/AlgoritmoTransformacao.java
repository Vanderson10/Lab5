package BibliTeX;

/**
 * interface para Algoritmo tranformação
 * @author vanderson
 *
 */
public interface AlgoritmoTransformacao {
	
	/**
	 * Assinaturas dos métodos
	 * @param original
	 * @return Strings
	 */
	public String transforma(String original);
    public String getNome();


}
