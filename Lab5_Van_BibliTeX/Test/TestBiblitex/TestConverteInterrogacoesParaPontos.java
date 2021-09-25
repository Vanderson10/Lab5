package TestBiblitex;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BibliTeX.AlgoritmoTransformacao;
import BibliTeX.ConverteInterrogacoesParaPontos;

public class TestConverteInterrogacoesParaPontos {
	
	private AlgoritmoTransformacao at;

	@BeforeEach
	void iniciaTransformacao() {
		this.at = new ConverteInterrogacoesParaPontos();
	}
	
	@Test
	void testTransformaCaMeLcAsEfY() {
		System.out.println(at.transforma("oi, como vc vai?"));
	}
	
	@Test
	void testTransformaTextoNull() {
		try {
			at.transforma(null);
			fail("É NULO");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
}
	
	@Test
	void testTransformaTextoVazio() {
		try {
			at.transforma("");
			fail("É vazio e não pode");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
