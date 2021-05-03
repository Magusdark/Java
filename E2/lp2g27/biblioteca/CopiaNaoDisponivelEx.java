package lp2g27.biblioteca;
public class CopiaNaoDisponivelEx extends Exception{
	private static final long serialVersionUID = 1L;

	public CopiaNaoDisponivelEx() {
		System.out.println("Nao existe copia disponivel deste livro!");
	}
}