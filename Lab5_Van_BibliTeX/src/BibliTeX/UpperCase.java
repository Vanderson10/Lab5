package BibliTeX;
/**
 * representa uma transformação
 * @author vanderson
 *
 */
public class UpperCase implements AlgoritmoTransformacao{

	/**
	 * atributo nome
	 */
	private String nome;
	
	/**
	 * construtor
	 */
	public UpperCase() {
		this.nome = "upperCase";
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
	 * transforma a entrada em maiuscula
	 */
	@Override
	public String transforma(String original) {
		validacao(original);
		return original.toUpperCase();
	}

	/**
	 * metodo para acessar o nome da trasnformação
	 */
	@Override
	public String getNome() {
		return this.nome;
	}

}
