package lp2g27.biblioteca;
public class UsuarioNaoCadastradoEx extends Exception{
	
	private static final long serialVersionUID = 1L;

	public UsuarioNaoCadastradoEx() {
		System.out.println("Usuario nao cadastrado");
	}
}