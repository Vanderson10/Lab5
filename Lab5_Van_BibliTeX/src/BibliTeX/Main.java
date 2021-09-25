package BibliTeX;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TransformaTexto tt = new TransformaTexto();
		System.out.println(tt.transforma("clean", "oi, como vc vai?"));
		System.out.println(tt.transforma("clean", "oi, como vc vai?"));
		System.out.println(tt.contaTransformacao());

	}

}
