package lp2g27.biblioteca;
public class LivroNaoCadastradoEx extends Exception{
	private static final long serialVersionUID = 1L;

	public LivroNaoCadastradoEx() {
		System.out.println("Livro nao cadastrado");
	}
}
