package BibliTeX;
/**
 * representa uma transformação
 * @author vanderson
 *
 */
public class Troca_Espaco implements AlgoritmoTransformacao{

	/**
	 * atributo nome
	 */
	private String nome;
	
	/**
	 * construtor
	 */
	public Troca_Espaco() {
		this.nome = "troca_espaco";
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
	 * tranforma os espaços em "_"
	 */
	@Override
	public String transforma(String original) {
		validacao(original);
		String novaString = "";
		String[] letras = original.split("");
		for (int i=0; i<letras.length; i++) {
			if (letras[i].equals(" ")) {
				novaString += "_";
			}
			else {
				novaString += letras[i];
			}
		}
		return novaString;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

}
