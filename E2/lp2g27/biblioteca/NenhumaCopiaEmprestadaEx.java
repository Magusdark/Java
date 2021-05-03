package lp2g27.biblioteca;
public class NenhumaCopiaEmprestadaEx extends Exception{
	private static final long serialVersionUID = 1L;

	public NenhumaCopiaEmprestadaEx() {
		System.out.println("Nenhuma copia deste livro foi emprestada!");
	}
}