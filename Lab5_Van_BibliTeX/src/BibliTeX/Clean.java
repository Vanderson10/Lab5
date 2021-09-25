package BibliTeX;
/**
 * Transformação clean
 * @author vanderson
 *
 */
public class Clean implements AlgoritmoTransformacao{
	
	/**
	 * atributo nome
	 */
	private String nome;
	
	/**
	 * construtor
	 */
	public Clean() {
		this.nome = "clean";
		
	}
	
	/**
	 * método que válida entradas
	 * @param entrada
	 */
	private void validacao(String entrada) {
		if (entrada == null) {
			throw new NullPointerException("ENTRADA NULA NÃO PODE!");
		}else if(entrada.isBlank()) {
			throw new IllegalArgumentException("ENTRADA VAZIA!");
		}
	}

	/**
	 * return a entrada sem pontuação
	 */
	@Override
	public String transforma(String original) {
		validacao(original);
		String saida = original.replaceAll("\\p{Punct}", "");
		return saida;
	}

	/**
	 * metodo para acessar o nome da trasnformação
	 */
	@Override
	public String getNome() {
		return this.nome;
	}

}
