package BibliTeX;
/**
 * 
 * @author vanderson
 *
 */
public class CleanSpaces implements AlgoritmoTransformacao{

	/**
	 * atributo nome
	 */
	private String nome;
	
	/**
	 * construtor
	 */
	public CleanSpaces() {
		this.nome = "cleanSpaces";
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
	 * tira os espaços do texto inserido
	 */
	@Override
	public String transforma(String original) {
		validacao(original);
		String novaString = "";
		String[] letras = original.split("");
		for (int i=0; i<letras.length; i++) {
			if (!letras[i].equals(" ")) {
				novaString += letras[i];
			}
		}
		return novaString;
	}

	/**
	 * metodo para acessar o nome da transformação
	 */
	@Override
	public String getNome() {
		return this.nome;
	}

}
