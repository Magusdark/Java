package lp2g27.biblioteca;
import java.util.GregorianCalendar;
import java.util.Collection;
import java.util.ArrayList;
import java.io.*;

public class Usuario extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String endereco;
	protected int codigoUsuario;
	protected ArrayList<Emprestimo> historico= new ArrayList<Emprestimo>();
	protected int[] devolvidos=new int[1000];
	
	public Usuario(String a, GregorianCalendar b, String c, int d){
		super(a,b);
		endereco=c;
		codigoUsuario=d;
		for(int i=0;i<1000;i++){
			devolvidos[i]=0;
		}
	}
	
	public void addLivroHist(GregorianCalendar a, GregorianCalendar b, String c){
		Emprestimo emp=new Emprestimo(a,b,c);
		historico.add(emp);
	}
	
	public int getCod(){
		return codigoUsuario;
	}
	
	public String getEndereco(){
		return endereco;
	}
	
	public ArrayList getHistorico(){
		return historico;
	}
	
	public void setDevolvido(int a){
		devolvidos[a]=1;
	}

	public String toString(){
		return super.toString()+"\nEndereco: "+endereco+"\nCodigo do Usuario: "+codigoUsuario+"\nHistorico do Usuario: "+historico;
	}
}