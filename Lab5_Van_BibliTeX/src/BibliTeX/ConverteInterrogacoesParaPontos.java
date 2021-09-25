package BibliTeX;
/**
 * representa uma tranformação
 * @author vanderson
 *
 */
public class ConverteInterrogacoesParaPontos implements AlgoritmoTransformacao{

	/**
	 * atributo nome
	 */
	private String nome;
	
	/**
	 * construtor
	 */
	public ConverteInterrogacoesParaPontos() {
		this.nome = "ConverteInterrogacoesParaPontos";
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
	 * transforma "?" da entrada por "."
	 */
	@Override
	public String transforma(String original) {
		validacao(original);
		String novaString = "";
		String[] letras = original.split("");
		for (int i=0; i<letras.length; i++) {
			if (letras[i].equals("?")) {
				novaString += ".";
			}
			else {
				novaString +=letras[i];
			}
		}
		return novaString;
	}
	
	/**
	 * metodo para acessar o nome da trasnformação
	 */
	@Override
	public String getNome() {
		return this.nome;
	}

}
